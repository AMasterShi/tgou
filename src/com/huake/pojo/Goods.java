package com.huake.pojo;

public class Goods {
	private int id;
	private String title;
	private int oldMoney;
	private int money;
	private String goodNumber;
	private String goodIntroduction;
	private String sellNumber;
	private String images;
	private int newgoods;
	private int sellwell;
	
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Goods(String title, int oldMoney, int money, String goodNumber, String goodIntroduction, String sellNumber,
			int newgoods, int sellwell, String images) {
		super();
		this.title = title;
		this.oldMoney = oldMoney;
		this.money = money;
		this.goodNumber = goodNumber;
		this.goodIntroduction = goodIntroduction;
		this.sellNumber = sellNumber;
		this.images = images;
		this.newgoods = newgoods;
		this.sellwell = sellwell;
	}

	public Goods(int id, String title, int oldMoney, int money, String goodNumber, String goodIntroduction,
			String sellNumber, String images) {
		super();
		this.id = id;
		this.title = title;
		this.oldMoney = oldMoney;
		this.money = money;
		this.goodNumber = goodNumber;
		this.goodIntroduction = goodIntroduction;
		this.sellNumber = sellNumber;
		this.images = images;
	}

	public Goods(String title, int oldMoney, int money, String goodNumber, String goodIntroduction,
			String sellNumber, String images) {
		super();
		this.title = title;
		this.oldMoney = oldMoney;
		this.money = money;
		this.goodNumber = goodNumber;
		this.goodIntroduction = goodIntroduction;
		this.sellNumber = sellNumber;
		this.images = images;
	}

	public Goods(String title, int oldMoney, int money, String goodNumber, String goodIntroduction,
			String sellNumber) {
		super();
		this.title = title;
		this.oldMoney = oldMoney;
		this.money = money;
		this.goodNumber = goodNumber;
		this.goodIntroduction = goodIntroduction;
		this.sellNumber = sellNumber;
	}
	public Goods(int id, String title, int oldMoney, int money, String goodNumber, String goodIntroduction,
			String sellNumber, int newgoods, int sellwell, String images) {
		super();
		this.id = id;
		this.title = title;
		this.oldMoney = oldMoney;
		this.money = money;
		this.goodNumber = goodNumber;
		this.goodIntroduction = goodIntroduction;
		this.sellNumber = sellNumber;
		this.images = images;
		this.newgoods = newgoods;
		this.sellwell = sellwell;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getOldMoney() {
		return oldMoney;
	}

	public void setOldMoney(int oldMoney) {
		this.oldMoney = oldMoney;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getGoodNumber() {
		return goodNumber;
	}

	public void setGoodNumber(String goodNumber) {
		this.goodNumber = goodNumber;
	}

	public String getGoodIntroduction() {
		return goodIntroduction;
	}

	public void setGoodIntroduction(String goodIntroduction) {
		this.goodIntroduction = goodIntroduction;
	}

	public String getSellNumber() {
		return sellNumber;
	}

	public void setSellNumber(String sellNumber) {
		this.sellNumber = sellNumber;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public int getNewgoods() {
		return newgoods;
	}

	public void setNewgoods(int newgoods) {
		this.newgoods = newgoods;
	}

	public int getSellwell() {
		return sellwell;
	}

	public void setSellwell(int sellwell) {
		this.sellwell = sellwell;
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", title=" + title + ", oldMoney=" + oldMoney + ", money=" + money + ", goodNumber="
				+ goodNumber + ", goodIntroduction=" + goodIntroduction + ", sellNumber=" + sellNumber + ", images="
				+ images + ", newgoods=" + newgoods + ", sellwell=" + sellwell + "]";
	}
}
