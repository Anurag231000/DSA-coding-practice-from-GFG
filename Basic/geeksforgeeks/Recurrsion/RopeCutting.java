package Basic.geeksforgeeks.Recurrsion;


public class RopeCutting {

	public static void main(String[] args) {
		RopeCutting rc = new RopeCutting();
		int n=23, a=11, b=9, c=12;
		System.out.println(rc.MaxNumberOfPieces(n,a,b,c));
	}
	
	/*Time complexity : O(3^n)
	 * */
	private int MaxNumberOfPieces(int n, int a, int b, int c) {
		if(n==0)
			return 0;
		else if(n<0)
			return -1;
		
		int res = Math.max(MaxNumberOfPieces(n-a,a,b,c),
							MaxNumberOfPieces(n-b,a,b,c));
		int res1=Math.max(res, MaxNumberOfPieces(n-c,a,b,c));
		
		if(res1==-1)
			return -1;
		
		return res1+1;
	}

}
