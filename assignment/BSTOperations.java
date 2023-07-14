package assignment;

public class BSTOperations {
	
	static String inOrderResult = "";
	static String searchResult = "";
	
	// Initializing the root node of the BST
	Node bstRoot = null; 
 
	// Basic structure of Node
	static class Node
	{
	    int key;
	    Node left, right;
	}
	 
	// A utility function to create a new BST node
	static Node newNode(int item)
	{
	    Node temp = new Node();
	    temp.key = item;
	    temp.left = temp.right = null;
	    return temp;
	}
	 
	// Helper function
	// InOrder traversal of BST, This will generate a sorted List
	static void inOrder(Node root)
	{
	    if (root != null)
	    {
	    	inOrder(root.left);
	    	inOrderResult = inOrderResult + root.key + " ";
	    	inOrder(root.right);
	    }
	    
	}
	
	// Helper function to get the BST height(Level)
	static int bstHeight(Node root) {
	    if (root == null) {
	        return -1;
	    }

	    int lefth = bstHeight(root.left);
	    int righth = bstHeight(root.right);

	    if (lefth > righth) {
	        return lefth + 1;
	    } else {
	        return righth + 1;
	    }
	}
	
	// Helper function to generate InOrder sequence after Insertion operation
	public String insertOperationInBST(int[] inputarray) {
		
		for (int i = 0; i < inputarray.length; i++) {
			if(bstRoot == null) {
				//Setting the root
				bstRoot = newNode(inputarray[i]);
			}
			else
				insert(bstRoot, inputarray[i]);
	    }
		
		// Generating inorder traversal output for Gradescope evaluation
		inOrderResult = "";
		System.out.println(bstHeight(bstRoot));
		inOrder(bstRoot);
		return inOrderResult.trim();
	}
	
	// Helper function to generate InOrder sequence after Deletion operation
	public String deleteOperationInBST(int[] deleteelementsarray) {
		
		for (int i = 0; i < deleteelementsarray.length; i++) {
			
			Node removedNode = delete(deleteelementsarray[i]);
			if(removedNode == null) {
				System.out.println("The key " + deleteelementsarray[i] + " is not present in the tree");
			}
			else {
				
				
			}
			
	    }
		
		//Generating inorder traversal output for Gradescope evaluation
		inOrderResult = "";
		System.out.println(bstHeight(bstRoot));
		inOrder(bstRoot);
		return inOrderResult.trim();
		
	}
	
	//Helper function to generate search result after Search operation
	public String searchOperationInBST(int[] searchelementsarray) {
		
		boolean ElementinBST = false; 
		searchResult = "";
		
		for (int i = 0; i < searchelementsarray.length; i++) {
			
			ElementinBST = false; 
			if(search(bstRoot, searchelementsarray[i]) != null) 
				ElementinBST = true;
				
			searchResult = searchResult + ElementinBST + " ";
	    }
		
		return searchResult.trim();
		
	}
	
    
	/**
	 * Given the binary search tree and a key
     * Insert a new node with given key in the BST
	 */
	public void insert(Node node, int key)
	{
		
		//Making sure the current node isn't null
		if(node!=null){

			
			if(node.key > key){

				if(node.left!=null){

					//Calling the method recursively to go deeper
					insert(node.left, key);
				}
				//If the node is null then this is the place to insert new value
				else{

					node.left = newNode(key);
				}
			} else{

				if(node.right!=null){

					insert(node.right, key);

				//If the node is null then this is the place to insert new value
				} else{

					node.right = newNode(key);
				}
			}
		}
	    
	}

	
	
	public int getLeftValue(Node root){

		int min = root.key;

		while(root.left!=null){

			min = root.left.key;
			root = root.left;
		}

		return min;
	}

	public Node deleteHelper(Node root,int value){

		if(root==null){

			return root;
		}
		
		//Checking whether to go down the left or right subtree

		if(root.key > value){

			root.left = deleteHelper(root.left, value);

		} else if(root.key < value){

			root.right = deleteHelper(root.right, value);

		} else{

			//If the code made it here then the current node is the one to remove
			//Pushing up either right of left child node 
			if(root.left == null){

				return root.right;

			} else if(root.right == null){

				return root.left;
			}

			// If the mode made it here then there are two children nodes
			// Finding the smallest node in the right substree and swapping values
			// going down the left subpath

			root.key = getLeftValue(root.right);
			root.right = deleteHelper(root.right,root.key);


		}

	

		return root;
		
	}
	
	//Deals with small tree
	public Node smallTreeCase(Node root){

		//If the left node is not null and right is then just switch root and left node
		if(root.left != null && root.right == null){

			root.key = root.left.key;
			return root.left;
		
		//If the right node is not null and the left node is then just switch root and right node
		} else if(root.right!=null && root.left == null){

			root.key = root.right.key;
			return root.right;
		}

		return null;
	}

	/**
     * Given the binary search tree and a key
     * Deletes the key and return the deleted node
	 */
	public Node delete(int value) {
   
		if(search(this.bstRoot, value)!=null){

			//Checking if it is small tree
			if(bstHeight(this.bstRoot) == 1){

				//If node needs to be removed then it is returns otherwise returns null
				Node result = smallTreeCase(this.bstRoot);
				
				// Checking for null
				if(result!=null){
	
					return result;
				}
			}

			return deleteHelper(this.bstRoot, value);

		} else{

			return null;
		}
	}
	
	/**
     * Given the binary search tree and a key
     * Search the given key in BST
     * return null if key is not available or return the root if key is present
	 */
	public Node search(Node root, int key){
		
		Node currentNode1 = root;
		Node returnElement1 = null;

		
		while(true){

			//Making sure the node isn't null would cause errors
			if(currentNode1 == null){

				break;
			}

		
			else if(currentNode1.key > key){

				if(currentNode1.left!=null){

					currentNode1 = currentNode1.left;

				} else{

					break;
				}

			
			} else if(currentNode1.key < key){

				if(currentNode1.right!=null){

					currentNode1 = currentNode1.right;
				} else{
					break;
				}

				
		
			} else{
				returnElement1 = currentNode1;
				break;
			}


		}

		//Returning the element if the value was not found returning null
		return returnElement1;

		

	}
	
}