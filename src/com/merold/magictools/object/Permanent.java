package com.merold.magictools.object;

import com.merold.magictools.player.Player;

public interface Permanent extends Object {
	
	public Player getOwner();
	
	public Player getController();

}
