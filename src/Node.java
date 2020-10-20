
public class Node {

	Employee employee;
	Node next;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node(Employee employee) {
		this.employee = employee;
		this.next = null;
	}

	public Node(Employee employee, Node next) {
		this.employee = employee;
		this.next = next;
	}

}
