package com.merold.magictools;

import java.util.ArrayList;
import java.util.List;

public class HandImpl implements Hand {

	private List<Card> hand = new ArrayList<Card>();
	private Deck deck;
	private int startingHandSize;

	public HandImpl(Deck deck, int startingHandSize) {
		this.deck = deck;
		this.startingHandSize = startingHandSize;
	}

	@Override
	public void draw() {
		hand.add(deck.draw());
	}

	@Override
	public int size() {
		return hand.size();
	}

	@Override
	public String revealHand() {
		StringBuilder sb = new StringBuilder();
		for (Card card : hand) {
			System.out.println("\t" + card.getName());
		}
		return sb.toString();
	}

	@Override
	public void drawStartingHand() {
		for (int i = 0; i < startingHandSize; i++) {
			draw();
		}
	}
}
