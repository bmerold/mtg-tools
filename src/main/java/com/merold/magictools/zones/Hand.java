package com.merold.magictools.zones;

import com.merold.magictools.object.Card;

public interface Hand {
	public void put(Card card);
	public int count();
	public String revealHand();
}
