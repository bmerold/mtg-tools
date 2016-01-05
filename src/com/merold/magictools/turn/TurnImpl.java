package com.merold.magictools.turn;

import java.util.List;

import com.merold.magictools.game.Game;
import com.merold.magictools.phase.BeginningPhase;
import com.merold.magictools.phase.BeginningPhaseImpl;
import com.merold.magictools.phase.CombatPhase;
import com.merold.magictools.phase.CombatPhaseImpl;
import com.merold.magictools.phase.EndingPhase;
import com.merold.magictools.phase.EndingPhaseImpl;
import com.merold.magictools.phase.MainPhase;
import com.merold.magictools.phase.MainPhaseImpl;
import com.merold.magictools.phase.MainPhaseType;
import com.merold.magictools.player.Player;

public class TurnImpl implements Turn {

	private BeginningPhase beginning;
	private MainPhase preCombatMain;
	private MainPhase postCombatMain;
	private CombatPhase combat;
	private EndingPhase end;
	private Player activePlayer;
	private List<Player> players;
	private Game game;
	
	public TurnImpl(Game game, List<Player> players, Player activePlayer) {
		beginning = new BeginningPhaseImpl(game);
		preCombatMain = new MainPhaseImpl(game, MainPhaseType.PRECOMBAT);
		postCombatMain = new MainPhaseImpl(game, MainPhaseType.POSTCOMBAT);
		combat = new CombatPhaseImpl(game);
		end = new EndingPhaseImpl(game);
		this.players = players;
		this.activePlayer = activePlayer;
	}

	@Override
	public void play() {
		beginning.start();
		preCombatMain.start();
		combat.start();
		combat.end();
		postCombatMain.start();
		end.start();
		end.end();
	}
}
