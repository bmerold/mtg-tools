package com.merold.magictools;

public class CardImpl implements Card {
	private String name;
	
	public CardImpl (final String name) {
		this.name = name;
	}
	
	public CardImpl (final Card card) {
		this.name = card.getName();
	}
	
	public String getName() {
		return name;
	}
}
