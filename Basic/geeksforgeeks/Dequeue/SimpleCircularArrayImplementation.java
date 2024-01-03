package Basic.geeksforgeeks.Dequeue;

public class SimpleCircularArrayImplementation {
	
	static int[] arr;
	static int size;
	int front;
	int rear;
	static int cap;
	SimpleCircularArrayImplementation(int x){
		cap=x;
		size=0;
		front=0;
		arr = new int[cap];
	}

	public static void main(String[] args) {
		SimpleCircularArrayImplementation cai = new SimpleCircularArrayImplementation(10);
		cai.insertFront(10);
		cai.insertRear(20);
		cai.insertFront(30);
		cai.insertRear(50);
		cai.deleteFront();
		cai.deleteRear();
		System.out.println(cai.getFrontElement());
		System.out.println(cai.getRearElement());
		System.out.println(cai.size());
		System.out.println(cai.isFull());
		System.out.println(cai.isEmpty());
		
		System.out.println();
		printElements();
	}

	private static void printElements() {
		
		for(int i=0; i<cap; i++)
			System.out.print(arr[i]+" ");
		
	}

	private boolean isEmpty() {
		if(size==0)
			return true;
		
		return false;
	}

	private boolean isFull() {
		if(size>=cap)
			return true;
		
		return false;
	}

	private int size() {
		return size;
	}

	private int getRearElement() {
		if(size==0)
			return 0;
		
		return arr[rear];
	}

	private int getFrontElement() {
		if(size==0)
			return 0;
		
		return arr[front];
	}

	private void deleteRear() {
		if(size==0)
			return;
		
		arr[rear]=0;
		rear--;
		size--;
	}

	private void deleteFront() {
		if(size==0)
			return;
		
		//front=getRear();
		arr[front]=0;
		front=(front+1)%cap;
		size--;
	}

	private void insertRear(int val) {
		if(isFull())
			return;

		if(size==0){
			front=getRear();
			rear=front=(front+1)%cap;
			arr[front]=val;
			size++;
			return;
		}
		
		
		rear=getRear();
		rear=(rear+1)%cap;
		arr[rear]=val;
		size++;
	}

	private void insertFront(int val) {
		if(isFull())
			return;
		
		if(size==0){
			front=getRear();
			rear=front=(front+1)%cap;
			arr[front]=val;
			size++;
			return;
		}
		
		
		//front=getRear();
		front=(front-1+cap)%cap;
		arr[front]=val;
		size++;
	}
	
	private int getRear(){
		if(isEmpty())
			return -1;
		
		return (front+size-1)%cap;
	}
}
