package com.merold.magictools.manabase;

import com.merold.magictools.game.Game;
import com.merold.magictools.game.GameBuilder;
import com.merold.magictools.player.Player;
import com.merold.magictools.player.PlayerFactory;
import com.merold.magictools.zones.Deck;
import com.merold.magictools.zones.DeckFactory;

public class Test {
	
	public static void main (String... args) {
		Deck deck = DeckFactory.createDeck(100);
		Player player = PlayerFactory.createPlayer("Brett", deck);
		GameBuilder gameBuilder = new GameBuilder();
		Game game = gameBuilder.addPlayer(player).setNumTurns(4).createGame();
		game.start();
		
	}

}
