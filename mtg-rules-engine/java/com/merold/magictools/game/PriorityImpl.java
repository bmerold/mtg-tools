package com.merold.magictools.game;

import com.merold.magictools.player.Player;

public class PriorityImpl implements Priority {
	
	private Player owner;

	@Override
	public void setOwner(Player owner) {
		this.owner = owner;
	}

}
