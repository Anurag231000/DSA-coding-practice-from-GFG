package Basic.geeksforgeeks.LinkedList;

public class SortedInsertion extends Implementation{

	public static void main(String[] args) {
		SortedInsertion si = new SortedInsertion();
		
		Node head = null;
		head=insert(head,10);
		Node beg=head;
		head=insert(head,20);
//		head=insert(head,30);
//		head=insert(head,40);
		
//		while(beg!=null){
//			System.out.print(beg.data + " ");
//			beg=beg.next;
//		}
		int x=25;
//		si.sorted_Insert(beg,x);
		si.eff_sortedInsert(beg,x);
		
		while(beg!=null){
			System.out.print(beg.data + " ");
			beg=beg.next;
		}
	}
	
	/*TIme complexity : A. In case of insertion at beg Theta(1)
	 * 					B. In case of insertion at end Theta(n)
	 * 					C. In case of insertion at pos Theta(pos)
	 * Auxiliary space complexity : O(1)
	 * */
	private Node eff_sortedInsert(Node head, int x) {
		Node curr = new Node(x);
		
		if(curr==null)
			return curr;
		
		if(curr.data<head.data){
			curr.next=head;
			return curr;
		}
		Node temp=head;
		
		while(temp.next!=null && temp.next.data<curr.data){
			temp=temp.next;
		}
		curr.next=temp.next;
		temp.next=curr;
		
		return head;
	}
	
	/*TIme complexity : A. In case of insertion at beg Theta(1)
	 * 					B. In case of insertion at end Theta(n)
	 * 					C. In case of insertion at pos Theta(pos)
	 * Auxiliary space complexity : O(1)
	 * */
	private void sorted_Insert(Node head, int x) {
		Node curr = new Node(x),beg=head;
		if(head==null){
			head=curr;
			beg=head;
		}
		else{
			while(head.next!=null){
				//Below logic is for when the new node needs to be add at beginning
				if(curr.data<head.data){
					curr.next=head;
					beg=curr;
					break;
				}
				//Below logic is for when the new node needs to be add in the middle
				if(curr.data>head.data && head.next.data>curr.data){
					curr.next=head.next;
					head.next=curr;
					break;
				}
				//Below logic is for when the new node needs to be add at end
				if(curr.data>head.next.data && head.next.next==null){
					head.next.next=curr;
					break;
				}
				head=head.next;
			}
		}
		while(beg!=null){
			System.out.print(beg.data+" ");
			beg=beg.next;
		}
	}

	private static Node insert(Node head, int x) {
		Node curr = new Node(x);
		
		if(head==null)
			return curr;
		else{
			while(head.next!=null){
				head=head.next;
			}
			head.next=curr;
		}
		return curr;
	}

}
