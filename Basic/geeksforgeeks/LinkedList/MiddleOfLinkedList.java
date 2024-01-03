package Basic.geeksforgeeks.LinkedList;

public class MiddleOfLinkedList extends Implementation{

	public static void main(String[] args) {
		MiddleOfLinkedList mol = new MiddleOfLinkedList();
		
		Node head = null;
		head = insertAtEnd(head,10);
		Node beg=head,curr=head;
//		head = insertAtEnd(head,5);
		head = insertAtEnd(head,20);
//		head = insertAtEnd(head,15);
		head = insertAtEnd(head,30);
		head = insertAtEnd(head,40);
//		head = insertAtEnd(head,50);
		
		while(beg!=null){
			System.out.print(beg.data+" ");
			beg=beg.next;
		}
		System.out.println();
		System.out.println("******middle element of linked list*********");
		System.out.println(mol.MiddleNode(curr));
		
		System.out.println("******eff method for middle element of linked list*********");
		System.out.print(mol.eff_middleNode(curr));
		System.out.println("\n"+3/2 + " " + 6/2);
	}
	
	/*T.C : Theta(middle_pos)
	 * A.S.C : Theta(1)
	 * 
	 * LOGIC : We create two pointers slow and fast at first both pointers point at the head node only
	 * and then later slow node will move one node at a time but fast node will move 2 nodes at a time 
	 * when the fast pointer reaches at the end node or at null then we return the slow pointer node.
	 * */
	private int eff_middleNode(Node head) {
		if(head==null)
			return -1;
		
		if(head.next==null)
			return head.data;
		
		Node slow=head,fast=head;
		
		//Easy method
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow.data;
		//A bit complex method
//		while(slow.next.next!=null){
//			fast=fast.next.next;
//			if(fast==null || fast.next==null){
//				return slow.next.data;
//			}
//			slow=slow.next;
//		}
		
//		return -1;
	}

	private static Node insertAtEnd(Node head, int x) {
		Node temp = new Node(x);
		if(head==null)
			return temp;
		
		head.next=temp;
			
		return temp;
	}
	/*T.C : Theta(n)+Theta(middle_pos) = O(n)
	 * A.S.C : O(1)
	 * */
	private static int MiddleNode(Node head) {
		if(head==null)
			return 0;
		
		if(head.next==null)
			return head.data;
		
		int count=1;
		Node curr=head;
		while(head!=null){
			count++;
			head=head.next;
		}
		
		int pos=1,mid=0;
		if(count%2==0){
		 mid=count/2;
		}else{
			mid=(count/2)+1;
		}
		
		while(curr!=null){
			if(pos==mid){
				return curr.data;
			}
			pos++;
			curr=curr.next;
		}
		return 0;
	}

}
