package by.krukouski.prime.algorithms.probability;

import java.math.BigInteger;
import java.util.Random;

import org.apache.log4j.Logger;

public class MillerRabin {
	
	private static Logger log = Logger.getLogger(MillerRabin.class);
	
	private static final BigInteger TWO = new BigInteger("2");
	private BigInteger A = BigInteger.ONE;
	
	private Random rnd = new Random();
	
	private Integer probability = new Integer(2);
	
	public void setProvability(Integer probability){
		if(probability != null && probability > 0){
			this.probability = probability;
		}
	}
	
	public Integer getProbability(){
		return probability;
	}
	
	//decomposition n-1 = 2^s * t 
	private Integer findDegreeOfTwo(BigInteger number) {
		
		Integer degree = 0;//s
		
		while(number.remainder(TWO).compareTo(BigInteger.ZERO) == 0){
			   number = number.divide(new BigInteger("2"));//t
			   degree++;
		}
		log.info("s = " + degree + "; t = " + number);
		return degree;
	}
	
	private void increaseArgumentNum(BigInteger p){
		do {
			A = new BigInteger(p.bitLength(), rnd);
		} while (A.compareTo(p) >= 0 || A.compareTo(BigInteger.ZERO) == 0 || A.compareTo(BigInteger.ONE) == 0);
		log.info("A = " + A);
	}
	
	private boolean checkNumber(BigInteger p){
		
		increaseArgumentNum(p.subtract(BigInteger.ONE));
		
		BigInteger gtc = A.gcd(p);
		log.info("gtc(" + A + "," + p + ") = " + gtc);
		//(a, p) != 1
		if(gtc.compareTo(BigInteger.ONE) != 0){
			log.info(p + " not prime");
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
			log.info(p + " is prime on 1 - 1/4");
			return true;
		}
		
		for(int i = 1; i < s; i++){
			//j = j^2 mod<p>
			j = j.modPow(TWO, p);
			//if j=1 => not prime
			if(j.compareTo(BigInteger.ONE) == 0){
				log.info(p + " not prime");
				return false;
			}
			//if j=p-1 => is prime
			if(j.compareTo(p.subtract(BigInteger.ONE)) == 0){
				log.info(p + " is prime");
				return true;
			}
		}
		log.info(p + " not prime");
		return false;
		
	} 
	
	public boolean check(BigInteger p){
		
		boolean result = true;
		
		if(p.compareTo(BigInteger.ZERO) <= 0){
			result = false;
			log.info(p + " is negative number");
			return result;
		}
		if(p.compareTo(TWO) == 0){
			log.info(p + " is prime on 1 - 2^(-" + probability + ")");
			return result;
		}
		
		for(int i=0; i<probability; i++){
			if(!checkNumber(p)){
				log.info(p + " not prime");
				result = false;
			}
		}
		
		log.info(p + " is prime on 1 - 4^(-" + probability + ")");
		return result;
	}
	
	
	

}
