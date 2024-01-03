package Java;

import java.math.BigInteger;

public class BigIntegerExample {

	public static void main(String[] args) {
		BigIntegerExample bi = new BigIntegerExample();
		int n = 20;
		
		/*Factorial of number*/
//		System.out.println(bi.factorial(n));
		
		/*Fibonacci of number*/
//		System.out.println(bi.fibonacci(n));
		
		/*Prime check of number*/
		System.out.println(isPrime(n));
		
		/*Next prime number of a given number*/
		System.out.println(nextPrime(n));
	}

	private static int nextPrime(int n) {
		BigInteger b = BigInteger.valueOf(n);
		String a = b.nextProbablePrime().toString();
		int c = Integer.parseInt(a);
		return c;
	}
	
	/*The isProbablePrime(int certainty) method expects an integer argument which returns a boolean value, if certainty is <=0, true is returned*/
	private static boolean isPrime(int n) {
		BigInteger b = BigInteger.valueOf(n);
		return b.isProbablePrime(1);
	}

	private BigInteger fibonacci(int n) {
		BigInteger a = new BigInteger("0");
		BigInteger b = new BigInteger("1");
		BigInteger c = null;
		
		for(int i=2; i<=n; i++){
			c = a.add(b);
			a=b;
			b=c;
		}
		
		return c;
	}

	private BigInteger factorial(int n) {
		BigInteger f = new BigInteger("1");
		
		for(int i=2; i<=n; i++){
			BigInteger x = BigInteger.valueOf(i);
			f=f.multiply(x);
		}
		return f;
	}

}
