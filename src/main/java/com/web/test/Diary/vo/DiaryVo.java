package com.web.test.Diary.vo;

public class DiaryVo {

	private Integer diary_no;
	private String diary_date;
	private String diary_content;
	private Integer mini_no;
	private String user_id;
	
	public DiaryVo() {}
	
	public DiaryVo(Integer diary_no, String diary_date, String diary_content, Integer mini_no) {
		super();
		this.diary_no = diary_no;
		this.diary_date = diary_date;
		this.diary_content = diary_content;
		this.mini_no = mini_no;
	}


	public Integer getDiary_no() {
		return diary_no;
	}


	public void setDiary_no(Integer diary_no) {
		this.diary_no = diary_no;
	}


	public String getDiary_date() {
		return diary_date;
	}


	public void setDiary_date(String diary_date) {
		this.diary_date = diary_date;
	}


	public String getDiary_content() {
		return diary_content;
	}


	public void setDiary_content(String diary_content) {
		this.diary_content = diary_content;
	}


	public Integer getMini_no() {
		return mini_no;
	}


	public void setMini_no(Integer mini_no) {
		this.mini_no = mini_no;
	}
	
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "DiaryVo [diary_no=" + diary_no + ", diary_date=" + diary_date + ", diary_content=" + diary_content
				+ ", mini_no=" + mini_no + "]";
	}

	
	
	
}
