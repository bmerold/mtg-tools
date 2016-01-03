package com.merold.magictools.characteristics;

import java.util.ArrayList;
import java.util.List;

public class TypeImpl implements Type {

	private List<TypeEnum> types = new ArrayList<TypeEnum>();
	
	public TypeImpl(TypeEnum... types) {
		
		if(types.length == 0) {
			throw new RuntimeException("Empty types are not allowed!");
		}
		
		for(TypeEnum type : types) {
			this.types.add(type);
		}
	}

	@Override
	public boolean isType(TypeEnum type) {
		return types.contains(type);
		
	}
}
