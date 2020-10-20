import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Additem_Window extends JFrame implements ActionListener{
	static JTextField txtItemId;
	static JTextField txtItemName;
	static JTextField txtPrice;
	JButton btnAdd;
	JButton btnClear;

	
	
	public Additem_Window() {
		super("Cafe Managemnt System");
		setSize(370, 280);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblItemId = new JLabel("Item ID");
		lblItemId.setBounds(88, 39, 74, 13);
		getContentPane().add(lblItemId);
		
		JLabel lblItemPrice = new JLabel("Item Price");
		lblItemPrice.setBounds(88, 144, 74, 13);
		getContentPane().add(lblItemPrice);
		
		JLabel lblItemName = new JLabel("Item Name");
		lblItemName.setBounds(88, 88, 74, 13);
		getContentPane().add(lblItemName);
		
		txtItemId = new JTextField();
		txtItemId.setBounds(156, 36, 96, 19);
		getContentPane().add(txtItemId);
		txtItemId.setColumns(10);
		
		txtItemName = new JTextField();
		txtItemName.setColumns(10);
		txtItemName.setBounds(156, 85, 96, 19);
		getContentPane().add(txtItemName);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(156, 141, 96, 19);
		getContentPane().add(txtPrice);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(88, 198, 85, 21);
		getContentPane().add(btnAdd);
		
		btnClear = new JButton("Clear");
		btnClear.setBounds(183, 198, 85, 21);
		getContentPane().add(btnClear);
		
		btnAdd.addActionListener(this);
		btnClear.addActionListener(this);
	}

	static void showEditItem(int id, String name, double price) {
		txtItemId.setText(Integer.toString(id));
		txtItemName.setText(name);
		txtPrice.setText(Double.toString(price));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			if (txtItemId.getText().equals("") || txtItemName.getText().equals("") || txtPrice.equals("")) { 
				JOptionPane.showMessageDialog(this, "Please do not leave any empty fields."); //
			} 
			else {
				Main_Frame.tree.insert(new Menu_Item(Integer.parseInt(txtItemId.getText()), txtItemName.getText(), Double.parseDouble(txtPrice.getText())));
				Main_Frame.dlmMenu.clear();						// updates the list
				Main_Frame.tree.inorder(Main_Frame.tree.root);	// updates the list
				this.setVisible(false);
				new ManageMenu_Window().setVisible(true);
			}
		}
		
		if(e.getSource() == btnClear) {
			txtItemId.setText("");
			txtItemName.setText("");
			txtPrice.setText("");
		}
		
	}
}
