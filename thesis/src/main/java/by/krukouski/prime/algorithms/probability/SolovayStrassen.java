package by.krukouski.prime.algorithms.probability;

import java.math.BigInteger;

import by.krukouski.prime.utils.symbols.Jacobi;

public class SolovayStrassen {

	private static BigInteger A = BigInteger.ONE;
	
	private static void increaseArgumentNum(BigInteger p){
		A = A.add(BigInteger.ONE);		
	}
	
	
	private static boolean checkNumber(BigInteger p){
		//(a, p)
		increaseArgumentNum(p);
		//System.out.println(A);
		BigInteger gtc = A.gcd(p);
		//System.out.println(gtc);
		//(a, p) != 1
		if(gtc.compareTo(BigInteger.ONE) != 0){
			return false;
		}
		//j = a^(p-1)/2 mod<p>
		BigInteger j = p.subtract(BigInteger.ONE);// p-1
		//System.out.println(j);
		j = j.divide(new BigInteger("2"));// (p-1)/2
		//System.out.println(j);
		j = A.modPow(j, p);
		//System.out.println(j);
		if(p.subtract(j).equals(BigInteger.ONE)){
			j = new BigInteger("-1");
		}
		//J(a,p)
		int jacobiSymbol = Jacobi.calculate(A, p);
		//System.out.println(jacobiSymbol);
		//j != J(a,p) => not prime 
		if(j.intValue() != jacobiSymbol){
			return false;
		}else{// => is prime
			return true;
		}		
		
	} 
	
	public static String check(BigInteger p, int prob){
		
		boolean result = true;
		
		for(int i=0; i<prob; i++){
			if(!checkNumber(p)){
				result = false;
			}
		}
		
		if(result){
			return p.toString() + " is prime with probability 1-2^" + prob;
		}else{
			return p.toString()  + " is not prime";
		}
		
	}
	
	
	
	
}
