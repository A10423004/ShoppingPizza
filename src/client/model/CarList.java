package client.model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CarList implements List{
	private ArrayList<CartItem> list;
	private Strategy strategy;
	double totalPrice =0;
	
	public CarList() {
		list = new ArrayList<CartItem>();
	}
	public void add(Item item) {
		list.add((CartItem)item);
	}
	public Item remove(int index) {
		CartItem item = list.get(index);
		list.remove(index);
		return item;
	}
	public void removeAll() {
		list.clear();
	}

	public int getLength() {
		return list.size();
	}
	public CartItem getItemAt(int index) {
		return list.get(index);
	}
	public Iterator iterator() {
		return new CartListIterator(this);
	}
	//���`����
	public double getTotalCost() {
		double total = 0.0;
		try{
			for(CartItem item : list){
				total = getStrategy() + totalPrice;
			}
			return total;
		}
		catch(Exception e){
			System.out.println("�п�ܨ��\�覡!!");
			return (Double) null;
		}
	}
	//set�]�mStrategy����k
	public void setStrategy(Strategy s){
		this.strategy = s;
	}
	//get���oStrategy��getTransportPrice()��k
	public double getStrategy(){
		return strategy.getTakewaymealPrice();
	}
	//set�]�mPizzaComponentPrice����k
	public void setPrice(double price) {
		this.totalPrice = price;
	}
	
}
