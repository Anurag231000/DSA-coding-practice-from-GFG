package Basic.geeksforgeeks.Sorting;


public class QuickSort_Hoares {

	public static void main(String[] args) {
		QuickSort_Hoares qsh = new QuickSort_Hoares();
//		int[] arr = {8,4,7,9,3,10,5};
		int[] arr = {0,1,2,1,1,2};
		int l=0,h=arr.length-1;
		qsh.qsort(arr,l,h);
		
		//Printint the sorted array
		for(int i=0; i<=h; i++)
			System.out.print(arr[i] + " ");
	}
	/*Time complexity : O(nlog(n)), but in worst case it is O(n2)
	 * Auxiliary space complexity : O(1)
	 * 
	 * LOGIC : Here the traverse of an array is done from both the ends. we consider the 1st element as pivot element.
	 * From left we will iterate the array till we encounter an element which is greater than pivot element. 
	 * From right we will iterate the array till we encounter an element which is smaller than pivot element. 
	 * 
	 * When both the above while loops ends then we will swap both the small and larger element.
	 * 
	 * We will do the above steps till the we complete the iteration of whole array.
	 * 
	 * Because we are using recursion there will be a time when the pivot index will be returned when there is only 2
	 * elements. There both these 2 elements gets sorted, similar way the process will be done till all the elements
	 * gets sorted.
	 * */
	private void qsort(int[] arr, int l, int h) {
		if(l<h){
			int p = partition(arr,l,h);
			qsort(arr,l,p);
			qsort(arr,p+1,h);
		}
	}

	private int partition(int[] arr, int l, int h) {
		int pivot=arr[l],i=l-1,j=h+1;
		
		while(true){
			do{
				i++;
			}while(arr[i]<pivot);
			
			do{
				j--;
			}while(arr[j]>pivot);
			
			if(i>=j)
				return j;
			
			int temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
		}
	}

}
