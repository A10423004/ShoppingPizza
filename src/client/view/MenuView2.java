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
	private JRadioButton rbBymail;//郵寄按鈕
	private JRadioButton rbCashondelivery;//貨到付款按鈕
	private JLabel lbTransportmethod;
	private JLabel lbTransportmethodText;//運送方式顯示
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
		
		//按紐分組
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
	//設計商品列表的商品資料
	public void addShopItem(String item) {
		itemModel.addElement(item);
	}
	//清空商品列表的商品資料
	public void removeAllShopItem() {
		itemModel.removeAllElements();
	}
	//設定商品列表的監聽器
	public void addShopListSelectionListener(ListSelectionListener listSelectionListener) {
		itemList.addListSelectionListener(listSelectionListener);
	}
	//取得目前選擇的商品清單index
	public int  getSelectShopListIndex() {
		return itemList.getSelectedIndex();
	}
	//設定price資訊
	public void setShopItemPrice(Double price) {
		lblPrice.setText("Price : " + price + " NTD");
	}
	
	//設定按下>的監聽器
	public void addButtonBuyActionListener(ActionListener actionListener) {
		button_buy.addActionListener(actionListener);
	}
		
	//清空購物車
	public void carListClear() {
		cartModel.clear();
	}
	
	//填入購物車
	public void addCarItem(String item) {
		cartModel.addElement(item);
	}
	
	//Pizza名稱
	public void shwoPizzaName(String name){
		pizzaname.setText(name);
	}
	
	//Pizza餅皮
	public void shwoPizzaCrust(String crust){
		pizzacrust.setText(crust);
	}
	
	//Pizza主餐
	public void shwoPizzaMains(String mains){
		pizzamains.setText(mains);
	}
	
	//Pizza醬汁
	public void shwoPizzaSauce(String sauce){
		pizzasauce.setText(sauce);
	}
	
	//Pizza配料
	public void shwoPizzaTopping(String topping){
		pizzatopping.setText(topping);
	}
	
	//設定按下<的監聽器
	public void addButtonDelActionListener(ActionListener actionListener) {
		button_del.addActionListener(actionListener);
	}
	
	//取得選擇的購物車清單index
	public int getSelectCarListIndex() {
		return cartList.getSelectedIndex();
	}

	//設定>可否使用
	public void setButtonBuyEnabled(boolean b) {
		button_buy.setEnabled(b);
	}
	
	//設定<可否使用
	public void setButtonDelEnabled(boolean b) {
		button_del.setEnabled(b);
	}

	//設定CheckOut可否使用
	public void setCheckOutEnabled(boolean b) {
		btnCheckOut.setEnabled(b);
	}
	//設定Bill可否使用
	public void setBillEnabled(boolean b) {
		btnBill.setEnabled(b);
	}
	
	//設定CheckOut按鈕監聽器
	public void addCheckOutActionListener(ActionListener actionListener) {
		btnCheckOut.addActionListener(actionListener);
	}
	
	//顯示結帳訊息框
	public void showCheckOutMessage(String msg) {
		JOptionPane.showMessageDialog(frmShoppingcart, msg, "Check Out!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	//Bill按鈕監聽器
	public void addBillActionListener(ActionListener actionListener) {
		btnBill.addActionListener(actionListener);
	}
	
	//設定Exit按鈕監聽器
	public void addExitActionListener(ActionListener actionListener) {
		btnExit.addActionListener(actionListener);
	}
	
	//rbBymail的按鈕監聽器
	public void addRbBymailActionListener(ActionListener actionListener) {
		rbBymail.addActionListener(actionListener);
	}
	
	//rbCashondelivery的按鈕監聽器
	public void addRbCashondeliveryActionListener(ActionListener actionListener){
		rbCashondelivery.addActionListener(actionListener);
	}
	
	//設定運送方式的顯示文字
	public void setTransportmethodText(String text) {
		lbTransportmethodText.setText(text);
	}
	
	//設定郵寄按鈕可否點選
	public void setRbBymailEnabled(boolean b) {
		rbBymail.setEnabled(b);
	}
	
	//設定貨到付款按鈕可否點選
	public void setRbCashondeliveryEnabled(boolean b) {
		rbCashondelivery.setEnabled(b);
	}
	
	//設定郵寄按鈕點選狀態
	public void setRbBymailSelected(boolean b) {
		rbBymail.setSelected(b);
	}
	
	//設定貨到付款按鈕點選狀態
	public void setRbCashondeliverySelected(boolean b) {
		rbCashondelivery.setSelected(b);
	}
	
	//判斷郵寄按鈕點選狀態
	public boolean rbRbBymail_isSelected() {
		return rbBymail.isSelected();
	}
	
	//判斷貨到付款按鈕點選狀態
	public boolean rbCashondelivery_isSelected() {
		return rbCashondelivery.isSelected();
	}
}
