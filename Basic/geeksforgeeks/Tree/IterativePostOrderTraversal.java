package Basic.geeksforgeeks.Tree;

import java.util.Stack;

public class IterativePostOrderTraversal extends TreeTraversal{

	public static void main(String[] args) {
		IterativePostOrderTraversal ipt = new IterativePostOrderTraversal();
		
		Node root= new Node(10);
		root.left=new Node(20);
		root.left.left=new Node(40);
		root.left.left.left=new Node(80);
		root.left.left.right=new Node(90);
		root.left.right=new Node(50);
		root.right=new Node(30);
		root.right.left=new Node(60);
		root.right.right=new Node(70);
		
		ipt.recursive(root);
		System.out.println("\n***iterative***");
		ipt.itertative_postOrder(root);
		System.out.println("\n***efficient iterative***");
		ipt.eff_itertative_postOrder(root);
	}
	
	private void eff_itertative_postOrder(Node root) {
		if(root==null)
			return;
		
		Stack<Node> st = new Stack<>();
		Node curr=root;
		
		
	}

	/*By Using 2 stacks
	 * T.C : O(n)+O(n) = O(n)
	 * A.S.C : O(h)
	 * */
	private void itertative_postOrder(Node root) {
		if(root==null)
			return;
		
		if(root.left==null && root.right==null){
			System.out.print(root.key+" ");
			return;
		}
		
		Stack<Node> st = new Stack<>();
		Stack<Node> st1 = new Stack<>();
		Node curr=root;
		st.push(curr);
		
		while(curr!=null && st.isEmpty()==false){
			curr=st.pop();
			
			if(curr.left!=null)
				st.push(curr.left);
			if(curr.right!=null)
				st.push(curr.right);
			
			st1.push(curr);
		}
		
		while(st1.isEmpty()==false){
			curr=st1.pop();
			System.out.print(curr.key+" ");
		}
	}

	private void recursive(Node root) {
		if(root==null)
			return;
		
		if(root.left==null && root.right==null){
			System.out.print(root.key+" ");
			return;
		}
		
		if(root!=null){
			recursive(root.left);
			recursive(root.right);
			System.out.print(root.key+" ");
		}
	}

}
