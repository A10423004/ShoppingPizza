package client.model;

public class TomatosauceConcreateDecorator extends PizzaDecorator{
	private CartItem item;
	private String name;
	
	public TomatosauceConcreateDecorator(CartItem cartItem) {
		super(cartItem);
		this.item = cartItem;
	}

	//取得Tomatosauce的名子
	public String getName() {
		item.setName("Tomatosauce " + item.getName());
		return item.getName();
	}
	
	//取得Tomatosauce的價錢
	@Override
	public double getPrice() {
		item.setPrice(item.getPrice() + 30.0);
		return item.getPrice();
	}
	
}
