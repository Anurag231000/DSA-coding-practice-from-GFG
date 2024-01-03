package Basic.geeksforgeeks.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IterativePreorderTraversal extends TreeTraversal{

	public static void main(String[] args) {
		IterativePreorderTraversal ipt = new IterativePreorderTraversal();
		
		Node root= new Node(10);
		root.left=new Node(20);
		root.left.left=new Node(40);
		root.left.left.left=new Node(80);
		root.left.left.right=new Node(90);
		root.left.right=new Node(50);
		root.right=new Node(30);
		root.right.left=new Node(60);
		root.right.right=new Node(70);
		
		ipt.iterative_preorderTraversal(root);
		System.out.println("\n***Space efficient method***");
		ipt.eff_iterative_preorderTraversal(root);
	}
	
	/*T.C : O(n)
	 * A.S.C : Theta(height of right tree)
	 * */
	private void eff_iterative_preorderTraversal(Node root) {
		if(root==null)
			return;
		
		if(root.left==null && root.right==null){
			System.out.print(root.key+" ");
			return;
		}
		
		Stack<Node> st = new Stack<>();
		Node curr=root;
		
		while(curr!=null || st.isEmpty()==false){
			while(curr!=null){
				System.out.print(curr.key+" ");
				if(curr.right!=null)
					st.push(curr.right);
				curr=curr.left;
			}
			
			if(st.isEmpty()==false)
			curr=st.pop();
		}
	}

	/*T.C : O(n)
	 * A.S.C : O(n)
	 * */
	private void iterative_preorderTraversal(Node root) {
		if(root==null)
			return;
		
		if(root.left==null && root.right==null){
			System.out.print(root.key+" ");
			return;
		}
		
		Stack<Node> st = new Stack<>();
		Node curr=root;
		st.push(root);
		
		//Below method is uses less code 
		while(curr!=null && st.isEmpty()==false){
			curr=st.pop();
			System.out.print(curr.key+" ");
			if(curr.right!=null)
				st.push(curr.right);
			if(curr.left!=null)
				st.push(curr.left);
		}
		
//		while(curr!=null && st.isEmpty()==false){
//			
//			if(curr==root)
//			System.out.print(curr.key+" ");
//			
//			while(curr.left!=null){
//				curr=curr.left;
//				System.out.print(curr.key+" ");
//				st.push(curr);
//			}
//			curr=st.pop();
//			
//			if(curr.right!=null){
//				curr=curr.right;
//				System.out.print(curr.key+" ");
//				st.push(curr);
//			}
//		}
	}

}
