
public class TreeNode {

	Menu_Item item;
	TreeNode left;
	TreeNode right;

	public TreeNode(Menu_Item item) {
		this.item = item;
		this.left = left;
		this.right = right;
	}

	public Menu_Item getMenuItem() {
		return item;
	}

	public void setMenuItem(Menu_Item item) {
		this.item = item;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

}
