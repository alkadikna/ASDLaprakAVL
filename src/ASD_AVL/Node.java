package ASD_AVL;

public class Node {
	int data;
	Node left, right;
	int height;
	
	public Node(int data) {
		this.data = data;
		height = 1;
	}
}
