package by.krukouski.core.prime.algorithms;

import by.krukouski.core.prime.exceptions.ProbabilityAlgorithmException;
import by.krukouski.thesisfront.dto.PrimeNumberInfo;

public interface ProbabilityAlgorithm {

	public boolean checkNumber(PrimeNumberInfo primeNumberInfo) throws ProbabilityAlgorithmException;
	
}
