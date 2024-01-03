package Basic.geeksforgeeks.Array;

public class ArrayRotation {

	public static void main(String[] args) {
		ArrayRotation ar = new ArrayRotation();
		int[] arr = {1,2,3,4,5};
		//ar.naive(arr); // rotation by 1
	
		int d=17,n=arr.length;
		//Rotating array by d
		//ar.naive_rotate(arr,d,n);
		//ar.eff_rotate(arr,n,d);
		ar.eff1_rotate(arr,n,d);
	}
	/*Time Complexity : Theta(d)+Theta(n-d)+Theta(n)=Theta(n)
	  Auxiliary Space : Theta(n+1)= Theta(n)
	  
	  LOGIC : 1.First we switch the elements upto the nr of rotations(d).
	  		  2.Second we switch the elements from nr of rotations till the end(d to n-1).
	  		  3.Lastly we switch all the elements from 0 to n-1. 
	  */
	private void eff1_rotate(int[] arr, int n, int d) {
		if(d>=n && d%n==0)
			d=0;
		else if(d>=n && d%n!=0)
			d=d%n;
		
		reverse(arr,0,d-1);
		reverse(arr,d,n-1);
		reverse(arr,0,n-1);
		
		for(int i=0; i<n; i++)
			System.out.print(arr[i] + " ");
	}
	private void reverse(int[] arr, int low, int high){
		while(low < high){
			int temp=arr[low];
			arr[low]=arr[high];
			arr[high]=temp;
			low++;
			high--;
		}
	}
	/*Time Complexity : Theta(d)+Theta(n-d)+Theta(d)=Theta(n)
	  Space Complexity : Theta(d)
	  
	  LOGIC : 1. Calculating the nr of rotations required.
	  2. Copy the nr of elements same as rotation nr in a separate array.
	  3. Move the elements which starts from the count of nr of elements to the left.
	  4. Now copy paste the elements that we stored in a separate array to the existing array from the calculated location[n-d+i].
	  */
	private void eff_rotate(int[] arr, int n, int d) {
		/*We are using this below, if and else logic to reduce the number of rotations if the given nr of rotations is more than the nr of elements.
		 * */
		if(d>=n && d%n==0)
			d=0;
		else if(d>=n && d%n!=0)
			d=d%n;
		
		int[] temp = new int[d];
		for(int i=0; i<d; i++)
			temp[i]=arr[i];
		
		for(int i=d; i<n; i++)
			arr[i-d]=arr[i];
		
		for(int i=0; i<d; i++)
			arr[n-d+i]=temp[i];
		
		for(int i=0; i<n; i++)
			System.out.print(arr[i] + " ");
	}
	//Time complexity : Theta(nd)
	//Space Complexity : Theta(d)
	/*In order to rotate the array, we are just calling the single rotation method multiple times.
	 * */
	private void naive_rotate(int[] arr, int d, int n) {
		for(int i=0; i<d; i++){
			naive(arr);
		}
		//Comment out the print logic in naive method.
		for(int i=0; i<n; i++){
			System.out.print(arr[i]+" ");
		}
	}
	//Time Complexity : Theta(n-1)
	//Space Complexity : Theta(1)
	/*LOGIC : Below method is only rotate the array by 1 position anti-clockwise. 
	 * We store the first element in a variable and then rest of the elements we move to the left by 1. Now we copy the earlier saved first element 
	 * to the last.
	 * */
	private void naive(int[] arr) {	
		int temp=arr[0];
		for(int i=1; i<arr.length; i++){
			arr[i-1]=arr[i];
		}
		arr[arr.length-1]=temp;
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}

}
