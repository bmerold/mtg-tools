package com.merold.magictools.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.merold.magictools.action.Action;
import com.merold.magictools.manabase.GameStartHandler;
import com.merold.magictools.phase.Phase;
import com.merold.magictools.player.Player;
import com.merold.magictools.step.Step;
import com.merold.magictools.turn.Turn;
import com.merold.magictools.turn.TurnImpl;
import com.merold.magictools.zones.Battlefield;
import com.merold.magictools.zones.Command;
import com.merold.magictools.zones.Exile;
import com.merold.magictools.zones.Stack;

public class GameImpl implements Game {

	/* Game's zones. */
	private Battlefield battlefield;
	private Stack stack;
	private Exile exile;
	private Command command;
	
	/* Game's turn/phase/step. */
	private Phase currentPhase;
	private Step currentStep;
	
	private List<Player> players = new ArrayList<Player>();
	private int numTurns;
	private Player activePlayer;
	private Player startingPlayer;
	private PriorityHandler priorityHandler;
	
	public GameImpl(Player player) {
		players.add(player);
		numTurns = 0;
		priorityHandler = new PriorityHandler(this);
	}
	
	public GameImpl(Player player, int numTurns) {
		players.add(player);
		this.numTurns = numTurns;
		priorityHandler = new PriorityHandler(this);
	}
	
	public GameImpl(List<Player> players) {
		this.players.addAll(players);
		priorityHandler = new PriorityHandler(this);
	}
	
	public GameImpl(List<Player> players, int numTurns) {
		this.players.addAll(players);

		for (Player player : players) {
			player.joinGame(this);
		}
		this.numTurns = numTurns;
		priorityHandler = new PriorityHandler(this);
	}
	
	@Override
	public void start() {
		GameStartHandler start = new GameStartHandler(this);
		start.startGame();
		if (numTurns > 0) {
			for (int i = 1; i <= numTurns; i++) {
				for (Player player : players) {
					this.activePlayer = player;
					System.out.println(player.getName() + " is starting their turn " + i);
					Turn turn = new TurnImpl(this, players, activePlayer);
					turn.play();
				}
			}
		}
		
		//Testing purposes
		for (Player player : players) {
			player.revealHand();
		}
	}
	
	@Override
	public List<Player> getPlayers() {
		return players;
	}

	@Override
	public void executeAction(Action action) {
		action.execute();
	}

	@Override
	public Player getActivePlayer() {
		return this.activePlayer;
	}

	@Override
	public void setStartingPlayer(Player startingPlayer) {
		startingPlayer.setStartingPlayer();
		this.startingPlayer = startingPlayer;
		
	}

	@Override
	public void setTurnOrder() {
		Collections.sort(this.players);
		System.out.print("Turn order: ");
		for (Player player : players) {
			System.out.print(player.getName() + ",");
		}
		System.out.print(".\r\n");
	}

	@Override
	public void giveActivePlayerPriority() {
		priorityHandler.giveActivePlayerPriority(activePlayer);
		
	}

	@Override
	public void setCurrentPhase(Phase phase) {
		this.currentPhase = phase;
	}

	@Override
	public void setCurrentStep(Step step) {
		this.currentStep = step;
	}

	@Override
	public Phase getCurrentPhase() {
		return currentPhase;
	}

	@Override
	public Step getCurrentStep() {
		return currentStep;
	}

	@Override
	public void passPriority(Player player) {
		priorityHandler.passPriority(player);
		
	}

	@Override
	public void resolve() {
		if (stack == null || stack.isStackEmpty()) {
			currentStep.end();
		}
	}
}
