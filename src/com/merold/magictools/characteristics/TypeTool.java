package com.merold.magictools.characteristics;

import com.merold.magictools.object.Card;

public class TypeTool {
	
	public static boolean isLand(Card card) {
		return card.getType().isType(TypeEnum.LAND);
	}

}
