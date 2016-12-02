package server.model;

import java.util.ArrayList;

import client.model.ShopItem;
import client.model.ShopList;

public class CenterConsole implements Subject{
	private ArrayList<Observer> observers;
	private ShopList shoplist;
	
	public CenterConsole() {
		observers = new ArrayList<Observer>();
	}
	
	@Override
	public void register(Observer newObserver) {
		observers.add(newObserver);
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
}
