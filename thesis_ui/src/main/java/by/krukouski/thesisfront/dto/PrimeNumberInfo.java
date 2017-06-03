package by.krukouski.thesisfront.dto;

import java.math.BigInteger;

import by.krukouski.core.prime.symbols.Symbols;

public class PrimeNumberInfo {

	private BigInteger primeNumber;
	private int probability;//count steps for probability algorithms
	private Symbols jacobiAlgorithm;
	
	public PrimeNumberInfo() {}
	
	public void setPrimeNumber(BigInteger primeNumber) {
		this.primeNumber = primeNumber;
	}
	public BigInteger getPrimeNumber() {
		return primeNumber;
	}
	
	public void setProbability(double probability, int base) {
		double res = Math.log(1/(1-probability))/Math.log(base);//log'a'(b) = ln(b)/ln(a)
		int result = (int) res;
		if(result > 1) {
			this.probability = result;
		}else {
			this.probability = 1;
		}
	}
	public int getProbability() {
		return probability;
	}
	
	public void setJacobiAlgorithm(Symbols jacobiAlgorithm) {
		this.jacobiAlgorithm = jacobiAlgorithm;
	}
	public Symbols getJacobiAlgorithm() {
		return jacobiAlgorithm;
	}
		
}
