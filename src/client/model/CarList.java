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
	//算總價錢
	public double getTotalCost() {
		double total = 0.0;
		try{
			for(CartItem item : list){
				total = getStrategy() + totalPrice;
			}
			return total;
		}
		catch(Exception e){
			System.out.println("請選擇取餐方式!!");
			return (Double) null;
		}
	}
	//set設置Strategy的方法
	public void setStrategy(Strategy s){
		this.strategy = s;
	}
	//get取得Strategy的getTransportPrice()方法
	public double getStrategy(){
		return strategy.getTakewaymealPrice();
	}
	//set設置PizzaComponentPrice的方法
	public void setPrice(double price) {
		this.totalPrice = price;
	}
	
}
