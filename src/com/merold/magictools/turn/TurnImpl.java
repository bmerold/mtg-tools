package com.merold.magictools.turn;

import java.util.List;

import com.merold.magictools.phase.BeginningPhase;
import com.merold.magictools.phase.BeginningPhaseImpl;
import com.merold.magictools.phase.CombatPhase;
import com.merold.magictools.phase.CombatPhaseImpl;
import com.merold.magictools.phase.EndingPhase;
import com.merold.magictools.phase.EndingPhaseImpl;
import com.merold.magictools.phase.MainPhase;
import com.merold.magictools.phase.MainPhaseImpl;
import com.merold.magictools.phase.PostCombatMainPhaseImpl;
import com.merold.magictools.player.Player;

public class TurnImpl implements Turn {

	private BeginningPhase beginning;
	private MainPhase main;
	private MainPhase secondMain;
	private CombatPhase combat;
	private EndingPhase end;
	private Player activePlayer;
	private List<Player> players;
	
	public TurnImpl(List<Player> players, Player activePlayer) {
		beginning = new BeginningPhaseImpl();
		main = new MainPhaseImpl();
		secondMain = new PostCombatMainPhaseImpl();
		combat = new CombatPhaseImpl();
		end = new EndingPhaseImpl();
		this.players = players;
		this.activePlayer = activePlayer;
	}

	@Override
	public void play() {
		beginning.start();
		beginning.end(players);
		main.start();
		main.end(players);
		combat.start();
		combat.end(players);
		secondMain.start();
		secondMain.end(players);
		end.start();
		end.end(players);
	}
}
