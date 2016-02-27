package com.merold.magictools.phase;


import com.merold.magictools.game.Game;

public class MainPhaseImpl extends PhaseImpl implements MainPhase {
	
	private final MainPhaseType mainPhaseType;

	public MainPhaseImpl(Game game, MainPhaseType mainPhaseType) {
		super(game);
		this.mainPhaseType = mainPhaseType;
		if (mainPhaseType == MainPhaseType.PRECOMBAT) {
			this.phaseName = "precombat main";
		} else {
			this.phaseName = "postcombat main";
		}
	}

	@Override
	public void start() {
		System.out.println("Starting the " + phaseName + " phase.");
		game.setCurrentPhase(this);
		game.giveActivePlayerPriority();
	}

}
