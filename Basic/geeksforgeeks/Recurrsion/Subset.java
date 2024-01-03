package Basic.geeksforgeeks.Recurrsion;


public class Subset {

	public static void main(String[] args) {
		Subset sub = new Subset();
		String s = "ABC", curr="";
		int index=0;
		sub.sets(s,curr,index);
	}

	private void sets(String s, String curr, int index) {
		
		if(index==s.length()){
			System.out.print(curr + " ");
			return ;
		}
		
		sets(s,curr,index+1);
		sets(s,curr+s.charAt(index),index+1);	
	}

}
