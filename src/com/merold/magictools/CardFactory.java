package com.merold.magictools;

import java.util.HashMap;
import java.util.Map;

public class CardFactory {
	
	private static Map<String, Card> cardCache = new HashMap<String, Card>();

	public static Card createCard(final String name) {
		Card card;
		if (cardCache.containsKey(name)) {
			card = new CardImpl(cardCache.get(name));
		} else {
			card = new CardImpl(name);
			cardCache.put(name, card);
		}
		return card;
	}
}
