package ASD_AVL;

public class AvlTree {
	Node root;
	//Method untuk memberi height/level dari node tertentu
	public int height(Node node) {
		if(node==null) {
			return 0;
		}else {
			return node.height;
		}
	}
	
	public void levels() {
		System.out.print(height(root));
	}
	//Method untuk mencari yang terbesar
	public int max(int a, int b) {
		if(a > b) {
			return a;
		}else {
			return b;
		}
	}
	
	public Node rightRotate(Node target){
		//Proses rotasi ke kanan
		Node leftChild = target.left;
		Node temp = leftChild.right;
		
		leftChild.right = target;
		target.left = temp;
		
		//Proses untuk memperbarui height
		target.height = max(height(target.left), height(target.right)) + 1;
		leftChild.height = max(height(leftChild.left), height(leftChild.right)) + 1;
		return leftChild;
	}
	
	public Node leftRotate(Node target) {
		//Proses rotasi kiri
		Node rightChild = target.right;
		Node temp = rightChild.left;
		rightChild.left = target;
		target.right = temp;

		//Proses untuk memperbarui height
		target.height = max(height(target.left), height(target.right)) + 1;
		rightChild.height = max(height(rightChild.left), height(rightChild.right)) + 1;
		return rightChild;
	}
	//Method untuk mencari balance factor
	public int countBalanceFactor(Node node) {
		if(node==null) {
			return 0;
		}
		return height(node.left)-height(node.right);
	}
	
	public void insert(int data) {
        root = insert(root, data);
    }
	//Method insertion
	public Node insert(Node node, int data) {
		//Insert BST
		
		if(node==null) {
			return (new Node(data));
		}
		if(data < node.data) {
			node.left = insert(node.left, data);
		}else if(data > node.data) {
			node.right = insert(node.right, data);
		}else {
			return node;
		}
		
		//Proses rebalancing
		node.height = 1 + max(height(node.left), height(node.right));
		int bf = countBalanceFactor(node);
		/*	
	 		1.	BF < -1 and data > data right child then left rotation around node
			2.	BF < -1 and data < data right child then right rotation around right child followed by right rotation around node
			3.	BF > 1 and data < data left child then right rotation around node
			4.	BF > 1 and data > data left child then left rotation around left child followed by left rotation around node
		 */
		if(bf < -1) {
			if(data > node.right.data) {
				return leftRotate(node);
			}else if(data < node.right.data) {
				node.right = rightRotate(node.right);
				return leftRotate(node);
			}
		}
		
		if(bf > 1) {
			if(data < node.left.data) {
				return rightRotate(node);
			}else if(data > node.left.data) {
				node.left = leftRotate(node.left);
				return rightRotate(node);
			}
		}
		return node;
		
	}
	
	
	void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }
	
	void preorderTraversal(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preorderTraversal(root.left);
			preorderTraversal(root.right);
		}
	}
	
	void postorderTraversal(Node root) {
		if (root != null) {
			postorderTraversal(root.left);
			postorderTraversal(root.right);
			System.out.print(root.data + " ");
		}
	}
	
	
	
}
