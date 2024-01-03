package Basic.geeksforgeeks.Array;


public class SecondLargest {

	public static void main(String[] args) {
		SecondLargest sl = new SecondLargest();
		// int[] arr = {4,20,15,3,28,17};
		int[] arr = { 10, 10, 10 };
		// int[] arr = {20,10,20,8,12};
		// sl.naive(arr);
		sl.eff(arr);

	}
	
	/*Time complexity : O(n)
	 * Auxiliary space complexity : O(1)
	 * 
	 * LOGIC : In a single iteration we are going to keep track of largest element and second largest element, so that we can find the second 
	 * largest element.
	 * */
	private void eff(int[] arr) {
		int largest = 0, Slargest = 0, index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > largest)
				largest = arr[i];

			if (arr[i] < largest && Slargest > arr[i]) {
				Slargest = arr[i];
				index = i;
			}
		}
		if (Slargest == 0)
			System.out.println("There is no second largest number");

		System.out.println("Largest : " + largest + " Slargest : " + Slargest
				+ " index : " + index);
	}
	
	/*Time Complexity : O(n)+O(n)=O(n)
	 * Auxiliary space complexity : O(1)
	 * 
	 * LOGIC : 1. First we find the largest element from an array.
	 * 		   2. Second we store the largest element in a variable to keep track of it.
	 * 		   3. Now we iterate through the array one more time to find the second largest element.
	 * */
	private void naive(int[] arr) {
		int largest = arr[0], Slargest = 0, index = 0;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > largest)
				largest = arr[i];
		}
		System.out.println("Largest : " + largest);
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] > Slargest && Slargest < largest) {
				if (arr[j] == largest)
					continue;
				Slargest = arr[j];
				index = j;
			}
		}
		if (Slargest == 0)
			System.out.println("there is no second largest number");

		System.out.println("largest : " + largest + " second largest : "
				+ Slargest);
		int min = Math.min(largest, Slargest);
		System.out.println(min + " " + index);
	}

}
