package Basic.geeksforgeeks.LinkedList;

public class TraversingLinkedList extends Implementation{
	
	public static void main(String[] args) {
		TraversingLinkedList tll = new TraversingLinkedList();
//		Node head=null;
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		
		// Below methods are for traversing the Linked List
		//tll.printLinkedList(head);
		//tll.recursive_printLinkedList(head);
		
		//Below methods are for insertion of nodes in LinkedList
		int x=300,pos=4;
//		System.out.print(tll.search(head,x));
//		System.out.println();
//		System.out.println(tll.recursive_search(head,x));
		
//		tll.insertBegin(head,x);
//		tll.insertEnd(head,x);
		tll.insertAtPos(head,pos,x);
		
		//Below methods are for deletion nodes in Linked List
//		tll.deleteBegin(head);
//		tll.deleteEnd(head);
	}
	
	/*LOGIC : We are going to traverse the linked list just till just before the position at which we
	 * need to insert the node.
	 * 
	 * We point the next of new node to current node's next. And then current's node next point to new
	 * node.
	 * */
	private void insertAtPos(Node head, int pos, int x) {
		Node n = new Node(x), curr=head;
		int count=1;
		
		if(head==null & pos>1)
			return;
		
		//Below logic is for inserting the new node at the beginning.
		if(pos==1 && head!=null){
			n.next=head;
			curr=n;
			printLinkedList(curr);
			return;
		}
		
		while(pos-1>1 && head.next!=null){
			pos--;
			head=head.next;
		}
		n.next=head.next;
		head.next=n;

//		while(curr!=null){
//			if(count==pos-1){
//				n.next=curr.next;
//				curr.next=n;
//			}
//			count++;
//			curr=curr.next;
//		}
//		if(pos>=count+1)
//			return;
		
		printLinkedList(curr);
	}

	/*Time complexity : O(n)
	 * Auxiliary space complexity : O(1)
	 * 
	 * LOGIC : We iterate through the linked list till we reach the 2nd last node and then we point the
	 * current node's next to null so it indicates that the current node is the last node now.
	 * */
	private void deleteEnd(Node head) {
		
		if(head==null)
			System.out.print("There are no nodes to delete");
		if(head.next==null)
			head=null;
		
		Node curr=head;	
		while(curr.next.next!=null){
				curr=curr.next;
		}
		curr.next=null;
		
		printLinkedList(head);
	}

	/*Time complexity : O(1)
	 * Auxiliary space complexity : O(1)
	 * 
	 * LOGIC : We just need to move the head node to next node.
	 * 
	 * NOTE : In Java as we have garbage collector we don't need to point the head node to null, we just 
	 * move it to next node and garbage collector will take care of the first node own its own.
	 * */
	private void deleteBegin(Node head) {
		
		if(head==null)
			System.out.print("There are no nodes to delete");
		else{
				head=head.next;
		}
		printLinkedList(head);
	}

	/*Time complexity : O(n)
	 * Auxiliary space complexity : O(1)
	 * 
	 * LOGIC : We are going to traverse the linked list till we reach the last node, just before the
	 * null and then we make the last node point to new node and the new node point to null indicating
	 * that the new node is the last node now.
	 * */
	private void insertEnd(Node head, int x) {
		Node curr = new Node(x);
		Node beg=head;
		if(head==null)
			System.out.print(curr.data);
		else{
			while(beg.next!=null){
				beg=beg.next;
			}
			beg.next=curr;
			curr.next=null;
		}
		printLinkedList(head);
	}
	/*Time complexity : O(1)
	 * Auxiliary space complexity : O(1)
	 * 
	 * LOGIC : We just need to insert the new node at beginning and then make the next pointer of the
	 * new node to point to earlier first node[head node].
	 * */
	private void insertBegin(Node head, int x) {
		Node curr = new Node(x);
		curr.next=head;
		printLinkedList(curr);
	}

	/*Time complexity : O(n)
	 * Auxiliary space complexity : O(n)
	 * */
	private int recursive_search(Node head, int x) {
		if(head==null)
			return -1;
		
		if(head.data==x)
			return 1;
		else{
			int res=recursive_search(head.next,x);
			if(res==-1)
				return -1;
			else
				return res+1;
		}
	}
	/*Time complexity : O(n)
	 * Auxiliary space complexity : O(1)
	 * */
	private int search(Node head, int x) {
		int count=0;
		Node curr=head;
		while(curr!=null){
			count++;
			if(curr.data==x){
				return count;
			}
			curr=curr.next;
		}
		return -1;
	}
	/*Time complexity : O(n)
	 * Auxiliary space complexity : O(n)
	 * 
	 * LOGIC : We are printing the current element data along the way as we move forward. 
	 * */
	private void recursive_printLinkedList(Node head) {
		Node curr = head;
		
		if(curr==null)
			return;
		System.out.print(curr.data + " ");

		recursive_printLinkedList(curr.next);
	}
	/*Time complexity : O(n)
	 * Auxiliary space complexity : O(1)
	 * */
	public void printLinkedList(Node head) {
		Node curr = head;
		while(curr!=null){
			System.out.print(curr.data + " ");
			curr=curr.next;
		}
	}

}
