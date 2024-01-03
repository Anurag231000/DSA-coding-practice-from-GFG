package Basic.geeksforgeeks.Array;

public class MoveZeroToEnd {

	public static void main(String[] args) {
		MoveZeroToEnd mzt = new MoveZeroToEnd();
		int[] arr = { 8, 5, 0, 10, 0, 20 };
		int n = arr.length;
		// mzt.naive(arr,n);
		// mzt.eff(arr,n);
		mzt.eff1(arr, n);
	}

	/*
	 * Time Complexity : Theta(n) 
	 * Auxiliary Space Complexity : Theta(1)
	 */
	private void eff1(int[] arr, int n) {
		int index = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] != 0) {
				int temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
				index++;
			}
		}
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}
	
	/*
	 * Time Complexity : Theta(n) 
	 * Auxiliary Space complexity : Theta(n)
	 */
	private void eff(int[] arr, int n) {
		int[] arr1 = new int[n];
		int index = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] != 0) {
				arr1[index] = arr[i];
				index++;
			}
		}

		for (int i = 0; i < n; i++)
			System.out.print(arr1[i] + " ");
	}

	/*
	 * Time Complexity : Theta(n2) Auxiliary Space : Theta(1)
	 */
	private void naive(int[] arr, int n) {
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				for (int j = i; j < n; j++) {
					if (arr[j] != 0) {
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
						break;
					}
				}
			}

		}
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}
}
