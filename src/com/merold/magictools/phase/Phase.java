package com.merold.magictools.phase;

import java.util.List;

import com.merold.magictools.player.Player;

public interface Phase {
	
	public void end(List<Player> players);
	public void start();

}
