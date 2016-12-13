package client.model;

public class TomatosauceConcreateDecorator extends PizzaDecorator{
	
	public TomatosauceConcreateDecorator(PizzaComponent PizzaComponent) {
		super(PizzaComponent);
	}

	@Override
	public String getName() {
		return "Tomatosauce" + this.PizzaComponent.getName();
	}
	
	@Override
	public double getPrice() {
		return this.PizzaComponent.getPrice() + 30.0;
	}
	
}
