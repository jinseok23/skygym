package com.skygym.detailview.model.vo;

import java.sql.Date;

public class GYMReply {

	private int GYMNumber;
	private String userId;
	private int GYMScore;
	private int replyNumber;
	private int replyNumber_REF;
	private int replyLevel;
	private String reply_content;
	private Date reply_date;
	
	public GYMReply() {}

	public GYMReply(int gYMNumber, String userId, int gYMScore, int replyNumber, int replyNumber_REF, int replyLevel,
			String reply_content, Date reply_date) {
		super();
		GYMNumber = gYMNumber;
		this.userId = userId;
		GYMScore = gYMScore;
		this.replyNumber = replyNumber;
		this.replyNumber_REF = replyNumber_REF;
		this.replyLevel = replyLevel;
		this.reply_content = reply_content;
		this.reply_date = reply_date;
	}

	public int getGYMNumber() {
		return GYMNumber;
	}

	public void setGYMNumber(int gYMNumber) {
		GYMNumber = gYMNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getGYMScore() {
		return GYMScore;
	}

	public void setGYMScore(int gYMScore) {
		GYMScore = gYMScore;
	}

	public int getReplyNumber() {
		return replyNumber;
	}

	public void setReplyNumber(int replyNumber) {
		this.replyNumber = replyNumber;
	}

	public int getReplyNumber_REF() {
		return replyNumber_REF;
	}

	public void setReplyNumber_REF(int replyNumber_REF) {
		this.replyNumber_REF = replyNumber_REF;
	}

	public int getReplyLevel() {
		return replyLevel;
	}

	public void setReplyLevel(int replyLevel) {
		this.replyLevel = replyLevel;
	}

	public String getReply_content() {
		return reply_content;
	}

	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}

	public Date getReply_date() {
		return reply_date;
	}

	public void setReply_date(Date reply_date) {
		this.reply_date = reply_date;
	}

	@Override
	public String toString() {
		return "GYMReply [GYMNumber=" + GYMNumber + ", userId=" + userId + ", GYMScore=" + GYMScore + ", replyNumber="
				+ replyNumber + ", replyNumber_REF=" + replyNumber_REF + ", replyLevel=" + replyLevel
				+ ", reply_content=" + reply_content + ", reply_date=" + reply_date + "]";
	}

	
	
}
