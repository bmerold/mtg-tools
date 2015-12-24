package com.merold.magictools.manabase;

import com.merold.magictools.Deck;
import com.merold.magictools.DeckFactory;
import com.merold.magictools.Game;
import com.merold.magictools.GameBuilder;
import com.merold.magictools.Player;
import com.merold.magictools.PlayerFactory;

public class Test {
	
	public static void main (String... args) {
		Deck deck = DeckFactory.createDeck(100);
		Player player = PlayerFactory.createPlayer("Brett", deck);
		GameBuilder gameBuilder = new GameBuilder();
		Game game = gameBuilder.addPlayer(player).createGame();
		game.start();
		
	}

}
