package com.merold.magictools.manabase;

import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

import com.merold.magictools.game.Game;
import com.merold.magictools.game.TurnOrder;
import com.merold.magictools.player.Player;

public class GameStartHandler {
	
	private Game game;
	
	public GameStartHandler(Game game) {
		this.game = game;
	}
	
	public void startGame() {
		System.out.println("Starting game.");
		System.out.println("Each player shuffles their decks");
		shuffleDecks();
		initializeLibraries();
		System.out.println("Determine which player chooses to go first or draw.");
		Player first = determineFirst();
		TurnOrder turnOrder = first.chooseTurnOrder();
		System.out.println(first.getName() + " has chosen " + turnOrder + ".");
		System.out.println("Players draw starting hands.");
		game.setStartingPlayer(first);
		game.setTurnOrder();
		drawStartingHands();
	}
	
	private void initializeLibraries() {
		for (Player player : game.getPlayers()) {
			player.initializeLibrary();
		}
	}

	private void showHands() {
		for (Player player : game.getPlayers()) {
			player.revealHand();
		}
	}

	private void drawStartingHands() {
		for (Player player : game.getPlayers()) {
			player.drawStartingHand();
		}
	}

	private void shuffleDecks() {
		for (Player player : game.getPlayers()) {
			System.out.println("Shuffling " + player.getName() + "'s deck.");
			player.shuffleDeck();
		}
	}
	
	private Player determineFirst() {
		SortedMap<Integer, Player> rolls = new TreeMap<Integer, Player>();
		Random random = new Random();
		for (Player player : game.getPlayers()) {
			Integer roll;
			do {
				roll = random.nextInt(20);
			} while (rolls.containsKey(roll));
			rolls.put(random.nextInt(20), player);
		}
		
		Player first = rolls.get(rolls.lastKey());
		System.out.println(first.getName() + " won the roll with a " + rolls.lastKey() + ".");
		return first;
	}

}
