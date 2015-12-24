package com.merold.magictools.manabase;

import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;
import com.merold.magictools.Game;
import com.merold.magictools.Player;
import com.merold.magictools.TurnOrder;

public class GameStartHandler {
	
	private Game game;
	
	public GameStartHandler(Game game) {
		this.game = game;
	}
	
	public void startGame() {
		System.out.println("Starting game.");
		System.out.println("Each player shuffles their decks");
		shuffleDecks();
		System.out.println("Determine which player chooses to go first or draw.");
		Player first = determineFirst();
		TurnOrder turnOrder = first.chooseTurnOrder();
		System.out.println("Player " + first.getName() + " has chosen " + turnOrder + ".");
		System.out.println("Players draw starting hands.");
		drawStartingHands();
		showHands();
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
		System.out.println("Player " + first.getName() + " won the roll with a " + rolls.lastKey() + ".");
		System.out.println("Player " + first.getName() + " gets to choose.");
		return first;
	}

}
