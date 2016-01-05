package com.merold.magictools.step;

import com.merold.magictools.game.Game;

public class CombatDamageStepImpl extends StepWithPriority implements CombatDamageStep {

	public CombatDamageStepImpl(Game game) {
		super(game);
		name = "combat damage";
	}

}
