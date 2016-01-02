package com.merold.magictools.phase;

import java.util.List;

import com.merold.magictools.player.Player;

public abstract class PhaseImpl implements Phase {
	
	@Override
	public void end(List<Player> players) {
		for (Player player : players) {
			player.emptyManaPool();
		}
	}

}
