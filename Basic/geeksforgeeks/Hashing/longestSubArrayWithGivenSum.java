package Basic.geeksforgeeks.Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

public class longestSubArrayWithGivenSum {
	/*SubArray means contiguous elements.
	 * */
	public static void main(String[] args) {
		longestSubArrayWithGivenSum ls = new longestSubArrayWithGivenSum();
		int[] arr ={5,8,-4,-4,9,-2,2}; //sum=0 op: 3 {5,13,9,5,14,12,14}
 		//int[] arr ={3,1,0,1,8,2,3,6}; //sum=5 op:4 {3,4,4,5,13,15,18,24}
		//int[] arr ={8,3,7}; //sum=15 op:0 {8,11,18}
		//int[] arr ={8,3,1,5,-6,6,2,2}; //sum=4 op:4 {8,11,12,17,11,17,19,21}
		int sum=0,n=arr.length;
		
		System.out.println(ls.naive(arr,n,sum));
		System.out.println("****Efficient solution****");
		System.out.println(ls.eff(arr,n,sum));
	}
	
	/*T.C : O(n)
	 * A.S.C : O(n)
	 *  
	 * LOGIC : We store the key value pair for every element in hash table then we check at the same time in 
	 * hash table whether value of pre_sum-sum exists or not, if it exists we get the index from which we get the
	 * value and the index of value.
	 * The computed size would be := index from which we got the value(i)-index of value.
	 * */
	private int eff(int[] arr, int n, int sum) {
		int len=0,pre_sum=0;
		HashMap<Integer,Integer> hs = new HashMap<>();
		
		for(int i=0; i<n; i++){
			pre_sum+=arr[i];
			int val=pre_sum-sum;
			
			if(pre_sum==sum) //This is the corner case when the sub-array starts from index 0 itself
				return i+1;
			
			if(!hs.containsKey(pre_sum)) //If the key doesn't exist in hash map then insert it.
				hs.put(pre_sum,i);
			
			if(hs.containsKey(val)){
				len=Math.max(len,(i-hs.get(val)));
			}
		}
		return len;
	}

	/*T.C : O(n2)
	 * A.S.C : O(1)
	 * 
	 * LOGIC : We are just iterating through the array and keep check if s(prefix sum) does already exist in
	 * an array or not and at the same time we keep track of length of each s(prefix sum), if it does we store
	 * the length, and we keep on doing the above steps until we reach the end of an array.
	 * Finally return the largest length.
	 * */
	private int naive(int[] arr, int n, int sum) {
		int len=0;
		for(int i=0; i<n; i++){
			int s=0,l=0;
			for(int j=i; j<n; j++){
				s+=arr[j];
				l++;
				
				if(s==sum && len<=l){
					len=l;
				}
			}
		}
		return len;
	}

}
