package Basic.geeksforgeeks.Stack;

import java.util.ArrayList;
/*NOTE : Here as we are using the ArrayList and it increases the size on its own that's why we don't need to
*introduce CAP & TOP variable here.
*/
public class ArayList {

	private ArrayList<Integer> al = new ArrayList<>();
	
	public static void main(String[] args) {
		ArayList ar = new ArayList();
		
		ar.push(5);
		ar.push(15);
		ar.push(25);
		System.out.println(ar.peek());
		System.out.println(ar.pop());
		ar.push(35);
		System.out.println(ar.peek());
		System.out.println(ar.size());
		System.out.println(ar.isEmpty());
	}

	private boolean isEmpty() {
		if(al.size()==0)
			return true;
		
		return false;
	}

	private int size() {
		return al.size();
	}

	private int pop() {
		int val=al.get(al.size()-1);
		al.remove(al.size()-1);
		return val;
	}

	private int peek() {
		return al.get(al.size()-1);
	}

	private void push(int x) {
		al.add(x);
	}

}
