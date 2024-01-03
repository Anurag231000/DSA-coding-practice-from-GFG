package Basic.geeksforgeeks.Tree;

public class BalancedTreeCheck extends TreeTraversal{

	public static void main(String[] args) {
		BalancedTreeCheck btc = new BalancedTreeCheck();
		
		Node root=new Node(1);
		root.left=new Node(2);
		//root.left.left=new Node(4);
		root.right= new Node(3);

		System.out.println(btc.isBalanced(root));
	}

	private boolean isBalanced(Node root) {
		if(root==null)
	        return false;
	   
	   int left=0;
	   int right=0;
	   
	   Node lef=root,rig=root;
	   while(lef.left!=null){
	       left++;
	       lef=lef.left;
	   }
	   
	   while(rig.right!=null){
	       right++;
	       rig=rig.right;
	   }
	   
	   if(left-right==1)
	        return true;
	   
	   return false;
	}

}
