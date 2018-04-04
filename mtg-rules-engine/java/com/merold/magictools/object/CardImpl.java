package com.merold.magictools.object;

import com.merold.magictools.characteristics.Subtype;
import com.merold.magictools.characteristics.Supertype;
import com.merold.magictools.characteristics.Type;
import com.merold.magictools.player.Player;

public class CardImpl implements Card {
	private String name;
	private Player owner;
	private String cardTypes;
	private Type types;
	private Supertype supertypes;
	private Subtype subtypes;
	
	public CardImpl (final String name, final String types) {
		this.name = name;
		this.cardTypes = types;
	}
	
	public CardImpl (final Card card) {
		this.name = card.getName();
	}
	
	public String getName() {
		return name;
	}

	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Supertype getSuperType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Subtype getSubtype() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player getOwner() {
		return owner;
	}

	@Override
	public void setOwner(Player owner) {
		this.owner = owner;
	}
}
