package com.lmig.gfc.travel_site.hero_and_villians.models;

public class Monster extends LivingThing {
	
	public String getClassification() {
		return classification;
	}

	private String classification;

	public Monster(String name, int health, String classification) {
		super(name, health);
		this.classification = classification;
	
	}

}
