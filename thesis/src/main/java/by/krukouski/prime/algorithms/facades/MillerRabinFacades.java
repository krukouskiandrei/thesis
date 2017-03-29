package by.krukouski.prime.algorithms.facades;

import java.math.BigInteger;

import by.krukouski.prime.algorithms.probability.MillerRabin;

public class MillerRabinFacades {

private final static BigInteger TWO = new BigInteger("2");
	
	public static String checkNumber(BigInteger number, Integer probability){
		MillerRabin mrAlgorithm = new MillerRabin();
		Integer spyProbability = probability + 1;
		if(number.compareTo(new BigInteger((spyProbability).toString())) > 0){
			mrAlgorithm.setProvability(probability);
		}else{
			probability = number.subtract(TWO).intValue();
			mrAlgorithm.setProvability(probability);
		}
		boolean result = mrAlgorithm.check(number);
		if(result){
			return number.toString() + " is prime with probability 1-2^" + probability;
		}else{
			return number.toString()  + " is not prime";
		}
	}
	
	//BAD!!!!!!!reworked
	public static boolean checkNumberForTest(BigInteger number, Integer probability){
		MillerRabin mrAlgorithm = new MillerRabin();
		Integer spyProbability = probability + 1;
		if(number.compareTo(new BigInteger((spyProbability).toString())) > 0){
			mrAlgorithm.setProvability(probability);
		}else{
			probability = number.subtract(TWO).intValue();
			mrAlgorithm.setProvability(probability);
		}
		boolean result = mrAlgorithm.check(number);
		return result;
	}
}
