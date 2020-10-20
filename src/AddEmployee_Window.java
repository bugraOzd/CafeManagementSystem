import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AddEmployee_Window extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	JTextField txtId;
	JTextField txtNameSurname;
	JTextField txtWage;
	JPasswordField txtPw;
	JButton btnAdd;
	JButton btnClear;

	LinkedList newList = Login.list;

	public AddEmployee_Window() {

		super("Cafe Managemnt System -Employee Management-");
		setSize(370, 280);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel lblId = new JLabel("Staff ID");
		lblId.setBounds(88, 66, 115, 13);
		getContentPane().add(lblId);

		JLabel lblStaffNamesurname = new JLabel("Staff Name-Surname");
		lblStaffNamesurname.setBounds(88, 89, 115, 13);
		getContentPane().add(lblStaffNamesurname);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(88, 112, 115, 13);
		getContentPane().add(lblPassword);

		JLabel lblWage = new JLabel("Wage");
		lblWage.setBounds(88, 135, 115, 13);
		getContentPane().add(lblWage);

		txtId = new JTextField();
		txtId.setBounds(189, 63, 96, 19);
		getContentPane().add(txtId);
		txtId.setColumns(10);

		txtNameSurname = new JTextField();
		txtNameSurname.setColumns(10);
		txtNameSurname.setBounds(189, 86, 96, 19);
		getContentPane().add(txtNameSurname);

		txtWage = new JTextField();
		txtWage.setColumns(10);
		txtWage.setBounds(189, 135, 96, 19);
		getContentPane().add(txtWage);

		txtPw = new JPasswordField();
		txtPw.setBounds(189, 112, 96, 19);
		getContentPane().add(txtPw);

		btnAdd = new JButton("Add");
		btnAdd.setBounds(88, 187, 85, 21);
		getContentPane().add(btnAdd);

		btnClear = new JButton("Clear");
		btnClear.setBounds(200, 187, 85, 21);
		getContentPane().add(btnClear);

		btnAdd.addActionListener(this);
		btnClear.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			if (txtId.getText().equals("") || txtNameSurname.getText().equals("") || txtPw.getText().equals("")//
					|| txtWage.getText().isEmpty()) { // Control if there is any empty field
				JOptionPane.showMessageDialog(this, "Please do not leave any empty fields."); //
			} else {
				Login.list.insert(new Employee(txtId.getText(), txtNameSurname.getText(), txtPw.getText(), //
						Double.parseDouble(txtWage.getText()))); // By using LinkedList class's insert method
				this.setVisible(false); // add new element to the list
				new ManageEmployees_Window().setVisible(true); //
			}
		}

		if (e.getSource() == btnClear) // Clear fields
			txtId.setText("");
		txtNameSurname.setText("");
		txtPw.setText("");
		txtWage.setText("");

	}

}
