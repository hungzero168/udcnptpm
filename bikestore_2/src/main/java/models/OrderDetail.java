package models;

public class OrderDetail {
	private String ordercode;
	private String bikecode;
	private int amount;
	public OrderDetail(String ordercode, String bikecode, int amount) {
		super();
		this.ordercode = ordercode;
		this.bikecode = bikecode;
		this.amount = amount;
	}
	public String getOrdercode() {
		return ordercode;
	}
	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}
	public String getBikecode() {
		return bikecode;
	}
	public void setBikecode(String bikecode) {
		this.bikecode = bikecode;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	

}
