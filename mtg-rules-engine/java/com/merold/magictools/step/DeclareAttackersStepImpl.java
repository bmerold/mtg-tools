package com.merold.magictools.step;

import com.merold.magictools.game.Game;

public class DeclareAttackersStepImpl extends StepWithPriority implements DeclareAttackersStep {

	public DeclareAttackersStepImpl(Game game) {
		super(game);
		name = "declare attackers";
	}
	
	@Override
	public void start() {
		setCurrentStep();
		System.out.println("Starting the " + name + " step.");
		game.declareAttackers();
		game.giveActivePlayerPriority();
	}

}
