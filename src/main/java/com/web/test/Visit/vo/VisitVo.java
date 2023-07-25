package com.web.test.Visit.vo;

public class VisitVo {
	
	private Integer register_no;
	private String register_title;
	private String register_date;
	private String register_content;
	private Integer mini_no;
	private String user_id;
	private String register_writer;
	
	public VisitVo() {}
	
	public VisitVo(String user_id, String register_title) {
		this.user_id = user_id;
		this.register_title = register_title;
	}
	
	public VisitVo(Integer register_no, String register_title, String register_date, String register_content,
			Integer mini_no, String register_writer) {
		super();
		this.register_no = register_no;
		this.register_title = register_title;
		this.register_date = register_date;
		this.register_content = register_content;
		this.mini_no = mini_no;
		this.register_writer = register_writer;
	}

	public Integer getRegister_no() {
		return register_no;
	}

	public void setRegister_no(Integer register_no) {
		this.register_no = register_no;
	}

	public String getRegister_title() {
		return register_title;
	}

	public void setRegister_title(String register_title) {
		this.register_title = register_title;
	}

	public String getRegister_date() {
		return register_date;
	}

	public void setRegister_date(String register_date) {
		this.register_date = register_date;
	}

	public String getRegister_content() {
		return register_content;
	}

	public void setRegister_content(String register_content) {
		this.register_content = register_content;
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

	public String getRegister_writer() {
		return register_writer;
	}

	public void setRegister_writer(String register_writer) {
		this.register_writer = register_writer;
	}

	@Override
	public String toString() {
		return "VisitVo [register_no=" + register_no + ", register_title=" + register_title + ", register_date="
				+ register_date + ", register_content=" + register_content + ", mini_no=" + mini_no + ", user_id="
				+ user_id + ", register_writer=" + register_writer + "]";
	}	
}
