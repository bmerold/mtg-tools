package com.merold.magictools.zones;

import com.merold.magictools.object.Card;

public interface Deck {
	
	public Card draw();
	public void shuffle();
	public void add(Card card);
	public int size();

}
