import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class ManageMenu_Window extends JFrame implements ActionListener{

	DefaultListModel dlmMenuEdit = Main_Frame.dlmMenu;
	JList listMenuEdit = new JList(dlmMenuEdit);
	JScrollPane spMenuEdit = new JScrollPane(listMenuEdit);
	JButton btnDeleteItem, btnEditItem, btnAddItem;
	
	public ManageMenu_Window(){
		super("Cafe Managemnt System");
		setSize(684, 448);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		spMenuEdit.setBounds(81, 44, 500, 300);
		getContentPane().add(spMenuEdit);
		
		btnAddItem = new JButton("Add Item");
		btnAddItem.setBounds(81, 354, 135, 35);
		getContentPane().add(btnAddItem);
		
		btnDeleteItem = new JButton("Delete Item");
		btnDeleteItem.setBounds(263, 354, 135, 35);
		getContentPane().add(btnDeleteItem);
		
		
		btnEditItem = new JButton("Edit Item");
		btnEditItem.setBounds(446, 354, 135, 35);
		getContentPane().add(btnEditItem);
		
		btnAddItem.addActionListener(this);
		btnDeleteItem.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAddItem) {
			new Additem_Window().setVisible(true);
			this.setVisible(false);
		}
		
		if(e.getSource() == btnDeleteItem) {
			int index = -1;
			Menu_Item currentItem;
			if(listMenuEdit.getSelectedIndex() >= 0) {
				index = listMenuEdit.getSelectedIndex();
				currentItem = (Menu_Item) dlmMenuEdit.get(index);
				Main_Frame.tree.deleteKey(currentItem.id);
				dlmMenuEdit.remove(index);
			}
		}
		
		/*if(e.getSource() == btnEditItem) {
			int index = -1;
			Menu_Item currentItem = null;
			if(listMenuEdit.getSelectedIndex() >= 0) {
				index = listMenuEdit.getSelectedIndex();
				currentItem = (Menu_Item) dlmMenuEdit.get(index);
			}
			new Additem_Window().setVisible(true);
			Additem_Window.showEditItem(currentItem.id, currentItem.name, currentItem.price);
			dlmMenuEdit.setElementAt(currentItem, index);
		}*/
		
	}
}
