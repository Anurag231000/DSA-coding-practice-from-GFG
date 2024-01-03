package Basic.geeksforgeeks.Heap;
/*Binary Heap applications : 
 * A. Used in Heap Sort
 * B. Used to implement Priority Queue
 * C. Useful in djikstra's algo, Prim's min spanning tree algo, huffman coding
 * 
 * Types of Binary Heap :
 * A. Min Heap (Highest priority item is assigned with low value)
 * B. Max Heap (Highest priority item is assigned with highest value)
 * 
 * NOTE : Binary heap structure are stored as an array
 * 
 * Advantage of a structure that is complete and can be represented as an Array (Complete binary Tree):
 * A. Items are at contiguous location, therefore random access.
 * B. Cache friendly because all items are at contiguous location, they have locality of reference.
 * C. Due to complete binary tree, it's a tree with min height.
 * 
 * NOTE : Most of the operations on binary heap are depend upon the height of the tree, that's why their T.C are mostly log(n).
 * */
public class Pilot {
	static int[] arr;
	static int size;
	static int capacity;
	
	Pilot(int c){
		capacity=c;
		size=0;
		arr = new int[c];
	}
	public static void main(String[] args) {
		Pilot p = new Pilot(15);
		
		int[] arr = {10,20,15,40,50,100,25,45,12};
		int[] binaryHeap = new int[arr.length];
		
//		int[] heap = {40,20,30,35,25,80,32,100,70,60};
		int[] heap = {20,25,30,35,40,80,32,100,70,60};
		size=10;
		
//			minHeapify(heap,0);
		
//		for(int i=0; i<arr.length; i++)
//			p.insert(binaryHeap,arr,i);
		
		for(int i=0; i<size; i++)
			System.out.print(heap[i]+" ");
		
		System.out.println("");
		p.extractMin(heap);
		
		for(int i=0; i<size; i++)
			System.out.print(heap[i]+" ");
	}
	
	/*T.C : O(log(h))
	 *A.S.C : O(log(h)) in case of recursive else O(1) in case of iterative
	 * 
	 * LOGIC : We remove the minimum value from the binary heap, in case of min heap its the first(root) value. We do this by replacing the root's value with the last binary heap value, now the binary heap is not in order
	 * we then just heapify the whole binary heap until the whole binear heap gets heapify.
	 * We decrease the size of binary heap as well as we have just removed the first value from binary heap*/
	private void extractMin(int[] heap) {
		
		//Integer.MAX_VALUE returns the infinite value
		if(size<=0)
			System.out.println("There is no minimum value to return as binary heap is empty : " + Integer.MAX_VALUE);
		if(size==1){
			size--;
			System.out.println("Minimum vaue : " + heap[0]);
		}
		
		heap[0]=heap[size-1];
		size--;
		
		//for(int i=0; i<size; i++)
			minHeapify(heap,0);
	}
	/*T.C : O(log(h))
	 * A.S.C : O(log(h)) in case of recursive else O(1) in case of iterative
	 * 
	 * LOGIC : We insert the element at the end and then check whether the new node's parent node value is smaller(in case of min heap else it should be largest) or not. If its not then we heapify the binary heap.
	 * Heapify :  we will swap the child's node value with paren't value until the tree becomes binary heap tree. 
	 * 
	 * NOTE : Using bottom-up approach here
	 * */
	private int[] insert(int[] binaryHeap, int[] arr, int i){
		if(size==capacity)
			return binaryHeap;
		
		int parent = (i-1)/2;
		
		//If the size is not full keep on adding the node at the end.
		if(size!=arr.length)
			size++; binaryHeap[size-1]=arr[i];
		
		//Heapfying the binary heap
		if(i!=0 && binaryHeap[parent]>binaryHeap[i]){
			int temp=binaryHeap[parent];
			binaryHeap[parent]=binaryHeap[i];
			binaryHeap[i]=temp;
			
			/*Heapify the binary heap until we reached the root node or parent node value becomes smaller[in case of min heap else large value
			 * in case of max heap] than child nodes*/	
			insert(binaryHeap,arr,parent);
		}
 		return binaryHeap;	
	}
	
	/*T.C : O(log(h))
	 * A.S.C : O(log(h)) in case of recursive else O(1) in case of iterative
	 * 
	 * LOGIC : We just pass the index of the root node and check whether the root value is smallest(in case of min heap else it should be largest) among its child nodes or not, If not we heapify the bineay heap by
	 * swapping the paren't node with one of its smallest children.
	 * We repeat the process until the whole binary heap gets heapify.
	 * 
	 * NOTE : Using top-down approach here
	 * */
	private static void minHeapify(int[] heap, int i) {
		/*left and right returns the indexes of left & right child of parent present at index i*/
		int min = i;     //parent=(i-1)/2;
		int left = 2*i+1;
		int right = 2*i+2;
		
		//If the left child exists and its value is less than parent then assign its value to min.
		if(left<size && heap[left]<heap[min]) 
			min=left;
		
		//If the right child exists and its value is less than parent then assign its value to min.
		if(right<size && heap[right]<heap[min])
			min=right;
		
		//If any of the child is smaller than parent then swap them with parent.
		if(i!=min){
			int temp=heap[i];
			heap[i]=heap[min];
			heap[min]=temp;
			
			//Recursively calling the heapify method until the full binary heap gets heapify.
			minHeapify(heap,min);
		}	
	}
}
