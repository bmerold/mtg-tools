package com.merold.magictools.zones;

import com.merold.magictools.object.Card;

public class LibraryImpl extends Zone implements Library {
	
	private Deck deck;
	
	public LibraryImpl(Deck deck) {
		this.deck = deck;
	}

	@Override
	public Card getTopCard() {
		return deck.draw();
	}

	@Override
	public int count() {
		return deck.size();
	}

	@Override
	public void shuffle() {
		deck.shuffle();
	}
}
