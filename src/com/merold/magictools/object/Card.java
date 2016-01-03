package com.merold.magictools.object;

import com.merold.magictools.player.Player;

public interface Card extends Object {
	
	public String getName();
	public Player getOwner();
	public void setOwner(Player player);

}
