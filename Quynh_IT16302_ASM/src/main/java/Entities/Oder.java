package Entities;

import java.util.List;

public class Oder {
	private int id;
	private List<Cart> carties;
	private User user;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Cart> getCarties() {
		return carties;
	}
	public void setCarties(List<Cart> carties) {
		this.carties = carties;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Oder [id=" + id + ", carties=" + carties + ", user=" + user + ", status=" + status + "]";
	}
	
	
}
