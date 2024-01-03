package Basic.geeksforgeeks.Tree;

public class PrintKthNode extends TreeTraversal{

	public static void main(String[] args) {
		PrintKthNode pkn = new PrintKthNode();
		
		Node root= new Node(10);
//		root.left= new Node(20);
//		root.left.left= new Node(40);
//		root.left.right= new Node(50);
//		root.right= new Node(30);
//		root.right.right= new Node(70);
		
		root.left= new Node(6);
		root.right= new Node(8);
		root.right.right= new Node(7);
		root.right.right.left= new Node(11);
		root.right.right.right= new Node(12);
		
		int k=3;
		pkn.hieightOfTree(root,k);
	}

	private void hieightOfTree(Node root, int k) {
		if(root==null)
			return;
		
		if(k==0){
			System.out.print(root.key+" ");
			return;
		}
		else{
		hieightOfTree(root.left,k-1);
		hieightOfTree(root.right,k-1);
		}
	}

}
