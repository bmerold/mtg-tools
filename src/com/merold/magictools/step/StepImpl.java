package com.merold.magictools.step;

import com.merold.magictools.game.Game;

public abstract class StepImpl implements Step {
	
	protected Game game;
	
	public StepImpl(Game game) {
		this.game = game;
	}

	@Override
	public void start() {

	}
	
	@Override
	public void end() {
		
	}
	
	protected void setCurrentStep() {
		game.setCurrentStep(this);
	}

}
