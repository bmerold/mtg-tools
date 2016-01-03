package com.merold.magictools.characteristics;

import java.util.ArrayList;
import java.util.List;

public class SupertypeImpl {
	
	private List<SupertypeEnum> supertypes = new ArrayList<SupertypeEnum>();
	
	public SupertypeImpl() {
		
	}
	
	public SupertypeImpl(SupertypeEnum... supertypes ) {
		for (SupertypeEnum supertype : supertypes) {
			this.supertypes.add(supertype);
		}
	}

}
