package com.merold.magictools.step;

import com.merold.magictools.game.Game;

public class DeclareBlockersStepImpl extends StepWithPriority implements DeclareBlockersStep {

	public DeclareBlockersStepImpl(Game game) {
		super(game);
		name = "declare blockers";
	}

}
