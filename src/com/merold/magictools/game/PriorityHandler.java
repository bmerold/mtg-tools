package com.merold.magictools.game;

import com.merold.magictools.player.Player;

public class PriorityHandler {
	
	private Priority priority;
	private int consecutivePasses = 0;
	private Game game;
	
	public PriorityHandler(Game game) {
		priority = new PriorityImpl();
		this.game = game;
	}
	
	public void giveActivePlayerPriority(Player activePlayer) {
		priority.setOwner(activePlayer);
		consecutivePasses = 0;
		System.out.println("Active player " + activePlayer.getName() + " receives priority.");
		activePlayer.receivePriority(priority);
	}

	public void passPriority(Player currentPlayer) {
		System.out.println("Player " + currentPlayer.getName() + " passes priority.");
		priority.setOwner(null);
		consecutivePasses++;
		
		/* Only give the next player priority if they haven't passed already. */
		if(consecutivePasses < game.getPlayers().size()) {
			Player nextPlayer = getNextPlayer(currentPlayer);
			System.out.println("Player " + nextPlayer.getName() + " receives priority.");
			nextPlayer.receivePriority(priority);
		} else {
			game.resolve();
		}
	}
	
	private Player getNextPlayer(Player currentPlayer) {
		boolean found = false;
		Player nextPlayer = null;
		for (Player player : game.getPlayers()) {
			/* If in the last iteration the player was found then the next player is the player in the current iteration. */
			if (found) {
				nextPlayer = player;
				break;
			}
			/* Found the current player, set found to true to grab the next player in the next iteration. */
			if (player == currentPlayer) {
				found = true;
			}
		}
		
		/* Current Player was at the end of the list. */
		if (found && nextPlayer == null) {
			nextPlayer = game.getPlayers().get(0);
		}
		
		if (nextPlayer == null) {
			throw new RuntimeException("Couldn't find the next player to receive priority.");
		}
		
		return nextPlayer;
	}
}
