package com.testing.model;

import java.util.Date;

public class UserModel extends PageVO{
	
	private String tuid;
	private String name;
	private String phone;
	private Date udate;
	private String birthday; 
	private String remark;
	private String mail;
	private String card;
	public String getTuid() {
		return tuid;
	}
	public void setTuid(String tuid) {
		this.tuid = tuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getUdate() {
		return udate;
	}
	public void setUdate(Date udate) {
		this.udate = udate;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	@Override
	public String toString() {
		return "UserModel [tuid=" + tuid + ", name=" + name + ", phone=" + phone + ", udate=" + udate + ", birthday="
				+ birthday + ", remark=" + remark + ", mail=" + mail + ", card=" + card + "]\n";
	}
}
