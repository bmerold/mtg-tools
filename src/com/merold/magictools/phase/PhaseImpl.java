package com.merold.magictools.phase;

import java.util.List;

import com.merold.magictools.game.Game;
import com.merold.magictools.player.Player;

public abstract class PhaseImpl implements Phase {
	
	private Game game;
	
	public PhaseImpl(Game game) {
		this.game = game;
	}
	
	@Override
	public void end(List<Player> players) {
		for (Player player : players) {
			player.emptyManaPool();
		}
	}

}
