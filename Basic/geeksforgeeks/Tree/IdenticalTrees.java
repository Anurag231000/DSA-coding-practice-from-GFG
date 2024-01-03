package Basic.geeksforgeeks.Tree;

public class IdenticalTrees extends TreeTraversal{

	public static void main(String[] args) {
		IdenticalTrees it = new IdenticalTrees();
		
		Node root1=new Node(1);
		root1.left=new Node(2);
		root1.right=new Node(3);
		
		Node root2=new Node(1);
		root2.left=new Node(3);
		root2.right=new Node(3);
		//root2.right.right=new Node(3);
		
		System.out.println(it.isIdentical(root1,root2));

	}

	private boolean isIdentical(Node root1, Node root2) {
		
		if(root1==root2)
	        return true;
		
		if((root1==null && root2!=null) || (root1!=null && root2==null) || root1.key!=root2.key)
	        return false;

	   return isIdentical(root1.left,root2.left)&&isIdentical(root1.right,root2.right);
	}

}
