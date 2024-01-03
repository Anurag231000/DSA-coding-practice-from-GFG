package Basic.geeksforgeeks.Hashing;

import java.util.HashMap;
import java.util.Hashtable;

public class longestSubArrayWithEqualNrOf0sand1s {
	/*SubArray means contiguous elements.
	 * */
	public static void main(String[] args) {
		longestSubArrayWithEqualNrOf0sand1s lsa = new longestSubArrayWithEqualNrOf0sand1s();
		//int arr[] = {1,0,1,1,1,0,0}; //op:6 {1,1,2,3,4,4,4} {1,-1,1,1,1,-1,-1} {1,0,1,2,3,2,1}
		//int arr[] = {1,1,1,1}; //op:0     {1,2,3,4}
		int arr[] = {0,0,1,1,1,1,1,0}; //op:4 {0,0,1,2,3,4,5,5}
		int n=arr.length;
		System.out.println(lsa.naive(arr,n));
		System.out.println("****Efficient solution****");
		System.out.println(lsa.eff(arr,n));
		System.out.println("****GFG Efficient solution****");
		System.out.println(lsa.gfg_eff(arr,n));
	}
	
	/*T.C : O(n)
	 * A.S.C : O(n)
	 * 
	 * LOGIC : We calculate the prefix sum by adding the contiguous elements, if the prefix sum does not exist in hasTable then insert into it, else
	 * we calculate the length by getting the (current index - index of from the hasTable for the prefix_sum).
	 * */
	private int gfg_eff(int[] arr, int n) {
		int prefix_sum=0,sum=0,len=0;
		Hashtable<Integer,Integer> ht = new Hashtable<>();
		
		for(int j=0; j<n; j++){
			if(arr[j]==0)
				arr[j]=-1;
		}
		
		for(int i=0; i<n; i++){
			prefix_sum+=arr[i];
			//int val=prefix_sum-sum;
			
			if(prefix_sum==sum) //This is the corner case when the sub-array starts from index 0 itself
				len=i+1;
			
			if(ht.containsKey(prefix_sum)){
				len=Math.max(len,(i-ht.get(prefix_sum)));
			}
			
			if(!ht.containsKey(prefix_sum)) //If the key doesn't exist in hash map then insert it.
				ht.put(prefix_sum,i);
		}
		if(len==0)
			return 0;
		
		return len;
	}

	/*T.C : O(n)
	 * A.S.C : O(n)
	 * 
	 * LOGIC : Get the count of maximum number of repeated elements and then multiply it by 2.
	 * */
	private int eff(int[] arr, int n) {
		int len=0,prefix_sum=0,count=0;
		HashMap<Integer,Integer> ht = new HashMap<>();
		for(int i=0; i<n; i++){
			prefix_sum+=arr[i];
			
			if(ht.containsKey(prefix_sum)){
				len++;
				count=len;
			}else{
				//count=len;
				len=0;
				count=Math.max(len, count);
			}
			
			if(!ht.containsKey(prefix_sum))
				ht.put(prefix_sum, i);
		}
		
		if(count==0)
			return 0;
		
		return (count+1)*2;
	}

	/*T.C : O(n2)
	 * A.S.C : O(1)
	 * 
	 * LOGIC : We start from 1st element till end of the array. If we get the contiguous nr of 0s and 1s same then we calculate the subArray
	 * length, else we start from the next element and we repeat it until we get the subArray length or reach the end of the array from outer loop.
	 * */
	private int naive(int[] arr, int n) {
		int len=0;
		for(int i=0; i<n; i++){
			int c0=0,c1=0;
			for(int j=i; j<n; j++){
				
				if(arr[j]==0)
					c0++;
				else
					c1++;
				
				if(c0==c1) 
					len=Math.max(len, j-i+1); //To get the subArray length.
			}
		}
		return len;
	}

}
