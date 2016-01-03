package com.merold.magictools.action;

import com.merold.magictools.player.Player;

public class ActionFactory {
	
	public static DrawAction createDrawAction(Player player) {
		return new DrawAction(player);
	}

}
