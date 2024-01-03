package Basic.geeksforgeeks.LinkedList;

import java.util.ArrayList;

public class ReverseLinkedList {

	public static void main(String[] args) {
		ReverseLinkedList rll = new ReverseLinkedList();
		Node head = null;
		head = insertAtEnd(head,10);
		Node temp=head;
		head = insertAtEnd(head,20);
		head = insertAtEnd(head,30);
		head = insertAtEnd(head,40);
		
		/*Naive solution will be using Arraylist as auxiliary space storing the nodes and then prints it 
		 * in backwards.
		 * Time Complexity : O(n)+O(n)=O(n)
		 * Auxiliary space complexity : O(n)
		 * */
//		rll.naive_reverse(temp);
		
		/** Time Complexity : O(n)
		 * Auxiliary space complexity : O(1)
		 * */
//		rll.eff_reverse(temp);
//		Node nnode = head;
//		while(nnode!=null){
//			System.out.print(nnode.data+" ");
//			nnode=nnode.next;
//		}
		
		//Below methods are recursive
		//In this method we are traversing and reversing the nth node and then linking the first node
//		Node rev = rll.recursive(temp); 
		//In this method we are traversing and reversing the n-1 node and then linking the nth node. 
		Node prev=null;
		Node rev = rll.recursive2(temp,prev);
		
		while(rev!=null){
			System.out.print(rev.data+" ");
			rev=rev.next;
		}
	}

	//This method is very much similar to the iterative method
	/*LOGIC : logic is kind of similar as iterative we keep track of head's next node and then we make
	 * the heads's next pointed to null and the new head will be the one which we stored earlier, in 
	 * the end we return the new head node and prev node.
	 * We keep on repeating the steps until we traverse through the whole linked list.
	 * */
	private Node recursive2(Node head, Node prev) {
		if(head==null)
			return prev;
//		
//		if(head.next==null)
//			return head;
		
		Node next=head.next;
		head.next=prev;
		return recursive2(next,head);
	}

	private Node recursive(Node head) {
		//Node curr=head;
		
		if(head==null)
			return null;
		
		if(head.next==null){
			return head;
		}
		
		Node rest_head=recursive(head.next);
		Node rest_tail = head.next;
		rest_tail.next=head;
		head.next=null;
		
		return rest_head;
	}

	private void naive_reverse(Node head) {
		if(head==null)
			return;
		
		if(head.next==null)
			System.out.print(head.data);
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(Node curr=head; curr!=null; curr=curr.next){
			arr.add(curr.data);
		}
		
		for(Node curr=head; curr!=null; curr=curr.next){
			curr.data=arr.remove(arr.size()-1);
		}
//		Node temp=curr;
		while(head!=null){
			System.out.print(head.data+" ");
			head=head.next;
		}
	}

	/*Time Complexity : O(n)
		 * Auxiliary space complexity : O(1)
		 * 
		 * LOGIC : We created 2 nodes prev & NEXT, the prev node is null at first and NEXT node contains
		 * the head's next node. 
		 * As we traverse through linked list till the end, 
		 * 1.we keep on storing the current's next node in the NEXT node and 
		 * 2.we keep on making the current's next to prev node and then 
		 * 3.storing the prev node with current node and 
		 * 4.current node with NEXT node.
		 * 
		 * In the end we return the prev node.
	 * */
	private void eff_reverse(Node head) {
		Node curr = head, prev=null;
		if(head==null)
			return;
		
		if(head.next==null){
			System.out.println(head.data);
			return;
		}
		
		while(curr!=null){
			Node next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		head=prev;
		
		while(head!=null){
			System.out.print(head.data+" ");
			head=head.next;
		}
	}


	private static Node insertAtEnd(Node head, int x) {
		Node curr = new Node(x);
		if(head==null)
			return curr;
		
		head.next=curr;
		
		return curr;
	}

}
