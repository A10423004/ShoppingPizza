package client.model;

public class CheeseConcreateDecorator extends PizzaDecorator{
	private CartItem item;
	
	public CheeseConcreateDecorator(CartItem cartItem) {
		super(cartItem);
		this.item = cartItem;
	}
	
	//取得Cheese的名子
	public String getName() {
		item.setName("Cheese" + item.getName());
		return item.getName();
	}
	
	//取得Cheese的價錢
	public double getPrice() {
		item.setPrice(item.getPrice() + 60.0);
		return item.getPrice();
	}
	
}
