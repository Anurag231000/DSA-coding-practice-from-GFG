package Basic.geeksforgeeks.Sorting;


public class KthSmallestElement {

	public static void main(String[] args) {
		KthSmallestElement kse = new KthSmallestElement();
//		int[] arr = {10,5,30,12};
//		int[] arr = {30,20,5,10,8};
		int[] arr = {10,4,5,8,11,6,26};
		int k=5,len=arr.length-1,low=0,high=len;
		
		/*This method is naive because first it sorts the array and then finds the kth element 
		 * Time Compexity : O(nlog(n))
		 * Auxiliary space complexity : Theta(1) , If array modification is allowed.
		 * */
		kse.qsort(arr,low,high); 
		System.out.print(arr[k-1]);
		
		System.out.println();
		System.out.println("******Below is efficient one********");
		/*Below is the efficient method because in best & average case it is O(n) and in worst case
		 * is O(n2);
		 * Auxiliary space complexity : Theta(1) , If array modification is allowed.
		 * */
		System.out.print(kse.eff_kthSmallest(arr,low,high,k));
	}
	/*LOGIC : Here we are getting the index of pivot element after partition the array. If the index matches then
	 * we are returning the element at that index from array.
	 * Else if the returned index is smaller than the kth index than we increase the staring index and repeat the
	 * process.
	 * In case if the index is larger than we decrease the last size of the array that we need to iterate.
	 * */
	private int eff_kthSmallest(int[] arr, int low, int high, int k) {
		if(k>high+1)
			return -1;
		
		while(low<=high){
			int p=lomunto_partition(arr,low,high);
			
			if(p==k-1)
				return arr[p];
			else if(p>k-1)
				high=p-1;
			else
				low=p+1;
		}
		return -1;
	}

	private int lomunto_partition(int[] arr, int low, int high) {
		int element=arr[high],i=low-1;
		
		for(int j=low; j<arr.length; j++){
			
			if(arr[j]<element){
				i++;
				int temp=arr[j];
				arr[j]=arr[i];
				arr[i]=temp;
			}
		}
		int temp=arr[i+1];
		arr[i+1]=arr[high];
		arr[high]=temp;
		
		return i+1;
	}

	private void qsort(int[] arr, int low, int high) {
		if(low<high){
		int	p=hoares_partition(arr,low,high);
			qsort(arr,low,p);
			qsort(arr,p+1,high);
		}
	}

	private int hoares_partition(int[] arr, int low, int high) {
		int i=low-1, j=high+1,ele=arr[low];
		
		while(true){
			do{
				i++;
			}while(arr[i]<ele);
			
			do{
				j--;
			}while(arr[j]>ele);
				
			if(i>=j)
				return j;
			
			int temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
		}
	}
}
