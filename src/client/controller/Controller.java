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
		//��ܰӫ~�C��
		loadItemList();
		//����ʪ������Y
		showCarItems();
		/*�H�U����ť���]�w*/
		//�ӫ~�M���ť��
		menuView2.addShopListSelectionListener(new ShopListSelectionListener());
		//>���s��ť��
		menuView2.addButtonBuyActionListener(new ButtonBuyActionListener());
		//<���s��ť��
		menuView2.addButtonDelActionListener(new ButtonDelActionListener());
		//CheckOut���s��ť��
		menuView2.addCheckOutActionListener(new CheckOutActionListener());
		//Bill���s��ť��
		menuView2.addBillActionListener(new BillActionListener());
		//Exit���s��ť��
		menuView2.addExitActionListener(new ExitActionListener());
		//Pickup���s��ť��
		menuView2.addRbPickupActionListener(new RbPickupActionListener());
		//Delivery���s��ť��
		menuView2.addRbDeliveryActionListener(new RbDeliveryActionListener());
		//Cheese���s��ť��
		menuView2.addCheeseActionListener(new CheeseActionListener());
		//Mozzarella���s��ť��
		menuView2.addMozzarellaActionListener(new MozzarellaActionListener());
		//Tomatosauce���s��ť��
		menuView2.addTomatosauceActionListener(new TomatosauceActionListener());
		/*��ť���]�w����*/
		
		//����<�BCheckOut�BBill���s�����I��
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
	
	//���J�ӫ~�M��
	private void loadItemList() {
		menuView2.removeAllShopItem();
		Iterator iterator = shopList.iterator();
		while(iterator.hasNext()){
			menuView2.addShopItem(iterator.Next().getName());
		}
	}
	
	//�]�w�ӫ~�C����ť��
	class ShopListSelectionListener implements ListSelectionListener{
		public void valueChanged(ListSelectionEvent e) {
			//�p�G����_�Ǫ�index�N���n���
			if(menuView2.getSelectShopListIndex() >= 0){
				menuView2.setShopItemPrice(shopList.getItemAt(menuView2.getSelectShopListIndex()).getPrice());
			}
		}
	}
	
	//���U>�ʶR���ʧ@��ť��
	class ButtonBuyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int selectIndex = menuView2.getSelectShopListIndex();
			//�����b������~���ʧ@
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
				//��s�ʪ����e��
				showCarItems();
				//���}<�BCheckOut���s���I��
				menuView2.setButtonDelEnabled(true);
				menuView2.setCheckOutEnabled(true);
				menuView2.setButtonBuyEnabled(false);
			}
		}
	}
	
	
	
	//��s�ʪ����M��
	public void showCarItems() {
		//���M���ʪ���
		menuView2.carListClear();
		//�M���J����
		menuView2.addCarItem("Item Name");
		menuView2.addCarItem("-----------\n");
		Iterator iterator = carList.iterator();
		while(iterator.hasNext()){
			CartItem cartItem = (CartItem) iterator.Next();
			String name = cartItem.getName();
			menuView2.addCarItem(String.format("%s\n", name));
		}
	}
	
	//���U<�R�����ʧ@��ť��
	class ButtonDelActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int selectIndex = menuView2.getSelectCarListIndex() - 2;
			//���b���Y��L�ʧ@�A���b������~���ʧ@
			if(selectIndex >= 0){
				carList.remove(selectIndex);				
				//��s�ʪ����e��
				showCarItems();
				menuView2.shwoPizzaName("Kinds: ");
				menuView2.shwoPizzaCrust("Crust: ");
				menuView2.shwoPizzaMains("Mains: ");
				menuView2.shwoPizzaSauce("Sauce: ");
				menuView2.shwoPizzaTopping("Topping: ");
				//�p�G�R���F�N����A�R���P���b�F
				if(carList.getLength() == 0){
					menuView2.setButtonDelEnabled(false);
					menuView2.setCheckOutEnabled(false);
					menuView2.setButtonBuyEnabled(true);
				}
			}
		}
	}
	
	//CheckOut�����s�ʧ@
	class CheckOutActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//�P�_Strategy���B�e�覡�O���@�ءA�A��۹�����Strategy new�X�ӡA�ǶiCarList
			if(menuView2.rbRbPickup_isSelected()){//�ϥΪ��I��Pickup�覡
				strategy = new PickupStrategy();
				carList.setStrategy(strategy);
			}
			else if(menuView2.rbDelivery_isSelected()){//�ϥΪ��I��Delivery�覡
				strategy = new DeliveryStrategy();
				carList.setStrategy(strategy);
			}else{//�Y���S���I��h���X
				String msg = "�п�ܨ��\�覡!!";
				menuView2.showCheckOutMessage(msg);
				return;
			}
			/*�H�U�i�J���b�{��*/
			//���s��������
			menuView2.setButtonBuyEnabled(false);
			menuView2.setButtonDelEnabled(false);
			menuView2.setCheckOutEnabled(false);
			menuView2.setRbPickupEnabled(false);
			menuView2.setRbDeliveryEnabled(false);
			//�}�l���b
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
			//�̫ᥴ�}Bill���s
			menuView2.setBillEnabled(true);
		}
	}
	
	//Bill���s�ʧ@
	class BillActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				Runtime.getRuntime().exec("cmd /c start Bill.txt");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	//Exit���s�ʧ@
	class ExitActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	//Pickup���s�ʧ@
	class RbPickupActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			menuView2.setTakewaymealText("�ۨ�");
		}
	}
			
	//Delivery���s�ʧ@
	class RbDeliveryActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			menuView2.setTakewaymealText("�~�e");
		}
	}
		
	//Cheese���s�ʧ@
	class CheeseActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			PizzaComponent = new CheeseConcreateDecorator(cartitem);
			cartitem.setName(PizzaComponent.getName());
			menuView2.setlbSelect("Select�G " + cartitem.getName());
			
			carList.setPrice(PizzaComponent.getPrice());
		}
	}
		
	//Mozzarella���s�ʧ@
	class MozzarellaActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			PizzaComponent= new MozzarellaConcreateDecorator(cartitem);
			cartitem.setName(PizzaComponent.getName());
			menuView2.setlbSelect("Select�G" + cartitem.getName());
			
			carList.setPrice(PizzaComponent.getPrice());
		}
	}
		
	//Tomatosauce���s�ʧ@
	class TomatosauceActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			PizzaComponent = new TomatosauceConcreateDecorator(cartitem);
			cartitem.setName(PizzaComponent.getName());
			menuView2.setlbSelect("Select�G" + cartitem.getName());
			
			carList.setPrice(PizzaComponent.getPrice());
		}
	}
	
}
