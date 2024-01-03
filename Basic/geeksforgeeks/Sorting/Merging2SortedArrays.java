package Basic.geeksforgeeks.Sorting;


public class Merging2SortedArrays {

	public static void main(String[] args) {
		Merging2SortedArrays msa = new Merging2SortedArrays();
		int[] a = {1,2,3,0,0,0};
		int[] b = {2,5,6};
		msa.naive(a,b);	
	}
	
	/*Time complexity : Theta(len1+len2)
	 *auxiliary space comlexity : Theta(len1+len2)
	 *
	 *LOGIC : Single array is created with the size of both arr1 & arr2. And then the elements gets compared from both the
	 *arrays the smallest one comes first. Like that whole array gets iterated till all the elements gets sorted. 
	 * */
	private void naive(int[] a, int[] b) {
		int len1=a.length, len2=b.length,index=0,i=0,j=0;
		int[] arr = new int[len1+len2];
		while(i<len1 && j<len2){
				if(a[i]<=b[j]){
					arr[index]=a[i];
					index++;
					i++;
				}
				else{
					arr[index]=b[j];
					index++;
					j++;
				}
		}
		//System.out.println(i+" " + j + " " + index);
		while(i<len1){
			arr[index]=a[i];
			i++;
			index++;
		}
		//System.out.println(i+" " + j + " " + index);
		while(j<len2){
			arr[index]=b[j];
			index++;
			j++;
		}
		int m=0;
		for(int l=0; l<arr.length; l++){
			if(arr[l]!=0){
            a[m]=arr[l];
            m++;
			}
        }
		for(int k=0; k<len1; k++)
			System.out.print(a[k] + " ");
		//System.out.println(i+" " + j + " " + index);
	}

}
