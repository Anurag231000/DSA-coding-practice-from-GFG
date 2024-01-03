package Basic.geeksforgeeks.Tree;

import java.util.LinkedList;
import java.util.Queue;

//class NodeL{
//	int data;
//	NodeL next;
//	NodeL(int x){
//		data=x;
//		next=null;
//	}
//}

public class binaryTreeToCircularDoublyLL extends TreeTraversal{
	static Node head=null;
	Node temp=null;
	public static void main(String[] args) {
		binaryTreeToCircularDoublyLL btdll = new binaryTreeToCircularDoublyLL();
		
		Node root= new Node(10);
		root.left=new Node(12);
		root.right=new Node(15);
		root.left.left=new Node(25);
		root.left.right=new Node(30);
		root.right.left=new Node(36);
		
		
	}
	
	
}
