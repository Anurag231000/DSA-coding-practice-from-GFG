package Basic.geeksforgeeks.Hashing;

import java.util.*;

public class ArrayElementFrequencies {

	public static void main(String[] args) {
		ArrayElementFrequencies aef = new ArrayElementFrequencies();
		int[] arr={10,12,10,15,10,20,12,12};
		//int[] arr ={10,10,10,10};
		///int[] arr={10,20};
		aef.naive(arr);
		System.out.println("***Efficient solution***");
		aef.eff(arr);
	}
	
	/*T.C : Theta(n)
	 *A.S.C : O(n)
	 *
	 *LOGIC : We store the elements as key and their occurrences as value.
	 *
	 *NOTE : If we want to print the elements's frequencies in an order then we need to use the LinkedHashMap.
	 */
	private void eff(int[] arr) {
		HashMap<Integer,Integer> hm = new HashMap<>();
		for(int i=0; i<arr.length; i++){
			
			if(hm.containsKey(arr[i])){
				hm.put(	arr[i],hm.getOrDefault(arr[i],0)+1); //hm.getOrDefault method gets the value of the specified key. only works with java 1.8 or above.
			}else
				hm.put(arr[i],1); 
		}
		
		for(Map.Entry<Integer,Integer> e : hm.entrySet()){ //hm.entrySet() method returns the key value pair stored in HashMap.
			System.out.println(e.getKey()+" "+e.getValue());
		}
	}

	/*T.C : O(n)*(O(n)+O(n)) = O(n2)
	 *A.S.C : O(1)
	 * 
	 * LOGIC : For every element in an array we first try to find the element in left array, if we find it it means that we have already computed for that element
	 * and we no need to compute it again that's why we skip the current iteration. 
	 * We do the above step until we reach the end of the array.
	 * */
	private void naive(int[] arr) {
		for(int i=0; i<arr.length; i++){
			int count=0;
			boolean flag=false;
			
			for(int k=i-1; k>=0; k--){
				if(arr[i]==arr[k]){
					flag=true;
					break;
				}
			}
			
			if(flag==true)
				continue;
			
			for(int j=0; j<arr.length; j++){
				if(arr[i]==arr[j])
					count++;
			}
			
			System.out.println(count);
		}
		
	}

}
