package by.krukouski.prime.utils.symbols;

import java.math.BigInteger;

import org.apache.commons.math3.util.ArithmeticUtils;

//J(a, p)
public class Jacobi {

	//if ARGUMENT is quadratic residue
	private static final int RESIDUE = 1;
	//if ARGUMENT isn't quadratic residue
	private static final int NO_RESIDUE = -1;
	
	private static final BigInteger TWO = new BigInteger("2");
	private static final BigInteger FOUR = new BigInteger("4");
	private static final BigInteger EIGHT = new BigInteger("8");
	private static final BigInteger NEGATVE_ONE = new BigInteger("-1");
	
	//J(a, p)
	public static int calculate(BigInteger a, BigInteger p){
		
		
		if(p.remainder(TWO).compareTo(BigInteger.ZERO) == 0){
			//throw new Exception
			return 2;
		}
		
		if(a.compareTo(BigInteger.ZERO) == -1){
			BigInteger degree = p.subtract(BigInteger.ONE).divide(TWO);//(n-1)/2
			int result = ArithmeticUtils.pow(NEGATVE_ONE, degree).intValue(); // (-1)^((n-1)/2)
			return calculate(a.negate(), p) * result;//J(-a, p) * (-1)^((n-1)/2)
		}
		if(a.remainder(TWO).compareTo(BigInteger.ZERO) == 0){
			BigInteger degree = ArithmeticUtils.pow(p, TWO).subtract(BigInteger.ONE).divide(EIGHT);//(n^2-1)/8
			int result = ArithmeticUtils.pow(NEGATVE_ONE, degree).intValue(); // (-1)^((n^2-1)/8)
			return calculate(a.divide(TWO), p)*result;//J(a/2, p)*(-1)^((n^2-1)/8)
		}
		if(a.compareTo(BigInteger.ONE) == 0){//a=1
			return RESIDUE;
		}
		if(a.compareTo(p) == -1){
			BigInteger degree = p.subtract(BigInteger.ONE).divide(TWO).multiply(a.subtract(BigInteger.ONE).divide(TWO));//(p-1)*(a-1)/4
			int result = ArithmeticUtils.pow(NEGATVE_ONE, degree).intValue(); // (-1)^((p-1)*(a-1)/4)
			return calculate(p, a) * result;
		}
		
		return calculate(a.mod(p), p);		
		
	}
	
	
}
