package com.merold.magictools.phase;

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
	
	public BeginningPhaseImpl() {
		untap = new UntapStepImpl();
		upkeep = new UpkeepStepImpl();
		draw = new DrawStepImpl();
	}

	@Override
	public void start() {
		untap.start();
		upkeep.start();
		draw.start();
	}
	
	

}
