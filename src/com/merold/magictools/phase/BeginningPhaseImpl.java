package com.merold.magictools.phase;

import com.merold.magictools.game.Game;
import com.merold.magictools.step.DrawStep;
import com.merold.magictools.step.DrawStepImpl;
import com.merold.magictools.step.UntapStep;
import com.merold.magictools.step.UntapStepImpl;
import com.merold.magictools.step.UpkeepStep;
import com.merold.magictools.step.UpkeepStepImpl;

public class BeginningPhaseImpl extends PhaseImpl implements BeginningPhase {
	
	private UntapStep untap;
	private UpkeepStep upkeep;
	private DrawStep draw;
	
	public BeginningPhaseImpl(Game game) {
		super(game);
		untap = new UntapStepImpl(game);
		upkeep = new UpkeepStepImpl(game);
		draw = new DrawStepImpl(game);
		phaseName = "beginning";
	}

	@Override
	public void start() {
		System.out.println("Starting the beginning phase.");
		this.game.setCurrentPhase(this);
		untap.start();
		upkeep.start();
		draw.start();
		end();
	}
}
