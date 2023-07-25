package com.web.test.Photo.vo;

import org.springframework.web.multipart.MultipartFile;

public class PhotoVo {

	private Integer photo_no;
	private String photo_name;
	private String photo_date;
	private String photo_path;
	private Integer mini_no;
	private String user_id;
	private String photo_text;
	private MultipartFile photoFile;
	
	public PhotoVo() {}
	
	public PhotoVo(String user_id, String photo_name) {
		this.user_id = user_id;
		this.photo_name = photo_name;
	}
	
	public PhotoVo(Integer photo_no, String photo_name, String photo_date, String photo_path, Integer mini_no, String photo_text) {
		super();
		this.photo_no = photo_no;
		this.photo_name = photo_name;
		this.photo_date = photo_date;
		this.photo_path = photo_path;
		this.mini_no = mini_no;
		this.photo_text = photo_text;
	}

	public Integer getPhoto_no() {
		return photo_no;
	}

	public void setPhoto_no(Integer photo_no) {
		this.photo_no = photo_no;
	}

	public String getPhoto_name() {
		return photo_name;
	}

	public void setPhoto_name(String photo_name) {
		this.photo_name = photo_name;
	}

	public String getPhoto_date() {
		return photo_date;
	}

	public void setPhoto_date(String photo_date) {
		this.photo_date = photo_date;
	}

	public String getPhoto_path() {
		return photo_path;
	}

	public void setPhoto_path(String photo_path) {
		this.photo_path = photo_path;
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

	public String getPhoto_text() {
		return photo_text;
	}

	public void setPhoto_text(String photo_text) {
		this.photo_text = photo_text;
	}

	public MultipartFile getPhotoFile() {
		return photoFile;
	}

	public void setPhotoFile(MultipartFile photoFile) {
		this.photoFile = photoFile;
	}

	@Override
	public String toString() {
		return "PhotoVo [photo_no=" + photo_no + ", photo_name=" + photo_name + ", photo_date=" + photo_date
				+ ", photo_path=" + photo_path + ", mini_no=" + mini_no + ", user_id=" + user_id + ", photo_text="
				+ photo_text + "]";
	}
}
