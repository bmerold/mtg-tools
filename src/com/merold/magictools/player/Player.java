package com.merold.magictools.player;

import com.merold.magictools.game.TurnOrder;

public interface Player {
	public TurnOrder chooseTurnOrder();
	public String getName();
	public void shuffleDeck();
	public void drawStartingHand();
	public void revealHand();
	public void emptyManaPool();
	public void drawCard();

}
