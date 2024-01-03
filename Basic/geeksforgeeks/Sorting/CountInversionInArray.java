package Basic.geeksforgeeks.Sorting;


public class CountInversionInArray {

	public static void main(String[] args) {
		CountInversionInArray cia = new CountInversionInArray();
		int[] arr = {2,4,1,3,5};
		int low=0, high=arr.length-1;
		System.out.print(cia.merge_sort(arr,low,high));
	}

	private int merge_sort(int[] arr, int low, int high) {
		int res=0;
		while(low<high){
			int mid=low+(high-low)/2;
			res = res + merge_sort(arr,low,mid);
			res = res + merge_sort(arr,mid+1,high);
			res = res + merge(arr,low,high,mid);
		}
		return res;
	}

	private int merge(int[] arr, int low, int high, int mid) {
		int n1=mid-low+1,n2=high-mid;
		int[] left = new int[n1];
		int[] right = new int[n2];
		
		for(int i=0; i<n1; i++)
			left[i]=arr[low+i];
		
		for(int i=0; i<n2; i++)
			right[i]=arr[mid+1+i];
		
		int j=0,k=0,l=low,result=0;
		
		while(j<n1 && k<n2){
			if(left[j]<=right[k]){
				arr[l]=left[j];
				l++;
				j++;
			}else{
				arr[l]=right[k];
				result+=n1-j;
				l++;
				k++;
			}
		}
		
		while(j<n1){
			arr[l]=left[j];
			j++;
			l++;
		}
		
		while(k<n2){
			arr[l]=right[k];
			l++;
			k++;
		}
		return result;
	}

}
