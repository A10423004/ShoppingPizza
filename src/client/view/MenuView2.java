package client.view;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionListener;
import javax.swing.JRadioButton;

public class MenuView2 {
	private JFrame frmShoppingcart;
	/**
	 * Create the application.
	 */
	public MenuView2() {
		initialize();
	}
	public void show(){
		this.frmShoppingcart.setVisible(true);
	}
	public void hide(){
		this.frmShoppingcart.setVisible(false);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private JLabel lblShopItem;
	private DefaultListModel<String> itemModel;
	private JList<String> itemList;
	private JLabel lblPrice;
	private JButton button_buy;
	private JButton button_del;
	private JLabel lblShoppingcart;
	private DefaultListModel<String> cartModel;
	private JList<String> cartList;
	private JButton btnCheckOut;
	private JButton btnBill;
	private JButton btnExit;
	private JRadioButton rbPickup;//�ۨ����s
	private JRadioButton rbDelivery;//�~�e���s
	private JLabel lbTakewaymeal;
	private JLabel lbTakewaymealText;//�ۨ��覡���
	private JLabel lbGarnish;//�t�����
	private JButton btnCheese;//�_�q���s
	private JButton btnMozzarella;//���T���s
	private JButton btnTomatosauce;//�f�X����s
	private JLabel lbSelect;//����覡���
	private JLabel pizzaname;
	private JLabel pizzacrust;
	private JLabel pizzamains;
	private JLabel pizzasauce;
	private JLabel pizzatopping;
	private JLabel lblNewLabel;

	
	private void initialize() {
		frmShoppingcart = new JFrame();
		frmShoppingcart.setTitle("ShoppingCart");
		frmShoppingcart.setBounds(100, 100, 883, 393);
		frmShoppingcart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmShoppingcart.getContentPane().setLayout(springLayout);
		
		lblShopItem = new JLabel("Shop Item");
		springLayout.putConstraint(SpringLayout.NORTH, lblShopItem, 26, SpringLayout.NORTH, frmShoppingcart.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblShopItem, 36, SpringLayout.WEST, frmShoppingcart.getContentPane());
		frmShoppingcart.getContentPane().add(lblShopItem);
		
		
		itemModel = new DefaultListModel<>();
		itemList = new JList<String>(itemModel);
		itemList.setFont(new Font("Consolas", Font.BOLD, 14));
		springLayout.putConstraint(SpringLayout.NORTH, itemList, 6, SpringLayout.SOUTH, lblShopItem);
		springLayout.putConstraint(SpringLayout.WEST, itemList, 0, SpringLayout.WEST, lblShopItem);
		springLayout.putConstraint(SpringLayout.SOUTH, itemList, 230, SpringLayout.SOUTH, lblShopItem);
		springLayout.putConstraint(SpringLayout.EAST, itemList, 219, SpringLayout.WEST, frmShoppingcart.getContentPane());
		frmShoppingcart.getContentPane().add(itemList);
		
		lblPrice = new JLabel("Price : ");
		springLayout.putConstraint(SpringLayout.NORTH, lblPrice, 6, SpringLayout.SOUTH, itemList);
		springLayout.putConstraint(SpringLayout.WEST, lblPrice, 121, SpringLayout.WEST, frmShoppingcart.getContentPane());
		frmShoppingcart.getContentPane().add(lblPrice);

		
		button_buy = new JButton(">");
		springLayout.putConstraint(SpringLayout.NORTH, button_buy, 117, SpringLayout.NORTH, frmShoppingcart.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, button_buy, 6, SpringLayout.EAST, itemList);
		frmShoppingcart.getContentPane().add(button_buy);
		
		button_del = new JButton("<");
		springLayout.putConstraint(SpringLayout.NORTH, button_del, 28, SpringLayout.SOUTH, button_buy);
		springLayout.putConstraint(SpringLayout.WEST, button_del, 6, SpringLayout.EAST, itemList);
		frmShoppingcart.getContentPane().add(button_del);
		
		lblShoppingcart = new JLabel("ShoppingCart");
		springLayout.putConstraint(SpringLayout.NORTH, lblShoppingcart, 0, SpringLayout.NORTH, lblShopItem);
		springLayout.putConstraint(SpringLayout.WEST, lblShoppingcart, 186, SpringLayout.EAST, lblShopItem);
		frmShoppingcart.getContentPane().add(lblShoppingcart);
		
		cartModel = new DefaultListModel<>();
		cartList = new JList<String>(cartModel);
		springLayout.putConstraint(SpringLayout.NORTH, cartList, 6, SpringLayout.SOUTH, lblShoppingcart);
		springLayout.putConstraint(SpringLayout.WEST, cartList, 6, SpringLayout.EAST, button_buy);
		springLayout.putConstraint(SpringLayout.SOUTH, cartList, 0, SpringLayout.SOUTH, itemList);
		cartList.setFont(new Font("Consolas", Font.BOLD, 14));
		frmShoppingcart.getContentPane().add(cartList);
		
		btnCheckOut = new JButton("Check Out");
		springLayout.putConstraint(SpringLayout.EAST, btnCheckOut, -10, SpringLayout.EAST, frmShoppingcart.getContentPane());
		frmShoppingcart.getContentPane().add(btnCheckOut);
		
		btnBill = new JButton("Bill");
		springLayout.putConstraint(SpringLayout.SOUTH, btnCheckOut, -6, SpringLayout.NORTH, btnBill);
		springLayout.putConstraint(SpringLayout.SOUTH, btnBill, -10, SpringLayout.SOUTH, frmShoppingcart.getContentPane());
		frmShoppingcart.getContentPane().add(btnBill);
		
		btnExit = new JButton("Exit");
		springLayout.putConstraint(SpringLayout.EAST, btnExit, -10, SpringLayout.EAST, frmShoppingcart.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnBill, -6, SpringLayout.WEST, btnExit);
		springLayout.putConstraint(SpringLayout.NORTH, btnExit, 0, SpringLayout.NORTH, btnBill);
		frmShoppingcart.getContentPane().add(btnExit);
		
		rbPickup = new JRadioButton("Pickup");
		springLayout.putConstraint(SpringLayout.NORTH, rbPickup, -4, SpringLayout.NORTH, lblPrice);
		springLayout.putConstraint(SpringLayout.WEST, rbPickup, 0, SpringLayout.WEST, lblShoppingcart);
		frmShoppingcart.getContentPane().add(rbPickup);
		
		rbDelivery = new JRadioButton("Delivery");
		springLayout.putConstraint(SpringLayout.NORTH, rbDelivery, -4, SpringLayout.NORTH, lblPrice);
		springLayout.putConstraint(SpringLayout.WEST, rbDelivery, 6, SpringLayout.EAST, rbPickup);
		frmShoppingcart.getContentPane().add(rbDelivery);
		
		lbTakewaymeal = new JLabel("Take way meal\uFF1A");
		springLayout.putConstraint(SpringLayout.NORTH, lbTakewaymeal, 301, SpringLayout.NORTH, frmShoppingcart.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lbTakewaymeal, 271, SpringLayout.WEST, frmShoppingcart.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lbTakewaymeal, -31, SpringLayout.SOUTH, frmShoppingcart.getContentPane());
		frmShoppingcart.getContentPane().add(lbTakewaymeal);
		
		lbTakewaymealText = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, lbTakewaymealText, 5, SpringLayout.SOUTH, rbDelivery);
		springLayout.putConstraint(SpringLayout.WEST, lbTakewaymealText, 410, SpringLayout.WEST, frmShoppingcart.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lbTakewaymealText, -31, SpringLayout.SOUTH, frmShoppingcart.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lbTakewaymeal, -34, SpringLayout.WEST, lbTakewaymealText);
		frmShoppingcart.getContentPane().add(lbTakewaymealText);
		
		lbGarnish = new JLabel("Garnish\uFF1A");
		springLayout.putConstraint(SpringLayout.WEST, lbGarnish, 486, SpringLayout.WEST, frmShoppingcart.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, cartList, -22, SpringLayout.WEST, lbGarnish);
		frmShoppingcart.getContentPane().add(lbGarnish);
		
		btnCheese = new JButton("Cheese");
		springLayout.putConstraint(SpringLayout.NORTH, btnCheese, -4, SpringLayout.NORTH, lbGarnish);
		springLayout.putConstraint(SpringLayout.WEST, btnCheese, 6, SpringLayout.EAST, lbGarnish);
		frmShoppingcart.getContentPane().add(btnCheese);
		
		btnMozzarella = new JButton("Mozzarella");
		springLayout.putConstraint(SpringLayout.NORTH, btnMozzarella, -4, SpringLayout.NORTH, lbGarnish);
		springLayout.putConstraint(SpringLayout.WEST, btnMozzarella, 2, SpringLayout.EAST, btnCheese);
		frmShoppingcart.getContentPane().add(btnMozzarella);
		
		btnTomatosauce = new JButton("Tomatosauce");
		springLayout.putConstraint(SpringLayout.NORTH, btnTomatosauce, -4, SpringLayout.NORTH, lbGarnish);
		springLayout.putConstraint(SpringLayout.WEST, btnTomatosauce, 3, SpringLayout.EAST, btnMozzarella);
		frmShoppingcart.getContentPane().add(btnTomatosauce);
		
		lbSelect = new JLabel("Select\uFF1A");
		springLayout.putConstraint(SpringLayout.NORTH, lbSelect, 22, SpringLayout.SOUTH, lbGarnish);
		springLayout.putConstraint(SpringLayout.WEST, lbSelect, 0, SpringLayout.WEST, lbGarnish);
		frmShoppingcart.getContentPane().add(lbSelect);
		
		//���ä���
		ButtonGroup bg = new ButtonGroup();  
		bg.add(rbPickup);
		bg.add(rbDelivery);
		
		pizzaname = new JLabel("Kinds\uFF1A");
		springLayout.putConstraint(SpringLayout.NORTH, pizzaname, -6, SpringLayout.NORTH, itemList);
		springLayout.putConstraint(SpringLayout.WEST, pizzaname, 0, SpringLayout.WEST, lbGarnish);
		springLayout.putConstraint(SpringLayout.EAST, pizzaname, 340, SpringLayout.EAST, cartList);
		frmShoppingcart.getContentPane().add(pizzaname);
		
		pizzacrust = new JLabel("Crust\uFF1A");
		springLayout.putConstraint(SpringLayout.NORTH, pizzacrust, 10, SpringLayout.SOUTH, pizzaname);
		springLayout.putConstraint(SpringLayout.WEST, pizzacrust, 22, SpringLayout.EAST, cartList);
		springLayout.putConstraint(SpringLayout.EAST, pizzacrust, -63, SpringLayout.EAST, frmShoppingcart.getContentPane());
		frmShoppingcart.getContentPane().add(pizzacrust);
		
		pizzamains = new JLabel("Mains\uFF1A");
		springLayout.putConstraint(SpringLayout.NORTH, pizzamains, 107, SpringLayout.NORTH, frmShoppingcart.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, pizzacrust, -6, SpringLayout.NORTH, pizzamains);
		springLayout.putConstraint(SpringLayout.WEST, pizzamains, 22, SpringLayout.EAST, cartList);
		springLayout.putConstraint(SpringLayout.EAST, pizzamains, -63, SpringLayout.EAST, frmShoppingcart.getContentPane());
		frmShoppingcart.getContentPane().add(pizzamains);
		
		pizzasauce = new JLabel("Sauce\uFF1A");
		springLayout.putConstraint(SpringLayout.NORTH, pizzasauce, 136, SpringLayout.NORTH, frmShoppingcart.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, pizzasauce, 22, SpringLayout.EAST, cartList);
		springLayout.putConstraint(SpringLayout.EAST, pizzasauce, -63, SpringLayout.EAST, frmShoppingcart.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, pizzamains, -6, SpringLayout.NORTH, pizzasauce);
		frmShoppingcart.getContentPane().add(pizzasauce);
		
		pizzatopping = new JLabel("Topping\uFF1A");
		springLayout.putConstraint(SpringLayout.NORTH, lbGarnish, 14, SpringLayout.SOUTH, pizzatopping);
		springLayout.putConstraint(SpringLayout.WEST, pizzatopping, 22, SpringLayout.EAST, cartList);
		springLayout.putConstraint(SpringLayout.EAST, pizzatopping, -63, SpringLayout.EAST, frmShoppingcart.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, pizzasauce, -9, SpringLayout.NORTH, pizzatopping);
		springLayout.putConstraint(SpringLayout.NORTH, pizzatopping, 0, SpringLayout.NORTH, button_del);
		frmShoppingcart.getContentPane().add(pizzatopping);
		
		lblNewLabel = new JLabel("");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, btnCheese);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, 0, SpringLayout.SOUTH, lbSelect);
		frmShoppingcart.getContentPane().add(lblNewLabel);
		
	}
	//�]�p�ӫ~�C���ӫ~���
	public void addShopItem(String item) {
		itemModel.addElement(item);
	}
	//�M�Űӫ~�C���ӫ~���
	public void removeAllShopItem() {
		itemModel.removeAllElements();
	}
	//�]�w�ӫ~�C����ť��
	public void addShopListSelectionListener(ListSelectionListener listSelectionListener) {
		itemList.addListSelectionListener(listSelectionListener);
	}
	//���o�ثe��ܪ��ӫ~�M��index
	public int  getSelectShopListIndex() {
		return itemList.getSelectedIndex();
	}
	//�]�wprice��T
	public void setShopItemPrice(Double price) {
		lblPrice.setText("Price : " + price + " NTD");
	}
	
	//�]�w���U>����ť��
	public void addButtonBuyActionListener(ActionListener actionListener) {
		button_buy.addActionListener(actionListener);
	}
		
	//�M���ʪ���
	public void carListClear() {
		cartModel.clear();
	}
	
	//��J�ʪ���
	public void addCarItem(String item) {
		cartModel.addElement(item);
	}
	
	//Pizza�W��
	public void shwoPizzaName(String name){
		pizzaname.setText(name);
	}
	
	//Pizza���
	public void shwoPizzaCrust(String crust){
		pizzacrust.setText(crust);
	}
	
	//Pizza�D�\
	public void shwoPizzaMains(String mains){
		pizzamains.setText(mains);
	}
	
	//Pizza���
	public void shwoPizzaSauce(String sauce){
		pizzasauce.setText(sauce);
	}
	
	//Pizza�t��
	public void shwoPizzaTopping(String topping){
		pizzatopping.setText(topping);
	}
	
	//�]�w���U<����ť��
	public void addButtonDelActionListener(ActionListener actionListener) {
		button_del.addActionListener(actionListener);
	}
	
	//���o��ܪ��ʪ����M��index
	public int getSelectCarListIndex() {
		return cartList.getSelectedIndex();
	}

	//�]�w>�i�_�ϥ�
	public void setButtonBuyEnabled(boolean b) {
		button_buy.setEnabled(b);
	}
	
	//�]�w<�i�_�ϥ�
	public void setButtonDelEnabled(boolean b) {
		button_del.setEnabled(b);
	}

	//�]�wCheckOut�i�_�ϥ�
	public void setCheckOutEnabled(boolean b) {
		btnCheckOut.setEnabled(b);
	}
	//�]�wBill�i�_�ϥ�
	public void setBillEnabled(boolean b) {
		btnBill.setEnabled(b);
	}
	
	//�]�wCheckOut���s��ť��
	public void addCheckOutActionListener(ActionListener actionListener) {
		btnCheckOut.addActionListener(actionListener);
	}
	
	//��ܵ��b�T����
	public void showCheckOutMessage(String msg) {
		JOptionPane.showMessageDialog(frmShoppingcart, msg, "Check Out!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	//Bill���s��ť��
	public void addBillActionListener(ActionListener actionListener) {
		btnBill.addActionListener(actionListener);
	}
	
	//�]�wExit���s��ť��
	public void addExitActionListener(ActionListener actionListener) {
		btnExit.addActionListener(actionListener);
	}
	
	//rbPickup�����s��ť��
	public void addRbPickupActionListener(ActionListener actionListener) {
		rbPickup.addActionListener(actionListener);
	}
			
	//rbDelivery�����s��ť��
	public void addRbDeliveryActionListener(ActionListener actionListener){
		rbDelivery.addActionListener(actionListener);
	}
			
	//�]�w�ۨ��覡����ܤ�r
	public void setTakewaymealText(String text) {
		lbTakewaymealText.setText(text);
	}
			
	//�]�w�ۨ����s�i�_�I��
	public void setRbPickupEnabled(boolean b) {
		rbPickup.setEnabled(b);
	}
			
	//�]�w�~�e���s�i�_�I��
	public void setRbDeliveryEnabled(boolean b) {
		rbDelivery.setEnabled(b);
	}
			
	//�]�w�ۨ����s�I�窱�A
	public void setRbPickupSelected(boolean b) {
		rbPickup.setSelected(b);
	}
			
	//�]�w�~�e���s�I�窱�A
	public void setRbDeliverySelected(boolean b) {
		rbDelivery.setSelected(b);
	}
			
	//�P�_�ۨ����s�I�窱�A
	public boolean rbRbPickup_isSelected() {
		return rbPickup.isSelected();
	}
			
	//�P�_�~�e���s�I�窱�A
	public boolean rbDelivery_isSelected() {
		return rbDelivery.isSelected();
	}
			
	//Cheese���s��ť��
	public void addCheeseActionListener(ActionListener actionListener) {
		btnCheese.addActionListener(actionListener);
	}
		
	//Mozzarella���s��ť��
	public void addMozzarellaActionListener(ActionListener actionListener) {
		btnMozzarella.addActionListener(actionListener);
	}
			
	//Tomatosauce���s��ť��
	public void addTomatosauceActionListener(ActionListener actionListener) {
		btnTomatosauce.addActionListener(actionListener);
	}
	
	//�]�w����覡����ܤ�r
	public void setlbSelect(String text) {
		lbSelect.setText(text);
	}
}
