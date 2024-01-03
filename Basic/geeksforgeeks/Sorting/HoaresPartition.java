package Basic.geeksforgeeks.Sorting;

//NOTE :  Not Stable
public class HoaresPartition {

	public static void main(String[] args) {
		HoaresPartition hp = new HoaresPartition();
//		int[] arr = {10,5,8,20,2,18};
		int[] arr = {5,3,8,4,2,7,1,10};
//		int[] arr = {5,10,9,12};
//		int[] arr = {12,10,5,9};
//		int[] arr = {5,5,5,5};
		int pivot=arr[0];
		hp.naive(arr,pivot);
	}
	/*/*Time complexity : O(nlog(n)), but in worst case it is O(n2)
	 * Auxiliary space complexity : O(1)
	 * 
	 * LOGIC : Here the traverse of an array is done from both the ends. we consider the 1st element as pivot element.
	 * From left we will iterate the array till we encounter an element which is greater than pivot element. 
	 * From right we will iterate the array till we encounter an element which is smaller than pivot element. 
	 * 
	 * When both the above while loops ends then we will swap both the small and larger element.
	 * 
	 * We will do the above steps till the we complete the iteration of whole array.
	 */
	private void naive(int[] arr, int pivot) {
		int len=arr.length-1,i=0,low=i-1,high=len+1;
		
		while(true){
			do{
				low++;
			}while(low<len && arr[low]<pivot);
			
			do{
				high--;
			}while(high>-1 && arr[high]>pivot);
			
			//Below logic means we have iterated the whole array and we are breaking the loop to top the process.
			if(low>=high)
				break;
			
			int temp=arr[low];
			arr[low]=arr[high];
			arr[high]=temp;
		}
		
		for(int k=0; k<len; k++)
			System.out.print(arr[k] + " ");
	}

}
