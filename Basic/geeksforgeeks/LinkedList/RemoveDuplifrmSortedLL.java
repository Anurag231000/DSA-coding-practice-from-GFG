package Basic.geeksforgeeks.LinkedList;

public class RemoveDuplifrmSortedLL extends Implementation{

	public static void main(String[] args) {
		RemoveDuplifrmSortedLL rdll = new RemoveDuplifrmSortedLL();
		Node head=null;
		head = insertAtEnd(head,10);
		Node beg=head;
		head = insertAtEnd(head,20);
		head = insertAtEnd(head,20);
		head = insertAtEnd(head,30);
		head = insertAtEnd(head,30);
		head = insertAtEnd(head,30);
		head = insertAtEnd(head,40);
		
//		rdll.removeduplicates(beg);
		rdll.removeduplicates2(beg);
	}
	
	//By using extra Node variable that keeps track of head of next.
	private void removeduplicates2(Node head) {
		if(head==null)
			return;
		
		if(head.next==null){
			System.out.print(head.data+" ");
			return;
			}
		Node first=head;
		
		while(head.next!=null){
			Node curr=head.next;
			if(head.data==curr.data){
				Node nxt = curr.next;
				head.next=nxt;
			}else{
				curr=curr.next;
				head=head.next;
			}
		}
		while(first!=null){
			System.out.print(first.data+" ");
			first=first.next;
		}
	}

	//Without using extra Node variable but the Time complexity gets O(n2) in worst case.
	private void removeduplicates(Node head) {
		if(head==null)
			return;
		
		if(head.next==null){
			System.out.print(head.data+" ");
			return;
			}
		
		Node curr=head;
		while(head!=null){
			while(head.next!=null && head.data==head.next.data){
				Node nxt = head.next.next;
				head.next=nxt;
			}
			head=head.next;
		}
		
		while(curr!=null){
			System.out.print(curr.data+" ");
			curr=curr.next;
		}
	}

	private static Node insertAtEnd(Node head, int x) {
		Node curr = new Node(x);
		
		if(head==null)
			return curr;
		
		return head.next=curr;
	}

}
