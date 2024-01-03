package Basic.geeksforgeeks.Recurrsion;


public class TowerOfHanoi {

	public static void main(String[] args) {
		TowerOfHanoi toh = new TowerOfHanoi();
		char x='A', y='B', z='C';
		int n=3;
		toh.recursive(x,y,z,n);
	}

	private void recursive(char x, char y, char z,int n) {
		if(n<0)
			return;
		
		if(n==1)
			System.out.println("Move disk "+n+" from "+x+" to "+z);
		
		if(n>1){
		recursive(x,z,y,n-1);
		System.out.println("Move disk "+n+" from "+x+" to "+z);
		recursive(y,x,z,n-1);
		}
	}

}
