package Basic.geeksforgeeks.Dequeue;

public class CircularArrayImplementation {
	static int[] arr;
	int front,size;
	static int cap;
	int rear;
	CircularArrayImplementation(){
		cap=10;
		arr=new int[cap];
		front=rear=-1;
		size=0;
	}
	public static void main(String[] args) {
		CircularArrayImplementation cai = new CircularArrayImplementation();
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
		if(size>cap)
			return  true;
		
		return false;
	}
	private int size() {
		return size;
	}
	private int getRearElement() {
		if(rear==-1 || size==0)
			return -1;
		
		return arr[rear];
	}
	private int getFrontElement() {
		if(front==-1 || size==0)
			return -1;
		
		return arr[front];
	}
	
	private void deleteFront() {
		if(size==0)
			return;
		
		size--;
		front--;
	}
	private void deleteRear() {
		if(size==0)
			return;
		
		size--;
		rear--;
	}
	private void insertRear(int x) {
		if(size==cap)
			return;
		
		
		rear=getRear();
		if(rear==0)
		rear=(rear+1)%cap;
		size++;
		arr[rear]=x;
	}
	private void insertFront(int x) {
		if(size==cap)
			return;
		
		if(size==0){
		size++;
		front=(front+1)%cap;
		rear=(rear+1)%cap;
		arr[front]=x;
		return;
		}
		
		size++;
		int prev=front;
		front++;
		front=(front+1)%cap;
		arr[front]=arr[rear];
		arr[front-1]=x;
		
		int temp=arr[front-1];
		arr[front-1]=arr[prev];
		arr[prev]=temp;
	}
	private int getRear(){
		rear=(rear+size-1)%cap;
		
		return rear;
	}
}
