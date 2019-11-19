package com.skygym.rank.model.vo;

public class GymRank {

	private int rank;
	private int gymNumber;
	private String gymBranchName;
	private String gymDistrict;
	private String gymAddress;
	private String gymCategory;
	private String gymHomepage;
	private String mainimage;
	private double score;
	
	public GymRank() {}

	public GymRank(int rank, int gymNumber, String gymBranchName, String gymDistrict, String gymAddress,
			String gymCategory, String gymHomepage, String mainimage, double score) {
		super();
		this.rank = rank;
		this.gymNumber = gymNumber;
		this.gymBranchName = gymBranchName;
		this.gymDistrict = gymDistrict;
		this.gymAddress = gymAddress;
		this.gymCategory = gymCategory;
		this.gymHomepage = gymHomepage;
		this.mainimage = mainimage;
		this.score = score;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getGymNumber() {
		return gymNumber;
	}

	public void setGymNumber(int gymNumber) {
		this.gymNumber = gymNumber;
	}

	public String getGymBranchName() {
		return gymBranchName;
	}

	public void setGymBranchName(String gymBranchName) {
		this.gymBranchName = gymBranchName;
	}

	public String getGymDistrict() {
		return gymDistrict;
	}

	public void setGymDistrict(String gymDistrict) {
		this.gymDistrict = gymDistrict;
	}

	public String getGymAddress() {
		return gymAddress;
	}

	public void setGymAddress(String gymAddress) {
		this.gymAddress = gymAddress;
	}

	public String getGymCategory() {
		return gymCategory;
	}

	public void setGymCategory(String gymCategory) {
		this.gymCategory = gymCategory;
	}

	public String getGymHomepage() {
		return gymHomepage;
	}

	public void setGymHomepage(String gymHomepage) {
		this.gymHomepage = gymHomepage;
	}

	public String getMainimage() {
		return mainimage;
	}

	public void setMainimage(String mainimage) {
		this.mainimage = mainimage;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "GymRank [rank=" + rank + ", gymNumber=" + gymNumber + ", gymBranchName=" + gymBranchName
				+ ", gymDistrict=" + gymDistrict + ", gymAddress=" + gymAddress + ", gymCategory=" + gymCategory
				+ ", gymHomepage=" + gymHomepage + ", mainimage=" + mainimage + ", score=" + score + "]";
	}

	
}
