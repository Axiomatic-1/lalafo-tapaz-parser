package com.parser.az.entities.lalafo;

public class Meta{
	private String feed;
	private int pageCount;
	private int perPage;
	private int totalCount;
	private int currentPage;

	public void setFeed(String feed){
		this.feed = feed;
	}

	public String getFeed(){
		return feed;
	}

	public void setPageCount(int pageCount){
		this.pageCount = pageCount;
	}

	public int getPageCount(){
		return pageCount;
	}

	public void setPerPage(int perPage){
		this.perPage = perPage;
	}

	public int getPerPage(){
		return perPage;
	}

	public void setTotalCount(int totalCount){
		this.totalCount = totalCount;
	}

	public int getTotalCount(){
		return totalCount;
	}

	public void setCurrentPage(int currentPage){
		this.currentPage = currentPage;
	}

	public int getCurrentPage(){
		return currentPage;
	}
}
