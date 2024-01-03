package Basic.geeksforgeeks.Stack;

/*We have created an array with size equal to CAP which will be provided by the user.
 * Here we have declared some variables like CAP & TOP, CAP is the maximum size of the array that can hold 
 * the nr of elements, TOP is created in order to keep note of the nr of elements in an array[Stack].
 * */
public class Array {
	
	int[] arr;
	int cap,top;
	public Array(int x) {
		top=-1;
		cap=x;
		arr = new int[cap];
	}

	public static void main(String[] args) {
		Array ar = new Array(1);
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
	
	/*This method returns true if stack is empty otherwise false.
	 * */
	private boolean isEmpty() {
		if(top==-1)
			return true;
		
		return false;
	}
	
	/*This method keeps track of the nr of elements in an array[Stack].
	 * */
	private int size() {
		return top+1;
	}
	
	/*This method will remove the element pointed by TOP variable from an array and decrementing the TOP at
	 * the same time acting as a pop() functionality of stack.
	 * */
	private int pop() {
		int val=arr[top];
		if(top==-1)
			System.out.println("Stack Underflow");
		top-=1;
		return val;
	}
	
	/*This method will return the topmost element of the stack from an array, with the help of TOP variable.
	 * */
	private int peek() {
		if(top!=-1)
		return arr[top];
		
		return 0;
	}
	
	/*Here we are simply inserting the elements in an array at the index of TOP and incrementing the TOP
	 * value at the same time.
	 * */
	private void push(int val) {
		int n=arr.length-1;
		if(top<n){
			top++;
			arr[top]=val;
		}else
			System.out.println("Stack overflow");
	}

}
