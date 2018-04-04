package com.merold.magictools.characteristics;

public class ColorFactory {
	
	public static Color createColor(ColorEnum... colors) {
		return new ColorImpl(colors);
	}

}
