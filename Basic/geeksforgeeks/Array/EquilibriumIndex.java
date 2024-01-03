package Basic.geeksforgeeks.Array;
/*NOTE : Return the index such that, element's value before index = element's value after index.
 * For e.g if the index is i arr[0]+arr[i-1] = arr[i+1]+arr[n-1];
 * */
public class EquilibriumIndex {

	public static void main(String[] args) {
		EquilibriumIndex ei = new EquilibriumIndex();
		
		int[] arr ={-7, 1, 5, 2, -4, 3, 0};
		
		System.out.println(ei.naive(arr));
		System.out.println(ei.eff(arr));
	}
	
	/*T.C : O(n)
	 *A.S.C : O(1)
	 *
	 *LOGIC : We first calculate the total sum of array elements. Then we iterate through the array and deducting the index's element's value from the
	 *total value to get the right element's sum, at the same time we will be calculating the left element's value by adding.
	 *Once at the value of left element's value macthes the right element's value we retrun the index.
	 *
	 *For e.g if the index is i then,
	 *for(0 to n-1)
	 *right=total-arr[i]
	 *left=sum of arr elements[i]
	 * */
	private int eff(int[] arr) {
		
		int total=0;
		for(int i=0; i<arr.length; i++)
			total+=arr[i];
		
		int left=0, right=0;
		for(int j=0; j<arr.length; j++){	
			right=total-arr[j];
			total=right;
			
			if(right==left)
				return j;
			
			left+=arr[j];
		}
			
		return -1;
	}

	/*T.C : O(n2)
	 *A.S.C : O(1)
	 *
	 *LOGIC : we are iterating through the array and calculating the sum of elements before the index "i" and after the index "i", if the sum of left
	 *element's value matches the right element's value then it means we have reached an equilibrium, we return the index.
	 *
	 *For e.g if the index is i then,
	 *left = sum of array elements from (0 to i-1);
	 *right = sum of array elements from (i+1 to n-1);
	 * */
	private int naive(int[] arr) {
		for(int i=0; i<arr.length; i++){
			int left=0;
			for(int j=0; j<i; j++)
				left+=arr[j];
			
			int right=0;
			for(int j=i+1; j<arr.length; j++)
				right+=arr[j];
			
			if(left==right)
				return i;
		}
		return -1;
	}

}
