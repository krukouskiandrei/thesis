package by.krukouski.core.prime.symbols.impl;

import java.math.BigInteger;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import by.krukouski.core.prime.exceptions.SymbolsException;
import by.krukouski.core.prime.symbols.Symbols;

@Component("lebesgueJacobiAlgorithm")
public class LebesgueJacobiAlgorithm implements Symbols {

	private static Logger log = Logger.getLogger(LebesgueJacobiAlgorithm.class);
	
	private static final BigInteger TWO = new BigInteger("2");
	private static final BigInteger THREE = new BigInteger("3");
	private static final BigInteger FIVE = new BigInteger("5");
	private static final BigInteger EIGHT = new BigInteger("8");
	private static final BigInteger FOUR = new BigInteger("4");
	
	public int calculate(BigInteger a, BigInteger p) throws SymbolsException {
		//a >= 0, p > 0 and p odd
		if(p.remainder(TWO).compareTo(BigInteger.ZERO) == 0 || p.compareTo(BigInteger.ZERO) <= 0) {
			log.info("second number shouldn't be even or negative");
			throw new SymbolsException();			
		}
		
		int result = 1;
		
		//a != 0
		while(a.compareTo(BigInteger.ZERO) != 0) {
			//a < 0
			if(a.compareTo(BigInteger.ZERO) < 0) {
				//a = -a
				a = a.negate();
				//p = 3 (mod 4)
				if(p.mod(FOUR).compareTo(THREE) == 0) {
					result = -result;
				}
			}	
				//a = 0 (mod 2)
			while(a.mod(TWO).compareTo(BigInteger.ZERO) == 0) {
				a = a.divide(TWO);
				//p=3 mod(8) or p=5 mod(8)
				if((p.mod(EIGHT).compareTo(THREE) == 0) || (p.mod(EIGHT).compareTo(FIVE) == 0)) {
					result = -result;
				}
			}
				
			// a <=> p
			BigInteger k = a;
			a = p;
			p = k;
				
			// a = 3 mod(4) and p = 3 mod(4)
			if((a.mod(FOUR).compareTo(THREE) == 0) && (p.mod(FOUR).compareTo(THREE) == 0)){
				result = -result;
			}
				
			//a = a (mod p)
			a = a.mod(p);
				
			if(a.compareTo(p.divide(TWO)) > 0) {
				a = a.subtract(p);
			}
			
		}
		
		// p = 1
		if(p.compareTo(BigInteger.ONE) == 0) {
			return result;
		} else {
			return 0;
		}
	}

}
