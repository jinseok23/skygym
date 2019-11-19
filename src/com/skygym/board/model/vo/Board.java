package com.skygym.board.model.vo;

import java.sql.Date;

public class Board {

	private int boardNo;
	private String boardTitle;
	private String boardWriter;
	private String boardContent;
	private Date boardDate;
	private int boardReadCount;
	private String boardInvisible;
	private int CommentTotalCnt;
	private String boardTime;
	private int newIcon;
	
	
	public Board() {}


	public int getBoardNo() {
		return boardNo;
	}


	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}


	public String getBoardTitle() {
		return boardTitle;
	}


	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}


	public String getBoardWriter() {
		return boardWriter;
	}


	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}


	public String getBoardContent() {
		return boardContent;
	}


	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}


	public Date getBoardDate() {
		return boardDate;
	}


	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}


	public int getBoardReadCount() {
		return boardReadCount;
	}


	public void setBoardReadCount(int boardReadCount) {
		this.boardReadCount = boardReadCount;
	}


	public String getBoardInvisible() {
		return boardInvisible;
	}


	public void setBoardInvisible(String boardInvisible) {
		this.boardInvisible = boardInvisible;
	}


	public int getCommentTotalCnt() {
		return CommentTotalCnt;
	}


	public void setCommentTotalCnt(int commentTotalCnt) {
		CommentTotalCnt = commentTotalCnt;
	}


	public String getBoardTime() {
		return boardTime;
	}


	public void setBoardTime(String boardTime) {
		this.boardTime = boardTime;
	}


	public int getNewIcon() {
		return newIcon;
	}


	public void setNewIcon(int newIcon) {
		this.newIcon = newIcon;
	}


	public Board(int boardNo, String boardTitle, String boardWriter, String boardContent, Date boardDate,
			int boardReadCount, String boardInvisible, int commentTotalCnt, String boardTime, int newIcon) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardWriter = boardWriter;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
		this.boardReadCount = boardReadCount;
		this.boardInvisible = boardInvisible;
		CommentTotalCnt = commentTotalCnt;
		this.boardTime = boardTime;
		this.newIcon = newIcon;
	}
	
	
	
	
	
	

	
	
	
}
