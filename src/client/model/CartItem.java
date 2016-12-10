package client.model;
public class CartItem extends Item{
	private int quantity;
				
	public CartItem(String name, int quantity, double price) {
		// TODO Auto-generated constructor stub	public CartItem(String name, double price, int quantity){
		super(name, price);
		setQuantity(quantity);
	
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
