package server.model;

public class PizzaBuilder implements Builder{

	private StringBuffer sb = new StringBuffer();
	
	@Override
	public void buildPizza(PizzaKinds pizzakinds) {
		// TODO Auto-generated method stub
		sb.append(pizzakinds.getName());
		sb.append("\nCrust: ");
		sb.append(pizzakinds.getCrust());
		sb.append("\nMains: ");
		sb.append(pizzakinds.getMains());
		sb.append("\nSauce: ");
		sb.append(pizzakinds.getSauce());
		sb.append("\nTopping: ");
		sb.append(pizzakinds.getTopping());
	}
	
	public StringBuffer getResult(){
		return sb;
	}

}
