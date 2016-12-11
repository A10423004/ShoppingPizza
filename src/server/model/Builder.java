package server.model;

public interface Builder{
	public void buildPizza(String name, double price, String crust, String mains, String sauce, String topping);
	public PizzaKinds getPizza();
}