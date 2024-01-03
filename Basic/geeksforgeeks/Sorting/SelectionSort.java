package Basic.geeksforgeeks.Sorting;

//NOTE : Not a stable algorithm
public class SelectionSort {

	public static void main(String[] args) {
		SelectionSort ss = new SelectionSort();
		int[] arr = {10,5,8,20,2,18}; 
		//ss.naive(arr);
		ss.little_eff(arr);
	}
	
	/*Time complexity : O(n^2)
	 * Auxiliary space complexity : O(1)
	 * 
	 * LOGIC : Here we are assuming the first element of an array is the smallest one and then comparing it with the remaining elements, if there is
	 * any other element which is smaller than the assumed one then we swap, if not we iterate till end. Now in the next iteration 2nd element will 
	 * be assumed as smallest and the cycle repeats.
	 * 
	 * Summary: Find the smallest element in an array and keep on putting them in beginning of an array. 
	 * */
	private void little_eff(int[] arr) {
		int len=arr.length,min_ind=0;
		
		for(int i=0; i<len-1; i++){
			boolean swapped=false;
			min_ind=i;
			for(int j=i; j<len; j++){
				if(arr[j]<arr[min_ind]){
					min_ind=j;
					swapped=true;
				}
					
			}
			if(swapped==true){
				int temp=arr[min_ind];
				arr[min_ind]=arr[i];
				arr[i]=temp;
			}
		}
		for(int i=0; i<len; i++){
			System.out.print(arr[i] + " ");
		}
		
	}

	/*Time complexity : O(n^2)
	 * Auxiliary space complexity : O(1)
	 * */
	private void naive(int[] arr) {
		int len=arr.length,index=0;
		
		for(int i=0; i<len-1; i++){
			boolean swapped=false;
			int smallest=arr[i];
			for(int j=i; j<len-1; j++){
				if(arr[j]<arr[j+1] && arr[j]<smallest){
					smallest=arr[j];
					index=j;
					swapped=true;
				}else if(arr[j+1]<arr[j] && arr[j+1]<smallest){
					smallest=arr[j+1];
					index=j+1;
					swapped=true;
				}
					
			}
			if(swapped==true){
				int temp=arr[index];
				arr[index]=arr[i];
				arr[i]=temp;
			}
		}
		
		for(int i=0; i<len; i++){
			System.out.print(arr[i] + " ");
		}
		
	}

}
