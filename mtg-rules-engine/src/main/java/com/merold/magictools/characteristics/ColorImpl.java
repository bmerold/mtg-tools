package com.merold.magictools.characteristics;

import java.util.ArrayList;
import java.util.List;

public final class ColorImpl implements Color {
	
	private List<ColorEnum> colors = new ArrayList<ColorEnum>();

	@Override
	public boolean isColor(ColorEnum color) {
		return colors.contains(color);
	}
	
	public ColorImpl(ColorEnum... colors ) {
		for (ColorEnum color : colors) {
			this.colors.add(color);
		}
	}
	
	@Override
	public Color addColor(ColorEnum color) {
		colors.add(color);
		return this;
	}
	
	@Override
	public Color changeColor(ColorEnum color) {
		return ColorFactory.createColor(color);
	}

}
