package client.model;

public class TomatosauceConcreateDecorator extends PizzaDecorator{
	private CartItem item;
	private String name;
	
	public TomatosauceConcreateDecorator(CartItem cartItem) {
		super(cartItem);
		this.item = cartItem;
	}

	//���oTomatosauce���W�l
	public String getName() {
		item.setName("Tomatosauce " + item.getName());
		return item.getName();
	}
	
	//���oTomatosauce������
	@Override
	public double getPrice() {
		item.setPrice(item.getPrice() + 30.0);
		return item.getPrice();
	}
	
}
