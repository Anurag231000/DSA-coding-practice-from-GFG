package Advanced.bitMagic;

public class CountSetBit {

	public static void main(String[] args) {
		
		CountSetBit csb = new CountSetBit();
		
		csb.naive(12);
		//csb.naive_1(13);
		//csb.Brian_kerningam_algo(40);
		//csb.lookup_table(40);
	}

	private void lookup_table(int n) {
		int[] table = new int[256];
		table[0] = 0;
		for(int i=0; i<256; i++){
			table[i] = (i & 1) + table[i/2];
		}
		int res = table[n&0xff] ;
		n=n>>8;
		res=res + table[n&0xff];
		n=n>>8;
		res = res + table[n&0xff];
		n=n>>8;
		res = res + table[n&0xff];
		System.out.println("This method table of lookup table algorithm runs for time complexity of O(1)");
		System.out.println(res);
	}

	private void Brian_kerningam_algo(int n) {
		int res=0;
		while(n>0){
			n = n & n-1;
			res++;
		}
		System.out.println("This runs with the time complexity of Theta(Number of set bits)");
		System.out.println(res);
	}

	private void naive_1(int n) {
		int res=0;
		while(n>0){
			res = res + (n & 1);
			n=n>>1;
		}
		System.out.println("This runs with time complexity of Theta(n)");
		System.out.println(res);
	}

	private void naive(int n) {
		int d=0, count=0, num=n;
		int[] binary = new int[num];
		
		while(n>0){
			binary[d++]=n%2;
			n=n/2;
		}
//		for(int i=d-1; i>=0; i--){
//			if(binary[i]==1)
//				count++;
//		}
		for(int i=d-1; i>=0; i--){
			System.out.print(binary[i]);
		}
//		System.out.println(count);
	}

}
