package com.merold.magictools.game;

import java.util.ArrayList;
import java.util.List;

import com.merold.magictools.manabase.GameStartHandler;
import com.merold.magictools.player.Player;
import com.merold.magictools.turn.Turn;
import com.merold.magictools.turn.TurnImpl;

public class GameImpl implements Game {

	private List<Player> players = new ArrayList<Player>();
	private int numTurns;
	
	public GameImpl(Player player) {
		players.add(player);
		numTurns = 0;
	}
	
	public GameImpl(Player player, int numTurns) {
		players.add(player);
		this.numTurns = numTurns;
	}
	
	public GameImpl(List<Player> players) {
		this.players.addAll(players);
	}
	
	public GameImpl(List<Player> players, int numTurns) {
		this.players.addAll(players);
		this.numTurns = numTurns;
	}
	
	@Override
	public void start() {
		GameStartHandler start = new GameStartHandler(this);
		start.startGame();
		if (numTurns > 0) {
			for (int i = 0; i < numTurns; i++) {
				for (Player player : players) {
					Turn turn = new TurnImpl(players, player);
					turn.play();
				}
			}
		}
	}
	
	@Override
	public List<Player> getPlayers() {
		return players;
	}

}
