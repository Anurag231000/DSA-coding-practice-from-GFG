package Basic.geeksforgeeks.Heap;
//Building binary heap from random array

public class buildHeap {
	static int size;
	int capacity;
	int[] arr;
	
	buildHeap(int c){
		capacity=c;
		size=0;
		arr=new int[c];
	}
	
	public static void main(String[] args) {
		buildHeap bh = new buildHeap(15);
		
		int arr[] = {10,5,20,2,4,8};
		size=6;
		
		bh.constructingHeap(arr);
		
		for(int j=0; j<size; j++)
			System.out.print(arr[j]+" ");
	}
	
	/*T.C : O(n)
	 *A.S.C : 
	 * 
	 *LOGIC : We start the heapifying process from the bottom most right most node and then go upto the root or first value.
	 *In simple terms we start the heapifying at the index of last values's parent node.
	 *
	 *that's why the formula is (size-2)/2.
	 *1. size-1 : to get the last value.
	 *2. (i-1)/2 : to get the parent
	 *
	 * so to get the last value's parent node : (size-1)-1/2 = (size-2)/2;
	 * */
	private void constructingHeap(int[] arr){
		
		for(int i=(size-2)/2; i>=0; i--)
			minHeapify(arr,i);
	}
	
	/*T.C : O(log(n))
	 *A.S.C : O(log(n))
	 * */
	private void minHeapify(int[] arr, int i) {
		if(size<=0)
			System.out.println("There is nothing to heapify : " + Integer.MAX_VALUE);
		
		int min=i;
		int left=2*i+1;
		int right=2*i+2;
		
		if(left<size && arr[left]<arr[min])
			min=left;
			
		if(right<size && arr[right]<arr[min])
			min=right;
		
		if(i!=min){
			int temp=arr[i];
			arr[i]=arr[min];
			arr[min]=temp;
			
			minHeapify(arr,min);
		}
	}
}
