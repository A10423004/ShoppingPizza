package client.model;

public class MozzarellaConcreateDecorator extends PizzaDecorator{
	private CartItem item;
	
	public MozzarellaConcreateDecorator(CartItem cartItem) {
		super(cartItem);
		this.item = cartItem;
	}
	
	//取得Mozzarella的名子
	public String getName() {
		item.setName("Mozzarella " + item.getName());
		return item.getName();
	}
	
	//取得Mozzarella的價錢
	public double getPrice() {
		item.setPrice(item.getPrice() + 50.0);
		return item.getPrice();
	}
	
}
