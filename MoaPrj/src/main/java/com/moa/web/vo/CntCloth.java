package com.moa.web.vo;

public class CntCloth {

	private String memberUid;
	private int cntOuters;
	private int cntTops;
	private int cntBottoms;
	private int cntShoes;
	private int cntEtc;

	public CntCloth() {
		// TODO Auto-generated constructor stub
	}

	public CntCloth(String memberUid, int cntOuters, int cntTops, int cntBottoms, int cntShoes, int cntEtc) {
		super();
		this.memberUid = memberUid;
		this.cntOuters = cntOuters;
		this.cntTops = cntTops;
		this.cntBottoms = cntBottoms;
		this.cntShoes = cntShoes;
		this.cntEtc = cntEtc;
	}

	public String getMemberUid() {
		return memberUid;
	}

	public void setMemberUid(String memberUid) {
		this.memberUid = memberUid;
	}

	public int getCntOuters() {
		return cntOuters;
	}

	public void setCntOuters(int cntOuters) {
		this.cntOuters = cntOuters;
	}

	public int getCntTops() {
		return cntTops;
	}

	public void setCntTops(int cntTops) {
		this.cntTops = cntTops;
	}

	public int getCntBottoms() {
		return cntBottoms;
	}

	public void setCntBottoms(int cntBottoms) {
		this.cntBottoms = cntBottoms;
	}

	public int getCntShoes() {
		return cntShoes;
	}

	public void setCntShoes(int cntShoes) {
		this.cntShoes = cntShoes;
	}

	public int getCntEtc() {
		return cntEtc;
	}

	public void setCntEtc(int cntEtc) {
		this.cntEtc = cntEtc;
	}

	@Override
	public String toString() {
		return "CntCloth [memberUid=" + memberUid + ", cntOuters=" + cntOuters + ", cntTops=" + cntTops
				+ ", cntBottoms=" + cntBottoms + ", cntShoes=" + cntShoes + ", cntEtc=" + cntEtc + "]";
	}

}
