package com.merold.magictools.action;

import com.merold.magictools.player.Player;

public class DrawAction extends TurnBasedAction implements Action {

	private Player player;
	
	public DrawAction(Player player) {
		this.player = player;
	}
	@Override
	public void execute() {
		player.drawCard();
	}

}
