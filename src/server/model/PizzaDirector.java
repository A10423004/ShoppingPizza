package server.model;

public class PizzaDirector {
	private Builder builder;

	
	public PizzaDirector(Builder builder){
		this.builder = builder;
	}
	
	public void construct(String name, double price, String crust, String mains, String sauce, String topping){
		builder.buildPizza(name, price, crust, mains, sauce, topping);
	}
}
