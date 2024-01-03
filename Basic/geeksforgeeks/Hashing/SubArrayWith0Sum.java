package Basic.geeksforgeeks.Hashing;

import java.util.HashSet;

public class SubArrayWith0Sum {
	/*SubArray means contiguous elements.
	 * */
	public static void main(String[] args) {
		SubArrayWith0Sum sa = new SubArrayWith0Sum();
		
		int[] arr = {1,4,13,-3,-10,5};
		int n = arr.length;
		System.out.println(sa.naive_sol(arr,n));
		System.out.println("****Efficient solution****");
		System.out.println(sa.eff_sol(arr,n));
	}
	
	/*T.C : O(n)
	 * A.S.C : O(n)
	 * 
	 * LOGIC : We are iterating over the array and computing the prefix sum of it one by one. If we find the 
	 * prefix sum already present in the hastSet[hash table] it means that the subarray with zero is already
	 * present and we return true, else we check if the prefix sum is 0 or not and if not we insert it into the
	 * hash table.
	 * 
	 * NOTE : For e.g the elements in hash table for input {1,4,13,-3,-10,5} will be {1,5,18,15,5,10}. The logic is
	 * if there is a duplicate element then the array is having sub array of 0. The subarray starts from next of 1st 
	 * Occurrence of duplicate element and till the repeated element. Here the subarray will be {18,15,5}.
	 * 
	 * The above NOTE logic doesn't handle one of the -ve test case if the prefix sum is zero. We need to handle this
	 * explicitly.
	 * */
	private boolean eff_sol(int[] arr, int n) {
		
		HashSet<Integer> hash = new HashSet<>();
		int prefix_sum=0;
		
		for(int i=0; i<n; i++){
			prefix_sum+=arr[i];
			
			if(hash.contains(prefix_sum)) // OR if(hash.contains(prefix_sum-0))
				return true;
			
			if(prefix_sum==0)
				return true;
			
			hash.add(prefix_sum);
		}
		return false;
	}
	
	/*T.C : O(n2)
	 * A.S.C : O(1)
	 * 
	 * LOGIC : We check the sum of elements from 1st element till end of the array. If we find the sum as zero we return true else we keep on decreasing
	 * elements from beginning and consider the subArray from next element.
	 * */
	private boolean naive_sol(int[] arr, int n) {
		
		for(int i=0; i<n; i++){
			int sum=0;
			for(int j=i; j<n; j++){
				sum+=arr[j];
				if(sum==0)
					return true;
			}
		}
		
		return false;
	}

}
