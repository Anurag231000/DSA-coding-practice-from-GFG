package Basic.geeksforgeeks.Sorting;


import java.util.Random;

public class NaivePartition {

	public static void main(String[] args) {
		NaivePartition np = new NaivePartition();
		Random ram = new Random();
		
		int[] arr = {3,8,6,12,10,7};
		//int[] arr = {3,5,8,5};
		//int[] arr= {2,7,8,3,7};
		int p=1,len=arr.length;
		int part= ram.nextInt(len); // Use random fun to generate a random partition point in array. 
		System.out.print(np.naive(arr,p));
	}
	//Assuming all the elements are non-zero
	/*Time complexity : O(n)
	 * Auxiliary space complexity : O(n)
	 * 
	 * It's a stable algo
	 * LOGIC : We consider any 1 element from any array as pivot. And then we create two new arrays arr1 && arr2. The
	 * elements smaller than pivot element goes to the 1st array and the remaining elements goes to the 2nd array.
	 * So ones the rearranging of elements around pivot gets completed we return the new index(location) of the pivot
	 * element.
	 * */
	private int naive(int[] arr, int p){
		int left[] = new int[arr.length-1];
		int right[] = new int[arr.length-1];
		int li=0,ri=0,element=arr[p],index=0,j=0;
		for(int i=0; i<arr.length; i++){
			if(arr[i]<element){
				left[li]=arr[i];
				li++;
			}
			else{
				right[ri]=arr[i];
				ri++;
			}
		}
		for(int k=0; k<arr.length; k++){
			if(k<arr.length-1 && left[k]!=0){
				arr[k]=left[k];
				if(arr[k]==element)
					index=k;
			}
			else{
				arr[k]=right[j];
				j++;
				if(arr[k]==element)
					index=k;
			}
		}
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.print("\n");
		return index;
	}
}
