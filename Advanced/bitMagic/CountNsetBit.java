package Advanced.bitMagic;

public class CountNsetBit {

	public static void main(String[] args) {
		
		CountNsetBit cnsb = new CountNsetBit();
		
		System.out.println(cnsb.lookup_table(255));
	}

	private int lookup_table(int n) {
		if(n == 0)
			return 0;
		
		int table[] = new int[256];
		table[0]=0;
		
		for(int i=0; i<256; i++){
			table[i]=(i&1) + table[i/2];
		}
		int res=0;
//		for(int j=1; j<=n; j++){
//	int	res=table[n&0xff];
//		n=n>>8;
//		res = res + table[n&0xff];
//		n=n>>8;
//		res = res + table[n&0xff];
//		n=n>>8;
//		res = res + table[n&0xff];
		//}
		for(int j=1; j<=n; j++){
			res = res + table[j];
		}
		
		return res;
	}

}
