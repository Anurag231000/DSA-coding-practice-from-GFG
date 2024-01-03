package Basic.geeksforgeeks.Array;

public class ReverseArray {

	public static void main(String[] args) {
		ReverseArray ra = new ReverseArray();
		// int arr[] = {20,10,20,8,12};
		int arr[] = { 10, 5, 7, 30, 25 };
		ra.naive(arr);
	}
	
	/*Time complexity : Theta(n)
	 * Auxiliary space complexity : O(1)
	 * 
	 * LOGIC : Iterating from both ends and swapping until we reach the middle.
	 * */
	private void naive(int[] arr) {
		int low = 0, high = arr.length - 1;

		while (low < high) {
			int temp = arr[low];
			arr[low] = arr[high];
			arr[high] = temp;
			low++;
			high--;
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
