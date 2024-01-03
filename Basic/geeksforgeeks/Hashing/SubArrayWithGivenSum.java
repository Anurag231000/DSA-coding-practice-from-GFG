package Basic.geeksforgeeks.Hashing;

import java.util.HashSet;

public class SubArrayWithGivenSum {
	/*SubArray means contiguous elements.
	 * */
	public static void main(String[] args) {
		SubArrayWithGivenSum sa = new SubArrayWithGivenSum();
		//int[] arr ={5,8,6,13,3,-1}; //22
		//int[] arr ={15,2,8,10,-5,-8,6}; //3
		int[] arr ={3,2,5,6}; //10
		int sum=7,n=arr.length;
		System.out.println(sa.naive(arr,sum,n));
		System.out.println("****Efficient solution****");
		System.out.println(sa.eff(arr,sum,n));
	}
	
	/*T.C : O(n)
	 * A.S.C : O(n)
	 * 
	 * LOGIC : We are iterating through the array and at the same time summing the elements if the curr_sum
	 * is equal to the sum then we return true, or if the element exists in hash table that we get after 
	 * deducting the sum from curr_sum[curr_sum-sum] then we return true else we return false.
	 * */
	private boolean eff(int[] arr, int sum, int n) {
		HashSet<Integer> hash = new HashSet<>();
		int curr_sum=0;
		
		for(int i=0; i<n; i++){
			curr_sum+=arr[i];
			
			if(hash.contains(curr_sum-sum)) // This line is responsible to check in hash table whether element exist or not.
				return true;
			
			if(curr_sum == sum)
				return true;
			
			hash.add(curr_sum);
		}
		
		return false;
	}

	/*T.C : O(n2)
	 * A.S.C : O(1)
	 * 
	 *LOGIC : We check the sum of elements from 1st element till end of the array. If we find the sum as given value we return true, else we keep 
	 *on decreasing elements from beginning and consider the subArray from next element.
	 * */
	private boolean naive(int[] arr, int sum, int n) {
		
		for(int i=0; i<n; i++){
			int curr_sum=0;
			for(int j=i; j<n; j++){
				curr_sum+=arr[j];
				if(curr_sum == sum)
					return true;
			}
		}
		
		return false;
	}

}
