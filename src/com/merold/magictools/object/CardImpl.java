package com.merold.magictools.object;

import com.merold.magictools.characteristics.Subtype;
import com.merold.magictools.characteristics.Supertype;
import com.merold.magictools.characteristics.Type;

public class CardImpl implements Card {
	private String name;
	
	public CardImpl (final String name) {
		this.name = name;
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
}
