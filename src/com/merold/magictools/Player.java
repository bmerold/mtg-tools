package com.merold.magictools;

public interface Player {
	public TurnOrder chooseTurnOrder();
	public String getName();
	public void shuffleDeck();
	public void drawStartingHand();
	public void revealHand();

}
