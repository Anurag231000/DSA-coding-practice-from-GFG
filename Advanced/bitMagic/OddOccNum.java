package Advanced.bitMagic;

public class OddOccNum {

	public static void main(String[] args) {
		OddOccNum oon = new OddOccNum();
		int[] arr = {4,3,4,4,4,5,5};
		int[] arr1 = {3,4,3,4,8,4,4,32,7,7};
		//oon.efficient_sol(arr);
		oon.odd_nr_occurred_2_times(arr1);
	}

	private void odd_nr_occurred_2_times(int[] arr1) {
		int x=0, res1=0, res2=0;
		for(int i=0; i<arr1.length; i++){
			x=x^arr1[i];
		}
		System.out.println(x);
		int sn = x&(~(x-1));
		System.out.println(sn);
		
		for(int j=0; j<arr1.length; j++){
			if((sn&arr1[j]) != 0)
				res1=res1^arr1[j];
			else
				res2=res2^arr1[j];
		}
		System.out.println(res1 + " " + res2);
	}

	//Theta(n)
	private void efficient_sol(int[] arr) {
		int x = 0;
		for (int i=0; i<arr.length; i++){
			x = x^arr[i];
		}
		System.out.println("Number which has occurred odd times : " + x);
	}



}
