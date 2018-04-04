package com.merold.magictools.step;

import com.merold.magictools.game.Game;

public class UntapStepImpl extends StepImpl implements UntapStep {

	public UntapStepImpl(Game game) {
		super(game);
		name = "untap";
	}

	@Override
	public void start() {
		setCurrentStep();
		System.out.println("Starting the untap step.");
		System.out.println(game.getActivePlayer().getName() + " untaps their permanents.");
		game.resolve();
	}

}
