package server.model;

import client.model.PizzaComponent;

public class PizzaKinds extends PizzaComponent{
	private String name;		//�f��
	private String crust;		//���
	private String mains;		//�D�\
	private String sauce;		//���
	private String topping;		//pizza�W�����t��
	private double price;		//����
	
	//////////////////////////////////////////////set
	public void setName(String name){
		this.name = name;
	}
	
	public void setPrice(double price){
		this.price = price;
	}
	
	public void setCrust(String crust){
		this.crust = crust;
	}
	
	public void setMains(String mains){
		this.mains = mains;
	}
	
	public void setSauce(String sauce){
		this.sauce = sauce;
	}
	
	public void setTopping(String topping){
		this.topping = topping;
	}
	
	////////////////////////////////////////////////get
	
	public String  getName(){
		return name;
	}
	
	public double getPrice(){
		return price;
	}
	
	public String getCrust(){
		return crust;
	}
	
	public String getMains(){
		return mains;
	}
	
	public String getSauce(){
		return sauce;
	}
	
	public String getTopping(){
		return topping;
	}

}
