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
		phaseName = "ending";
	}

	@Override
	public void start() {
		System.out.println("Starting the ending phase.");
		game.setCurrentPhase(this);
		end.start();
		cleanup.start();
		
	}

}
