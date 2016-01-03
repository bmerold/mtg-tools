package com.merold.magictools.zones;

import com.merold.magictools.object.Card;

public interface Library {
	
	public Card getTopCard();
	public int count();
	public void shuffle();

}
