package com.merold.magictools.game;

import java.util.List;

import com.merold.magictools.player.Player;

public interface Game {

	public void start();
	public List<Player> getPlayers();
}
