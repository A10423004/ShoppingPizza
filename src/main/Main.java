package main;
import java.util.Scanner;

import client.controller.Controller;
import client.view.MenuView2;
import server.model.CenterConsole;
import server.model.Director;
import server.model.PizzaBuilder;
import server.model.PizzaKinds;

public class Main {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in); 
		
		CenterConsole centerConsole = CenterConsole.getProduct();
		
		MenuView2 mv = new MenuView2();
		Controller controller = new Controller(mv);
		
		centerConsole.register(controller);

		//new a pizza kinds
		PizzaKinds hawaiian = new PizzaKinds();
		
		//set pizza name, price, crust, mains, sauce and topping
		hawaiian.setName("Hawaiian");
		hawaiian.setPrice(100.0);
		hawaiian.setCrust("thick");
		hawaiian.setMains("ham¡B pineapple");
		hawaiian.setSauce("mayonnaise");
		hawaiian.setTopping("cheese powder");
		
		PizzaBuilder hawaiianpizza = new PizzaBuilder();
		Director director = new Director(hawaiianpizza);
		director.construct(hawaiian);
		
		System.out.println("Is there any update?(y/n)");
		String check = cin.nextLine();
		if(check.toLowerCase().equals("y")){
			centerConsole.addNewItem(hawaiian.getName(), hawaiian.getPrice(), hawaiian.getCrust(), hawaiian.getMains(), hawaiian.getSauce(), hawaiian.getTopping());
		}
		
		
	}
}
