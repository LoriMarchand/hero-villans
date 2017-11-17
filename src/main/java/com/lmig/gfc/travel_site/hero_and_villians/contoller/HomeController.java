package com.lmig.gfc.travel_site.hero_and_villians.contoller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.travel_site.hero_and_villians.models.Hero;
import com.lmig.gfc.travel_site.hero_and_villians.models.Monster;

@Controller
public class HomeController {

	private ArrayList<Monster> ourMonsters;
	private Hero ourHero;

	public HomeController() {
		this.initGame();
	}

	@RequestMapping("/")
	public ModelAndView defaultPage() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("monsters", ourMonsters);
		mv.addObject("hero", ourHero);
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping("/fight")
	public ModelAndView fightPage() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("monsters", ourMonsters);
		mv.addObject("hero", ourHero);

		Monster currentMonster = null;
		for (Monster monster : ourMonsters) {
			currentMonster = monster;
			while (ourHero.isAlive() && monster.isAlive()) {
				ourHero.attack(currentMonster);

			}
			if (this.isGameOver()) {
				break;
			}

		}
		if (ourHero.isAlive() == false) {
			mv.addObject("victoriousMonster", currentMonster);
		}

		mv.addObject("isGameOver", this.isGameOver());
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping("/reset")
	public ModelAndView resetPage() {
		ModelAndView mv = new ModelAndView();

		this.initGame();

		mv.addObject("monsters", ourMonsters);
		mv.addObject("hero", ourHero);

		mv.setViewName("index");
		return mv;
	}

	public boolean isGameOver() {

		if (ourHero.isAlive() == false) {
			return true;
		}

		boolean isOver = true;
		for (Monster monster : ourMonsters) {
			if (monster.isAlive()) {
				isOver = false;
				break;
			}

		}

		return isOver;
	}

	public void initGame() {
		ourMonsters = new ArrayList<Monster>();
		Monster monster1 = new Monster("Harvey", 150, "Gorn");
		Monster monster2 = new Monster("Wrath", 125, "Kahn");
		Monster monster3 = new Monster("Fuzzie", 100, "Tribble");
		Monster monster4 = new Monster("Groovy", 65, "Hippie");
		Monster monster5 = new Monster("PangFar", 200, "Spock");

		ourMonsters.add(monster1);
		ourMonsters.add(monster2);
		ourMonsters.add(monster3);
		ourMonsters.add(monster4);
		ourMonsters.add(monster5);

		ourHero = new Hero("Captain Kirk", 600, "Supercaptain");

	}
}
