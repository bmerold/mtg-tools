package com.merold.magictools.zones;

import java.util.ArrayList;
import java.util.List;

import com.merold.magictools.object.Card;

public class HandImpl extends Zone implements Hand {

	private List<Card> hand = new ArrayList<Card>();

	public HandImpl() {
	}

	@Override
	public void put(Card card) {
		hand.add(card);
	}

	@Override
	public int count() {
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
}
