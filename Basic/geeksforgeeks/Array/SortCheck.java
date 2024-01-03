package Basic.geeksforgeeks.Array;

public class SortCheck {

	public static void main(String[] args) {
		SortCheck sc = new SortCheck();
		int[] arr = { 4, 20, 3, 15, 3, 28, 17 };
		int[] arr1 = { 7, 20, 30, 80 };
		System.out.println(sc.naive(arr1));
	}
	
	/*Time complexity : O(n)
	 * Auxiliary space complexity : O(1)
	 * 
	 * LOGIC : We just check for the consecutive elements. If the previous element is larger than the current one then the array is not sorted.
	 * */
	private boolean naive(int[] arr) {
		int len = arr.length;

		if (len <= 1)
			return false;

		if (len >= 2) {
			for (int i = 0; i < len - 1; i++) {
				// if(i+1<len){
				if (arr[i] > arr[i + 1])
					return false;
				// }
			}
		}
		return true;
	}

}
