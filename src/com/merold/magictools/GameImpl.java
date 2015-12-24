package com.merold.magictools;

import java.util.ArrayList;
import java.util.List;

import com.merold.magictools.manabase.GameStartHandler;

public class GameImpl implements Game {

	private List<Player> players = new ArrayList<Player>();
	
	public GameImpl(Player player) {
		players.add(player);
	}
	
	public GameImpl(List<Player> players) {
		this.players.addAll(players);
	}
	
	@Override
	public void start() {
		GameStartHandler start = new GameStartHandler(this);
		start.startGame();

	}
	
	@Override
	public List<Player> getPlayers() {
		return players;
	}

}
