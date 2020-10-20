
public class Employee {

	public String id;
	public String nameSurname;
	public String password;
	public double wage;
	public boolean permission;

	public Employee(String id, String nameSurname, String password, double wage) {
		this.id = id;
		this.nameSurname = nameSurname;
		this.password = password;
		this.wage = wage;
		permission = false;
	}

	@Override
	public String toString() {
		return "Employee [ID: " + id + ", Name Surname: " + nameSurname + ", Wage: " + wage + "]";
	}

}
