package Basic.geeksforgeeks.Sorting;


import java.util.*;
//NOTE : Not Stable
public class LomutoPartition {

	public static void main(String[] args) {
		LomutoPartition lp = new LomutoPartition();
//		int[] arr = {10,80,30,90,40,50,70};
//		int[] arr = {70,60,80,40,30};
		int[] arr = {30,40,20,50,80};
		int pivot=arr[arr.length-1];
		lp.Lomuto_partition(arr,pivot);
	}
	/*T.C : O(nlog(n))
	 * A.S.C : O(1)
	 * 
	 * LOGIC : We consider the last element of an array as a pivot element. We iterate through the array and swap all the 
	 * elements smaller than pivot element one-by-one, Once swapping is done one last swap will be done where pivot element
	 * will be swapped with the just immediate after element once the for loop ends.
	 * In the end we return new index(location) of the pivot element.
	 * */
	private void Lomuto_partition(int[] arr, int pivot) {
		int low=0,k=low-1,high=arr.length-1;
		
		for(int i=low; i<arr.length-1; i++){
			if(arr[i]<pivot){
				k++;
				int temp=arr[k];
				arr[k]=arr[i];
				arr[i]=temp;
			}
		}
		System.out.println(k);
		//shifting the elements to left
//		if(k==-1){
//			for(int i=arr.length-1; i>0; i--)
//				arr[i]=arr[i-1];
//		}else{
//		for(int i=arr.length-1; i>k; i--)
//			arr[i]=arr[i-1];
//		}
//		arr[k+1]=pivot;
		
		//Without shifting : by swapping
		int temp=arr[high];
		arr[high]=arr[k+1];
		arr[k+1]=temp;
		
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
	}

}
