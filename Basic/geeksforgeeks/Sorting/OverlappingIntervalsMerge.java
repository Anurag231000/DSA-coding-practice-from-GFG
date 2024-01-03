package Basic.geeksforgeeks.Sorting;


public class OverlappingIntervalsMerge{
	
	public static void main(String[] args) {
		OverlappingIntervalsMerge oim = new OverlappingIntervalsMerge();
		int[] a ={5,10}, b={1,7};
		int arr[][] = {{1,3},{2,4},{5,7},{6,8}};
		
		System.out.println(oim.IntervalCheck(a,b));
		
//		Interval in = new Interval();
	}

	private boolean IntervalCheck(int[] a, int[] b) {
		boolean res=false;
		
		if(a[1]>=b[0] && a[1]<=b[1])
			return true;
		else if(b[1]>=a[0] && b[1]<=a[1])
			return true;
		
		return res;
	}

}
