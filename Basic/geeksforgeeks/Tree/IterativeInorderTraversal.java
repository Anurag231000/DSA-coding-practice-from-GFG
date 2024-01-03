package Basic.geeksforgeeks.Tree;

import java.util.Stack;

public class IterativeInorderTraversal extends TreeTraversal{

	public static void main(String[] args) {
		IterativeInorderTraversal iit = new IterativeInorderTraversal();
		
		Node root=new Node(10);
		root.left=new Node(20);
		root.left.left=new Node(40);
		root.left.right= new Node(50);
		root.right=new Node(30);
		root.right.left=new Node(60);
		
		iit.treetraversal(root);
	}
	
	/*T.C : Theta(n)
	 * A.S.C : O(h)
	 * */
	private void treetraversal(Node root) {
		if(root==null)
			return;
		
		Stack<Node> st = new Stack<>();
		
		Node curr=root;
		while(curr!=null || st.isEmpty()==false){
			while(curr!=null){
				st.push(curr);
				curr=curr.left;
			}
			curr=st.pop();
			System.out.print(curr.key+" ");
			curr=curr.right;
		}
	}

}
