package Basic.geeksforgeeks.CircularLinkedList;

public class Deletion extends FirstProgram{

	public static void main(String[] args) {
		
		Node head = null;
		head = insertAtEnd(10,head);
		Node beg=head;
		head = insertAtEnd(20,head);		
		head = insertAtEnd(30,head);
		head = insertAtEnd(40,head);
		
		printNodes(beg);
		
		System.out.println("\n***After Deleting first Node***");
//		Node res = deleteAtBegin(beg);
//		Node res = deleteAtBegin_eff(beg);
//		printNodes(res);
		
		//Delete at kth node
		int k=1;
		Node res = deleteAtKth(beg,k);
		printNodes(res);
	}
	
	/*Time Complexity : O(k)
	 * Auxiliary Space Complexity : O(1)
	 * 
	 * LOGIC : We traverse through the circular LL till we reach the one node before the Kth pos and then
	 * we simply point the current node's pointer to current's next to next node.
	 * */
	private static Node deleteAtKth(Node beg, int k) {
		if(beg==null)
			return null;
	
		if(k==1 && beg.next==beg)
			return null;
		else if(k>1 && beg.next==beg)
			return beg;
		
		Node head=beg;
		
		if(k>1){
			while(beg!=null && k-1>1){
				k--;
				beg=beg.next;
				if(beg.next==head)
					return head;
				}
			beg.next=beg.next.next;
		}else if(k==1){
			beg.data=beg.next.data;
			beg.next=beg.next.next;
		}
		
		return head;
	}

	/*Time Complexity : O(1)
	 * Auxiliary Space Complexity : O(1)
	 * 
	 * LOGIC :  We copied the header's next node data to the header's data, then we point the header's
	 * next pointer to header's next to next node.
	 * */
	private static Node deleteAtBegin_eff(Node beg) {
		if(beg==null)
			return null;
		
		if(beg.next==beg)
			return null;
		
		beg.data=beg.next.data;
		beg.next=beg.next.next;
		
		return beg;
	}

	/*Time Complexity : O(n)
	 * Auxiliary Space Complexity : O(1)
	 * 
	 * LOGIC : Here we are traversing till the last node to get the tail node and then we point the tail
	 * node's next pointer to header's next node.
	 * */
	private static Node deleteAtBegin(Node beg) {
		if(beg==null)
			return null;
		
		Node n=beg.next,head=beg;
		if(beg.next==beg)
			return null;
			
		while(beg!=null){
			if(beg.next==head)
				break;
			beg=beg.next;
		}
		beg.next=n;
		
		return n;
	}

	private static void printNodes(Node beg) {
		Node head=beg;
		if(beg==null)
			System.out.println("LinkedList is empty");
		
		while(beg!=null){
			System.out.print(beg.data+" ");
			beg=beg.next;
			if(beg==head)
				break;
		}
		
	}

	private static Node insertAtEnd(int x, Node head) {
		Node n = new Node(x);
		
		if(head==null){
			head=n;
			head.next=head;
			return head;
		}
		
		n.next=head.next;
		head.next=n;
		
		return n;
	}

}
