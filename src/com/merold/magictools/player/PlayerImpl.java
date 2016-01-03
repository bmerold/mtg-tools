package com.merold.magictools.player;

import com.merold.magictools.game.Game;
import com.merold.magictools.game.Priority;
import com.merold.magictools.game.TurnOrder;
import com.merold.magictools.object.Card;
import com.merold.magictools.zones.Deck;
import com.merold.magictools.zones.Graveyard;
import com.merold.magictools.zones.Hand;
import com.merold.magictools.zones.HandFactory;
import com.merold.magictools.zones.Library;
import com.merold.magictools.zones.LibraryFactory;

public class PlayerImpl implements Player {

	/* Player's zones. */
	private Hand hand;
	private Library library;
	private Graveyard graveyard;
	
	/* Player's characteristics. */
	private String name;
	private boolean startingPlayer;
	private int maximumHandSize = 7;
	private int lifeTotal;
	private int startingLifeTotal;
	
	private Deck deck;
	private ManaPool manaPool;
	private Priority priority;
	private Game game;

	public PlayerImpl(String name, int startingLifeTotal) {
		this.name = name;
		this.hand = HandFactory.createHand();
		this.manaPool = ManaPoolFactory.createManaPool();
		this.startingPlayer = false;
		this.lifeTotal = startingLifeTotal;
		this.startingLifeTotal = startingLifeTotal;
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
		for (int i = 1; i <= maximumHandSize; i++) {
			Card card = library.getTopCard();
			hand.put(card);
		}
	}

	@Override
	public void revealHand() {
		System.out.println(name + " reveals hand: ");
		hand.revealHand();
	}

	@Override
	public void emptyManaPool() {
		manaPool.empty();
		// System.out.println(name + " emptied mana pool.");
	}

	@Override
	public void drawCard() {
		hand.put(library.getTopCard());
	}

	@Override
	public void setStartingPlayer() {
		this.startingPlayer = true;
	}

	@Override
	public boolean isStartingPlayer() {
		return this.startingPlayer;
	}

	@Override
	public int compareTo(Player otherPlayer) {
		if (otherPlayer.isStartingPlayer() && startingPlayer) {
			throw new RuntimeException("Two players cannot be the starting player.");
		} else if (!otherPlayer.isStartingPlayer() && startingPlayer) {
			return -1;
		} else {
			return 1;
		}
	}

	@Override
	public void setDeck(Deck deck) {
		this.deck = deck;
		deck.setOwner(this);

	}

	@Override
	public void initializeLibrary() {
		this.library = LibraryFactory.createLibrary(deck);
	}

	@Override
	public void receivePriority(Priority priority) {
		this.priority = priority;
		/* Either take an action or pass priority. */
		passPriority();
	}

	@Override
	public void passPriority() {
		this.priority = null;
		game.passPriority(this);
	}

	@Override
	public void joinGame(Game game) {
		this.game = game;
	}

}
