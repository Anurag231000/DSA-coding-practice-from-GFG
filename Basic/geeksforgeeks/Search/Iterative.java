package Basic.geeksforgeeks.Search;

public class Iterative {

	public static void main(String[] args) {
		Iterative it = new Iterative();
		int[] arr = {10,20,30,40,50,60};
		//int[] arr = {10,10};
		int size=arr.length;
		int element=50;
		//System.out.print(it.naive(arr,size,element));
		System.out.print(it.naive_sorted_search(arr,size,element));
		
	}
	/*Time complexity : O(log(n))
	 * Auxiliary space complexity : O(1)
	 * 
	 * NOTE : Below method the binary search concept for which sorted array is required.
	 * 
	 * LOGIC : If the element is equal to the mid element of an array then we return true, else if the element is larger than the mid element than
	 * we search in the right half else we search in the left half. 
	 * We repeat the above process until we find the element or traverse the whole half array. 
	 * */
	private int naive_sorted_search(int[] arr, int size, int element) {
		int low=0, high=size-1;
		while(low<=high){
			int mid=(low+high)/2;
			
			if(arr[mid]==element)
				return mid;
			
			if(arr[mid]>element)
				high=mid-1;
			else
				low=mid+1;
		}
			
		return -1;
	}
	/*Time complexity = O(n)
	 * Auxiliary space complexity = Theta(1)
	 * NOTE : Array does not need to be sorted.
	 * 
	 * LOGIC : We compare each element with the given value till the end of an array.
	 * */
	private int naive(int[] arr, int size, int element) {
		for(int i=0; i<size; i++){
			if(arr[i] == element)
				return i;
		}
		return -1;
	}
	

}
