package com.merold.magictools.zones;

import com.merold.magictools.object.Card;
import com.merold.magictools.player.Player;

public interface Deck {
	
	public Card draw();
	public void shuffle();
	public void add(Card card);
	public int size();
	public void setOwner(Player owner);

}
