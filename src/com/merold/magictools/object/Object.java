package com.merold.magictools.object;

import com.merold.magictools.characteristics.Subtype;
import com.merold.magictools.characteristics.Supertype;
import com.merold.magictools.characteristics.Type;

public interface Object {
	
	public String getName();
	
	public Type getType();
	
	public Supertype getSuperType();
	
	public Subtype getSubtype();
	
	/* Characteristics:
	 * 		name,
	 * 		mana cost,
	 * 		type,
	 * 		sub type,
	 * 		super type,
	 * 		color,
	 * 		color indicator,
	 * 		rules text,
	 * 		abilities,
	 * 		power,
	 * 		toughness,
	 * 		loyalty,
	 * 		hand modifier,
	 * 		life modifier
	 */

}
