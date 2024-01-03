package Basic.geeksforgeeks.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SizeOfBinaryTree extends TreeTraversal{

	public static void main(String[] args) {
		SizeOfBinaryTree sofbt = new SizeOfBinaryTree();
		Node root = new Node(10);
		root.left = new Node(80);
		root.left.left = new Node(30);
		//root.left.right = new Node(40);
		root.right = new Node(70);
		root.right.right = new Node(100);
		root.right.right.right = new Node(60);
		
		int count=0;
		System.out.println(sofbt.sizeofTree(root,count));
		
		System.out.println(sofbt.recur_sizeofTree(root));
	}
	
	/*T.C : Theta(n)
	 * A.S.C : O(h)
	 * Recursive method
	 * */
	private int recur_sizeofTree(Node root) {
		if(root==null)
			return 0;
		
		return recur_sizeofTree(root.left)+recur_sizeofTree(root.right)+1;
	}

	/*T.C : Theta(n)
	 * A.S.C : O(width of binary tree)
	 * Iterative method
	 * */
	private int sizeofTree(Node root, int count) {
		if(root==null)
			return 0;
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		
		while(q.isEmpty()==false){
			Node curr=q.poll();
			count++;
			
			if(curr.left!=null)
				q.add(curr.left);
			if(curr.right!=null)
				q.add(curr.right);
			
		}
		
		return count;
	}

}
