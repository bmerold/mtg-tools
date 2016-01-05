package com.merold.magictools.step;

import com.merold.magictools.game.Game;

public class UpkeepStepImpl extends StepWithPriority implements UpkeepStep {

	public UpkeepStepImpl(Game game) {
		super(game);
		name = "upkeep";
	}

}
