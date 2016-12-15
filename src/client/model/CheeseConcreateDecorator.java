package client.model;

public class CheeseConcreateDecorator extends PizzaDecorator{
	private CartItem item;
	
	public CheeseConcreateDecorator(CartItem cartItem) {
		super(cartItem);
		this.item = cartItem;
	}
	
	//���oCheese���W�l
	public String getName() {
		item.setName("Cheese" + item.getName());
		return item.getName();
	}
	
	//���oCheese������
	public double getPrice() {
		item.setPrice(item.getPrice() + 60.0);
		return item.getPrice();
	}
	
}
