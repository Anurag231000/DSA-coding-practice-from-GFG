package Basic.geeksforgeeks.Recurrsion;


public class PrintNNumbers {
	
	public static void main(String[] args) {
		PrintNNumbers pn = new PrintNNumbers();
		int n=5;
		pn.print_numbers(n);
		System.out.print("\n");
		pn.Nto1(n);
	}
	
	/*Time Complexity : Theta(n) 
	 * Auxiliary space complexity : Theta(n)
	 * Recurrence relation T(n)=T(n-1) + T(1) 
	 * */
	private void Nto1(int n) {
		if(n==0)
			return;
		Nto1(n-1);
		System.out.print(n + " ");
	}

	/*Time Complexity : Theta(n) 
	 * Auxiliary space complexity : Theta(n)
	 * Recurrence relation T(n)=T(n-1) + T(1) 
	 * */
	private void print_numbers(int n) {
		if(n==0)
			return ;
		System.out.print(n + " ");
		print_numbers(n-1);	
	}

}
