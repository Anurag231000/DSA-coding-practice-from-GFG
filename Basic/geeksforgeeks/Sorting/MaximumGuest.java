package Basic.geeksforgeeks.Sorting;


public class MaximumGuest {

	public static void main(String[] args) {
		MaximumGuest mg = new MaximumGuest();
		int arr[] = {800,700,600,500};
		int dep[] = {840,820,830,530};
		
		//Arrival
		int n1=arr.length-1,a_low=0,a_high=n1;
		//Departure
		int n2=dep.length-1,d_low=0,d_high=n2;
		
		qsort(arr,a_low,a_high); //Time Complexity : O(nlog(n))
		qsort(dep,d_low,d_high); //Time Complexity : O(nlog(n))
		
		System.out.print(mg.MaxGuest(arr,dep,n1,n2));	//Time Complexity : O(n+m))
		
		/*Total Time complexity : O(nlog(n))
		 * */
	}
	
	/*LOGIC : After sorting the arrival and departure timings we compare the 2nd element from arrival with other
	 * timings from departure, and every time an arrival timing is greater than departure we increase the count
	 * else we decrease it. Hence the final result will give us the maximum number of guest we met.
	 * 
	 * we do this until one of the timings gets completed either arrival or departure.
	 * 
	 * NOTE : We don't consider the 1st arrival timing because we are concerned with the departure timing.
	 * */
	private int MaxGuest(int[] arr, int[] dep, int n1, int n2) {
		int res=0,i=1,j=0,count=1;
		while(i<=n1 && j<=n2){
			if(arr[i]<=dep[j]){
				count++;
				i++;
			}else{
				count--;
				j++;
			}
			res = Math.max(res, count);
		}
		
		return res;
	}

	private static void qsort(int[] ar, int low, int high) {
		
		if(low<high){
			int p = hoare_partition(ar,low,high);
			qsort(ar,low,p);
			qsort(ar,p+1,high);
		}
	}

	private static int hoare_partition(int[] ar, int low, int high) {
		int pivot=ar[low],l=low-1,h=high+1;
		
		while(true){
			do{
				l++;
			}while(ar[l]<pivot);
			
			do{
				h--;
			}while(ar[h]>pivot);
			
			if(l>=h)
				return h;
			
			swap(ar,l,h);
		}
	}

	private static void swap(int[] ar, int l, int h) {
		int temp=ar[l];
		ar[l]=ar[h];
		ar[h]=temp;
	}

}
