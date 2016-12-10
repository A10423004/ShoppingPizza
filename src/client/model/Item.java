package client.model;

public class Item {
	private String name;		//�f��
	private String crust;		//���
	private String mains;		//�D�\
	private String sauce;		//���
	private String topping;		//pizza�W�����t��
	private double price;		//����
	
	public Item(String name, double price, String crust, String mains, String sauce, String topping){
		setName(name);
		setPrice(price);
		setCrust(crust);
		setMains(mains);
		setSauce(sauce);
		setTopping(topping);
	}

	public Item(String name, double price) {
		// TODO Auto-generated constructor stub
		setName(name);
		setPrice(price);
	}

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

	public String getName(){
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
