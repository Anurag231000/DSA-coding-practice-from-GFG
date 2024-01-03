package Basic.geeksforgeeks.Array;

public class LargestNumber {

	public static void main(String[] args) {

		LargestNumber ln = new LargestNumber();
		int[] arr = { 4, 20, 3, 15, 3, 28, 17 };
		ln.naive(arr);
	}

	private void naive(int[] arr) {
		int len = arr.length;

		int largest = arr[0];
		int index = 0;

		for (int i = 1; i < len; i++) {
			if (arr[i] > largest) {
				largest = arr[i];
				index = i;
			}
		}
		System.out.println(index + " " + largest);
	}

}
