package client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import client.controller.Controller.CheeseActionListener;
import client.controller.Controller.TomatosauceActionListener;
import client.controller.Controller.MozzarellaActionListener;
import client.controller.Controller.RbDeliveryActionListener;
import client.controller.Controller.RbPickupActionListener;
import client.model.CarList;
import client.model.CartItem;
import client.model.CheeseConcreateDecorator;
import client.model.DeliveryStrategy;
import client.model.Db2;
import client.model.Iterator;
import client.model.MozzarellaConcreateDecorator;
import client.model.PickupStrategy;
import client.model.PizzaComponent;
import client.model.ShopList;
import client.model.Strategy;
import client.model.TomatosauceConcreateDecorator;
import client.view.MenuView2;
import server.model.Observer;
import server.model.PizzaKinds;

public class Controller implements Observer{
	private MenuView2 menuView2;
	private ShopList shopList;
	private CarList carList;
	private Strategy strategy;
	private CartItem cartitem;
	private PizzaComponent PizzaComponent;
	double totalPrice;
	
	public Controller(MenuView2 menuView2) {
		this.menuView2 = menuView2;
		this.menuView2.show();
		shopList = new ShopList();
		carList = new CarList();
		//顯示商品列表
		loadItemList();
		//顯示購物車標頭
		showCarItems();
		/*以下為監聽器設定*/
		//商品清單監聽器
		menuView2.addShopListSelectionListener(new ShopListSelectionListener());
		//>按鈕監聽器
		menuView2.addButtonBuyActionListener(new ButtonBuyActionListener());
		//<按鈕監聽器
		menuView2.addButtonDelActionListener(new ButtonDelActionListener());
		//CheckOut按鈕監聽器
		menuView2.addCheckOutActionListener(new CheckOutActionListener());
		//Bill按鈕監聽器
		menuView2.addBillActionListener(new BillActionListener());
		//Exit按鈕監聽器
		menuView2.addExitActionListener(new ExitActionListener());
		//Pickup按鈕監聽器
		menuView2.addRbPickupActionListener(new RbPickupActionListener());
		//Delivery按鈕監聽器
		menuView2.addRbDeliveryActionListener(new RbDeliveryActionListener());
		//Cheese按鈕監聽器
		menuView2.addCheeseActionListener(new CheeseActionListener());
		//Mozzarella按鈕監聽器
		menuView2.addMozzarellaActionListener(new MozzarellaActionListener());
		//Tomatosauce按鈕監聽器
		menuView2.addTomatosauceActionListener(new TomatosauceActionListener());
		/*監聽器設定結束*/
		
		//限制<、CheckOut、Bill按鈕不能點選
		menuView2.setButtonDelEnabled(false);
		menuView2.setCheckOutEnabled(false);
		menuView2.setBillEnabled(false);
	}
	
	//Observer
	@Override
	public void update(ShopList shoplist) {
		this.shopList = shoplist;
		loadItemList();
	}
	
	//載入商品清單
	private void loadItemList() {
		menuView2.removeAllShopItem();
		Iterator iterator = shopList.iterator();
		while(iterator.hasNext()){
			menuView2.addShopItem(iterator.Next().getName());
		}
	}
	
	//設定商品列表的監聽器
	class ShopListSelectionListener implements ListSelectionListener{
		public void valueChanged(ListSelectionEvent e) {
			//如果按到奇怪的index就不要顯示
			if(menuView2.getSelectShopListIndex() >= 0){
				menuView2.setShopItemPrice(shopList.getItemAt(menuView2.getSelectShopListIndex()).getPrice());
			}
		}
	}
	
