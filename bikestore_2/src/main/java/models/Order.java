package models;

public class Order {
	private String code;
	private String username;
	private String state;
	public Order() {}
	public Order(String code, String username, String state) {
		super();
		this.code = code;
		this.username = username;
		this.state = state;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
