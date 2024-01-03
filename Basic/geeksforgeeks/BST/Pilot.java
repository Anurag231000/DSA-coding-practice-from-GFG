package Basic.geeksforgeeks.BST;

import java.util.LinkedList;
import java.util.Queue;

class Node{
	int val;
	Node left;
	Node right;
		Node(int x){
			val=x;
			left=right=null;
		}
}

public class Pilot {
	
	public static void main(String[] args) {
		Pilot p = new Pilot();
		int[] arr = {50,30,40,70,60,80};
		Node root=new Node(arr[0]);
//		Node root=new Node(15);
//		root.left = new Node(5);
//		root.left.left = new Node(3);
//		root.right = new Node(20);
//		root.right.left = new Node(18);
//		root.right.left.left = new Node(16);
//		root.right.right = new Node(80);
		int x = 50;
//		for(int i=0; i<arr.length; i++){
//			p.insert(root,arr[i]);
//		}
		for(int i=0; i<arr.length; i++){
			p.itr_insert(root,arr[i]);
		}
		System.out.println(p.search(root,x));
		System.out.println(p.itr_search(root,x));
		
		p.delete(root,x);
		System.out.println(p.itr_search(root,x));
	}
	
	/*T.C : O(h)
	 * A.S.C : O(h)
	 * 
	 * NOTE : In case of skewered tree the time & space complexity will be O(n).
	 * 
	 * LOGIC : 1.If the root is null we return null.
	 * 2. If the node is smaller than root, we move to left subtree and vice-versa in case if the node is larger.
	 * 3. A. After reaching to the node location we check whether the node has left or right child, if the node does not has left child we return
	 * the right child else we return the left child.
	 * 	  B. If the node has both the left and right child then we find the successor of the node and return it.
	 * 4. We then replace the root value with the node value.
	 * 5. We recursively call the delete method in order to delete the successor node because we have already replaced the root value with
	 * successor value.
	 * */
	private Node delete(Node root, int x) {
		if(root==null)
			return null;
		else if(x>root.val)
			root.right=delete(root.right,x);
		else if (x<root.val)
			root.left=delete(root.left,x);
		else{
			if(root.left==null)
				return root.right;
			else if(root.right==null)
				return root.left;
			else{
				Node succ = getSucc(root); // To get the successor of the node.
				root.val=succ.val;
				if(root.right!=null)
					root.right=delete(root.right,succ.val);
				else
					root.left=delete(root.left,succ.val);
			}
		}
		return root;
	}
	/*If the root has both the left & right child then we use the below logic.
	 * 
	 * LOGIC : If we want the nearest greater node than the root, then we move to right and then we move left till we reach the leaf node.
	 * The same needs to be done if we need nearest smaller node than root, then we move to left of root and then move right till we reach the
	 * leaf node.
	 * */
	private Node getSucc(Node root) {
		Node curr=root;
		
		if(curr.right!=null){
			curr=curr.right;
			/*LOGIC : If we need the nearest greater node
			 * */
		while(curr!=null && curr.left!=null)
			curr=curr.left;
		}else{
			curr=curr.left;
			/*LOGIC : If we need the nearest smaller node
			 * */
			while(curr!=null && curr.right!=null)
				curr=curr.right;
		}
		return curr;
	}

	/*T.C : O(h)
	 * A.S.C : O(1)
	 * 
	 * LOGIC : 1. First we store the node value in a temporary node variable.
	 * 		   2. Second we then move to either left or right depending upon the node value compared to its root value.
	 * 		   3. Now if the temporary node variable value is less than its root value it will get assigned to its left subtree else it will get
	 * 			  assigned to its right subtree.
	 * 		   4. We repeat the above 3 steps for every node we want to insert in BST.
	 * */
	private Node itr_insert(Node root, int x) {
		Node temp=new Node(x);
		Node curr=root, parent=null;
		
		while(curr!=null){
			parent=curr;
			if(x>curr.val)
				curr=curr.right;
			else if(x<curr.val)
				curr=curr.left;
			else
				return root;
		}
		
		if(parent==null)
			return temp;
		else if(x>parent.val)
			return parent.right=temp;
		else
			return parent.left=temp;
	}
	/*T.C : O(h)
	 * A.S.C : O(h)
	 * 
	 * LOGIC : If the node value is smaller than the root value then it goes to the left subtree else it goes to the right subtree.
	 * */
	private Node insert(Node root, int x) {
		if(root==null)
			return root=new Node(x);
		else if(x>root.val)
			root.right=insert(root.right,x);
		else
			root.left=insert(root.left,x);
		
		return root;
	}

	/*T.C : O(h)
	 * A.S.C : O(1)
	 * 
	 * LOGIC : If the value of the search node is same as root then we return true,  else if the value of search node is smaller than root node
	 * than we move to the left subTree and vice-versa in case if the value of search node is larger than root node.
	 * */
	private boolean itr_search(Node root, int x) {
		if(root==null)
			return false;
		
		while(root!=null){
			if(root.val==x)
				return true;
			else if(root.val>x)
				root=root.left;
			else
				root=root.right;
		}
		return false;
	}

	/*T.C : O(h)
	 * A.S.C : O(h)
	 * 
	 * LOGIC : We recursively search the left or right sub tree based upon the value we need to search. for example if the value to be search
	 * is less than the root the we search in left subtree otherwise in right subTree.
	 * In worst case scenario if the element is not present in BST then we traverse the full tree of height(h).  
	 * */
	private boolean search(Node root, int x) {
		if(root==null)
			return false;
		
		if(root.val==x)
			return true;
		else{
				if(x>root.val)
					return search(root.right,x);
				else if(x<root.val)
					return search(root.left,x);
		}	
		return false;
	}

}
