package com.skygym.findgym.model.vo;

public class GYM 
{
   private int GYMNumber;
   private String GYMCategory;
   private String GYMdistrict; // 지역
   private String GYMbranchName; // 지점명
   private String GYMAddress; //주소
   private String GYMtel; //전화번호 
   private String GYMInfo;
   private String GYMHomePage;
   private String mainImage;
   
   public GYM() {}
   
   

public GYM(int gYMNumber, String gYMCategory, String gYMdistrict, String gYMbranchName, String gYMAddress,
		String gYMtel, String gYMInfo, String gYMHomePage) {
	super();
	GYMNumber = gYMNumber;
	GYMCategory = gYMCategory;
	GYMdistrict = gYMdistrict;
	GYMbranchName = gYMbranchName;
	GYMAddress = gYMAddress;
	GYMtel = gYMtel;
	GYMInfo = gYMInfo;
	GYMHomePage = gYMHomePage;
}



public int getGYMNumber() {
	return GYMNumber;
}

public void setGYMNumber(int gYMNumber) {
	GYMNumber = gYMNumber;
}

public String getGYMCategory() {
	return GYMCategory;
}

public void setGYMCategory(String gYMCategory) {
	GYMCategory = gYMCategory;
}

public String getGYMdistrict() {
	return GYMdistrict;
}

public void setGYMdistrict(String gYMdistrict) {
	GYMdistrict = gYMdistrict;
}

public String getGYMbranchName() {
	return GYMbranchName;
}

public void setGYMbranchName(String gYMbranchName) {
	GYMbranchName = gYMbranchName;
}

public String getGYMAddress() {
	return GYMAddress;
}

public void setGYMAddress(String gYMAddress) {
	GYMAddress = gYMAddress;
}

public String getGYMtel() {
	return GYMtel;
}

public void setGYMtel(String gYMtel) {
	GYMtel = gYMtel;
}

public String getGYMInfo() {
	return GYMInfo;
}

public void setGYMInfo(String gYMInfo) {
	GYMInfo = gYMInfo;
}

public String getGYMHomePage() {
	return GYMHomePage;
}

public void setGYMHomePage(String gYMHomePage) {
	GYMHomePage = gYMHomePage;
}

public String getMainImage() {
	return mainImage;
}

public void setMainImage(String mainImage) {
	this.mainImage = mainImage;
}

@Override
public String toString() {
	return "GYM [GYMNumber=" + GYMNumber + ", GYMCategory=" + GYMCategory + ", GYMdistrict=" + GYMdistrict
			+ ", GYMbranchName=" + GYMbranchName + ", GYMAddress=" + GYMAddress + ", GYMtel=" + GYMtel + ", GYMInfo="
			+ GYMInfo + ", GYMHomePage=" + GYMHomePage + ", mainImage=" + mainImage + "]";
}

public GYM(int gYMNumber, String gYMCategory, String gYMdistrict, String gYMbranchName, String gYMAddress,
		String gYMtel, String gYMInfo, String gYMHomePage, String mainImage) {
	super();
	GYMNumber = gYMNumber;
	GYMCategory = gYMCategory;
	GYMdistrict = gYMdistrict;
	GYMbranchName = gYMbranchName;
	GYMAddress = gYMAddress;
	GYMtel = gYMtel;
	GYMInfo = gYMInfo;
	GYMHomePage = gYMHomePage;
	this.mainImage = mainImage;
}

   
   
   
}