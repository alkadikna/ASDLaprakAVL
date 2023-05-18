package ASD_AVL;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		AvlTree avl = new AvlTree();
		
		String input = "";
		String splitted[] = new String[2];
		
		while(s.hasNextLine()) {
			input = s.nextLine();
			splitted = input.split(" ");
			
			if(splitted[0].equals("insert")) {
				try {
					avl.insert(Integer.parseInt(splitted[1]));
				}catch(NumberFormatException e) {
					System.out.println("Tolong input ulang:");
				}
				
			}else if(splitted[0].equals("print")) {
				if(splitted[1].equals("preorder")) {
					avl.preorderTraversal(avl.root);
					System.out.println("");
				}else if(splitted[1].equals("inorder")) {
					avl.inorderTraversal(avl.root);
					System.out.println();
				}else if(splitted[1].equals("postorder")) {
					avl.postorderTraversal(avl.root);
					System.out.println();
				}else if(splitted[1].equals("levels")) {
					avl.levels();
					System.out.println();
				}else {
					System.out.println("Tolong input ulang:");
					continue;
				}
			}else if(input.equals("exit")) {
				break;
			}else {
				System.out.println("Tolong input ulang:");
				continue;
			}
		}
		//System.out.println(avl.root.data);
	}
}

/*
 * Tes Case
 	insert 99
 	insert 88
 	insert 77
 	insert 1
 	insert 2
 	insert 3
 	print preorder
 	print inorder
 	print postorder
 	print levels
 	exit
 */

