package com.parser.az.entities.lalafo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemsItem{
	private String symbol;
	private int updatedTime;
	private String cityAlias;
	private int responseType;
	private Object nationalPrice;
	private int statusId;
	private boolean isSelect;
	private int price;
	private int id;
	private boolean hidePhone;
	private Object lat;
	private String image;
	private int createdTime;
	private List<ImagesItem> images;
	private Object lng;
	private Object adLabel;
	private boolean isVip;
	private Object oldPrice;
	private boolean isIdentity;
	private List<Object> params;
	private List<TrackingInfoItem> trackingInfo;
	private boolean isFreedom;
	private int callersCount;
	private boolean isPremium;
	private int userId;
	private String background;
	private long lastPushUp;
	private Object oldId;
	private long scoreOrder;
	private int priceType;
	private int countryId;
	private int cityId;
	private boolean campaignShow;
	private int originUserId;
	private String city;
	private List<Object> paidPackages;
	private String description;
	private String title;
	private boolean isPpv;
	private int categoryId;
	private Object nationalOldPrice;
	private int favoriteCount;
	private String currency;
	private int views;
	private List<Object> paidFeatures;
	private List<Integer> userIds;
	private boolean isNegotiable;
	private String mobile;
	private int impressions;
	private boolean hideChat;
	private boolean canFreePush;
	private User user;
	private int writersCount;

	public void setSymbol(String symbol){
		this.symbol = symbol;
	}

	public String getSymbol(){
		return symbol;
	}

	public void setUpdatedTime(int updatedTime){
		this.updatedTime = updatedTime;
	}

	public int getUpdatedTime(){
		return updatedTime;
	}

	public void setCityAlias(String cityAlias){
		this.cityAlias = cityAlias;
	}

	public String getCityAlias(){
		return cityAlias;
	}

	public void setResponseType(int responseType){
		this.responseType = responseType;
	}

	public int getResponseType(){
		return responseType;
	}

	public void setNationalPrice(Object nationalPrice){
		this.nationalPrice = nationalPrice;
	}

	public Object getNationalPrice(){
		return nationalPrice;
	}

	public void setStatusId(int statusId){
		this.statusId = statusId;
	}

	public int getStatusId(){
		return statusId;
	}

	public void setIsSelect(boolean isSelect){
		this.isSelect = isSelect;
	}

	public boolean isIsSelect(){
		return isSelect;
	}

	public void setPrice(int price){
		this.price = price;
	}

	public int getPrice(){
		return price;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setHidePhone(boolean hidePhone){
		this.hidePhone = hidePhone;
	}

	public boolean isHidePhone(){
		return hidePhone;
	}

	public void setLat(Object lat){
		this.lat = lat;
	}

	public Object getLat(){
		return lat;
	}

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setCreatedTime(int createdTime){
		this.createdTime = createdTime;
	}

	public int getCreatedTime(){
		return createdTime;
	}

	public void setImages(List<ImagesItem> images){
		this.images = images;
	}

	public List<ImagesItem> getImages(){
		return images;
	}

	public void setLng(Object lng){
		this.lng = lng;
	}

	public Object getLng(){
		return lng;
	}

	public void setAdLabel(Object adLabel){
		this.adLabel = adLabel;
	}

	public Object getAdLabel(){
		return adLabel;
	}

	public void setIsVip(boolean isVip){
		this.isVip = isVip;
	}

	public boolean isIsVip(){
		return isVip;
	}

	public void setOldPrice(Object oldPrice){
		this.oldPrice = oldPrice;
	}

	public Object getOldPrice(){
		return oldPrice;
	}

	public void setIsIdentity(boolean isIdentity){
		this.isIdentity = isIdentity;
	}

	public boolean isIsIdentity(){
		return isIdentity;
	}

	public void setParams(List<Object> params){
		this.params = params;
	}

	public List<Object> getParams(){
		return params;
	}

	public void setTrackingInfo(List<TrackingInfoItem> trackingInfo){
		this.trackingInfo = trackingInfo;
	}

	public List<TrackingInfoItem> getTrackingInfo(){
		return trackingInfo;
	}

	public void setIsFreedom(boolean isFreedom){
		this.isFreedom = isFreedom;
	}

	public boolean isIsFreedom(){
		return isFreedom;
	}

	public void setCallersCount(int callersCount){
		this.callersCount = callersCount;
	}

	public int getCallersCount(){
		return callersCount;
	}

	public void setIsPremium(boolean isPremium){
		this.isPremium = isPremium;
	}

	public boolean isIsPremium(){
		return isPremium;
	}

	public void setUserId(int userId){
		this.userId = userId;
	}

	public int getUserId(){
		return userId;
	}

	public void setBackground(String background){
		this.background = background;
	}

	public String getBackground(){
		return background;
	}

	public void setLastPushUp(long lastPushUp){
		this.lastPushUp = lastPushUp;
	}

	public long getLastPushUp(){
		return lastPushUp;
	}

	public void setOldId(Object oldId){
		this.oldId = oldId;
	}

	public Object getOldId(){
		return oldId;
	}

	public void setScoreOrder(long scoreOrder){
		this.scoreOrder = scoreOrder;
	}

	public long getScoreOrder(){
		return scoreOrder;
	}

	public void setPriceType(int priceType){
		this.priceType = priceType;
	}

	public int getPriceType(){
		return priceType;
	}

	public void setCountryId(int countryId){
		this.countryId = countryId;
	}

	public int getCountryId(){
		return countryId;
	}

	public void setCityId(int cityId){
		this.cityId = cityId;
	}

	public int getCityId(){
		return cityId;
	}

	public void setCampaignShow(boolean campaignShow){
		this.campaignShow = campaignShow;
	}

	public boolean isCampaignShow(){
		return campaignShow;
	}

	public void setOriginUserId(int originUserId){
		this.originUserId = originUserId;
	}

	public int getOriginUserId(){
		return originUserId;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setPaidPackages(List<Object> paidPackages){
		this.paidPackages = paidPackages;
	}

	public List<Object> getPaidPackages(){
		return paidPackages;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setIsPpv(boolean isPpv){
		this.isPpv = isPpv;
	}

	public boolean isIsPpv(){
		return isPpv;
	}

	public void setCategoryId(int categoryId){
		this.categoryId = categoryId;
	}

	public int getCategoryId(){
		return categoryId;
	}

	public void setNationalOldPrice(Object nationalOldPrice){
		this.nationalOldPrice = nationalOldPrice;
	}

	public Object getNationalOldPrice(){
		return nationalOldPrice;
	}

	public void setFavoriteCount(int favoriteCount){
		this.favoriteCount = favoriteCount;
	}

	public int getFavoriteCount(){
		return favoriteCount;
	}

	public void setCurrency(String currency){
		this.currency = currency;
	}

	public String getCurrency(){
		return currency;
	}

	public void setViews(int views){
		this.views = views;
	}

	public int getViews(){
		return views;
	}

	public void setPaidFeatures(List<Object> paidFeatures){
		this.paidFeatures = paidFeatures;
	}

	public List<Object> getPaidFeatures(){
		return paidFeatures;
	}

	public void setUserIds(List<Integer> userIds){
		this.userIds = userIds;
	}

	public List<Integer> getUserIds(){
		return userIds;
	}

	public void setIsNegotiable(boolean isNegotiable){
		this.isNegotiable = isNegotiable;
	}

	public boolean isIsNegotiable(){
		return isNegotiable;
	}

	public void setMobile(String mobile){
		this.mobile = mobile;
	}

	public String getMobile(){
		return mobile;
	}

	public void setImpressions(int impressions){
		this.impressions = impressions;
	}

	public int getImpressions(){
		return impressions;
	}

	public void setHideChat(boolean hideChat){
		this.hideChat = hideChat;
	}

	public boolean isHideChat(){
		return hideChat;
	}

	public void setCanFreePush(boolean canFreePush){
		this.canFreePush = canFreePush;
	}

	public boolean isCanFreePush(){
		return canFreePush;
	}

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}

	public void setWritersCount(int writersCount){
		this.writersCount = writersCount;
	}

	public int getWritersCount(){
		return writersCount;
	}

	@Override
	public String toString() {
		return "ItemsItem{" +
				"symbol='" + symbol + '\'' +
				", updatedTime=" + updatedTime +
				", cityAlias='" + cityAlias + '\'' +
				", responseType=" + responseType +
				", nationalPrice=" + nationalPrice +
				", statusId=" + statusId +
				", isSelect=" + isSelect +
				", price=" + price +
				", id=" + id +
				", hidePhone=" + hidePhone +
				", lat=" + lat +
				", image='" + image + '\'' +
				", createdTime=" + createdTime +
				", images=" + images +
				", lng=" + lng +
				", adLabel=" + adLabel +
				", isVip=" + isVip +
				", oldPrice=" + oldPrice +
				", isIdentity=" + isIdentity +
				", params=" + params +
				", trackingInfo=" + trackingInfo +
				", isFreedom=" + isFreedom +
				", callersCount=" + callersCount +
				", isPremium=" + isPremium +
				", userId=" + userId +
				", background='" + background + '\'' +
				", lastPushUp=" + lastPushUp +
				", oldId=" + oldId +
				", scoreOrder=" + scoreOrder +
				", priceType=" + priceType +
				", countryId=" + countryId +
				", cityId=" + cityId +
				", campaignShow=" + campaignShow +
				", originUserId=" + originUserId +
				", city='" + city + '\'' +
				", paidPackages=" + paidPackages +
				", description='" + description + '\'' +
				", title='" + title + '\'' +
				", isPpv=" + isPpv +
				", categoryId=" + categoryId +
				", nationalOldPrice=" + nationalOldPrice +
				", favoriteCount=" + favoriteCount +
				", currency='" + currency + '\'' +
				", views=" + views +
				", paidFeatures=" + paidFeatures +
				", userIds=" + userIds +
				", isNegotiable=" + isNegotiable +
				", mobile='" + mobile + '\'' +
				", impressions=" + impressions +
				", hideChat=" + hideChat +
				", canFreePush=" + canFreePush +
				", user=" + user +
				", writersCount=" + writersCount +
				'}';
	}
}