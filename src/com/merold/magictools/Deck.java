package com.merold.magictools;

public interface Deck {
	
	public Card draw();
	public void shuffle();
	public void add(Card card);
	public int size();

}
