package by.krukouski.core.prime.symbols.impl;

import java.math.BigInteger;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import by.krukouski.core.prime.exceptions.SymbolsException;
import by.krukouski.core.prime.symbols.Symbols;

@Component("binaryJacobiAlgorithm")
public class BinaryJacobiAlgorithm implements Symbols {
	
private static Logger log = Logger.getLogger(BinaryJacobiAlgorithm.class);
	
	//if ARGUMENT is quadratic residue
	private static final int RESIDUE = 1;
		
	private static final BigInteger TWO = new BigInteger("2");
	private static final BigInteger THREE = new BigInteger("3");
	private static final BigInteger FOUR = new BigInteger("4");
	private static final BigInteger FIVE = new BigInteger("5");
	private static final BigInteger EIGHT = new BigInteger("8");
	private static final BigInteger NEGATVE_ONE = new BigInteger("-1");

	public int calculate(BigInteger a, BigInteger p) throws SymbolsException {
		if(p.remainder(TWO).compareTo(BigInteger.ZERO) == 0 || a.compareTo(BigInteger.ZERO) < 0){
			log.info("second number shouldn't be even or negative");
			throw new SymbolsException();			
		}
		
		int result = 1;
		// a = 0 mod(2)
		while(a.compareTo(BigInteger.ZERO) != 0){
			
			while(a.mod(TWO).compareTo(BigInteger.ZERO) == 0){
				// a = a/2
				a = a.divide(TWO);
				//p=3 mod(8) or p=5 mod(8)
				if((p.mod(EIGHT).compareTo(THREE) == 0) || (p.mod(EIGHT).compareTo(FIVE) == 0)){
					result = -result;
				}
			}
			// a < p
			if(a.compareTo(p) < 0){
				// a <=> p
				BigInteger k = a;
				a = p;
				p = k;
				// a = 3 mod(4) and p = 3 mod(4)
				if((a.mod(FOUR).compareTo(THREE) == 0) && (p.mod(FOUR).compareTo(THREE) == 0)){
					result = -result;
				}
			}
			// a = (a-p)/2
			a = a.subtract(p).divide(TWO);
			// p = 3 mod(8) or p = 5 mod(8)
			if((p.mod(EIGHT).compareTo(THREE) == 0) || (p.mod(EIGHT).compareTo(FIVE) == 0)){
				result = -result;
			}
		}
		// p = 1
		if(p.compareTo(BigInteger.ONE) == 0){
			return result;
		}else{
			return 0;
		}
	}

}
