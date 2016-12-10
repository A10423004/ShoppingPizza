package server.model;

public class Director {
	private Builder builder;
	
	public Director(Builder builder){
		this.builder = builder;
	}
	
	public void construct(PizzaKinds pizzakinds){
		builder.buildPizza(pizzakinds);
	}
}
