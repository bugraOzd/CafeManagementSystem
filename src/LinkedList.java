
public class LinkedList {
	public Node head;
	public Node tail;

	public LinkedList() {
		head = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void outputList() {
		Node current = head;

		while (current != null) {
			System.out.println(current.employee.toString());
			current = current.next;
		}
	}

	public void insert(Employee employee) {
		head = new Node(employee, head);
	}

	public void delete(String key) {
		Node current = head;
		Node prev = null;

		if (current != null && key.equals(current.employee.id)) {
			head = current.next;
			return;
		}

		while (current != null && key.equals(current.employee.id)) {
			prev = current;
			current = current.next;
		}

		if (current == null)
			return;

		prev.next = current.next;
	}

}
