package Basic.geeksforgeeks.Recurrsion;


public class BaseCases {

	public static void main(String[] args) {
		BaseCases bc = new BaseCases();
		int n=4,k=1;
		//System.out.print(bc.factor(n,k));
		System.out.print(bc.fib(n,k) + " ");
	}
	
	/*By using tail recurrsion
	 * */
	private int fib(int n, int k) {
		if(n==0)
			return 0;
		
		if(n==1)
			return k;
		
		return (fib(n-1,k)+fib(n-2,k));
	}
	/*By using tail recurrsion
	 * */
	private int factor(int n, int k) {
		if(n==0)
			return k;
		
		return factor(n-1,k*n);
	}
	
	

}
