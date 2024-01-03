package Basic.geeksforgeeks.Heap;

public class Operations {
	static int size;
	int capacity;
	static int[] arr;
	
	Operations(int c){
		capacity=c;
		size=0;
		arr=new int[c];
	}
	
	public static void main(String[] args) {
		Operations op = new Operations(15);
		
//		int arr[] = {10,20,40,80,100,70};
//		int arr[] = {10,20,30,40,50,35,38,45};
		int arr[] = {5,9,8,12,14,20,40};
		
		
		int i=3, x=5;
		size=6;
//		op.decreaseKey(arr,i,x);
		
		size=7;
		op.delete(arr,i);
	}
	
	/*T.C : O(log(h))+O(log(h))=O(log(h))
	 * A.S.C : O(1) if used iterative method to heapify else O(log(h)) if recursive method is used.
	 * 
	 * LOGIC : We first replace the element at index i with 0 or -1 then heapify it, as we replaced it with the smallest value after heapify it will eventually be at the first or root, then we replace the first value with
	 * the last value and decrease the size by 1.
	 * We then heapify the binary heap again but now from first or root.
	 * 
	 * To summarize it has 2 method calls :
	 * 1. decreaseKey
	 * 2. extractMin
	 * */
	private void delete(int[] arr, int i) {
		arr[i]=0;
		itrHeapify(arr,i);
		
		arr[0]=arr[size-1];
		size--;
		
		heapify(arr,0);
		
		System.out.println("\n***After deleting an element***");
		for(int j=0; j<size; j++)
			System.out.print(arr[j]+" ");
	}

	private void heapify(int[] arr, int i) {
		if(size==0 || size==1){
			System.out.print("There is nothing to heapify");
			return;
		}
		
		int min=i;
		int left=2*i+1;
		int right=2*i+2;
		
		while(left<size || right<size && (arr[min]>arr[left] || arr[min]>arr[right])){
			if(left<size && arr[left]<arr[min])
				min=left;
			
			if(right<size && arr[right]<arr[min])
				min=right;
			
			if(i!=min){
				int temp=arr[i];
				arr[i]=arr[min];
				arr[min]=temp;
			}
			
			i=min;
			left=2*min+1;
			right=2*min+2;
		}
	}

	/*T.C : O(log(h))
	 *A.S.C : O(1) if used iterative method to heapify else O(log(h)) if recursive method is used.
	 *
	 *LOGIC : We replace the value at given index with a given value, then we heapify the binary heap.
	 * */
	private void decreaseKey(int[] arr, int i, int x) {
		arr[i]=x;
					
		System.out.println("***Recursive method***");
//		minHeapify(arr,i);
		
		System.out.println("***Iterative method***");
		itrHeapify(arr,i);
		
		for(int j=0; j<size; j++)
			System.out.print(arr[j]+" ");
	}
	
	private int parent(int i){
		return (i-1)/2;
	}
	
	/*T.C : O(log(h))
	 *A.S.C : O(1)
	 * */
	private void itrHeapify(int[] arr, int i) {
		if(size==0 || size==1){
			System.out.print("There is nothing to heapify");
			return;
		}
		
		while(i!=0 && arr[parent(i)]>arr[i]){
			int temp=arr[i];
			arr[i]=arr[parent(i)];
			arr[parent(i)]=temp;
			
			i=parent(i);
		}
	}

	/*T.C : O(log(h))
	 *A.S.C : O(log(h))
	 * */
	private void minHeapify(int[] arr, int i) {
		if(size==0 || size==1){
			System.out.print("There is nothing to heapify");
			return;
		}
		
		int min=(i-1)/2;
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
