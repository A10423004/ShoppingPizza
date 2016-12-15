package client.model;

public abstract class PizzaDecorator implements PizzaComponent{
	
	protected PizzaComponent PizzaComponent;
	
	public PizzaDecorator(PizzaComponent pizzaComponent) {
		this.PizzaComponent = pizzaComponent;
	}
}
