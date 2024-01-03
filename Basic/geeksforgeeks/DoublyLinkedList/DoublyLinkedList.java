package Basic.geeksforgeeks.DoublyLinkedList;

class Node{
	int data;
	Node next,prev;
	Node(int x){
		data=x;
		next=prev=null;
	}
}

public class DoublyLinkedList {

	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		Node head=null;
		head = insertAtEnd(head,10);
		Node curr=head;
		head = insertAtEnd(head,20);
		head = insertAtEnd(head,30);
		
		printLinkedList(curr);
		
		Node res = insertAtBegin(curr,5);
		res = insertAtBegin(res,1);
		 head = insertAtEnd(head,15);
		System.out.println("\n**Inster at Begin**");
		printLinkedList(res);
		
		System.out.println("\n**After reversing linkedlist**");
		Node rev = reverse(res);
		printLinkedList(rev);
		System.out.println("\nprinting revrese after reversing the linked list");
		printreverseLL(rev);
		
		rev = deleteAtBegin(rev);
		System.out.println("\n**After deleting the head node**");
		printLinkedList(rev);
		
		rev = deleteAtEnd(rev);
		System.out.println("\n**After deleting the tail node**");
		printLinkedList(rev);
	}
	
	/*Time Complexity : O(n)
	 * Auxiliary Space Complexity : O(1)
	 * 
	 * LOGIC : We traverse the doubly LL until we reach the tail node and then we make the tail's prev node's
	 * next point to null.
	 * */
	private static Node deleteAtEnd(Node head) {
		if(head==null || head.next==null)
			return null;
		
		Node curr=head;
		while(head.next!=null)
			head=head.next;
		
		head.prev.next=null;
		
		return curr;
	}

	/*Time Complexity : O(1)
	 * Auxiliary Space Complexity : O(1)
	 * 
	 * LOGIC :  We just traverse the header node to next node and make the new header's node prev point to
	 * null so that current node act as header node.
	 * */
	private static Node deleteAtBegin(Node head) {
		if(head==null || head.next==null)
			return null;
		
		head=head.next;
		head.prev=null;
		
		return head;
	}

	private static void printreverseLL(Node head) {
		
		while(head.next!=null)
			head=head.next;
		
		while(head!=null){
			System.out.print(head.data+" ");
			head=head.prev;
		}
	}
	
	/*Time Complexity : O(n)
	 * Auxiliary Space Complexity : O(1)
	 * 
	 * LOGIC : We have introduced a new node PRV containing the current's next node.
	 * 1.We point the current's next to current's prev.
	 * 2.Then we point the current's next to PRV.
	 * 3. If the PRV value becomes null it means we have reversed the whole doubly LL and we need to stop
	 * now.
	 * 4. Now we make the PRV node as current node.
	 * 5. We traverse the doubly LL in a reverse manner.
	 * */
	private static Node reverse(Node head) {
		if(head==null)
			return null;
		
		if(head.next==null)
			return head;
		
		Node curr=null;
		while(head!=null){
			curr=head;
			Node prv=curr.next;
			curr.next=curr.prev;
			curr.prev=prv;
			if(prv==null)
				break;
			curr=prv;
			head=head.prev;
		}
		return curr;
	}

	/*Time Complexity : O(1)
	 * Auxiliary Space Complexity : O(1)
	 * 
	 * LOGIC : we just point the next of new node to the header node and then return the new node as header
	 * node.
	 * */
	private static Node insertAtBegin(Node curr, int x) {
		Node n = new Node(x);
		
		if(curr==null)
			return n;
		
		if(curr!=null){
			curr.prev=n;
		}
		
		n.next=curr;
		
		return n;
	}

	private static void printLinkedList(Node curr) {
		while(curr!=null){
			System.out.print(curr.data+" ");
			curr=curr.next;
		}
	}
	
	/*Time Complexity : O(n)
	 * Auxiliary Space Complexity : O(1)
	 * 
	 * LOGIC : We traverse the doubly LL until we reach the last node and then we make the new node prev
	 * point to last node and last node next point to new node.
	 * */
	private static Node insertAtEnd(Node head, int x) {
		Node n = new Node(x);
		
		if(head==null){
			return n;
		}
		
		while(head.next!=null)
			head=head.next;
		
		n.prev=head;
		head.next=n;
		
		return n;
	}

}
