package com.merold.magictools.step;

import com.merold.magictools.game.Game;

public class EndOfCombatStepImpl extends StepWithPriority implements EndOfCombatStep {

	public EndOfCombatStepImpl(Game game) {
		super(game);
		name = "end of combat";
	}

}
