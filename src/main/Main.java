package main;
import java.util.InputMismatchException;
import java.util.Scanner;

import client.controller.Controller;
import client.view.MenuView2;
import server.model.CenterConsole;
import server.model.Director;
import server.model.PizzaBuilder;
import server.model.PizzaKinds;

public class Main {
	public static void main(String[] args) {
		String name, crust, mains, sauce, topping;
		double price = 0;
		boolean num = true;
		Scanner cin = new Scanner(System.in); 
				
		CenterConsole centerConsole = CenterConsole.getProduct();
		
		MenuView2 mv = new MenuView2();
		Controller controller = new Controller(mv);
		centerConsole.register(controller);
		
		
		
		while(true){
		
			System.out.println("New Pizza Kinds: ");
			name = cin.next();
			
			System.out.println("Crust: ");
			crust = cin.next();
			
			System.out.println("Mains: ");
			mains = cin.next();
			
			System.out.println("Sauce: ");
			sauce = cin.next();
			
			System.out.println("Topping: ");
			topping = cin.next();
			
			System.out.println("Price: ");
		
			while(num){
				try {
					price = cin.nextDouble();
					num = false;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Please enter number!");
					cin.next();
				}
			}
			num = true;
										
			PizzaBuilder newkindspizza = new PizzaBuilder();
			Director director = new Director(newkindspizza);
			director.construct(name, price, crust, mains, sauce, topping);
			PizzaKinds pizza = newkindspizza.getPizza();
		
			centerConsole.addNewItem(pizza.getName(), pizza.getPrice(), pizza.getCrust(), pizza.getMains(), pizza.getSauce(), pizza.getTopping());

		}
		
		
	}
}
