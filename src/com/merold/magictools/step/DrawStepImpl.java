package com.merold.magictools.step;

import com.merold.magictools.action.ActionFactory;
import com.merold.magictools.action.DrawAction;
import com.merold.magictools.game.Game;

public class DrawStepImpl extends StepWithPriority implements DrawStep {

	public DrawStepImpl(Game game) {
		super(game);
		name = "draw";
	}

	@Override
	public void start() {
		setCurrentStep();
		System.out.println("Starting the draw step.");
		System.out.println(game.getActivePlayer().getName() + " draws their card for the turn.");
		DrawAction draw = ActionFactory.createDrawAction(game.getActivePlayer());
		game.executeAction(draw);
		game.giveActivePlayerPriority();
	}

}
