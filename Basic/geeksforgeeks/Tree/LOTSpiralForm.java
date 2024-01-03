package Basic.geeksforgeeks.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LOTSpiralForm extends TreeTraversal{

	public static void main(String[] args) {
		LOTSpiralForm sf = new LOTSpiralForm();
		Node root=new Node(10);
		root.left=new Node(20);
		root.left.left=new Node(40);
		root.left.left.left=new Node(80);
		root.left.left.right=new Node(90);
		root.left.right=new Node(50);
		root.right=new Node(30);
		root.right.left=new Node(60);
		root.right.right=new Node(70);
//		root.left=new Node(20);
//		root.right=new Node(30);
//		root.left.left=new Node(40);
//		root.left.right=new Node(60);
//		root.right.left=new Node(4);
//		root.right.right=new Node(6);
//		root.right.left.right=new Node(5);
//		root.right.left.right.left=new Node(7);
		
		sf.spiralForm(root);
	}

	private void spiralForm(Node root) {
		if(root==null)
			return;
		
		if(root.left==null && root.right==null){
			System.out.println(root.key);
			return;
		}
		
		Stack<Node> st1 = new Stack<>();
		Stack<Node> st2 = new Stack<>();
		
		st1.push(root);
		while(st1.isEmpty()==false || st2.isEmpty()==false){
			while(st1.isEmpty()==false){
				Node temp=st1.peek();
				st1.pop();
				System.out.print(temp.key+" ");
				
				if(temp.right!=null)
					st2.push(temp.right);
				if(temp.left!=null)
					st2.push(temp.left);
			}
			
			while(st2.isEmpty()==false){
				Node temp=st2.peek();
				st2.pop();
				System.out.print(temp.key+" ");
				
				if(temp.left!=null)
					st1.push(temp.left);
				if(temp.right!=null)
					st1.push(temp.right);
			}
		}
	}

}
