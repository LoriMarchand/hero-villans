package com.lmig.gfc.travel_site.hero_and_villians.models;

import java.util.Random;

public class Hero extends LivingThing {	

	private String secretIdentity;
	public Hero(String name, int health, String secretIdentity) {
		super(name, health);
	this.secretIdentity = secretIdentity;
	}
	
	public void attack(LivingThing livingThing) {
		
		
		int livingThingDamage = this.getRandomNumberInRange(1,10);
		
		int heroDamage = this.getRandomNumberInRange(1,10);
		
		livingThing.setHealth(livingThing.getHealth()-livingThingDamage);
		
		this.setHealth(this.getHealth()-heroDamage);
		
	}
				
	private int getRandomNumberInRange(int min, int max) {
		Random random = new Random();
		return random.nextInt((max - min) + 1) + min;
	}
	
	public String getSecretIdentity() {
		return secretIdentity;
	}

	
	}



