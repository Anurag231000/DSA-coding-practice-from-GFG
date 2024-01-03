package Basic.geeksforgeeks.Queue;

/*By using circular array all operations takes Theta(1) time.
 * */
public class QueueUsingCircularArray {
	
	int[] arr;
	int front,cap,size;
	QueueUsingCircularArray(){
		front=-1;
		size=0;
		cap=1;
		arr=new int[cap];
	}

	public static void main(String[] args) {
		QueueUsingCircularArray qur = new QueueUsingCircularArray();
		qur.enqueue(10);
		qur.enqueue(20);
		qur.enqueue(30);
		//qur.dequeue();
		System.out.println(qur.size());
		System.out.println(qur.getFront());
		System.out.println(qur.getRearElement());
		System.out.println(qur.isFull());
		System.out.println(qur.isEmpty());
	}

	private int getRearElement() {
		int rear=getRear();
		return arr[rear];
	}

	private int getFront() {
		if(front==-1){
			//System.out.println("Queue is Empty");
			return -1;
		}
			
		return arr[front];
	}

	private int size() {
		return size;
	}

	private void dequeue() {
		if(size==0){
			System.out.println("Queue is Empty");
			return;
		}
		
		front=(front+1)%cap;
		size--;
	}

	private boolean isFull() {
		if(size==cap)
			return true;
		
		return false;
	}

	private boolean isEmpty() {
		if(size==0)
			return true;
		
		return false;
	}

	private void enqueue(int x) {
		if(isFull()){
			System.out.println("Queue is full");
			return;
		}
		
		if(front==-1)
			front++;
		
		int rear=getRear();
		rear=(rear+1)%cap;
		arr[rear]=x;
		size++;
	}

	private int getRear() {
		if(isEmpty())
			return -1;
		
		return (front+size-1)%cap;
	}

}
