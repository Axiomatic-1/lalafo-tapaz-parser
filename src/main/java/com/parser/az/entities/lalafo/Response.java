package com.parser.az.entities.lalafo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response{

	private Links _links;
	@JsonIgnoreProperties
	private Meta meta;
	private List<ItemsItem> items;

	public void set_links(Links _links){
		this._links = _links;
	}

	public Links get_links(){
		return _links;
	}

	public void setMeta(Meta meta){
		this.meta = meta;
	}

	public Meta getMeta(){
		return meta;
	}

	public void setItems(List<ItemsItem> items){
		this.items = items;
	}

	public List<ItemsItem> getItems(){
		return items;
	}
}