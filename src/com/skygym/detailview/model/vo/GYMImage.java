package com.skygym.detailview.model.vo;

public class GYMImage {

	private int GYMNumber;
	private String MainImage;
	private String subImagea;
	private String subImageb;
	private String subImagec;
	
	public GYMImage() {}

	public GYMImage(int gYMNumber, String mainImage, String subImagea, String subImageb, String subImagec) {
		super();
		GYMNumber = gYMNumber;
		MainImage = mainImage;
		this.subImagea = subImagea;
		this.subImageb = subImageb;
		this.subImagec = subImagec;
	}

	public int getGYMNumber() {
		return GYMNumber;
	}

	public void setGYMNumber(int gYMNumber) {
		GYMNumber = gYMNumber;
	}

	public String getMainImage() {
		return MainImage;
	}

	public void setMainImage(String mainImage) {
		MainImage = mainImage;
	}

	public String getSubImagea() {
		return subImagea;
	}

	public void setSubImagea(String subImagea) {
		this.subImagea = subImagea;
	}

	public String getSubImageb() {
		return subImageb;
	}

	public void setSubImageb(String subImageb) {
		this.subImageb = subImageb;
	}

	public String getSubImagec() {
		return subImagec;
	}

	public void setSubImagec(String subImagec) {
		this.subImagec = subImagec;
	}

	@Override
	public String toString() {
		return "GYMImage [GYMNumber=" + GYMNumber + ", MainImage=" + MainImage + ", subImagea=" + subImagea
				+ ", subImageb=" + subImageb + ", subImagec=" + subImagec + "]";
	}

	
	
	
	
	
	
}
