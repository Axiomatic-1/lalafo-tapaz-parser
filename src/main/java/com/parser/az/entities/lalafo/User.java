package com.parser.az.entities.lalafo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User{
	private Object responseInfo;
	private String userHash;
	private Object responseTime;
	private int id;
	private String avatar;
	private boolean pro;
	private Object responseRate;
	private String username;
	private Business business;
	private boolean noCompetitorsAds;
	private String publicUrl;
	private String companyName;
	private String logo;

	public void setResponseInfo(Object responseInfo){
		this.responseInfo = responseInfo;
	}

	public Object getResponseInfo(){
		return responseInfo;
	}

	public void setUserHash(String userHash){
		this.userHash = userHash;
	}

	public String getUserHash(){
		return userHash;
	}

	public void setResponseTime(Object responseTime){
		this.responseTime = responseTime;
	}

	public Object getResponseTime(){
		return responseTime;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setAvatar(String avatar){
		this.avatar = avatar;
	}

	public String getAvatar(){
		return avatar;
	}

	public void setPro(boolean pro){
		this.pro = pro;
	}

	public boolean isPro(){
		return pro;
	}

	public void setResponseRate(Object responseRate){
		this.responseRate = responseRate;
	}

	public Object getResponseRate(){
		return responseRate;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	public void setBusiness(Business business){
		this.business = business;
	}

	public Business getBusiness(){
		return business;
	}

	public void setNoCompetitorsAds(boolean noCompetitorsAds){
		this.noCompetitorsAds = noCompetitorsAds;
	}

	public boolean isNoCompetitorsAds(){
		return noCompetitorsAds;
	}

	public void setPublicUrl(String publicUrl){
		this.publicUrl = publicUrl;
	}

	public String getPublicUrl(){
		return publicUrl;
	}

	public void setCompanyName(String companyName){
		this.companyName = companyName;
	}

	public String getCompanyName(){
		return companyName;
	}

	public void setLogo(String logo){
		this.logo = logo;
	}

	public String getLogo(){
		return logo;
	}
}
