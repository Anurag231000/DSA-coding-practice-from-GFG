package Basic.geeksforgeeks.BST;

public class Ceil extends Pilot{
//CONCEPT : If the value is present in the tree then return the value or return the nearest largest value. And if the value is not present return null;
	public static void main(String[] args) {
		Ceil c = new Ceil();
		int[] arr = {50,30,20,40,70,60,78,55,65};
		
		Node root=new Node(arr[0]);
		
		for(int i=1; i<arr.length; i++){
			itr_insert(root,arr[i]);
		}
		
		int x=40;
		
		Node res=c.ceiling(root,x);
		
		if(res==null)
			System.out.println("Element is not +nt in BST");
		else
			System.out.println(res.val);
	}
	
	/*Time Complexity : O(h)
	 * Auxiliary space complexity : O(1)
	 * 
	 * It's an efficient solution
	 * */
	private Node ceiling(Node root, int x) {
		if(root==null)
			return null;
		
		Node res=null;
		while(root!=null){
			if(root.val==x)
				return root;
			else if(x>root.val)
				root=root.right;
			else{
				res=root;
				root=root.left;
			}
		}
		
		return res;
	}

	/*Time Complexity : O(h)
	 * Auxiliary space complexity : O(1)
	 * */
	private static Node itr_insert(Node root,int x){
		Node curr=root, parent=null;
		Node temp=new Node(x);
		
//		if(curr==null)
//			return temp;
		
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
		else if(x<parent.val)
			return parent.left=temp;
		else
			return parent.right=temp;
	}
}
