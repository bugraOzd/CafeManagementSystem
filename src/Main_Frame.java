import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;


public class Main_Frame extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton btnOrder, btnManageEmployees, btnManageMenu, btnAll, btnMain, btnDrink, btnDessert, btnExit, btnAdd, btnDelete;
	JLabel lblTotalPrice, lblStaffName, lblTotal;
	double total = 0;
	
	static DefaultListModel dlmMenu = new DefaultListModel();
	JList listMenu = new JList(dlmMenu);
	JScrollPane spMenu = new JScrollPane(listMenu);

	static DefaultListModel dlmOrder = new DefaultListModel();
	JList listOrder = new JList(dlmOrder);
	JScrollPane spOrder = new JScrollPane(listOrder);

	static BinarySearchTree tree = new BinarySearchTree();
	

	public Main_Frame(Employee em) {
		super("Cafe Managemnt System -Employee-");
		setSize(985, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		setButtons();
		
		lblStaffName = new JLabel("Staff Name:" + em.nameSurname);
		lblStaffName.setBounds(181, 448, 184, 13);
		getContentPane().add(lblStaffName);
	
		lblTotalPrice = new JLabel("Total Price:");
		lblTotalPrice.setBounds(181, 425, 72, 13);
		getContentPane().add(lblTotalPrice);
		
		lblTotal = new JLabel("0");
		lblTotal.setBounds(268, 425, 63, 13);
		getContentPane().add(lblTotal);

		spMenu.setBounds(482, 70, 446, 345);
		getContentPane().add(spMenu);
		
		spOrder.setBounds(171, 70, 289, 345);
		getContentPane().add(spOrder);
		
		tree.insert(new Menu_Item(100, "Salad", 20.0));
		tree.insert(new Menu_Item(101, "Hamburger", 22.0));
		tree.insert(new Menu_Item(103, "Pizza", 25.0));
		tree.insert(new Menu_Item(201, "Water", 5.0));
		tree.insert(new Menu_Item(104, "chicken", 23.0));
		tree.insert(new Menu_Item(202, "Cola", 7.0));
		tree.insert(new Menu_Item(300, "Sufle", 15.0));
		tree.inorder(tree.root);
		
		btnManageMenu.addActionListener(this);
		btnManageEmployees.addActionListener(this);
		btnAdd.addActionListener(this);
		btnExit.addActionListener(this);
		btnAll.addActionListener(this);
		btnMain.addActionListener(this);
		btnDrink.addActionListener(this);
		btnDessert.addActionListener(this);

	}

	public void setButtons() {

		btnOrder = new JButton("Order");
		btnOrder.setBounds(30, 115, 131, 65);
		getContentPane().add(btnOrder);

		btnManageEmployees = new JButton("Manage Employees");
		btnManageEmployees.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnManageEmployees.setBounds(30, 208, 131, 65);
		getContentPane().add(btnManageEmployees);

		btnManageMenu = new JButton("Manage Menu Items");
		btnManageMenu.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnManageMenu.setBounds(30, 300, 131, 65);
		getContentPane().add(btnManageMenu);

		btnAll = new JButton("All");
		btnAll.setBounds(534, 425, 63, 21);
		getContentPane().add(btnAll);

		btnMain = new JButton("Main");
		btnMain.setBounds(607, 425, 85, 21);
		getContentPane().add(btnMain);

		btnDrink = new JButton("Drink");
		btnDrink.setBounds(702, 425, 85, 21);
		getContentPane().add(btnDrink);

		btnDessert = new JButton("Dessert");
		btnDessert.setBounds(797, 425, 85, 21);
		getContentPane().add(btnDessert);

		btnAdd = new JButton("Add");
		btnAdd.setBounds(181, 472, 85, 43);
		getContentPane().add(btnAdd);

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(276, 471, 85, 43);
		getContentPane().add(btnDelete);

		btnExit = new JButton("Exit");
		btnExit.setBounds(843, 10, 85, 43);
		getContentPane().add(btnExit);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnManageEmployees) {
			new ManageEmployees_Window().setVisible(true);
		}
		
		if(e.getSource() == btnManageMenu) {
			new ManageMenu_Window().setVisible(true);
		}

		if (e.getSource() == btnAdd) {
			
			int index = -1;
			Menu_Item selectedNode;
			if (listMenu.getSelectedIndex() >= 0) {
				index = listMenu.getSelectedIndex();
				selectedNode = (Menu_Item) dlmMenu.get(index);
				total += selectedNode.price;
				lblTotal.setText(Double.toString(total));
				dlmOrder.addElement(dlmMenu.getElementAt(index));
			}
			
		}
		
		if(e.getSource() == btnAll) {
			dlmMenu.clear();
			tree.inorder(tree.root);
		}
		
		if(e.getSource() == btnMain) {
			dlmMenu.clear();
			tree.inorder(tree.root, 100, 199);
		}
		
		if(e.getSource() == btnDrink) {
			dlmMenu.clear();
			tree.inorder(tree.root, 200, 299);
		}
		
		if(e.getSource() == btnDessert) {
			dlmMenu.clear();
			tree.inorder(tree.root, 300, 399);
		}

		if (e.getSource() == btnExit) {
			System.exit(1);
		}

	}
}
