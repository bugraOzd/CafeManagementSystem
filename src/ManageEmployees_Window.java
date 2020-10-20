import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class ManageEmployees_Window extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton btnAdd;
	JButton btnDelete;
	JButton btnEditStaff;
	
	DefaultListModel<Employee> dlmEmployees = new DefaultListModel<Employee>();
	JList<Employee> listEmployees = new JList<Employee>(dlmEmployees);
	JScrollPane spEmployees = new JScrollPane(listEmployees);

	LinkedList linkedList = Login.list;
	
	public ManageEmployees_Window() {

		super("Cafe Managemnt System -Employee Management-");
		setSize(684, 448);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		spEmployees.setBounds(81, 44, 500, 300);
		getContentPane().add(spEmployees);
		
		listEmployee(linkedList);

		btnAdd = new JButton("Add New Staff");
		btnAdd.setBounds(91, 354, 135, 35);
		getContentPane().add(btnAdd);

		btnDelete = new JButton("Delete Staff");
		btnDelete.setBounds(270, 354, 135, 35);
		getContentPane().add(btnDelete);

		btnEditStaff = new JButton("Edit Staff");
		btnEditStaff.setBounds(446, 354, 135, 35);
		getContentPane().add(btnEditStaff);

		btnAdd.addActionListener(this);
		btnDelete.addActionListener(this);

	}

	public void listEmployee(LinkedList list) {
		Node current = linkedList.head;

		while (current != null) {
			dlmEmployees.addElement(current.employee);
			current = current.next;
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			new AddEmployee_Window().setVisible(true);
			this.setVisible(false);
		}
		
		if(e.getSource() == btnEditStaff) {
			//dlmEmployees.setElementAt("", listEmployees.getSelectedIndex());
		}

		if (e.getSource() == btnDelete) {
			int index = -1;
			Employee currentEmployee;
			if (listEmployees.getSelectedIndex() >= 0) {
				index = listEmployees.getSelectedIndex();
				currentEmployee = (Employee) dlmEmployees.get(index);
				linkedList.delete(currentEmployee.id);
				dlmEmployees.remove(index);
			}

		}

	}

}
