package Basic.geeksforgeeks.Tree;

class Node {
	int key;
	Node left;
	Node right;
	Node(int k){
		key=k;
		left=right=null;
	}
}

public class TreeTraversal {

	public static void main(String[] args) {
		TreeTraversal tt = new TreeTraversal();
		
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.right.left = new Node(40);
		root.right.right = new Node(50);

		/*Inorder traversal : left-root-right
		 * o/p : 20 10 40 30 50
		 * Time Complexity : Theta(n);
		 * Auxiliary Space : Theta(h); here h=height of the tree
		 * */ 
		System.out.println("*************Inorder traversal*****************");
		tt.inorder(root);
		
		/*Preorder traversal : root-left-right
		 * o/p : 10 20 30 40 50
		 * Time Complexity : Theta(n);
		 * Auxiliary Space : Theta(h); here h=height of the tree
		 * */ 
		System.out.print("\n");
		System.out.println("*************Preorder traversal*****************");
		tt.preorder(root);
		
		/*Postorder traversal : left-right-root
		 * o/p : 20 40 50 30 10
		 * Time Complexity : Theta(n);
		 * Auxiliary Space : Theta(h); here h=height of the tree
		 * */ 
		System.out.print("\n");
		System.out.println("*************Postorder traversal*****************");
		tt.postorder(root);
	}

	private void postorder(Node root) {
		if(root!=null){
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.key + " ");
		}
	}

	private void preorder(Node root) {
		if(root!=null){
			System.out.print(root.key + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}

	private void inorder(Node root) {
		if(root!=null){
			inorder(root.left);
			System.out.print(root.key + " ");
			inorder(root.right);
		}
	}

}
