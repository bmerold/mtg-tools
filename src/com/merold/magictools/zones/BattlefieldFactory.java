package com.merold.magictools.zones;

public class BattlefieldFactory {
	
	public static Battlefield createBattlefield() {
		return new BattlefieldImpl();
	}

}
