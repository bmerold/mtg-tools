package com.merold.magictools.player;

import com.merold.magictools.zones.Deck;

public class PlayerFactory {
	
	public static Player createPlayer(String name, int startingLifeTotal) {
		return new PlayerImpl(name, startingLifeTotal);
	}

}
