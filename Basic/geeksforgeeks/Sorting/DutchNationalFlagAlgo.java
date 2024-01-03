package Basic.geeksforgeeks.Sorting;


public class DutchNationalFlagAlgo {

	public static void main(String[] args) {
		DutchNationalFlagAlgo dnf = new DutchNationalFlagAlgo();
		int[] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		int n=arr.length,l=0,h=n-1;
		
		/* We are using this algorithm instead of quick sort because Quicksort exhibits poor 
		 * performance for inputs that contain many repeated elements. The problem is visible when 
		 * all the input elements are equal. Then at each point in recursion, the left partition 
		 * is empty (no input values are less than the pivot), and the right partition has only 
		 * decreased by one element (the pivot is removed). Consequently, the algorithm takes 
		 * quadratic time to sort an array of equal values.
		 * 
		 * Time Complexity : O(n)
		 * Auxiliary space complexity : Theta(1)
		 * */
		dnf.sort(arr,n);
		
		for(int i=0; i<n; i++)
			System.out.print(arr[i] + " ");
	}

	private void sort(int[] arr, int n) {
		int low=0,mid=0,high=n-1;
		
		while(mid<=high){
			if(arr[mid]<1){
				int temp=arr[low];
				arr[low]=arr[mid];
				arr[mid]=temp;
				low++;
				mid++;
			}else if(arr[mid]>1){
				int temp=arr[mid];
				arr[mid]=arr[high];
				arr[high]=temp;
				high--;
			}else{
				mid++;
			}
		}
	}

}
