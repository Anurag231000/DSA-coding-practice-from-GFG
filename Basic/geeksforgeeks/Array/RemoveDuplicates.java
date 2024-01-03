package Basic.geeksforgeeks.Array;
//NOTE : Removing duplicates from sorted array.
public class RemoveDuplicates {

	public static void main(String[] args) {
		RemoveDuplicates rd = new RemoveDuplicates();
		int[] arr = { 10, 20, 20, 30, 30, 30, 30 };
		// rd.naive(arr);
		rd.eff(arr);
	}
	
	/*Time Complexity : Theta(n)
	 * Auxiliary space complexity : O(1)
	 * 
	 * LOGIC : We are storing only the unique elements in an array.
	 * */
	private void eff(int[] arr) {
		int res = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != arr[res - 1]) {
				arr[res] = arr[i];
				res++;
			}
		}
		//Below code making the remaining duplicates as 0.
		for(int i=res; i<arr.length; i++){
			arr[i]=0;
		}

		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j] + " ");
		}
	}
	
	/*Time Complexity : Theta(n)
	 * Auxiliary space complexity : O(n)
	 * 
	 * LOGIC : We are storing the unique elements in a different array.
	 * */
	private void naive(int[] arr) {
		int[] arr1 = new int[arr.length];
		arr1[0] = arr[0];
		int res = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr1[res - 1] != arr[i]) {
				arr1[res] = arr[i];
				res++;
			}
		}

		for (int i = 0; i < res; i++) {
			System.out.print(arr1[i] + " ");
		}
	}

}
