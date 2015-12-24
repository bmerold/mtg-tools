package com.merold.magictools;

public class HandFactory {
	
	public static Hand createHand(Deck deck) {
		return new HandImpl(deck, 7);
	}

}
