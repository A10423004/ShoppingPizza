package server.model;

public class PizzaKinds {
	private String name;		//口味
	private String crust;		//餅皮
	private String mains;		//主餐
	private String sauce;		//醬汁
	private String topping;		//pizza上面的配料
	private double price;		//價錢
	
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
