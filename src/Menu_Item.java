
public class Menu_Item {

	public int id;
	public String name;
	public double price;

	public Menu_Item(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", price=" + price + "]";
	}

}
