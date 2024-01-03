package Basic.geeksforgeeks.Sorting;


public class MergeSort {

	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		int[] arr = {10,5,8,20,2,18};
		int l=0,r=arr.length-1;
		ms.recursive(arr,l,r);
		ms.print(arr);
	}
	
	/*Time Complexity : O(nlog(n))
	 * Auxiliary space complexity : O(n)
	 * 
	 * LOGIC : Here the array gets divided into 2 arrays from their midpoint and then while merging we sort the elements
	 * and then in the end we merge them.
	 * */
	private void recursive(int[] arr, int l, int r) {
		
		if(l<r){
			int mid=l+(r-l)/2; 		//To reduce the overhead we are not using (l+r)/2
			recursive(arr,l,mid);
			recursive(arr,mid+1,r);
			merge(arr,l,r,mid);
		}	
	}

	private void print(int[] arr) {
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		
	}

	private int[] merge(int[] arr, int l, int r, int mid) {
		int n1=mid-l+1,n2=r-mid;
		
		int[] left = new int[n1];
		int[] right = new int[n2];
		
		for(int i=0; i<n1; i++)
			left[i]=arr[l+i];
		
		for(int j=0; j<n2; j++)
			right[j]=arr[mid+j+1];
		
		int i=0,j=0,k=l;
		/*Below while loop runs till one of the array elements gets iterated fully.
		 * */
		while(i<n1 && j<n2){
			if(left[i]<=right[j]){	//In order to get the stability we need to put <= .
				arr[k]=left[i];
				i++;
			}
			else{
				arr[k]=right[j];
				j++;
			}
			k++;
		}
		
		/*Below while loop is used in order to get the remaining elements from arr1 in combined array.
		 * */
		while(i<n1){
			arr[k]=left[i];
			i++;
			k++;
		}
		
		/*Below while loop is used in order to get the remaining elements from arr2 in combined array.
		 * */
		while(j<n2){
			arr[k]=right[j];
			j++;
			k++;
		}
		
		return arr;
	}	

}
