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
	private JComboBox<Integer> comboBox;
	private JButton btnRemoveallitem;
	private JButton btnCheckOut;
	private JButton btnBill;
	private JButton btnExit;
	private JRadioButton rbBymail;//�l�H���s
	private JRadioButton rbCashondelivery;//�f��I�ګ��s
	private JLabel lbTransportmethod;
	private JLabel lbTransportmethodText;//�B�e�覡���
	
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
		springLayout.putConstraint(SpringLayout.EAST, cartList, -10, SpringLayout.EAST, frmShoppingcart.getContentPane());
		frmShoppingcart.getContentPane().add(cartList);
		
		comboBox = new JComboBox<Integer>();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 146, SpringLayout.NORTH, frmShoppingcart.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 6, SpringLayout.EAST, itemList);
		springLayout.putConstraint(SpringLayout.SOUTH, comboBox, -1, SpringLayout.NORTH, button_del);
		springLayout.putConstraint(SpringLayout.EAST, comboBox, 0, SpringLayout.EAST, button_buy);
		frmShoppingcart.getContentPane().add(comboBox);

		btnRemoveallitem = new JButton("Remove All Item");
		frmShoppingcart.getContentPane().add(btnRemoveallitem);
		
		btnCheckOut = new JButton("Check Out");
		springLayout.putConstraint(SpringLayout.NORTH, btnRemoveallitem, 0, SpringLayout.NORTH, btnCheckOut);
		springLayout.putConstraint(SpringLayout.EAST, btnRemoveallitem, -67, SpringLayout.WEST, btnCheckOut);
		springLayout.putConstraint(SpringLayout.EAST, btnCheckOut, -10, SpringLayout.EAST, frmShoppingcart.getContentPane());
		frmShoppingcart.getContentPane().add(btnCheckOut);
		
		btnBill = new JButton("Bill");
		springLayout.putConstraint(SpringLayout.SOUTH, btnCheckOut, -6, SpringLayout.NORTH, btnBill);
		springLayout.putConstraint(SpringLayout.SOUTH, btnBill, -10, SpringLayout.SOUTH, frmShoppingcart.getContentPane());
		frmShoppingcart.getContentPane().add(btnBill);
		
		btnExit = new JButton("Exit");
		springLayout.putConstraint(SpringLayout.EAST, btnBill, -6, SpringLayout.WEST, btnExit);
		springLayout.putConstraint(SpringLayout.NORTH, btnExit, 0, SpringLayout.NORTH, btnBill);
		springLayout.putConstraint(SpringLayout.EAST, btnExit, 0, SpringLayout.EAST, cartList);
		frmShoppingcart.getContentPane().add(btnExit);
		
		rbBymail = new JRadioButton("By mail");
		springLayout.putConstraint(SpringLayout.EAST, rbBymail, -515, SpringLayout.EAST, frmShoppingcart.getContentPane());
		frmShoppingcart.getContentPane().add(rbBymail);
		
		rbCashondelivery = new JRadioButton("Cash on delivery");
		springLayout.putConstraint(SpringLayout.WEST, rbCashondelivery, 7, SpringLayout.EAST, rbBymail);
		frmShoppingcart.getContentPane().add(rbCashondelivery);
		
		lbTransportmethod = new JLabel("Transport Method\uFF1A");
		springLayout.putConstraint(SpringLayout.SOUTH, lbTransportmethod, -31, SpringLayout.SOUTH, frmShoppingcart.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, rbCashondelivery, -3, SpringLayout.NORTH, lbTransportmethod);
		springLayout.putConstraint(SpringLayout.SOUTH, rbBymail, -3, SpringLayout.NORTH, lbTransportmethod);
		springLayout.putConstraint(SpringLayout.NORTH, lbTransportmethod, 30, SpringLayout.SOUTH, cartList);
		springLayout.putConstraint(SpringLayout.EAST, lbTransportmethod, -60, SpringLayout.EAST, rbCashondelivery);
		springLayout.putConstraint(SpringLayout.WEST, lbTransportmethod, 1, SpringLayout.WEST, lblShoppingcart);
		frmShoppingcart.getContentPane().add(lbTransportmethod);
		
		lbTransportmethodText = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, lbTransportmethodText, 3, SpringLayout.SOUTH, rbCashondelivery);
		springLayout.putConstraint(SpringLayout.WEST, lbTransportmethodText, 6, SpringLayout.EAST, lbTransportmethod);
		springLayout.putConstraint(SpringLayout.SOUTH, lbTransportmethodText, 0, SpringLayout.SOUTH, lbTransportmethod);
		frmShoppingcart.getContentPane().add(lbTransportmethodText);
		
		//�妸�ƶq1~5
		comboBox.addItem(1);
		comboBox.addItem(2);
		comboBox.addItem(3);
		comboBox.addItem(4);
		comboBox.addItem(5);
		
		//���ä���
		ButtonGroup bg = new ButtonGroup();  
		bg.add(rbBymail);
		bg.add(rbCashondelivery);
		
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
	
	//���o�妸�ƶq
	public int getSelectNum() {
		return comboBox.getItemAt(comboBox.getSelectedIndex()).intValue();
	}
	
	//�M���ʪ���
	public void carListClear() {
		cartModel.clear();
	}
	
	//��J�ʪ���
	public void addCarItem(String item) {
		cartModel.addElement(item);
	}
	
	//�]�w���U<����ť��
	public void addButtonDelActionListener(ActionListener actionListener) {
		button_del.addActionListener(actionListener);
	}
	
	//���o��ܪ��ʪ����M��index
	public int getSelectCarListIndex() {
		return cartList.getSelectedIndex();
	}
	
	//�]�w���URemoveAllItem����ť��
	public void addRemoveAllItemActionListener(ActionListener actionListener) {
		btnRemoveallitem.addActionListener(actionListener);
	}
	//�]�w>�i�_�ϥ�
	public void setButtonBuyEnabled(boolean b) {
		button_buy.setEnabled(b);
	}
	//�]�w<�i�_�ϥ�
	public void setButtonDelEnabled(boolean b) {
		button_del.setEnabled(b);
	}
	//�]�wRemoveAllItem�i�_�ϥ�
	public void setRemoveAllItemEnabled(boolean b) {
		btnRemoveallitem.setEnabled(b);
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
