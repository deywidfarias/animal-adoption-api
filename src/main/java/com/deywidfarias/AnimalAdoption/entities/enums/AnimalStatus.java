package com.deywidfarias.AnimalAdoption.entities.enums;

import com.deywidfarias.AnimalAdoption.entities.enums.AnimalStatus;

public enum AnimalStatus {
	DISPONIVEL(1),
	ADOTADO(2);	
	
	private int code;
	
	private AnimalStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static AnimalStatus valueOf(int code) {
		for(AnimalStatus value: AnimalStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid AnimalStatus code!");
	}

}
