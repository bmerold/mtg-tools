package com.merold.magictools.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.merold.magictools.action.Action;
import com.merold.magictools.manabase.GameStartHandler;
import com.merold.magictools.phase.MainPhase;
import com.merold.magictools.phase.Phase;
import com.merold.magictools.player.Player;
import com.merold.magictools.step.Step;
import com.merold.magictools.turn.Turn;
import com.merold.magictools.turn.TurnImpl;
import com.merold.magictools.zones.Battlefield;
import com.merold.magictools.zones.BattlefieldFactory;
import com.merold.magictools.zones.Command;
import com.merold.magictools.zones.Exile;
import com.merold.magictools.zones.Stack;
import com.merold.magictools.zones.StackFactory;

public class GameImpl implements Game {

	/* Game's zones. */
	private Battlefield battlefield = BattlefieldFactory.createBattlefield();
	private Stack stack = StackFactory.createStack();
	private Exile exile;
	private Command command;
	
	/* Game's turn/phase/step. */
	private Phase currentPhase;
	private Step currentStep;
	
	private List<Player> players = new ArrayList<Player>();
	private int numTurns;
	private Player activePlayer;
	private Player startingPlayer;
	private PriorityHandler priorityHandler = new PriorityHandler(this);
	
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

		for (Player player : players) {
			player.joinGame(this);
		}
		this.numTurns = numTurns;
	}
	
	@Override
	public void start() {
		GameStartHandler start = new GameStartHandler(this);
		start.startGame();
		if (numTurns > 0) {
			for (int i = 1; i <= numTurns; i++) {
				for (Player player : players) {
					this.activePlayer = player;
					System.out.println(player.getName() + " is starting their turn " + i + ".");
					Turn turn = new TurnImpl(this, players, activePlayer);
					turn.play();
				}
			}
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
			if (currentPhase instanceof MainPhase) {
				currentPhase.end();
			} else {
				currentStep.end();
			}
		}
	}

	@Override
	public boolean areThereAttackers() {
		return false;
	}

	@Override
	public void declareAttackers() {
		activePlayer.declareAttackers();
		
	}
}
