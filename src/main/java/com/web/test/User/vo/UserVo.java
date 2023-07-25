package com.web.test.User.vo;

public class UserVo {

	private Integer user_no;
	private String user_id;
	private String user_name;
	private String user_pwd;
	private String phone;
	private String postcode;
	private String address;
	private String detailaddress;
	private String extraaddress;
	private String manager_yn;
	
	public UserVo(Integer user_no, String user_id, String user_name, String user_pwd, String phone, String postcode,
			String address, String detailaddress, String extraaddress, String manager_yn) {
		super();
		this.user_no = user_no;
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_pwd = user_pwd;
		this.phone = phone;
		this.postcode = postcode;
		this.address = address;
		this.detailaddress = detailaddress;
		this.extraaddress = extraaddress;
		this.manager_yn = manager_yn;
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

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDetailaddress() {
		return detailaddress;
	}

	public void setDetailaddress(String detailaddress) {
		this.detailaddress = detailaddress;
	}

	public String getExtraaddress() {
		return extraaddress;
	}

	public void setExtraaddress(String extraaddress) {
		this.extraaddress = extraaddress;
	}

	public String getManager_yn() {
		return manager_yn;
	}

	public void setManager_yn(String manager_yn) {
		this.manager_yn = manager_yn;
	}

	@Override
	public String toString() {
		return "UserVo [user_no=" + user_no + ", user_id=" + user_id + ", user_name=" + user_name + ", user_pwd="
				+ user_pwd + ", phone=" + phone + ", postcode=" + postcode + ", address=" + address + ", detailaddress="
				+ detailaddress + ", extraaddress=" + extraaddress + ", manager_yn=" + manager_yn + "]";
	}
	
	
}
