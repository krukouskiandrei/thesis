package by.krukouski.prime.algorithms.probability;

import java.math.BigInteger;
import java.util.Random;

import org.apache.log4j.Logger;

import by.krukouski.prime.utils.symbols.Jacobi;
import by.krukouski.prime.utils.symbols.TimeTracker;

public class SolovayStrassen {

	private static Logger log = Logger.getLogger(SolovayStrassen.class);
	
	private BigInteger A = BigInteger.ONE;
	private BigInteger TWO = new BigInteger("2");
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
	
	private void increaseArgumentNum(BigInteger p){
		do {
			A = new BigInteger(p.bitLength(), rnd);
		} while (A.compareTo(p) >= 0 || A.compareTo(BigInteger.ZERO) == 0);
		log.info("A = " + A);
	}
	
	
	private boolean checkNumber(BigInteger p){
		//(a, p)
		increaseArgumentNum(p);
		BigInteger gtc = A.gcd(p);
		log.info("gtc(" + A + "," + p + ") = " + gtc);
		//(a, p) != 1
		if(gtc.compareTo(BigInteger.ONE) != 0){
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
		int jacobiSymbol = Jacobi.calculate(A, p);
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
		TimeTracker.getInstance().start();
		for(int i=0; i<probability; i++){
			if(!checkNumber(p)){
				TimeTracker.getInstance().stop("Solovay-Strassen, Usualy method");
				log.info(p + " not prime");
				result = false;
			}
		}
		TimeTracker.getInstance().stop("Solovay-Strassen, Usualy method");
		log.info(p + " is prime on 1 - 2^(-" + probability + ")");
		return result;
	}
	
	
	
	
}
