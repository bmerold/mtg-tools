package com.merold.magictools.zones;

public class LibraryFactory {
	
	public static Library createLibrary(Deck deck) {
		return new LibraryImpl(deck);
	}

}
