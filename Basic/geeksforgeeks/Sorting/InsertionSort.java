package Basic.geeksforgeeks.Sorting;

//NOTE : Stable algorithm
public class InsertionSort {

	public static void main(String[] args) {
		InsertionSort is = new InsertionSort();
		int arr[] = {10,5,8,20,2,18};
		is.naive(arr);
	}
	/*Time Complexity : O(n^2)
	 * Auxiliary space complexity : O(1)
	 * 
	 * LOGIC : Compare the first element with the other elements if there is any other element found smaller than the first element, than the elements
	 * before smallest one gets shifted to right side and then the smallest element gets inserted at its correct position.
	 * The cycle keeps on going for each element till the array gets sorted.
	 * */
	private void naive(int[] arr) {
		int len=arr.length;
		
		for(int i=1; i<len; i++){
			int temp=arr[i];
			int j=i-1;
			//If written like this arr[j]>=temp there will be no stability because then already sorted 
			//element will also gets shifted.
			while(j>=0 && arr[j]>temp){
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=temp;
		}
		for(int i=0; i<len; i++)
			System.out.print(arr[i] + " ");
	}

}
