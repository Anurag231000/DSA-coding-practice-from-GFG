package Basic.geeksforgeeks.CircularLinkedList;

class Node{
	int data;
	Node next;
	Node(int x){
		data=x;
		next=null;
	}
}

public class FirstProgram {

	public static void main(String[] args) {
//		Node head = null;
		Node head=new Node(10);
		Node beg=head;
	    head.next=new Node(5);
	    head.next.next=new Node(20);
	    head.next.next.next=new Node(15);
	    head.next.next.next.next=head;
	    
	    
	    /*CIRCULAR LINKED LIST : As the name implies, it is the linked list where there is no tail node,
	     * the last node itself points to the head.
	     * 
	     * LOGIC : In order to traverse the circular LL we keep track of the head node, then we keep
	     * on traversing the LL until we encounter the head node again.
	     * */
	    while(head!=null){
	    	System.out.print(head.data+" ");
	    	head=head.next;
	    	if(head==beg)
	    		break;
	    }
	}

}
