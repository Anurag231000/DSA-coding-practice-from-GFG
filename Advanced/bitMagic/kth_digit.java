package Advanced.bitMagic;

public class kth_digit {

	public static void main(String[] args) {
		
		kth_digit dg = new kth_digit();
		dg.left_shift(4,2);
		//dg.right_shift(13,3);
	}

	private void right_shift(int i, int j) {
		if((i>>j-1 & 1) == 1)
			System.out.println("Yes");
		else
			System.out.println("No");
		
	}

	private void left_shift(int i, int j) {
		if((i & 1<<j-1) !=0)
			System.out.println("Yes");
		else
			System.out.println("No");
		
	}

}
