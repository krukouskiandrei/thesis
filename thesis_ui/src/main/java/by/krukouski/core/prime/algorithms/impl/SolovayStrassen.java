package by.krukouski.core.prime.algorithms.impl;

import java.math.BigInteger;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import by.krukouski.core.prime.algorithms.ProbabilityAlgorithm;
import by.krukouski.core.prime.exceptions.ProbabilityAlgorithmException;
import by.krukouski.core.prime.exceptions.SymbolsException;
import by.krukouski.core.prime.symbols.Symbols;
import by.krukouski.core.utils.TimeTracker;
import by.krukouski.thesisfront.dto.PrimeNumberInfo;

@Component("solovayStrassenTest")
public class SolovayStrassen implements ProbabilityAlgorithm {

	private static Logger log = Logger.getLogger(SolovayStrassen.class);
	
	private BigInteger TWO = new BigInteger("2");
	private BigInteger A = BigInteger.ONE;
	private Random rnd = new Random();
	
	public boolean checkNumber(PrimeNumberInfo primeNumberInfo) throws ProbabilityAlgorithmException {
		boolean result = true;
		BigInteger p = primeNumberInfo.getPrimeNumber();
		Symbols jacobiAlgorithm = primeNumberInfo.getJacobiAlgorithm();
		
		if(p.compareTo(BigInteger.ZERO) <= 0) {
			result = false;
			log.info(p + "isn't positive number");
			return result;
		}
		
		if(p.compareTo(TWO) == 0) {
			log.info(p + " is prime number");
			return result;
		}
		
		TimeTracker.getInstance().start();
		for(int i = 0; i < primeNumberInfo.getProbability(); i++) {
			if(!check(p, jacobiAlgorithm)) {
				TimeTracker.getInstance().stop();
				log.info(p + " not prime number");
				result = false;
				return result;
			}
		}
		TimeTracker.getInstance().stop();
		log.info(p + "is prime number");
				
		return result;
	}
	
	private boolean check(BigInteger p, Symbols jacobiAlgorithm) throws ProbabilityAlgorithmException {
		//(a, p)
		increaseArgumentNum(p);
		BigInteger gcd = A.gcd(p);
		log.info("gcd(" + A + "," + p + ") = " + gcd);
		
		//(a, p) != 1
		if(gcd.compareTo(BigInteger.ONE) != 0){
			log.info(p + " not prime");
			return false;
		}
		
		//j = a^(p-1)/2 mod<p>
		BigInteger j = p.subtract(BigInteger.ONE);// p-1
		j = j.divide(new BigInteger("2"));// (p-1)/2
		j = A.modPow(j, p);
		log.info("j = " + j);
		if(p.subtract(j).equals(BigInteger.ONE)){
			j = new BigInteger("-1");
			log.info("j = " + j);
		}
		
		//J(a,p)
		int jacobiSymbol = 0;
		try{
			jacobiSymbol = jacobiAlgorithm.calculate(A, p);
		}catch(SymbolsException e) {
			log.info("Error in jacobi algorithm" + jacobiSymbol);
			throw new ProbabilityAlgorithmException();
		}
		log.info("J(" + A + ", " + p + ") = " + jacobiSymbol);
		//j != J(a,p) => not prime 
		if(j.intValue() != jacobiSymbol){
			log.info(p + " not prime");
			return false;
		}else{// => is prime
			log.info(p + " is prime on 1/2");
			return true;
		}		
	}

	private void increaseArgumentNum(BigInteger p){
		do {
			A = new BigInteger(p.bitLength(), rnd);
		} while (A.compareTo(p) >= 0 || A.compareTo(BigInteger.ZERO) == 0 || A.mod(TWO).compareTo(BigInteger.ONE) == 0);
		log.info("A = " + A);
	}
	
}
