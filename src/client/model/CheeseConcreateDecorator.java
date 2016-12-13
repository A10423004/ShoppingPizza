package client.model;

public class CheeseConcreateDecorator extends PizzaDecorator{
	
	public CheeseConcreateDecorator(PizzaComponent PizzaComponent) {
		super(PizzaComponent);
	}
	
	public String  getName() {
		return "Cheese" + PizzaComponent.getName();
	}
	
	public double getPrice() {
		return this.PizzaComponent.getPrice() + 60.0;
	}
	
}
