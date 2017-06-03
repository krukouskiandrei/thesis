package by.krukouski.core.prime.algorithms.impl;

import java.math.BigInteger;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import by.krukouski.core.prime.algorithms.ProbabilityAlgorithm;
import by.krukouski.core.prime.exceptions.ProbabilityAlgorithmException;
import by.krukouski.core.utils.TimeTracker;
import by.krukouski.thesisfront.dto.PrimeNumberInfo;

@Component("millerRabinTest")
public class MillerRabin implements ProbabilityAlgorithm {

	private static Logger log = Logger.getLogger(MillerRabin.class);
	
	private static final BigInteger TWO = new BigInteger("2");
	private BigInteger A = BigInteger.ONE;
	
	private Random rnd = new Random();
	
	private void increaseArgumentNum(BigInteger p) {
		do {
			A = new BigInteger(p.bitLength(), rnd);
		} while (A.compareTo(p) >= 0 || A.compareTo(BigInteger.ZERO) == 0 || A.compareTo(BigInteger.ONE) == 0);
		log.info("A = " + A);
	}
	
	//decomposition n-1 = 2^s * t 
	private Integer findDegreeOfTwo(BigInteger number) {
	
		Integer degree = 0;//s
		
		while(number.remainder(TWO).compareTo(BigInteger.ZERO) == 0) {
			number = number.divide(new BigInteger("2"));//t
			degree++;
		}
		log.info("s = " + degree + "; t = " + number);
		return degree;
	}

	public boolean checkNumber(PrimeNumberInfo primeNumberInfo) throws ProbabilityAlgorithmException {
		boolean result = true;
		BigInteger p = primeNumberInfo.getPrimeNumber();
		
		if(p.compareTo(BigInteger.ZERO) <= 0){
			result = false;
			log.info(p + " isn't positive number");
			return result;
		}
		if(p.compareTo(TWO) == 0){
			log.info(p + " is prime nember");
			return result;
		}
		
		TimeTracker.getInstance().start();
		for(int i = 0; i < primeNumberInfo.getProbability(); i++) {
			if(!check(p)) {
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
	
	private boolean check(BigInteger p) {
		
		increaseArgumentNum(p.subtract(BigInteger.ONE));
		
		BigInteger gcd = A.gcd(p);
		log.info("gcd(" + A + "," + p + ") = " + gcd);
		
		//(a, p) != 1
		if(gcd.compareTo(BigInteger.ONE) != 0){
			log.info(p + " not prime number");
			return false;
		}
		
		//t = p-1
		BigInteger t = p.subtract(BigInteger.ONE);
		//t = 2^s * k
		Integer s = findDegreeOfTwo(t);
		//j = a^t mod<p>
		BigInteger j = A.modPow(t, p);
		log.info("j = " + j);
		
		//if j=1 || j=p-1 => is prime
		if(j.compareTo(BigInteger.ONE) == 0 || j.compareTo(p.subtract(BigInteger.ONE)) == 0){
			log.info(p + " is prime number");
			return true;
		}
		
		for(int i = 1; i < s; i++){
			
			//j = j^2 mod<p>
			j = j.modPow(TWO, p);
			
			//if j=1 => not prime
			if(j.compareTo(BigInteger.ONE) == 0){
				log.info(p + " not prime number");
				return false;
			}
			
			//if j=p-1 => is prime
			if(j.compareTo(p.subtract(BigInteger.ONE)) == 0){
				log.info(p + " is prime number");
				return true;
			}
		}
		
		log.info(p + " not prime number");
		return false;
	}
	
	
}
