package com.merold.magictools.phase;

import com.merold.magictools.game.Game;
import com.merold.magictools.step.BeginngOfCombatStepImpl;
import com.merold.magictools.step.BeginningOfCombatStep;
import com.merold.magictools.step.CombatDamageStep;
import com.merold.magictools.step.CombatDamageStepImpl;
import com.merold.magictools.step.DeclareAttackersStep;
import com.merold.magictools.step.DeclareAttackersStepImpl;
import com.merold.magictools.step.DeclareBlockersStep;
import com.merold.magictools.step.DeclareBlockersStepImpl;
import com.merold.magictools.step.EndOfCombatStep;
import com.merold.magictools.step.EndOfCombatStepImpl;

public class CombatPhaseImpl extends PhaseImpl implements CombatPhase {
	private BeginningOfCombatStep begin;
	private DeclareAttackersStep attackers;
	private DeclareBlockersStep blockers;
	private CombatDamageStep damage;
	private EndOfCombatStep end;
	
	public CombatPhaseImpl(Game game) {
		super(game);
		begin = new BeginngOfCombatStepImpl(game);
		attackers = new DeclareAttackersStepImpl(game);
		blockers = new DeclareBlockersStepImpl(game);
		damage = new CombatDamageStepImpl(game);
		end = new EndOfCombatStepImpl(game);
	}

	@Override
	public void start() {
		begin.start();
		attackers.start();
		blockers.start();
		damage.start();
		end.start();
		
	}
}
