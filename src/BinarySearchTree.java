
public class BinarySearchTree {

	TreeNode root;
	int size;

	public BinarySearchTree() { // Creates default binary tree
		root = null;
		size = 0;
	}

	public TreeNode createNewNode(Menu_Item item) {
		return new TreeNode(item);
	}

	public int getSize() {
		return size;
	}

	public TreeNode getRoot() {
		return root;
	}
	
	

	// This method mainly calls insertRec()
	void insert(Menu_Item item) {
		root = insertRec(root, item);
	}

	// Recursive insert method is from geeksforgeeks.org
	/* A recursive function to insert a new key in BST */
	TreeNode insertRec(TreeNode root, Menu_Item item) {

		/* If the tree is empty, return a new node */
		if (root == null) {
			root = new TreeNode(item);
			return root;
		}

		/* Otherwise, recur down the tree */
		if (item.id < root.item.id)
			root.left = insertRec(root.left, item);
		else if (item.id > root.item.id)
			root.right = insertRec(root.right, item);

		/* return the (unchanged) node pointer */
		return root;
	}
	
	// This method mainly calls deleteRec() 
    void deleteKey(int key) 
    { 
        root = deleteRec(root, key); 
    } 
  
    /* A recursive function to insert a new key in BST */
    TreeNode deleteRec(TreeNode root, int key) 
    { 
        /* Base Case: If the tree is empty */
        if (root == null)  return root; 
  
        /* Otherwise, recur down the tree */
        if (key < root.item.id) 
            root.left = deleteRec(root.left, key); 
        else if (key > root.item.id) 
            root.right = deleteRec(root.right, key); 
  
        // if key is same as root's key, then This is the node 
        // to be deleted 
        else
        { 
            // node with only one child or no child 
            if (root.left == null) 
                return root.right; 
            else if (root.right == null) 
                return root.left; 
  
            // node with two children: Get the inorder successor (smallest 
            // in the right subtree) 
            root.item.id = minValue(root.right); 
  
            // Delete the inorder successor 
            root.right = deleteRec(root.right, root.item.id); 
        } 
  
        return root; 
    } 
    
    int minValue(TreeNode root) 
    { 
        int minv = root.item.id; 
        while (root.left != null) 
        { 
            minv = root.left.item.id; 
            root = root.left; 
        } 
        return minv; 
    } 

	
	public void inorder(TreeNode root) {
		if (root == null)
			return;
			
			inorder(root.getLeft()) ;
			Main_Frame.dlmMenu.addElement(root.item); 
			inorder(root.getRight());
	}
	
	public void inorder(TreeNode root, int rangeMin, int rangeMax) {
		if (root == null)
			return;
		
				inorder(root.getLeft());
				if(root.item.id >= rangeMin && root.item.id <= rangeMax) 
				Main_Frame.dlmMenu.addElement(root.item); 
				inorder(root.getRight());
				
		
			}
	
	}
	
	


