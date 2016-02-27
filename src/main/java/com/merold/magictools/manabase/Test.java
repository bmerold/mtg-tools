package com.merold.magictools.manabase;

import com.merold.magictools.game.Game;
import com.merold.magictools.game.GameBuilder;
import com.merold.magictools.player.Player;
import com.merold.magictools.player.PlayerFactory;
import com.merold.magictools.zones.Deck;
import com.merold.magictools.zones.DeckFactory;

public class Test {
	
	public static void main (String... args) {
		Deck deck1 = DeckFactory.createDeck(99);
		Deck deck2 = DeckFactory.createDeck(99);
		Player player1 = PlayerFactory.createPlayer("Brett", 20);
		player1.setDeck(deck1);
		Player player2 = PlayerFactory.createPlayer("Erin", 20);
		player2.setDeck(deck2);
		GameBuilder gameBuilder = new GameBuilder();
		Game game = gameBuilder.addPlayer(player1).addPlayer(player2).setNumTurns(4).createGame();
		game.start();
	}

}
