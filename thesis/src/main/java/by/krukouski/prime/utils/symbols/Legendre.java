package by.krukouski.prime.utils.symbols;

import java.math.BigInteger;
import org.apache.commons.math3.util.ArithmeticUtils;

// L(a, p)
public class Legendre {
	
	//if p is divisible by ARGUMENT 
	private static final int DIVIDER = 0;
	//if ARGUMENT is quadratic residue
	private static final int RESIDUE = 1;
	//if ARGUMENT isn't quadratic residue
	private static final int NO_RESIDUE = -1;

	private BigInteger p;
	
	public Legendre(BigInteger p){
		if(p == null){
			//throw new Exception
		}
		this.p = p;
	}
	
	
	public void setP(BigInteger p){
		this.p = p;
	}
	
	public BigInteger getP(){
		return p;
	}
	
	
	//L(a, p)
	public int calculate(BigInteger a){
		
		if(p.compareTo(new BigInteger("2")) != 0 && p.remainder(new BigInteger("2")).compareTo(BigInteger.ZERO) == 0){
			//throw new Exception
			return 2;
		}
		
		BigInteger degree = p.subtract(BigInteger.ONE);// p-1
		degree = degree.divide(new BigInteger("2"));// (p-1)/2
		
		BigInteger result = a.modPow(degree, p);
		
		if(result.compareTo(BigInteger.ZERO) == 0){
			return DIVIDER;
		}else if(result.compareTo(BigInteger.ONE) == 0){
			return RESIDUE;
		}else{
			return NO_RESIDUE;
		}
		
		/*
		if(a.equals(new BigInteger("1"))){
			return RESIDUE;
		}else if(a.mod(new BigInteger("2")).intValue() == 0){
			BigInteger halfA = a.divide(new BigInteger("2"));//   a/2
			BigInteger degree = ArithmeticUtils.pow(p, new BigInteger("2"));// p^2
			degree = degree.subtract(new BigInteger("1")); // p^2 - 1
			degree = degree.divide(new BigInteger("8")); // (p^2 - 1)/8
			int result = ArithmeticUtils.pow(new BigInteger("-1"), degree).intValue(); // (-1)^((p^2 - 1)/8)
			return calculate(p, halfA) * result; // L(a/2, p) * (-1)^((p^2 - 1)/8)
		}else{
			BigInteger modP = p.mod(a);
			BigInteger degree = a.subtract(new BigInteger("1")).multiply(p.subtract(new BigInteger("1"))); // (a-1)*(p-1)
			degree = degree.divide(new BigInteger("4")); // (a-1)*(p-1)/4
			int result = ArithmeticUtils.pow(new BigInteger("-1"), degree).intValue(); // (-1)^((a-1)*(p-1)/4)
			return calculate(a, modP) * result;// L(p mod<a>, a) * (-1)^((a-1)*(p-1)/4)
		}*/
		
	} 
	
	
	
	
	
	
	
	
	

}
