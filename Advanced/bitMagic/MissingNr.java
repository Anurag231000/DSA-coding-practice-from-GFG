package Advanced.bitMagic;

public class MissingNr {

	public static void main(String[] args) {
		MissingNr mnr = new MissingNr();
		int[] arr = {1, 2, 3, 5};
		int n = arr.length;
		mnr.XOR(arr,n);

	}

	private void XOR(int[] arr, int n) {
		int a = arr[0];
		int b = 1;
		
		for(int i=1; i<n; i++){
			a=a^arr[i];
		}
		for(int j=2; j<=n+1; j++){
			b=b^j;
		}
		System.out.println(a^b);
	}

}
