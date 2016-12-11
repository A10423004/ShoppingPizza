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
	private JRadioButton rbBymail;//�l�H���s
	private JRadioButton rbCashondelivery;//�f��I�ګ��s
	private JLabel lbTransportmethod;
	private JLabel lbTransportmethodText;//�B�e�覡���
	private JLabel pizzaname;
	private JLabel pizzacrust;
	private JLabel pizzamains;
	private JLabel pizzasauce;
	private JLabel pizzatopping;

	
	private void initialize() {
		frmShoppingcart = new JFrame();
		frmShoppingcart.setTitle("ShoppingCart");
		frmShoppingcart.setBounds(100, 100, 863, 393);
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
		springLayout.putConstraint(SpringLayout.SOUTH, cartList, 0, SpringLayout.SOUTH, itemList);
		cartList.setFont(new Font("Consolas", Font.BOLD, 14));
		springLayout.putConstraint(SpringLayout.WEST, cartList, 6, SpringLayout.EAST, button_buy);
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
		
		rbBymail = new JRadioButton("By mail");
		springLayout.putConstraint(SpringLayout.EAST, rbBymail, -515, SpringLayout.EAST, frmShoppingcart.getContentPane());
		frmShoppingcart.getContentPane().add(rbBymail);
		
		rbCashondelivery = new JRadioButton("Cash on delivery");
		springLayout.putConstraint(SpringLayout.EAST, cartList, 0, SpringLayout.EAST, rbCashondelivery);
		springLayout.putConstraint(SpringLayout.WEST, rbCashondelivery, 7, SpringLayout.EAST, rbBymail);
		frmShoppingcart.getContentPane().add(rbCashondelivery);
		
		lbTransportmethod = new JLabel("Transport Method\uFF1A");
		springLayout.putConstraint(SpringLayout.NORTH, lbTransportmethod, 301, SpringLayout.NORTH, frmShoppingcart.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lbTransportmethod, -31, SpringLayout.SOUTH, frmShoppingcart.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, rbCashondelivery, -3, SpringLayout.NORTH, lbTransportmethod);
		springLayout.putConstraint(SpringLayout.SOUTH, rbBymail, -3, SpringLayout.NORTH, lbTransportmethod);
		springLayout.putConstraint(SpringLayout.EAST, lbTransportmethod, -60, SpringLayout.EAST, rbCashondelivery);
		springLayout.putConstraint(SpringLayout.WEST, lbTransportmethod, 1, SpringLayout.WEST, lblShoppingcart);
		frmShoppingcart.getContentPane().add(lbTransportmethod);
		
		lbTransportmethodText = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, lbTransportmethodText, 3, SpringLayout.SOUTH, rbCashondelivery);
		springLayout.putConstraint(SpringLayout.WEST, lbTransportmethodText, 6, SpringLayout.EAST, lbTransportmethod);
		springLayout.putConstraint(SpringLayout.SOUTH, lbTransportmethodText, 0, SpringLayout.SOUTH, lbTransportmethod);
		frmShoppingcart.getContentPane().add(lbTransportmethodText);
		
		//���ä���
		ButtonGroup bg = new ButtonGroup();  
		bg.add(rbBymail);
		bg.add(rbCashondelivery);
		
		pizzaname = new JLabel("Kinds: ");
		springLayout.putConstraint(SpringLayout.NORTH, pizzaname, 2, SpringLayout.NORTH, itemList);
		springLayout.putConstraint(SpringLayout.WEST, pizzaname, 47, SpringLayout.EAST, cartList);
		springLayout.putConstraint(SpringLayout.SOUTH, pizzaname, -199, SpringLayout.SOUTH, itemList);
		springLayout.putConstraint(SpringLayout.EAST, pizzaname, 365, SpringLayout.EAST, cartList);
		frmShoppingcart.getContentPane().add(pizzaname);
		
		pizzacrust = new JLabel("Crust: ");
		springLayout.putConstraint(SpringLayout.NORTH, pizzacrust, 6, SpringLayout.SOUTH, pizzaname);
		springLayout.putConstraint(SpringLayout.WEST, pizzacrust, 0, SpringLayout.WEST, pizzaname);
		springLayout.putConstraint(SpringLayout.SOUTH, pizzacrust, 29, SpringLayout.SOUTH, pizzaname);
		springLayout.putConstraint(SpringLayout.EAST, pizzacrust, 0, SpringLayout.EAST, pizzaname);
		frmShoppingcart.getContentPane().add(pizzacrust);
		
		pizzamains = new JLabel("Mains: ");
		springLayout.putConstraint(SpringLayout.NORTH, pizzamains, 6, SpringLayout.SOUTH, pizzacrust);
		springLayout.putConstraint(SpringLayout.WEST, pizzamains, 0, SpringLayout.WEST, pizzacrust);
		springLayout.putConstraint(SpringLayout.SOUTH, pizzamains, -10, SpringLayout.SOUTH, button_buy);
		springLayout.putConstraint(SpringLayout.EAST, pizzamains, 318, SpringLayout.WEST, pizzacrust);
		frmShoppingcart.getContentPane().add(pizzamains);
		
		pizzasauce = new JLabel("Sauce: ");
		springLayout.putConstraint(SpringLayout.NORTH, pizzasauce, 6, SpringLayout.SOUTH, pizzamains);
		springLayout.putConstraint(SpringLayout.WEST, pizzasauce, 0, SpringLayout.WEST, pizzacrust);
		springLayout.putConstraint(SpringLayout.EAST, pizzasauce, 0, SpringLayout.EAST, pizzacrust);
		frmShoppingcart.getContentPane().add(pizzasauce);
		
		pizzatopping = new JLabel("Topping: ");
		springLayout.putConstraint(SpringLayout.NORTH, pizzatopping, 168, SpringLayout.NORTH, frmShoppingcart.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, pizzasauce, -9, SpringLayout.NORTH, pizzatopping);
		springLayout.putConstraint(SpringLayout.WEST, pizzatopping, 47, SpringLayout.EAST, cartList);
		springLayout.putConstraint(SpringLayout.SOUTH, pizzatopping, 0, SpringLayout.SOUTH, button_del);
		springLayout.putConstraint(SpringLayout.EAST, pizzatopping, 0, SpringLayout.EAST, pizzacrust);
		frmShoppingcart.getContentPane().add(pizzatopping);

		
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
	
	//rbBymail�����s��ť��
	public void addRbBymailActionListener(ActionListener actionListener) {
		rbBymail.addActionListener(actionListener);
	}
	
	//rbCashondelivery�����s��ť��
	public void addRbCashondeliveryActionListener(ActionListener actionListener){
		rbCashondelivery.addActionListener(actionListener);
	}
	
	//�]�w�B�e�覡����ܤ�r
	public void setTransportmethodText(String text) {
		lbTransportmethodText.setText(text);
	}
	
	//�]�w�l�H���s�i�_�I��
	public void setRbBymailEnabled(boolean b) {
		rbBymail.setEnabled(b);
	}
	
	//�]�w�f��I�ګ��s�i�_�I��
	public void setRbCashondeliveryEnabled(boolean b) {
		rbCashondelivery.setEnabled(b);
	}
	
	//�]�w�l�H���s�I�窱�A
	public void setRbBymailSelected(boolean b) {
		rbBymail.setSelected(b);
	}
	
	//�]�w�f��I�ګ��s�I�窱�A
	public void setRbCashondeliverySelected(boolean b) {
		rbCashondelivery.setSelected(b);
	}
	
	//�P�_�l�H���s�I�窱�A
	public boolean rbRbBymail_isSelected() {
		return rbBymail.isSelected();
	}
	
	//�P�_�f��I�ګ��s�I�窱�A
	public boolean rbCashondelivery_isSelected() {
		return rbCashondelivery.isSelected();
	}
}
