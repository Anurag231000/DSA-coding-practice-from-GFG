package Basic.geeksforgeeks.Hashing;

import java.util.Arrays;
import java.util.HashSet;

public class distinctElementsCount {

	public static void main(String[] args) {
		distinctElementsCount dec = new distinctElementsCount();
		int[] arr={15,12,13,12,13,13,18}; //op:4
		//int[] arr={10,10,10,10,10}; //op:1
		//int[] arr={10,11,12}; //op:3
		int n=arr.length-1;
		System.out.println(dec.naive(arr,n));
		System.out.println("***GFG Naive Solution***");
		System.out.println(dec.gfg_naive(arr,n));
		System.out.println("***GFG Efficient Solution***");
		System.out.println(dec.eff(arr,n));
		System.out.println("***GFG Efficient Collection Framework Solution***");
		System.out.println(dec.eff_collection(arr));
	}
	
	/*T.C : Theta(n)
	 * A.S.C : O(n)
	 * 
	 * LOGIC : Arrays.asList(obj) method allows the array to be converted into ArrayList and it does this
	 * in place, it means that it doesn't allocate new memory for array items. It creates the arraylist on
	 * top of the existing array only.
	 */
	private int eff_collection(int[] arr) {
		HashSet<int[]> hs = new HashSet<>(Arrays.asList(arr)); 
		return hs.size();
	}

	/*T.C : O(n)
	 * A.S.C : O(n)
	 * 
	 * LOGIC : We are using HashSet here as we know that HashSet implements Set interface which does not
	 * allow duplicate elements, therefore the size of hashSet returns the count of distinct elements.
	 * */
	private int eff(int[] arr, int n) {
		HashSet<Integer> hs = new HashSet<>();
		
		for(int i=0; i<=n; i++)
			hs.add(arr[i]);
		
		return hs.size();
	}

	/*T.C : O(n2)
	 * A.S.C : O(1)
	 * 
	 * LOGIC : we are comparing and checking for each element whether it already exist in its left side
	 * or not, if not then we increase res else we break the inner loop and move to the next element from
	 * outer loop.
	 * */
	private int gfg_naive(int[] arr, int n) {
		int res=0;
		for(int i=0; i<=n; i++){
			boolean flag=false;
			for(int j=0; j<i; j++){
				if(arr[j]==arr[i]){
					flag=true;
					break;
				}
			}
			if(flag==false)
				res++;
		}
		return res;
	}

	/*T.C : O(nlogn)+O(n) = O(nlogn)
	 * A.S.C : O(1) 
	 * 
	 * LOGIC : We first sort the array and then we get the distinct elements. After the elements gets sorted we then compare the consecutive elements
	 * if the elements don't match we then increase the count by 1.
	 * */
	private int naive(int[] arr, int n) {
		int count=0,l=0;
		
		quick_sort(arr,l,n);
//		for(int i=0; i<=n; i++)
//			System.out.print(arr[i]+" ");
		
		//int res=1;
		for(int i=1; i<=n; i++){
			if(arr[i]!=arr[i-1])
				count++;
		}
		return count+1;
	}

	private void quick_sort(int[] arr, int l, int h) {
		if(l<h){
			int p=hoares_partition(arr,l,h);
			quick_sort(arr,l,p);
			quick_sort(arr,p+1,h);
		}
	}

	private int hoares_partition(int[] arr, int l, int h) {
		int i=l-1,j=h+1,pivot=arr[l];
		
		while(true){
		do{
			i++;
		}while(arr[i]<pivot);
		
		do{
			j--;
		}while(arr[j]>pivot);
		
		if(i>=j)
			return j;
		
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		}
		
		//return 0;
	}

}
