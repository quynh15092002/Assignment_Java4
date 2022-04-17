package Entities;

public class Cart {
	private int id;
	private Product product;
	private int amount;
	
	public Cart() {
		//
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getAmount() {
		return amount;
	}
	public int addQuantity() {
		return this.amount++;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", product=" + product + ", amount=" + amount + "]";
	}

	public Cart(Product product, int amount) {
		super();
		this.product = product;
		this.amount = amount;
	}
	
	
}
