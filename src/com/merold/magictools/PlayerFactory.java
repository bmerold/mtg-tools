package com.merold.magictools;

public class PlayerFactory {
	
	public static Player createPlayer(String name, Deck deck) {
		return new PlayerImpl(name, deck);
	}

}
