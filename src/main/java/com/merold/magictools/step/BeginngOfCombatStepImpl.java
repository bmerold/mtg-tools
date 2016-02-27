package com.merold.magictools.step;

import com.merold.magictools.game.Game;

public class BeginngOfCombatStepImpl extends StepWithPriority implements BeginningOfCombatStep {

	public BeginngOfCombatStepImpl(Game game) {
		super(game);
		name = "beginning of combat";
	}

}
