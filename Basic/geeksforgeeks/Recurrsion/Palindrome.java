package Basic.geeksforgeeks.Recurrsion;


public class Palindrome {

	public static void main(String[] args) {
		Palindrome p = new Palindrome();
		String s = "abba";
		int end=s.length()-1, start=0;
		System.out.print(p.palin_check(s,start,end));
	}
	
	/*Time complexity : O(n)
	 * Auxiliary space complexity : O(n)
	 * */
	private boolean palin_check(String s, int start, int end) {
		if(start>=end)
			return true;
		
		return (s.charAt(start)==s.charAt(end)) && palin_check(s,start+1,end-1);
	}

}
