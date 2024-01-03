package Basic.geeksforgeeks.Recurrsion;


public class SumofNNumbers {

	public static void main(String[] args) {
		SumofNNumbers son = new SumofNNumbers();
		int n=5;
		System.out.print(son.sum(n));
	}

	private int sum(int n) {
		if(n==0)
			return 0;
		
		return n+sum(n-1);
	}

}