	//按下>購買的動作監聽器
	class ButtonBuyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int selectIndex = menuView2.getSelectShopListIndex();
			//有按在項目欄才有動作
			if(selectIndex >= 0){
				String itemName = shopList.getItemAt(selectIndex).getName();
				double price = shopList.getItemAt(selectIndex).getPrice();
				String itemCrust = shopList.getItemAt(selectIndex).getCrust();
				String itemMains = shopList.getItemAt(selectIndex).getMains();
				String itemSauce = shopList.getItemAt(selectIndex).getSauce();
				String itemTopping = shopList.getItemAt(selectIndex).getTopping();
				cartitem = new CartItem(itemName, price, itemCrust, itemMains, itemSauce, itemTopping );
				carList.add(cartitem);
				menuView2.shwoPizzaName("Kinds: " + itemName);
				menuView2.shwoPizzaCrust("Crust: " + itemCrust);
				menuView2.shwoPizzaMains("Mains: " + itemMains);
				menuView2.shwoPizzaSauce("Sauce: " + itemSauce);
				menuView2.shwoPizzaTopping("Topping: " + itemTopping);
				//更新購物車畫面
				showCarItems();
				//打開<、CheckOut按鈕供點選
				menuView2.setButtonDelEnabled(true);
				menuView2.setCheckOutEnabled(true);
				menuView2.setButtonBuyEnabled(false);
			}
		}
	}
	
	
	
	//更新購物車清單
	public void showCarItems() {
		//先清空購物車
		menuView2.carListClear();
		//然後填入項目
		menuView2.addCarItem("Item Name");
		menuView2.addCarItem("-----------\n");
		Iterator iterator = carList.iterator();
		while(iterator.hasNext()){
			CartItem cartItem = (CartItem) iterator.Next();
			String name = cartItem.getName();
			menuView2.addCarItem(String.format("%s\n", name));
		}
	}
	
	//按下<刪除的動作監聽器
	class ButtonDelActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int selectIndex = menuView2.getSelectCarListIndex() - 2;
			//按在標頭欄無動作，按在項目欄才有動作
			if(selectIndex >= 0){
				carList.remove(selectIndex);				
				//更新購物車畫面
				showCarItems();
				menuView2.shwoPizzaName("Kinds: ");
				menuView2.shwoPizzaCrust("Crust: ");
				menuView2.shwoPizzaMains("Mains: ");
				menuView2.shwoPizzaSauce("Sauce: ");
				menuView2.shwoPizzaTopping("Topping: ");
				//如果刪光了就不能再刪除與結帳了
				if(carList.getLength() == 0){
					menuView2.setButtonDelEnabled(false);
					menuView2.setCheckOutEnabled(false);
					menuView2.setButtonBuyEnabled(true);
				}
			}
		}
	}
	
	//CheckOut的按鈕動作
	class CheckOutActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//判斷Strategy的運送方式是哪一種，再把相對應的Strategy new出來，傳進CarList
			if(menuView2.rbRbPickup_isSelected()){//使用者點選Pickup方式
				strategy = new PickupStrategy();
				carList.setStrategy(strategy);
			}
			else if(menuView2.rbDelivery_isSelected()){//使用者點選Delivery方式
				strategy = new DeliveryStrategy();
				carList.setStrategy(strategy);
			}else{//若都沒有點選則跳出
				String msg = "請選擇取餐方式!!";
				menuView2.showCheckOutMessage(msg);
				return;
			}
			/*以下進入結帳程序*/
			//按鈕全部關閉
			menuView2.setButtonBuyEnabled(false);
			menuView2.setButtonDelEnabled(false);
			menuView2.setCheckOutEnabled(false);
			menuView2.setRbPickupEnabled(false);
			menuView2.setRbDeliveryEnabled(false);
			//開始結帳
			String msg = "The total price is " + carList.getTotalCost() + "NTD.\nThank you and come again.";
			menuView2.showCheckOutMessage(msg);
			String str = "";
			str += "Item Name          |          Price|    TakePrice|    Subtotal\n";
			str += "-------------------+---------------+-------------+-------------\n";
			Iterator iterator = carList.iterator();
			int i = 0;
			while(iterator.hasNext()){
				CartItem cartItem = (CartItem) iterator.Next();
				String name = cartItem.getName();
				double price = cartItem.getPrice();
				double takeprice = carList.getStrategy();
				str += String.format("%s|%12.2f|%12.2f|%12.2f\n", name, price, takeprice, carList.getTotalCost());
				i++;
			}
			str += "-------------------+---------------+-------------+-------------\n";
			try {
				FileWriter fw = new FileWriter("Bill.txt");
				fw.write(str);
				fw.flush();
				fw.close();
				Runtime.getRuntime().exec("cmd /c start Bill.txt");
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			//最後打開Bill按鈕
			menuView2.setBillEnabled(true);
		}
	}
	
	//Bill按鈕動作
	class BillActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				Runtime.getRuntime().exec("cmd /c start Bill.txt");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	//Exit按鈕動作
	class ExitActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	//Pickup按鈕動作
	class RbPickupActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			menuView2.setTakewaymealText("自取");
		}
	}
			
	//Delivery按鈕動作
	class RbDeliveryActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			menuView2.setTakewaymealText("外送");
		}
	}
		
	//Cheese按鈕動作
	class CheeseActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			PizzaComponent = new CheeseConcreateDecorator(cartitem);
			cartitem.setName(PizzaComponent.getName());
			menuView2.setlbSelect("Select： " + cartitem.getName());
			
			carList.setPrice(PizzaComponent.getPrice());
		}
	}
		
	//Mozzarella按鈕動作
	class MozzarellaActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			PizzaComponent= new MozzarellaConcreateDecorator(cartitem);
			cartitem.setName(PizzaComponent.getName());
			menuView2.setlbSelect("Select：" + cartitem.getName());
			
			carList.setPrice(PizzaComponent.getPrice());
		}
	}
		
	//Tomatosauce按鈕動作
	class TomatosauceActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			PizzaComponent = new TomatosauceConcreateDecorator(cartitem);
			cartitem.setName(PizzaComponent.getName());
			menuView2.setlbSelect("Select：" + cartitem.getName());
			
			carList.setPrice(PizzaComponent.getPrice());
		}
	}
	
}
