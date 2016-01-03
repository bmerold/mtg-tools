package com.merold.magictools.phase;

import com.merold.magictools.game.Game;
import com.merold.magictools.step.CleanupStep;
import com.merold.magictools.step.CleanupStepImpl;
import com.merold.magictools.step.EndStep;
import com.merold.magictools.step.EndStepImpl;

public class EndingPhaseImpl extends PhaseImpl implements EndingPhase {
	
	private EndStep end;
	private CleanupStep cleanup;
	
	public EndingPhaseImpl(Game game) {
		super(game);
		end = new EndStepImpl(game);
		cleanup = new CleanupStepImpl(game);
	}

	@Override
	public void start() {
		end.start();
		cleanup.start();
		
	}

}
