package main;
import java.util.Scanner;

import client.controller.Controller;
import client.view.MenuView2;
import server.model.CenterConsole;

public class Main {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		
		CenterConsole centerConsole = CenterConsole.getProduct();
		
		MenuView2 mv = new MenuView2();
		Controller controller = new Controller(mv);
		
		centerConsole.register(controller);
		
		System.out.println("Please enter item name and item price.\nUse spaces to separate it.");
		while(cin.hasNext()){
			centerConsole.addNewItem(cin.next(), cin.nextDouble());
		}
	}
}
