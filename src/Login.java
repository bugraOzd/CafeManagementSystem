import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Login extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField txtId;
	JPasswordField pwField;
	JButton btnLogin;
	JButton btnCancel;
	static LinkedList list = new LinkedList();


	public Login() { 
		super("Cafe Managemet System -Login-");
		setSize(350, 225);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		employees();

		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblId.setBounds(79, 25, 62, 20);
		getContentPane().add(lblId);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(79, 76, 62, 20);
		getContentPane().add(lblPassword);

		txtId = new JTextField();
		txtId.setBounds(151, 27, 110, 18);
		getContentPane().add(txtId);
		txtId.setColumns(10);

		pwField = new JPasswordField();
		pwField.setBounds(151, 78, 110, 19);
		getContentPane().add(pwField);

		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogin.setBounds(79, 141, 86, 23);
		getContentPane().add(btnLogin);

		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancel.setBounds(175, 141, 86, 23);
		getContentPane().add(btnCancel);

		btnLogin.addActionListener(this);
		btnCancel.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLogin) {

			if (txtId.getText().equals("") || pwField.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Please do not fill any blank fields.");
			}
			Node current;
			current = list.head; //iterate over the linked list until there is a matching id and password
			
			while (current != null) {
				if (txtId.getText().equals(current.employee.id) // Check current nodes elements if its match to given
																// fields info
						&& pwField.getText().equals(current.employee.password)) {
					new Main_Frame(current.employee).setVisible(true);
					this.setVisible(false);
					break;
				} else {
					current = current.next;
				}

			}
		}
		if (e.getSource() == btnCancel) {
			System.exit(1);
		}

	}

	public void employees() {
		// insert employee information to the list
		list.insert(new Employee("0001", "Bugra Ozdilek", "1234", 1600.0));
		list.insert(new Manager("0002", "Manager", "1234", 1800.0));
		list.insert(new Employee("0003", "Employee2", "1234", 1600.0));
	}

	public static void main(String[] args) {

		Login login = new Login();
		login.setVisible(true);
	}
}
