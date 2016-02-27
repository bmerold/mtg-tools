package com.merold.magictools.phase;

import com.merold.magictools.game.Game;
import com.merold.magictools.player.Player;

public abstract class PhaseImpl implements Phase {

	protected Game game;
	protected String phaseName;

	public PhaseImpl(Game game) {
		this.game = game;
	}

	public void end() {
		System.out.println("Ending the " + phaseName + " phase.");
		game.setCurrentPhase(null);

		for (Player player : game.getPlayers()) {
			player.emptyManaPool();
		}
	}

}
