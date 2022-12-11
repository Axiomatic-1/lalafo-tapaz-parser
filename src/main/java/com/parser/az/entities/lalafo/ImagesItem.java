package com.parser.az.entities.lalafo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ImagesItem{
	private String originalUrl;
	private boolean isMain;
	private String thumbnailWebpUrl;
	private int width;
	private int id;
	private String thumbnailUrl;
	private int height;
	private boolean isCvImage;
	private String originalWebpUrl;

	public void setOriginalUrl(String originalUrl){
		this.originalUrl = originalUrl;
	}

	public String getOriginalUrl(){
		return originalUrl;
	}

	public void setIsMain(boolean isMain){
		this.isMain = isMain;
	}

	public boolean isIsMain(){
		return isMain;
	}

	public void setThumbnailWebpUrl(String thumbnailWebpUrl){
		this.thumbnailWebpUrl = thumbnailWebpUrl;
	}

	public String getThumbnailWebpUrl(){
		return thumbnailWebpUrl;
	}

	public void setWidth(int width){
		this.width = width;
	}

	public int getWidth(){
		return width;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setThumbnailUrl(String thumbnailUrl){
		this.thumbnailUrl = thumbnailUrl;
	}

	public String getThumbnailUrl(){
		return thumbnailUrl;
	}

	public void setHeight(int height){
		this.height = height;
	}

	public int getHeight(){
		return height;
	}

	public void setIsCvImage(boolean isCvImage){
		this.isCvImage = isCvImage;
	}

	public boolean isIsCvImage(){
		return isCvImage;
	}

	public void setOriginalWebpUrl(String originalWebpUrl){
		this.originalWebpUrl = originalWebpUrl;
	}

	public String getOriginalWebpUrl(){
		return originalWebpUrl;
	}
}
