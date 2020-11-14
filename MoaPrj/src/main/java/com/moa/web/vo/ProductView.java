package com.moa.web.vo;

public class ProductView {

	private int id;
	private String name;
	private int capacity;
	private int kcal;
	private int natrium;
	private int carbohydrate;
	private int sugars;
	private int fat;
	private int transfat;
	private int saturatedFat;
	private int cholesterol;
	private int protein;
	private int mfrId;
	private String mfr;
	private String logo;
	private int amount;
	private int year;
	private int quarter;
	private String img;

	public ProductView() {
		// TODO Auto-generated constructor stub
	}

	public ProductView(int id, String name, int kcal, String mfr) {
		this.id = id;
		this.name = name;
		this.kcal = kcal;
		this.mfr = mfr;
	}

	public ProductView(int id, String name, int capacity, int kcal, int natrium, int carbohydrate, int sugars, int fat,
			int transfat, int saturatedFat, int cholesterol, int protein, int mfrId, String mfr, String logo,
			int amount, int year, int quarter, String img) {
		this.id = id;
		this.name = name;
		this.capacity = capacity;
		this.kcal = kcal;
		this.natrium = natrium;
		this.carbohydrate = carbohydrate;
		this.sugars = sugars;
		this.fat = fat;
		this.transfat = transfat;
		this.saturatedFat = saturatedFat;
		this.cholesterol = cholesterol;
		this.protein = protein;
		this.mfrId = mfrId;
		this.mfr = mfr;
		this.logo = logo;
		this.amount = amount;
		this.year = year;
		this.quarter = quarter;
		this.img = img;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getKcal() {
		return kcal;
	}

	public void setKcal(int kcal) {
		this.kcal = kcal;
	}

	public int getNatrium() {
		return natrium;
	}

	public void setNatrium(int natrium) {
		this.natrium = natrium;
	}

	public int getCarbohydrate() {
		return carbohydrate;
	}

	public void setCarbohydrate(int carbohydrate) {
		this.carbohydrate = carbohydrate;
	}

	public int getSugars() {
		return sugars;
	}

	public void setSugars(int sugars) {
		this.sugars = sugars;
	}

	public int getFat() {
		return fat;
	}

	public void setFat(int fat) {
		this.fat = fat;
	}

	public int getTransfat() {
		return transfat;
	}

	public void setTransfat(int transfat) {
		this.transfat = transfat;
	}

	public int getSaturatedFat() {
		return saturatedFat;
	}

	public void setSaturatedFat(int saturatedFat) {
		this.saturatedFat = saturatedFat;
	}

	public int getCholesterol() {
		return cholesterol;
	}

	public void setCholesterol(int cholesterol) {
		this.cholesterol = cholesterol;
	}

	public int getProtein() {
		return protein;
	}

	public void setProtein(int protein) {
		this.protein = protein;
	}

	public int getMfrId() {
		return mfrId;
	}

	public void setMfrId(int mfrId) {
		this.mfrId = mfrId;
	}

	public String getMfr() {
		return mfr;
	}

	public void setMfr(String mfr) {
		this.mfr = mfr;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getQuarter() {
		return quarter;
	}

	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "ProductView [id=" + id + ", name=" + name + ", capacity=" + capacity + ", kcal=" + kcal + ", natrium="
				+ natrium + ", carbohydrate=" + carbohydrate + ", sugars=" + sugars + ", fat=" + fat + ", transfat="
				+ transfat + ", saturatedFat=" + saturatedFat + ", cholesterol=" + cholesterol + ", protein=" + protein
				+ ", mfrId=" + mfrId + ", mfr=" + mfr + ", logo=" + logo + ", amount=" + amount + ", year=" + year
				+ ", quarter=" + quarter + ", img=" + img + "]";
	}

}
