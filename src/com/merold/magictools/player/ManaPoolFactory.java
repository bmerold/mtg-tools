package com.merold.magictools.player;

public class ManaPoolFactory {
	public static ManaPool createManaPool() {
		return new ManaPoolImpl();
	}
}
