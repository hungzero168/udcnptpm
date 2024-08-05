package models;

import java.util.List;

public class Bike {
	String bikecode, color, categorycode, imagelink;
	int amount;
	private List<Bike> bikes;

	public Bike() {
		super();
		this.bikecode = "";
		this.color = "";
		this.categorycode = "";
		this.amount = 0;
		this.imagelink = "";
		
	}

	public Bike(String bikecode, String color, String categorycode, int amount, String imagelink) {
		super();
		this.bikecode = bikecode;
		this.color = color;
		this.categorycode = categorycode;
		this.amount = amount;
		this.imagelink = imagelink;
	}

	public String getBikecode() {
		return bikecode;
	}

	public void setBikecode(String bikecode) {
		this.bikecode = bikecode;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCategorycode() {
		return categorycode;
	}

	public void setCategorycode(String categorycode) {
		this.categorycode = categorycode;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getImagelink() {
		return imagelink;
	}

	public void setImagelink(String imagelink) {
		this.imagelink = imagelink;
	}

}
