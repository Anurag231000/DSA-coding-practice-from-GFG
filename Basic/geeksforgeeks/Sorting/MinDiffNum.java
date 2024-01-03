package Basic.geeksforgeeks.Sorting;


public class MinDiffNum {

	public static void main(String[] args) {
		MinDiffNum mdn = new MinDiffNum();
		int[] arr = {10,3,20,12};
		int l=0,h=arr.length-1;
		mdn.merge_sort(arr,l,h);
		
		mdn.minimum_value(arr,h);
	}
	
	/*LOGIC : We first sort the array and then we iterate the array until we find the minimum difference between
	 * two consecutive elements.
	 * 
	 * Sorting helps it because then we just need to compare the consecutive elements.
	 * */
	private void minimum_value(int[] arr, int h) {
		int res=Integer.MAX_VALUE;
		for(int i=0; i<h; i++){
			res=Math.min(res, Math.abs(arr[i+1]-arr[i]));
		}
		System.out.println(res);
	}

	private void merge_sort(int[] arr, int l, int h) {
		
		if(l<h){
			int mid=l+(h-l)/2;
			merge_sort(arr,l,mid);
			merge_sort(arr,mid+1,h);
			merge(arr,l,h,mid);
		}
	}

	private int[] merge(int[] arr, int l, int h, int mid) {
		int j=0,k=0,m=l,n1=mid-l+1,n2=h-mid;
		int[] left = new int[n1];
		int[] right = new int[n2];
		
		for(int i=0; i<n1; i++)
			left[i]=arr[l+i];
		
		for(int i=0; i<n2; i++)
			right[i]=arr[mid+i+1];
		
		while(j<n1 && k<n2){
			if(left[j]<=right[k]){
				arr[m]=left[j];
				j++;
			}else{
				arr[m]=right[k];
				k++;
			}
			m++;
		}
		while(j<n1){
			arr[m]=left[j];
			j++;
			m++;
		}
		
		while(k<n2){
			arr[m]=right[k];
			k++;
			m++;
		}
		
		return arr;
	}

}
