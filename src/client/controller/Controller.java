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
		//RemoveAllItem���s��ť��
		menuView2.addRemoveAllItemActionListener(new RemoveAllItemActionListener());
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
				int num = menuView2.getSelectNum();
				double price = shopList.getItemAt(selectIndex).getPrice();
				carList.add(new CartItem(itemName, num, price));
				//��s�ʪ����e��
				showCarItems();
				//���}<�BCheckOut���s���I��
				menuView2.setButtonDelEnabled(true);
				menuView2.setCheckOutEnabled(true);
			}
		}
	}
	
	//��s�ʪ����M��
	public void showCarItems() {
		//���M���ʪ���
		menuView2.carListClear();
		//�M���J����
		menuView2.addCarItem("No.|                Item Name|  Quantity|    Price|    Subtotal");
		menuView2.addCarItem("---+-------------------------+----------+---------+-----------+\n");
		Iterator iterator = carList.iterator();
		int i = 0;
		while(iterator.hasNext()){
			CartItem cartItem = (CartItem) iterator.Next();
			String name = cartItem.getName();
			int quantity = cartItem.getQuantity();
			double price = cartItem.getPrice();
			menuView2.addCarItem(String.format("%3d|%25s|%10d|%9.2f|%12.2f\n", i, name, quantity, price, quantity * price));
			i++;
		}
	}
	
	//���U<�R�����ʧ@��ť��
	class ButtonDelActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int selectIndex = menuView2.getSelectCarListIndex() - 2;
			int num = menuView2.getSelectNum();
			//���b���Y��L�ʧ@�A���b������~���ʧ@
			if(selectIndex >= 0){
				carList.remove(selectIndex, num);
				//��s�ʪ����e��
				showCarItems();
				//�p�G�R���F�N����A�R���P���b�F
				if(carList.getLength() == 0){
					menuView2.setButtonDelEnabled(false);
					menuView2.setCheckOutEnabled(false);
				}
			}
		}
	}
	
	//�������������s�ʧ@
	class RemoveAllItemActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			carList.removeAll();
			showCarItems();
			menuView2.setButtonDelEnabled(false);
			menuView2.setCheckOutEnabled(false);
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
			menuView2.setRemoveAllItemEnabled(false);
			menuView2.setCheckOutEnabled(false);
			menuView2.setRbBymailEnabled(false);
			menuView2.setRbCashondeliveryEnabled(false);
			//�}�l���b
			String msg = "The total price is " + carList.getTotalCost() + "NTD.\nThank you and come again.";
			menuView2.showCheckOutMessage(msg);
			String str = "";
			str += "No.|                Item Name|  Quantity|    Price|    Subtotal\n";
			str += "---+-------------------------+----------+---------+------------\n";
			Iterator iterator = carList.iterator();
			int i = 0;
			while(iterator.hasNext()){
				CartItem cartItem = (CartItem) iterator.Next();
				String name = cartItem.getName();
				int quantity = cartItem.getQuantity();
				double price = cartItem.getPrice();
				str += String.format("%3d|%25s|%10d|%9.2f|%12.2f\n", i, name, quantity, price, quantity * price);
				i++;
			}
			str += "---+-------------------------+----------+---------+------------\n";
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
