package server.model;

public class Director {
	private Builder builder;

	
	public Director(Builder builder){
		this.builder = builder;
	}
	
	public void construct(String name, double price, String crust, String mains, String sauce, String topping){
		builder.buildPizza(name, price, crust, mains, sauce, topping);
	}
}
