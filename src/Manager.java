
public class Manager extends Employee {

	public boolean permission;

	public Manager(String id, String nameSurname, String password, double wage) {
		super(id, nameSurname, password, wage);
		permission = true;
	}

	@Override
	public String toString() {
		return "Manager [ID: " + id + ", Name Surname: " + nameSurname + ", Wage: " + wage + "]";
	}

}
