package Basic.geeksforgeeks.Recurrsion;


public class SumofDigits {

	public static void main(String[] args) {
		SumofDigits sod = new SumofDigits();
		int n=9987;
		System.out.print(sod.sum(n));
	}
	
	/*time complexity : Theta(n) here n is no. of digits
	 * Auxiliary space complexity : Theta(n) here n is no. of digits
	 * */
	private int sum(int n) {
		if(n<=0)
			return 0;	
		
	return sum(n/10)+n%10;	
	}

}
