package com.parser.az.entities.lalafo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Links{
	private Next next;
	private Last last;
	private Self self;
	private First first;

	public void setNext(Next next){
		this.next = next;
	}

	public Next getNext(){
		return next;
	}

	public void setLast(Last last){
		this.last = last;
	}

	public Last getLast(){
		return last;
	}

	public void setSelf(Self self){
		this.self = self;
	}

	public Self getSelf(){
		return self;
	}

	public void setFirst(First first){
		this.first = first;
	}

	public First getFirst(){
		return first;
	}
}
