package com.merold.magictools.zones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.merold.magictools.object.Card;
import com.merold.magictools.player.Player;

public class DeckImpl extends Zone implements Deck {
	
	Deque<Card> deck = new LinkedList<Card>();

	@Override
	public Card draw() {
		return deck.removeFirst();
	}

	@Override
	public void shuffle() {
		final List<Card> deckList = new ArrayList<Card>(deck);
		Collections.shuffle(deckList);
		deck = new LinkedList<Card>(deckList);
	}

	@Override
	public void add(Card card) {
		deck.addFirst(card);
	}
	
	@Override
	public int size() {
		return deck.size();
	}

	@Override
	public void setOwner(Player owner) {
		for (Card card : deck) {
			card.setOwner(owner);
		}
		
	}

}
