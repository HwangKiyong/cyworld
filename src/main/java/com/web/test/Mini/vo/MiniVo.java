package com.web.test.Mini.vo;

import java.util.Date;

public class MiniVo {

	private Integer mini_no;
	private Integer mini_today;
	private Integer mini_total;
	private String mini_title;
	private String mini_profile;
	private String mini_room;
	private String mini_content;
	private Integer user_no;
	private String user_id;
	private Date mini_date;
	
	private String photo_name;
    private String register_title;    
    
	public MiniVo() {}
	
	public MiniVo(String photo_name, String register_title) {
		this.photo_name = photo_name;
		this.register_title = register_title;
	}
	
	public MiniVo(Integer mini_no, Integer mini_today, Integer mini_total, String mini_title, String mini_profile, String mini_room,
			String mini_content, Date mini_date) {
		super();
		this.mini_no = mini_no;
		this.mini_today = mini_today;
		this.mini_total = mini_total;
		this.mini_title = mini_title;
		this.mini_profile = mini_profile;
		this.mini_room = mini_room;
		this.mini_content = mini_content;
		this.mini_date = mini_date;
	}
	
	public Integer getMini_no() {
		return mini_no;
	}
	
	public void setMini_no(Integer mini_no) {
		this.mini_no = mini_no;
	}
	
	public Integer getMini_today() {
		return mini_today;
	}
	
	public void setMini_today(Integer mini_today) {
		this.mini_today = mini_today;
	}
	
	public Integer getMini_total() {
		return mini_total;
	}
	
	public void setMini_total(Integer mini_total) {
		this.mini_total = mini_total;
	}
	
	public String getMini_title() {
		return mini_title;
	}
	
	public void setMini_title(String mini_title) {
		this.mini_title = mini_title;
	}
	
	public String getMini_profile() {
		return mini_profile;
	}
	
	public void setMini_profile(String mini_profile) {
		this.mini_profile = mini_profile;
	}
		
	
	public String getMini_room() {
		return mini_room;
	}

	public void setMini_room(String mini_room) {
		this.mini_room = mini_room;
	}

	public String getMini_content() {
		return mini_content;
	}
	
	public void setMini_content(String mini_content) {
		this.mini_content = mini_content;
	}

	public Integer getUser_no() {
		return user_no;
	}

	public void setUser_no(Integer user_no) {
		this.user_no = user_no;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPhoto_name() {
		return photo_name;
	}

	public void setPhoto_name(String photo_name) {
		this.photo_name = photo_name;
	}

	public String getRegister_title() {
		return register_title;
	}

	public void setRegister_title(String register_title) {
		this.register_title = register_title;
	}
	
	public Date getMini_date() {
		return mini_date;
	}

	public void setMini_date(Date mini_date) {
		this.mini_date = mini_date;
	}

	@Override
	public String toString() {
		return "MiniVo [mini_no=" + mini_no + ", mini_today=" + mini_today + ", mini_total=" + mini_total
				+ ", mini_title=" + mini_title + ", mini_profile=" + mini_profile + ", mini_room=" + mini_room
				+ ", mini_content=" + mini_content + ", user_no=" + user_no + ", user_id=" + user_id + ", mini_date="
				+ mini_date + ", photo_name=" + photo_name + ", register_title=" + register_title + "]";
	}
	
}
