package Basic.geeksforgeeks.CircularLinkedList;

public class Insertion extends FirstProgram{

	public static void main(String[] args) {
		Insertion in = new Insertion();
		
		Node tail=null, beg=null, head=null;
		
		//Below methods are for insert at beginning 
		beg=insertAtBegin(beg,1);
		beg=insertAtBegin(beg,2);
		tail=printNodes(beg);
		System.out.println();
		System.out.println(tail.data);
		//Effiecient solution
		beg = insertAtBegin_eff(beg,12,tail);
		beg = insertAtBegin_eff(beg,15,tail);
		printNodes(beg);
		
		beg = inserAtBegin_eff1(beg,78);
		beg = inserAtBegin_eff1(beg,60);
		System.out.println();
		printNodes(beg);
		
		//Below methods are for insert at End
		System.out.println();
		tail = insertAtEnd(beg,10,tail);
//		beg=tail;
		tail = insertAtEnd(beg,20,tail);
		System.out.println("beg : " + beg.data);
		beg=insertAtEnd_eff(beg,30);
		beg=insertAtEnd_eff(beg,100);
		beg=insertAtEnd_eff(beg,300);
		printNodes(beg);
	}
	
	/*Time Complexity : O(1)
	 * Auxiliary Space Complexity : O(1).
	 * 
	 * LOGIC : Here we are storing the head's next into new node's next and then point the head's next to 
	 * new node and then swap the head's data and new node's data.
	 * */
	private static Node insertAtEnd_eff(Node head, int x) {
		Node n = new Node(x);
		
		if(head==null){
			n.next=n;
			return n;
		}
		
		n.next=head.next;
		head.next=n;
		
		int temp=head.data;
		head.data=n.data;
		n.data=temp;
		
		return n;
	}

	/*Time Complexity : O(1)
	 * Auxiliary Space Complexity : O(1).
	 * 
	 * LOGIC : Here we are making the next node of header node is a new node and then swapping the data of new node
	 * and header node.
	 * */
	private static Node inserAtBegin_eff1(Node beg, int x) {
		Node n = new Node(x);
		
		if(beg==null){
			n.next=n;
			return n;
		}
		else{
			n.next=beg.next;
			beg.next=n;
			
			int temp=beg.data;
			beg.data=n.data;
			n.data=temp;
		}
		
		return beg;
	}

	/*Time Complexity : O(1)
	 * Auxiliary Space Complexity : O(1).
	 * But it requires 2 nodes head and tail node
	 * 
	 * LOGIC : If we have the tail node then we no need to traverse the circular LL, then we can simply
	 * points the new nodes's next to head node and the tail next's to new node. 
	 * */
	private static Node insertAtBegin_eff(Node beg, int x, Node tail) {
		Node n = new Node(x);
		
		if(beg!=null){
			n.next=beg;
			tail.next=n;
		}
		
		return n;
	}

	private static Node printNodes(Node beg) {
		Node curr=beg,tail=null;
		
		if(beg==null){
			System.out.print("No nodes");
			return null;
		}
		
		do{
			System.out.print(curr.data+ " ");
			curr=curr.next;
			if(curr.next!=null && curr.next==beg)
				tail=curr;
		}while(curr!=beg);
		
		
		return tail;
	}
	/*Time Complexity : Theta(n)
	 * Auxiliary Space complexity : O(1)
	 * 
	 * NAIVE SOLUTION
	 * 
	 * LOGIC : We first find the tail node by traversing till the end, then we point the new node's 
	 * next to head node and the tail's next point to new node.
	 * */
	private static Node insertAtBegin(Node beg, int x) {
		Node n = new Node(x);
		if(beg==null)
			return n;
		else{
			Node tail=beg;
			while(tail.next!=null && tail.next!=beg)
				tail=tail.next;
			n.next=beg;
			tail.next=n;
		}
		return n;
	}
	
	/*Time Complexity : O(1)
	 * Auxiliary Space Complexity : O(1).
	 * But it requires 2 nodes head and tail node
	 * */
	private static Node insertAtEnd(Node head, int x, Node last_tail) {
			Node tail = new Node(x);
			
			if(head==null){
				tail.next=tail;
				return tail;
			}
			
			tail.next=head;
			last_tail.next=tail;
			
		return tail;
	}

}
