package com.web.test.Notice.vo;

import java.util.Date;

public class NoticeVo extends Criteria{
	private Long notice_no;
	private String title;
	private String content;
	private String writer;
	private String reg_date;
	private String update_date;
	private int view_count;
//	private Long seq;
	
	private String searchCondition;
	private String searchKeyword;
	
	private int startPage;
	private int endPage;	
	
	public NoticeVo() {
		
	}	

	public NoticeVo(String searchCondition, String searchKeyword) {
		super();
		this.searchCondition = searchCondition;
		this.searchKeyword = searchKeyword;
	}


	public NoticeVo(Long notice_no, String title, String content, String writer, String reg_date, String update_date,
			int view_count) {
		super();
		this.notice_no = notice_no;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.reg_date = reg_date;
		this.update_date = update_date;
		this.view_count = view_count;
	}
	
	public Long getNotice_no() {
		return notice_no;
	}

	public void setNotice_no(Long notice_no) {
		this.notice_no = notice_no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public String getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}

	public int getView_count() {
		return view_count;
	}

	public void setView_count(int view_count) {
		this.view_count = view_count;
	}


	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public int getStartPage() {
		return startPage;
	}


	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}


	public int getEndPage() {
		return endPage;
	}


	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	@Override
	public String toString() {
		return "NoticeVo [notice_no=" + notice_no + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", reg_date=" + reg_date + ", update_date=" + update_date + ", view_count=" + view_count
				+ ", searchCondition=" + searchCondition + ", searchKeyword=" + searchKeyword + ", startPage="
				+ startPage + ", endPage=" + endPage + "]";
	}	
	
	
	
}