package com.merold.magictools.step;

import com.merold.magictools.game.Game;

public class EndStepImpl extends StepWithPriority implements EndStep {

	public EndStepImpl(Game game) {
		super(game);
		name = "end";
	}

}
