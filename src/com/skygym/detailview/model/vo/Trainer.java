package com.skygym.detailview.model.vo;

public class Trainer {

	private int GYMNumber;
	private String trainerAImage;
	private String trainerBImage;
	private String trainerAName;
	private String trainerAPart;
	private String trainerBName;
	private String trainerBPart;
	
	
	public Trainer() {}


	public Trainer(int gYMNumber, String trainerAImage, String trainerBImage, String trainerAName, String trainerAPart,
			String trainerBName, String trainerBPart) {
		super();
		GYMNumber = gYMNumber;
		this.trainerAImage = trainerAImage;
		this.trainerBImage = trainerBImage;
		this.trainerAName = trainerAName;
		this.trainerAPart = trainerAPart;
		this.trainerBName = trainerBName;
		this.trainerBPart = trainerBPart;
	}


	public int getGYMNumber() {
		return GYMNumber;
	}


	public void setGYMNumber(int gYMNumber) {
		GYMNumber = gYMNumber;
	}


	public String getTrainerAImage() {
		return trainerAImage;
	}


	public void setTrainerAImage(String trainerAImage) {
		this.trainerAImage = trainerAImage;
	}


	public String getTrainerBImage() {
		return trainerBImage;
	}


	public void setTrainerBImage(String trainerBImage) {
		this.trainerBImage = trainerBImage;
	}


	public String getTrainerAName() {
		return trainerAName;
	}


	public void setTrainerAName(String trainerAName) {
		this.trainerAName = trainerAName;
	}


	public String getTrainerAPart() {
		return trainerAPart;
	}


	public void setTrainerAPart(String trainerAPart) {
		this.trainerAPart = trainerAPart;
	}


	public String getTrainerBName() {
		return trainerBName;
	}


	public void setTrainerBName(String trainerBName) {
		this.trainerBName = trainerBName;
	}


	public String getTrainerBPart() {
		return trainerBPart;
	}


	public void setTrainerBPart(String trainerBPart) {
		this.trainerBPart = trainerBPart;
	}


	@Override
	public String toString() {
		return "Trainer [GYMNumber=" + GYMNumber + ", trainerAImage=" + trainerAImage + ", trainerBImage="
				+ trainerBImage + ", trainerAName=" + trainerAName + ", trainerAPart=" + trainerAPart
				+ ", trainerBName=" + trainerBName + ", trainerBPart=" + trainerBPart + "]";
	}

	

	
	
	
	
	
}
