package com.merold.magictools;

public class DeckFactory {
	
	public static Deck createDeck(int size) {
		Deck deck = new DeckImpl();
		for (int i = 0; i < size; i++) {
			if (i<39) {
				deck.add(CardFactory.createCard("Forest"));
			} else {
				deck.add(CardFactory.createCard("Spell"));
			}
		}
		return deck;
	}

}
