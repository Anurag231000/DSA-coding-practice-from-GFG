package Basic.geeksforgeeks.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal extends TreeTraversal{

	public static void main(String[] args) {
		LevelOrderTraversal lot = new LevelOrderTraversal();
		
//		Node root= new Node(10);
//		root.left= new Node(20);
//		root.right= new Node(30);
//		root.left.left=new Node(8);
//		root.left.right=new Node(7);
//		root.left.right.left=new Node(9);
//		root.left.right.right=new Node(15);
//		root.right.right= new Node(6);
//		root.left.left=new Node(40);
//		root.left.right=new Node(60);
		
		Node root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.right.left=new Node(4);
		root.right.right=new Node(6);
		root.right.left.right=new Node(5);
		root.right.left.right.left=new Node(7);
		
		int h=lot.heightOfTree(root);
		
		/*T.C : Theta(h)*Theta(n) = Theta(hn), Therefore it is an inefficient way.
		 * A.S.C : Theta(n)
		 * */
		for(int i=0; i<h; i++)
		printLevelOrderNodes(root,i);
		
		System.out.println("\n***Efficient solution***");
		printLevelOrderNodes_eff(root);
		
	}
	
	/*T.C : Theta(n)
	 * A.S.C : O(n)
	 * */
	private static void printLevelOrderNodes_eff(Node root) {
		if(root==null)
			return;
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		
		while(q.isEmpty()==false){
			Node curr=q.poll();
			System.out.print(curr.key+" ");
			
			if(curr.left!=null)
				q.add(curr.left);
			if(curr.right!=null)
				q.add(curr.right);
		}
	}

	/*T.C : Theta(n)
	 * A.S.C : Theta(n)
	 * */
	private static void printLevelOrderNodes(Node root, int k) {
		if(root==null)
			return;
		
		if(k==0){
			System.out.print(root.key+" ");
			return;
		}else{
			printLevelOrderNodes(root.left,k-1);
			printLevelOrderNodes(root.right,k-1);
		}
		
	}
	/*T.C : Theta(n)
	 * A.S.C : Theta(n)
	 * */
	private int heightOfTree(Node root) {
		if(root==null)
			return 0;
		
		return Math.max(heightOfTree(root.left),heightOfTree(root.right))+1;
	}

}
