package com.merold.magictools.player;

import com.merold.magictools.game.TurnOrder;
import com.merold.magictools.zones.Deck;
import com.merold.magictools.zones.Hand;
import com.merold.magictools.zones.HandFactory;

public class PlayerImpl implements Player {

	private String name;
	private Deck deck;
	private Hand hand;
	private ManaPool manaPool;
	
	public PlayerImpl(String name, Deck deck) {
		this.name = name;
		this.deck = deck;
		this.hand = HandFactory.createHand(deck);
		this.manaPool = ManaPoolFactory.createManaPool();
	}
	
	@Override
	public TurnOrder chooseTurnOrder() {
		return TurnOrder.FIRST;
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void shuffleDeck() {
		deck.shuffle();
	}
	
	@Override
	public void drawStartingHand() {
		hand.drawStartingHand();
	}
	
	@Override
	public void revealHand() {
		System.out.println(name + " reveals hand: ");
		hand.revealHand();
	}

	@Override
	public void emptyManaPool() {
		manaPool.empty();
		//System.out.println(name + " emptied mana pool.");
		
	}

	@Override
	public void drawCard() {
		hand.draw();
		
	}

}
