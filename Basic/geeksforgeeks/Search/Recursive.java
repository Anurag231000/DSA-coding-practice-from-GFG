package Basic.geeksforgeeks.Search;

public class Recursive {

	public static void main(String[] args) {
		Recursive r = new Recursive();
		int arr[]={10,20,30,40,50,60};
		//int[] arr={10,10};
		int element=20,low=0,high=arr.length-1;
		System.out.println(r.naive(arr,low,high,element));
	}

	/*Time complexity : O(log(n))
	 * Auxiliary space complexity : O(n+1)
	 * 
	 * NOTE : Below method uses the binary search concept.
	 * 
	 * LOGIC : If the element is equal to the mid element of an array then we return true, else if the element is larger than the mid element than
	 * we search in the right half else we search in the left half. 
	 * We repeat the above process until we find the element or traverse the whole half array. 
	 * */
	private int naive(int[] arr, int low, int high, int element) {
		if(low>high)
			return -1;
		
		int mid=(low+high)/2;
		
		if(arr[mid]==element)
			return mid;
		
		if(arr[mid]>element)
			return naive(arr,low,mid-1,element);
		
		if(arr[mid]<element)
			return naive(arr,mid+1,high,element);
			
		return -1;
	}

}
