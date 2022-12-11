package com.parser.az.entities.lalafo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Business{

	private boolean business;

	public void setBusiness(boolean business){
		this.business = business;
	}

	public boolean isBusiness(){
		return business;
	}
}
