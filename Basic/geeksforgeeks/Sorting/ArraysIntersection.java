package Basic.geeksforgeeks.Sorting;


public class ArraysIntersection {

	public static void main(String[] args) {
		ArraysIntersection ai = new ArraysIntersection();
		int[] a = {20,40,2,60,20};
		int[] b = {20,20,10,20};
		int h1=a.length-1,h2=b.length-1,l1=0,l2=0,len=0,i=0,j=0;
		
		qsort(a,l1,h1);
		qsort(b,l2,h2);
		
		System.out.println("*****Intersection of 2 sorted arrays*****");
		/*Time complexity : O(max(h1,h2))
		 * Auxiliary space complexity : O(1)
		 * */
		//Below code for intersection of 2 sorted arrays
		while(i<=h1 && j<=h2){
			if(i>0 && a[i]==a[i-1]){
				i++;
				continue;
			}
			if(a[i]>b[j])
				j++;
			else if(a[i]<b[j])
				i++;
			else if(a[i]==b[j]){
				System.out.println(a[i] + " ");
				i++;
				j++;
			}
		}
		i=0;j=0;
		System.out.println("*****Union of 2 sorted arrays*****");
		/*Time Complexity : O(m+n)
		 * Auxiliary space complexity : O(1)
		 * */
		//Below code for union of 2 sorted arrays
		while(i<=h1 && j<=h2){
			if(i>0 && a[i]==a[i-1]){
				i++;
				continue;
			}else if(j>0 && b[j]==b[j-1]){
				j++;
				continue;
			}
			if(a[i]<b[j]){
				System.out.print(a[i] + " ");
				i++;
			}
			else if(a[i]>b[j]){
				System.out.print(b[j]+" ");
				j++;
			}else{
				System.out.print(a[i]+" ");
				i++;
				j++;
			}
		}
		
		while(i<=h1){
			if(i>0 && a[i]==a[i-1]){
				i++;
				continue;
			}else{
				System.out.print(a[i] + " ");
				i++;
			}
		}
		while(j<=h2){
			if(j>0 && b[j]==b[j-1]){
				j++;
				continue;
			}else{
				System.out.print(b[j] + " ");
				j++;
			}
		}
	}

	private static void qsort(int[] arr, int l, int h) {
		if(l<h){
			int p = partition(arr,l,h);
			qsort(arr,l,p-1);
			qsort(arr,p+1,h);
		}
	}

	private static int partition(int[] arr, int l, int h) {
		int pivot=arr[h],j=l-1;
		for(int i=l; i<h; i++){
			if(arr[i]<pivot){
				j++;
				int temp=arr[j];
				arr[j]=arr[i];
				arr[i]=temp;
			}	
		}
		int temp=arr[j+1];
		arr[j+1]=arr[h];
		arr[h]=temp;
		
		return j+1;
	}

}
