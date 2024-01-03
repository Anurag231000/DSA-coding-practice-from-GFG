package Basic.geeksforgeeks.Queue;

class Node{
	int data;
	Node next;
	Node(int x){
		data=x;
		next=null;
	}
}

public class QueueUsingLinkedList {
	
	static Node head;
	int size;

	public static void main(String[] args) {
		QueueUsingLinkedList qur = new QueueUsingLinkedList();
		
		Node tail=null;
		tail=qur.enqueue(tail,10);
		tail=qur.enqueue(tail,20);
		tail=qur.enqueue(tail,30);
		qur.dequeue(head);
		System.out.println(qur.size(tail));
		System.out.println(qur.getFront(head));
		System.out.println(qur.getRearElement(tail));
		System.out.println(qur.isEmpty(head));
	}

	private boolean isEmpty(Node head) {
	if(head==null)
		return true;
	return false;
}

	private int getRearElement(Node tail) {
	if(tail==null)
		return -1;
	
	return tail.data;
}

	private int size(Node head) {
	if(head==null)
		return -1;
	
	return size;
}

	private int getFront(Node head) {
		if(head==null)
			return -1;
		return head.data;
	}

	private Node dequeue(Node head) {
		if(head==null)
			return null;
		
		Node curr=head.next;
		head.next=null;
		size--;
		
		return curr;
	}

	private Node enqueue(Node tail, int x) {
		Node n=new Node(x);
		if(tail==null){
			size++;
			head=n;
			return n;
		}
		
		tail.next=n;
		size++;
		
		return n;
	}

}
