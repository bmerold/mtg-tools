package com.merold.magictools.game;

import java.util.ArrayList;
import java.util.List;

import com.merold.magictools.player.Player;

public class GameBuilder {
	
	List<Player> players = new ArrayList<Player>();
	int numTurns = 0;
	
	public GameBuilder addPlayer(Player player) {
		players.add(player);
		return this;
	}
	
	public GameBuilder setNumTurns(int numTurns) {
		this.numTurns = numTurns;
		return this;
	}
	
	public Game createGame() {
		Game game = new GameImpl(this.players, this.numTurns);
		return game;
	}

}
