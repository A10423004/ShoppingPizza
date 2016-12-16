package server.model;

import java.util.ArrayList;

import client.model.Db2;
import client.model.ShopItem;
import client.model.ShopList;

public class CenterConsole implements Subject{
	private static CenterConsole centerConsole = new CenterConsole();
	
	private ArrayList<Observer> observers;
	private ShopList shoplist;
	
	
	private CenterConsole() {
		observers = new ArrayList<Observer>();
		shoplist = Db2.getProduct().readItem();
	}
	
	public static CenterConsole getProduct() {
		return centerConsole;
	}
	
	@Override
	public void register(Observer newObserver) {
		observers.add(newObserver);
		newObserver.update(shoplist);
	}

	@Override
	public void unregister(Observer deleteObserver) {
		int observerIndex = observers.indexOf(deleteObserver);
		if(observerIndex >= 0){
			observers.remove(observerIndex);
		}
	}

	@Override
	public void notifyObserver() {
		for(Observer observer : observers){
			observer.update(shoplist);
		}
	}
	
	
	
	
		
	/*測試用
	 * 測試加商品並通知Observer
	 * */
	public void addNewItem(String name, double price, String crust, String mains, String sauce, String topping){
		shoplist.add(new ShopItem(name,price, crust, mains, sauce, topping));
		notifyObserver();
		
	}
}
