package client.model;
public class CartItem extends Item implements PizzaComponent {
	
	public CartItem(String name, double price, String crust, String mains, String sauce, String topping){
		super(name, price, crust, mains, sauce, topping);
	}
}
