package Basic.geeksforgeeks.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxInBinaryTree extends TreeTraversal{

	public static void main(String[] args) {
		MaxInBinaryTree mibt = new MaxInBinaryTree();
		
		Node root = new Node(10);
		root.left = new Node(30);
		root.left.left = new Node(80);
		root.left.left.right = new Node(70);
		root.right = new Node(40);
		root.right.left = new Node(60);
		root.right.right = new Node(20);
		
		int max=0;
		System.out.println(itr_MaximumElement(root,max));
		
		System.out.println(recur_MaximumElement(root));
	}
	
	private static int recur_MaximumElement(Node root) {
		if(root==null)
			return Integer.MIN_VALUE;
		
		return Math.max(root.key, Math.max(recur_MaximumElement(root.left), recur_MaximumElement(root.right)));
	}

	/*T.C : Theta(n)
	 * A.S.C : O(n)
	 * Iterative method
	 * */
	private static int itr_MaximumElement(Node root, int max) {
		if(root==null)
			return 0;
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		
		while(q.isEmpty()==false){
			Node curr=q.poll();
			if(curr.key>max)
				max=curr.key;
			
			if(curr.left!=null)
				q.add(curr.left);
			if(curr.right!=null)
				q.add(curr.right);
		}
		return max;
	}

}
