package Basic.geeksforgeeks.Queue;

/*By using single array all operations take O(1) time except Dequeue because after deleting an
 * element each element need to be move to its previous.
 * */
public class QueueUsingArray {
	
	int[] arr; 
	int front,rear,cap;
	/*Here we are maintaining 3 variables CAP, FRONT & REAR, CAP is the maximum capacity of the array[Queue],
	 * we are using FRONT in order to add the element to the array[Queue] and REAR in order to delete the
	 * element from the end of an array[Queue].
	 * 
	 * FRONT keeps track of the topmost element.
	 * REAR keeps track of the last element.
	 * */
	QueueUsingArray(){
		cap=10;
		arr = new int[cap];
		front=rear=-1;
	}
	public static void main(String[] args) {
		QueueUsingArray qur = new QueueUsingArray();
		qur.enqueue(10);
		qur.enqueue(20);
		qur.enqueue(30);
		qur.dequeue();
		System.out.println(qur.size());
		System.out.println(qur.getFront());
		System.out.println(qur.getRear());
		System.out.println(qur.isFull());
		System.out.println(qur.isEmpty());
	}
	private boolean isEmpty() {
		if(front==-1 || rear==-1)
			return true;
		
		return false;
	}
	private boolean isFull() {
		if(rear>cap)
			return true;
		
		return false;
	}
	private int getRear() {
		if(rear==-1)
			return -1;
		
		return arr[rear];
	}
	private int getFront() {
		if(front==-1)
			return -1;
		
		return arr[front];
	}
	private int size() {
		return rear;
	}
	
	private void dequeue() {
		if(rear==-1 || front==-1)
			System.out.println("Queue is underflow");
		
		for(int i=0; i<rear; i++){
				arr[i]=arr[i+1];
		}
		rear--;
	}
	/*If there are no elements then we then we need to increase both FORNT & REAR by 1 at the same time.
	 * */
	private void enqueue(int x) {
		if(rear>cap)
			System.out.println("Queue overflow");
		
		if(front==-1){
			front++;
			rear++;
			arr[front]=x;
			return;
		}
		rear++;
		arr[rear]=x;
	}

}
