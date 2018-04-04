package com.merold.magictools.step;

import com.merold.magictools.game.Game;

public abstract class StepWithPriority extends StepImpl implements Step {

	public StepWithPriority(Game game) {
		super(game);
	}
	
	@Override
	public void start() {
		setCurrentStep();
		System.out.println("Starting the " + name + " step.");
		game.giveActivePlayerPriority();
	}
	


}
