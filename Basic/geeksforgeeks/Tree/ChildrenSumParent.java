package Basic.geeksforgeeks.Tree;

public class ChildrenSumParent extends TreeTraversal{

	public static void main(String[] args) {
		ChildrenSumParent csp = new ChildrenSumParent();
		
		Node root=new Node(5);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(1);
		//root.left.right=new Node(1);
		
		System.out.println(csp.isSumProperty(root));
	}

	private int isSumProperty(Node root) {
		if(root==null)
            return 1;
        
        if(root.left==null && root.right==null)
            return 1;
        
        if(root.left==null && root.right!=null)
            return 0;
        
        if(root.left!=null && root.right==null)
            return 0;
        
        if(root.left!=null && root.right!=null){
            if(root.key==(root.left.key+root.right.key)){
                int left=isSumProperty(root.left);
                if(left==0)
                	return 0;
                int right=isSumProperty(root.right);
                if(right==0)
                	return 0;
            }
            else{
                return 0;
            }
        }
       
       return 1; 
        
	}
	
}
