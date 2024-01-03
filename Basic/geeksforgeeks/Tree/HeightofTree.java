package Basic.geeksforgeeks.Tree;

class Node1 {
	int key;
	Node right;
	Node left;
	Node1(int k){
		key=k;
		left=right=null;
	}
}

public class HeightofTree {
	
	public static void main(String[] args) {
		HeightofTree hot = new HeightofTree();
		
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.right.left = new Node(40);
		root.right.right = new Node(50);
		
		System.out.println(hot.height(root));
	}
	/*Time Complexity : O(n)
	 * Auxiliary spapce complexity : O(h)
	 * */
	private int height(Node root) {
		if(root==null)
			return 0;
		
		return Math.max(height(root.left),height(root.right))+1;
		}
}
