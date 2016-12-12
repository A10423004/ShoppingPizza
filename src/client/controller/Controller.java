package client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import client.model.CarList;
import client.model.CartItem;
import client.model.CashOnDeliveryPrice;
import client.model.Db2;
import client.model.Iterator;
import client.model.MailPrice;
import client.model.ShopList;
import client.model.Strategy;
import client.view.MenuView2;
import server.model.Observer;

public class Controller implements Observer{
	private MenuView2 menuView2;
	private ShopList shopList;
	private CarList carList;
	private Strategy strategy;
	
	
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
		//Bymail���s��ť��
		menuView2.addRbBymailActionListener(new RbBymailActionListener());
		//Cashondelivery���s��ť��
		menuView2.addRbCashondeliveryActionListener(new RbCashondeliveryActionListener());
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
				carList.add(new CartItem(itemName, price, itemCrust, itemMains, itemSauce, itemTopping ));
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
			//���b���Y��L�ʧ@�A���b������~���ʧ@
			
				carList.remove(0);				
				//��s�ʪ����e��
				showCarItems();
				menuView2.shwoPizzaName("Kinds: ");
				menuView2.shwoPizzaCrust("Crust: ");
				menuView2.shwoPizzaMains("Mains: ");
				menuView2.shwoPizzaSauce("Sauce: ");
				menuView2.shwoPizzaTopping("Topping: ");
				//�p�G�R���F�N����A�R���P���b�F
					menuView2.setButtonDelEnabled(false);
					menuView2.setCheckOutEnabled(false);
					menuView2.setButtonBuyEnabled(true);
		}
	}
	
	//CheckOut�����s�ʧ@
	class CheckOutActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//�P�_Strategy���B�e�覡�O���@�ءA�A��۹�����Strategy new�X�ӡA�ǶiCarList
			if(menuView2.rbRbBymail_isSelected()){//�ϥΪ��I��mail�覡
				strategy = new MailPrice();
				carList.setStrategy(strategy);
			}
			else if(menuView2.rbCashondelivery_isSelected()){//�ϥΪ��I��Cashondelivery�覡
				strategy = new CashOnDeliveryPrice();
				carList.setStrategy(strategy);
			}else{//�Y���S���I��h���X
				String msg = "�п�ܹB�e�覡!!";
				menuView2.showCheckOutMessage(msg);
				return;
			}
			/*�H�U�i�J���b�{��*/
			//���s��������
			menuView2.setButtonBuyEnabled(false);
			menuView2.setButtonDelEnabled(false);
			menuView2.setCheckOutEnabled(false);
			menuView2.setRbBymailEnabled(false);
			menuView2.setRbCashondeliveryEnabled(false);
			//�}�l���b
			String msg = "The total price is " + carList.getTotalCost() + "NTD.\nThank you and come again.";
			menuView2.showCheckOutMessage(msg);
			String str = "";
			str += "Item Name|    Price|    Subtotal\n";
			str += "-------------------------+---------+------------\n";
			Iterator iterator = carList.iterator();
			int i = 0;
			while(iterator.hasNext()){
				CartItem cartItem = (CartItem) iterator.Next();
				String name = cartItem.getName();
				double price = cartItem.getPrice();
				str += String.format("%25s|%12.2f\n", name, price);
				i++;
			}
			str += "-------------------------+----------+------------\n";
			str += String.format("Total: %.2f\n", carList.getTotalCost());
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
	
	//Bymail���s�ʧ@
	class RbBymailActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			menuView2.setTransportmethodText("�l�H");
		}
	}
	
	//Cashondelivery���s�ʧ@
	class RbCashondeliveryActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			menuView2.setTransportmethodText("�f��I��");
		}
	}

	
}
