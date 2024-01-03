package Basic.geeksforgeeks.Stack;

class Node{
	int data;
	Node next;
	Node(int x){
		data=x;
		next=null;
	}
}

/*We have declared 2 variables here HEAD & SIZE, HEAD is the first node or element in stack and SIZE will keep
 * track of the nr of nodes/elements in stack.
 * */
public class LinkedList {
	
	Node head;
	int size;
	
	LinkedList(){
		head=null;
		size=0;
	}
	
	public static void main(String[] args) {
		LinkedList sll = new LinkedList();
		
		sll.push(10);
		sll.push(20);
		sll.push(30);
		System.out.println(sll.peek());
		System.out.println(sll.pop());
		sll.push(40);
		System.out.println(sll.peek());
		System.out.println(sll.size());
		System.out.println(sll.isEmpty());
	}

	private boolean isEmpty() {
		if(size==0)
			return true;
		
		return false;
	}

	private int size() {	
		return size;
	}
	
	/*Getting the header's node data.
	 * */
	private int peek() {
		if(head==null)
			return 0;
		
		return head.data;
	}
	
	/*Here we are simply removing the nodes/elements from beginning of a singly LL.
	 * */
	private int pop() {
		
		if(head==null){
			System.out.println("Stack underflow");
			return 0;
		}
		
		Node curr=head.next;
		int val=head.data;
		head.next=null;
		head=curr;
		size=size-1;
		
		return val;
	}
	
	/*In this method we are simply inserting the elements at beginning of singly LL, because stack follows
	 * LIFO.
	 * */
	private void push(int x) {
		Node n = new Node(x);
		
		n.next=head;
		head=n;
		size=size+1;
	}

}
