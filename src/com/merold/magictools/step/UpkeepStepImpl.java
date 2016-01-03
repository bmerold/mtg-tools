package com.merold.magictools.step;

import com.merold.magictools.game.Game;

public class UpkeepStepImpl extends StepImpl implements UpkeepStep {

	public UpkeepStepImpl(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start() {
		setCurrentStep();
		System.out.println("Starting the upkeep step.");
		game.giveActivePlayerPriority();
	}
	
	@Override
	public void end() {
		System.out.println("Ending the upkeep step.");
	}
	
	@Override
	public void setCurrentStep(){
		game.setCurrentStep(this);
	}

}
