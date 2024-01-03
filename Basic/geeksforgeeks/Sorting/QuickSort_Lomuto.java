package Basic.geeksforgeeks.Sorting;


public class QuickSort_Lomuto {

	public static void main(String[] args) {
		QuickSort_Lomuto qsl = new QuickSort_Lomuto();
//		int[] arr = {8,4,7,9,3,10,5};
//		int[] arr = {20,20,10,20};
		int[] arr = {0,1,2,1,1,2};
		int l=0, h=arr.length-1;
		qsl.qsort(arr,l,h);
		
		//Printing the sorted array
		for(int i=0; i<=h; i++)
			System.out.print(arr[i]+" ");
	}
	/*Time complexity : O(nlog(n)), but in worst case it is O(n2)
	 * Auxiliary space complexity : O(1)
	 * 
	 * LOGIC : We consider the last element of an array as a pivot element. We iterate through the array and swap all the 
	 * elements smaller than pivot element one-by-one, Once swapping is done one last swap will be done where pivot element
	 * will be swapped with the just immediate after element once the for loop ends.
	 * In the end we return new index(location) of the pivot element.
	 * 
	 * Because we are using recursion there will be a time when the pivot index will be returned when there is only 2
	 * elements. There both these 2 elements gets sorted, similar way the process will be done till all the elements
	 * gets sorted.
	 * */
	private void qsort(int[] arr, int l, int h) {
		
		if(l<h){
			int p = partition(arr,l,h);
			qsort(arr,l,p-1);
			qsort(arr,p+1,h);
		}
		
	}

	private int partition(int[] arr, int l, int h) {
		int pivot=arr[h],k=l-1;
		
		for(int i=l; i<h; i++){
			if(arr[i]<pivot){
				k++;
				int temp=arr[i];
				arr[i]=arr[k];
				arr[k]=temp;
			}
		}
		int temp=arr[k+1];
		arr[k+1]=arr[h];
		arr[h]=temp;
		
		return k+1;
	}

}
