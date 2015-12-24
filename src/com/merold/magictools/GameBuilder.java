package com.merold.magictools;

import java.util.ArrayList;
import java.util.List;

public class GameBuilder {
	
	List<Player> players = new ArrayList<Player>();
	
	public GameBuilder addPlayer(Player player) {
		players.add(player);
		return this;
	}
	
	public Game createGame() {
		return new GameImpl(this.players);
	}

}
