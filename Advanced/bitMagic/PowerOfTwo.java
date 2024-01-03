package Advanced.bitMagic;

public class PowerOfTwo {

	public static void main(String[] args) {
		
		PowerOfTwo pft = new PowerOfTwo();
		//System.out.println(pft.naive(4));
		//pft.burningham_sol(248);
		System.out.println(pft.efficient_sol(16)); // This solution takes Theta(1) time complexity.
	}

	private boolean efficient_sol(int n) {
		if(n == 0)
			return false;
		
		if((n=n&n-1) > 0)
			return false;
		
		return true;
	}

	private void burningham_sol(int n) {
		int res=0;
		while(n>0){
			n= n&(n-1);
			n=n/2;
			res++;
		}
		if(res == 1)
			System.out.println("True");
		else
			System.out.println("False");
	}

	private boolean naive(int n) {
		
		while(n!=1){
			if(n%2 !=0 )
				return false;
			n=n/2;
		}
		return true;
	}

}
