package Basic.geeksforgeeks.Array;
/*NOTE : To get the sum of sub array of size k from array.
 * */
public class slidingWindow {

	public static void main(String[] args) {
		slidingWindow sw = new slidingWindow();
		
		int[] arr = {1, 4, 2, 10, 23, 3, 1, 0, 20};
		int k=1;
		System.out.println(sw.naive(arr,k));
		System.out.println(sw.sliding_window(arr,k));
	}
	
	/*T.C : O(n)
	 *A.S.C : O(1)
	 *
	 *LOGIC : We are first storing the sum of first till kth indexes values and then traversing the array step by step and removing the
	 *previous elements from the window of size k.
	 *
	 *To simplify it runs like a caterpillar, moving forward and retracting its rear.
	 * */
	private int sliding_window(int[] arr, int k) {
		if(k>arr.length || k<=0)
			return Integer.MIN_VALUE;
		
		int max_sum=0;
		for(int i=0; i<k; i++)
			max_sum+=arr[i];
		
		int sum=max_sum;
		for(int i=k; i<arr.length; i++){	
			sum+=arr[i]-arr[i-k];
			max_sum=Math.max(sum, max_sum);
		}
		
		return max_sum;
	}

	/*T.C : O(n2)
	 *A.S.C : O(1)
	 * */
	private int naive(int[] arr, int k) {
		if(k>arr.length || k<=0)
			return Integer.MIN_VALUE;
		
		int max_sum=0;
		for(int i=0; i<arr.length; i++){
			int sum=0;
			if(i+k<=arr.length){
				for(int j=0; j<k; j++){
					sum+=arr[j+i];
				}
			}
			if(sum>max_sum)
				max_sum=sum;
		}
		
		return max_sum;
	}

}
