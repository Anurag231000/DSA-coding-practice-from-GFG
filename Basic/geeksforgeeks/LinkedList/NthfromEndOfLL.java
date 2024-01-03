package Basic.geeksforgeeks.LinkedList;

public class NthfromEndOfLL extends Implementation{

	public static void main(String[] args) {
		NthfromEndOfLL nfeol = new NthfromEndOfLL();
		
		Node head = null;
		head = insertAtEnd(head,10);
		Node temp=head;
		head = insertAtEnd(head,20);
		head = insertAtEnd(head,30);
		head = insertAtEnd(head,40);
		head = insertAtEnd(head,50);
		head = insertAtEnd(head,60);
		head = insertAtEnd(head,70);
		
		int n=3;
		System.out.println(nfeol.NthNodefrmEnd(temp,n));
	}
	
	/*T.C : Theta(given pos)
	 * A.S.C : O(1)
	 * 
	 * LOGIC : We are using 2 pointers here 1st and 2nd we move the 2nd pointer till we complete the given
	 * position. And then we move the 1st and 2nd pointer one node at a time till the 2nd pointer becomes
	 * null. At the we will return the node pointed by the 1st pointer.
	 * */
	private int NthNodefrmEnd(Node head, int n) {
		if(head==null || n<=0)
			return -1;
		
		Node first=head,second=head;
		
		for(int i=0; i<n; i++){
			if(second==null)
				return -1;
			second=second.next;
		}
		while(second!=null){
			first=first.next;
			second=second.next;
		}
		
		return first.data;
	}

	private static Node insertAtEnd(Node head, int x) {
		Node curr=new Node(x);
		
		if(head==null)
			return curr;
		
		head.next=curr;
		
		return curr;
	}

}
