package Basic.geeksforgeeks.Array;

public class prefixSum {

	public static void main(String[] args) {
		prefixSum ps = new prefixSum();
		
		int[] arr = {10, 20, 10, 5, 15};
		int[] prefixArr = new int[arr.length];
		
		ps.prefix_sum(arr,prefixArr);
		
		for(int i=0; i<prefixArr.length; i++)
			System.out.print(prefixArr[i]+" ");
	}
	
	/*T.C : O(n)
	 *A.S.C : O(n)
	 *
	 *LOGIC : We first store the first's array value into newly created array and then run the loop from i=1 to till end, in the
	 *loop we will be adding the previous element to the current element.
	 * */
	private void prefix_sum(int[] arr, int[] prefixArr) {
		prefixArr[0]=arr[0];
		
		for(int i=1; i<arr.length; i++){
			prefixArr[i]=prefixArr[i-1]+arr[i];
		}
	}

}
