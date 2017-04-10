package by.krukouski.prime.algorithms.facades;

import java.math.BigInteger;

import by.krukouski.prime.algorithms.probability.MillerRabin;
import by.krukouski.prime.algorithms.probability.SolovayStrassen;

public class CommonAlgorithmsFacades {

	private final static BigInteger TWO = new BigInteger("2");
	
	public static boolean checkNumber(BigInteger number, Integer probability) {
		
		SolovayStrassen ssAlgorithm = new SolovayStrassen();
		Integer spyProbability = probability + 1;
		if(number.compareTo(new BigInteger((spyProbability).toString())) > 0){
			ssAlgorithm.setProvability(probability);
		}else{
			probability = number.subtract(TWO).intValue();
			ssAlgorithm.setProvability(probability);
		}
		boolean result = false;
		result = ssAlgorithm.check(number);
		result = ssAlgorithm.checkBinary(number);
		MillerRabin mrAlgorithm = new MillerRabin();
		spyProbability = probability + 1;
		if(number.compareTo(new BigInteger((spyProbability).toString())) > 0){
			mrAlgorithm.setProvability(probability);
		}else{
			probability = number.subtract(TWO).intValue();
			mrAlgorithm.setProvability(probability);
		}
		result = mrAlgorithm.check(number);
		return result;		
	}
	
	
}
