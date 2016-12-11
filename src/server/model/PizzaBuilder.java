package server.model;

public class PizzaBuilder implements Builder{

	private PizzaKinds pizzakinds = new PizzaKinds();
	@Override
	public void buildPizza(String name, double price, String crust,
			String mains, String sauce, String topping) {
		// TODO Auto-generated method stub
		pizzakinds.setName(name);
		pizzakinds.setPrice(price);
		pizzakinds.setCrust(crust);
		pizzakinds.setMains(mains);
		pizzakinds.setSauce(sauce);
		pizzakinds.setTopping(topping);
	}
	
	@Override
	public PizzaKinds getPizza() {
		// TODO Auto-generated method stub
		return pizzakinds;
	}

}
