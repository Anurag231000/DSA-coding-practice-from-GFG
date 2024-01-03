package Basic.geeksforgeeks.Tree;

import java.util.*;

public class MaxWidthofTree extends TreeTraversal{

	public static void main(String[] args) {
		MaxWidthofTree mwt = new MaxWidthofTree();
		
		Node root=new Node(9);
		root.left=new Node(10);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(7);
		//root.left.left.left=new Node(7);
		root.left.left.right=new Node(6);
		root.left.right.left=new Node(2);
		root.right.left=new Node(8);
		root.right.right=new Node(1);
		
		System.out.println(mwt.getMaxWidth(root));
	}

	private int getMaxWidth(Node root) {
		int count=0,cnt=0;
        
        if(root==null)
        return count;
        
        if(root.left==null && root.right==null){
            count++;
            return count;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(q.isEmpty()==false){
        	count=Math.max(count, q.size());
        	
        	for(int i=0; i<q.size(); i++){
	            Node curr=q.poll();
	            
	            if(curr.left!=null){
	                q.add(curr.left);
	            }
	            
	            if(curr.right!=null){
	                q.add(curr.right);
	            }
        	} 
        }
       return count; 
	}

}
