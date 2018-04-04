package com.merold.magictools.step;

import com.merold.magictools.game.Game;

public abstract class StepImpl implements Step {
	
	protected Game game;
	protected String name;
	
	public StepImpl(Game game) {
		this.game = game;
	}
	
	@Override
	public void end() {
		System.out.println("Ending the " + name + " step.");
		game.setCurrentStep(null);
	}
	
	protected void setCurrentStep(){
		game.setCurrentStep(this);
	}

}
