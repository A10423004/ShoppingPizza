package client.model;

public class MozzarellaConcreateDecorator extends PizzaDecorator{
	
	public MozzarellaConcreateDecorator(PizzaComponent PizzaComponent) {
		super(PizzaComponent);
	}
	
	public String  getName() {
		return "Mozzarella" + this.PizzaComponent.getName();
	}
	
	public double getPrice() {
		return this.PizzaComponent.getPrice() + 50.0;
	}
	
}
