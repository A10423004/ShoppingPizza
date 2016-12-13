package client.model;

public abstract class PizzaDecorator extends PizzaComponent{
	
	protected PizzaComponent PizzaComponent;
	
	public PizzaDecorator(PizzaComponent PizzaComponent) {
		
		this.PizzaComponent = PizzaComponent;
	}
}
