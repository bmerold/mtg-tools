package com.merold.magictools.game;

import java.util.List;

import com.merold.magictools.action.Action;
import com.merold.magictools.phase.Phase;
import com.merold.magictools.player.Player;
import com.merold.magictools.step.Step;

public interface Game {

	public void start();
	public List<Player> getPlayers();
	public void executeAction(Action action);
	public Player getActivePlayer();
	public void setStartingPlayer(Player startingPlayer);
	public void setTurnOrder();
	public void giveActivePlayerPriority();
	public void setCurrentPhase(Phase phase);
	public void setCurrentStep(Step step);
	public Phase getCurrentPhase();
	public Step getCurrentStep();
	public void passPriority(Player player);
	public void resolve();
}
