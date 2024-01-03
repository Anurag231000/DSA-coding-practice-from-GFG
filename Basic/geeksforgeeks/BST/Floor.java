package Basic.geeksforgeeks.BST;

import java.io.Console;

/*CONCEPT : If the given value is present then return the value, else return the nearest[immediate] smaller value than the given value.
 * And if the value is not present return null;
 * */
public class Floor extends Pilot{

	public static void main(String[] args) {
		Floor fl = new Floor();
		
		int[] arr= {50,30,20,40,70,60,80,55,65};
		Node root=new Node(arr[0]);
		
		for(int i=1; i<arr.length; i++)
			insert(root,arr[i]);
		
		int x = 10; 
		
		Node res = fl.eff_floor(root,x);
		
		if(res==null)
			System.out.println("Element is not +nt in BST");
		else
			System.out.println(res.val);
	}
	
	/*Time Complexity : O(h)
	 * Auxiliary space complexity : O(1)
	 * 
	 * LOGIC : As the floor concept is to return the exact or nearest smaller value, we are keeping track of only left subtree node values.
	 * */
	private Node eff_floor(Node root, int x) {
		
		if(root==null)
			return null;
		Node res=null;
		while(root!=null){
			if(root.val==x)
				return root;
			else if(root.val>x){
				root=root.left;
			}
			else{
				res=root;
				root=root.right;
			}
		}
		return res;
	}

	/*T.C : O(h)
	 * A.S.C : O(1)
	 * */
	private static Node insert(Node root, int x) {
		Node temp = new Node(x);
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

}
