package com.demo.entity;

public class Anything {
	Human human;

	public Human getHuman() {
		return human;
	}

	public void setHuman(Human human) {
		this.human = human;
	}

	
	public void anythingMeth() {
		System.out.println("this is a class of anything");
	}
	public void allMethods() {
		human.walk();
		anythingMeth();
	}
}
