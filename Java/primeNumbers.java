package Java;

import java.util.ArrayList;
import java.util.List;

public class primeNumbers {

	public static void main(String[] args) {
		int n=9999;
		
		List<Integer> al = new ArrayList<>();
		
		//NOTE :- The prime number starts from more than 1, that's why we are checking from 2.
		
		//Below for loop is to iterate upto n number.
		for(int i=2; i<=n; i++){
			boolean flg=true;
			//Below for loop to check the given number is prime or not by iterating only to its half nr.
			for(int j=2; j<=i/2; j++){
				//Below if condition to check whether the nr is prime or not.
				if(i%j==0){
					flg=false;
					break;
				}
			}
			if(flg)
				al.add(i);
		}
		
		System.out.println("Printing the prime numbers upto " + n);
		for(int numbers : al){
			System.out.print(numbers + " ");
		}
	}

}
