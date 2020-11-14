package com.moa.web.vo;

import java.sql.Date;

public class Cloth {

	private int id;
	private String memberUid;
	private String img;
	private Date regdate;
	private String category;

	public Cloth() {
		// TODO Auto-generated constructor stub
	}

	public Cloth(int id, String memberUid, String img, Date regdate, String category) {
		super();
		this.id = id;
		this.memberUid = memberUid;
		this.img = img;
		this.regdate = regdate;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMemberUid() {
		return memberUid;
	}

	public void setMemberUid(String memberUid) {
		this.memberUid = memberUid;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Cloth [id=" + id + ", memberUid=" + memberUid + ", img=" + img + ", regdate=" + regdate + ", category="
				+ category + "]";
	}

}
