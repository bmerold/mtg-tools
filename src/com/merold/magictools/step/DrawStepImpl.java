package com.merold.magictools.step;

import com.merold.magictools.action.ActionFactory;
import com.merold.magictools.action.DrawAction;
import com.merold.magictools.game.Game;

public class DrawStepImpl extends StepImpl implements DrawStep {

	public DrawStepImpl(Game game) {
		super(game);
	}

	@Override
	public void start() {
		DrawAction draw = ActionFactory.createDrawAction(game.getActivePlayer());
		game.executeAction(draw);
	}

}
