package com.merold.magictools;

public class PlayerImpl implements Player {

	private String name;
	private Deck deck;
	private Hand hand;
	
	public PlayerImpl(String name, Deck deck) {
		this.name = name;
		this.deck = deck;
		this.hand = HandFactory.createHand(deck);
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

}
