package by.krukouski.prime.algorithms.facades;

import java.math.BigInteger;

import by.krukouski.prime.algorithms.probability.SolovayStrassen;

public class SolovayStrassenFacades {
	
	private final static BigInteger TWO = new BigInteger("2");
	
	public static String checkNumber(BigInteger number, Integer probability){
		SolovayStrassen ssAlgorithm = new SolovayStrassen();
		Integer spyProbability = probability + 1;
		if(number.compareTo(new BigInteger((spyProbability).toString())) > 0){
			ssAlgorithm.setProvability(probability);
		}else{
			probability = number.subtract(TWO).intValue();
			ssAlgorithm.setProvability(probability);
		}
		boolean result = ssAlgorithm.check(number);
		if(result){
			return number.toString() + " is prime with probability 1-2^" + probability;
		}else{
			return number.toString()  + " is not prime";
		}
	}
	
	//BAD!!!!!!!reworked
	public static boolean checkNumberForTest(BigInteger number, Integer probability){
		SolovayStrassen ssAlgorithm = new SolovayStrassen();
		Integer spyProbability = probability + 1;
		if(number.compareTo(new BigInteger((spyProbability).toString())) > 0){
			ssAlgorithm.setProvability(probability);
		}else{
			probability = number.subtract(TWO).intValue();
			ssAlgorithm.setProvability(probability);
		}
		boolean result = ssAlgorithm.check(number);
		return result;
	}
	
}
