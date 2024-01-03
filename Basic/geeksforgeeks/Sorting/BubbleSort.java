package Basic.geeksforgeeks.Sorting;

//NOTE : Stable algorithm
/*LOGIC : We compare each element with every element present in an array or any other ds. If the present element
 * is larger than the compared element then we swap them */ 
public class BubbleSort {

	public static void main(String[] args) {
		BubbleSort bs = new BubbleSort();
		int[] arr = {10,5,8,20,2,18};
		//int[] arr = {10,20,30,40,50};
		//bs.naive(arr);
		bs.naive_1(arr);
		System.out.println("\n********Efficient solution*********");
		bs.eff(arr);
	}
	
	/*Time complexity : O(n^2) . If the array is sorted till half or from beginning itself : O(n)
	 * Auxiliary space complexity : O(1)
	 * 
	 * Below method is little bit efficient because of the flag swapped, the functionality of swapped flag is like this, if the array is already 
	 * sorted to some extent then the flag will set to false and there won't be any need to sort the remaining the elements.
	 * */
	private void eff(int[] arr) {
		int len=arr.length;
		boolean swapped=false;
		for(int i=0; i<len-1; i++){
			for(int j=0; j<len-i-1; j++){
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					swapped=true;
				}
			}
			if(swapped==false)
				break;
		}
		
		for(int i=0; i<len; i++){
			System.out.print(arr[i] + " ");
		}
		
	}

	/*Time complexity : O(n^2)
	 * Auxiliary space complexity : O(1)
	 * 
	 * LOGIC : We are decreasing the swap operation by 1 from end because after the swapping the largest element reaches at the end according
	 * to its value. So we don't need to compare the already sorted element. 
	 * */
	private void naive_1(int[] arr) {
		int len=arr.length;
		
		for(int i=0; i<len-1; i++){
			for(int j=0; j<len-i-1; j++){ //len-i-1 decreasing swap operation by 1.
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		
		for(int i=0; i<len; i++){
			System.out.print(arr[i] + " ");
		}
		
	}

	/*Time complexity : O(n^2)
	 * Auxiliary space complexity : O(1)
	 * */
	private void naive(int[] arr) {
		int len=arr.length;
		
		for(int i=0; i<len-1; i++){
			for(int j=0; j<len-1; j++){
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		
		for(int i=0; i<len; i++){
			System.out.print(arr[i] + " ");
		}
	}

}
