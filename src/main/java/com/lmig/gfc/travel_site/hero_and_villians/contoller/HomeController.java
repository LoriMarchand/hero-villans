package com.lmig.gfc.travel_site.hero_and_villians.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.travel_site.hero_and_villians.models.Hero;
import com.lmig.gfc.travel_site.hero_and_villians.models.Monster;

@Controller
public class HomeController {
	
	
	private Monster ourMonster;	
	private Hero ourHero;
	
	public HomeController() {
		ourMonster = new Monster("Harvey", 80, "Gorn");
		ourHero = new Hero ("Captain Kirk", 100, "Supercaptain");
	}
	
	@RequestMapping("/")
	public ModelAndView defaultPagee() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("monster", ourMonster);
		mv.addObject("hero", ourHero);
		mv.setViewName("index");
		return mv;

	}

}
