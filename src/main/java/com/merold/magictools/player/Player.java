package com.merold.magictools.player;

import com.merold.magictools.game.Game;
import com.merold.magictools.game.Priority;
import com.merold.magictools.game.TurnOrder;
import com.merold.magictools.zones.Deck;

public interface Player extends Comparable<Player>{
	public TurnOrder chooseTurnOrder();
	public String getName();
	public void shuffleDeck();
	public void drawStartingHand();
	public void revealHand();
	public void emptyManaPool();
	public void drawCard();
	public void setStartingPlayer();
	public boolean isStartingPlayer();
	public void setDeck(Deck deck);
	public void initializeLibrary();
	public void receivePriority(Priority priority);
	public void passPriority();
	public void joinGame(Game game);
	public void declareAttackers();
}
