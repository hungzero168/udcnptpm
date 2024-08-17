package models;

import java.util.List;

public class Category {
	private String code;
	private String name;
	private float price;
	
	private List<Bike> bikes;
	
	public Category() {
		super();
	}
	public Category(String code, String name, float price) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
	}
	
	
	
	public Category(String code, String name, float price, List<Bike> bikes) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.bikes = bikes;
	}
	public List<Bike> getBikes() {
        return bikes;
    }

    public void setBikes(List<Bike> bikes) {
        this.bikes = bikes;
    }
    
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
}
