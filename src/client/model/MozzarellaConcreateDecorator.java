package client.model;

public class MozzarellaConcreateDecorator extends PizzaDecorator{
	private CartItem item;
	
	public MozzarellaConcreateDecorator(CartItem cartItem) {
		super(cartItem);
		this.item = cartItem;
	}
	
	//���oMozzarella���W�l
	public String getName() {
		item.setName("Mozzarella " + item.getName());
		return item.getName();
	}
	
	//���oMozzarella������
	public double getPrice() {
		item.setPrice(item.getPrice() + 50.0);
		return item.getPrice();
	}
	
}
