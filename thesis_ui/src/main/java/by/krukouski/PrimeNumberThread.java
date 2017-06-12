package by.krukouski;

import java.math.BigInteger;

import by.krukouski.core.prime.algorithms.impl.MillerRabin;
import by.krukouski.core.prime.exceptions.ProbabilityAlgorithmException;
import by.krukouski.core.prime.exceptions.SymbolsException;
import by.krukouski.thesisfront.dto.PrimeNumberInfo;

public class PrimeNumberThread extends Thread {
	
	private BigInteger primeNumber = new BigInteger("1340185579782030309029142285845485748073406778702270938755484147318382420338087834406828955714187005654640257038495796545155402280055987076251704557994637589726712709889312042801858044039590155407650471667907995888292123909278046563998441725881316702608454953284969473141146885140822683049274853701491");
	private MillerRabin millerRabin = new MillerRabin();
	private static final BigInteger TWO = new BigInteger("2");
	private static final BigInteger TEN = new BigInteger("10");
	private static final BigInteger FIVE = new BigInteger("5");
	
	public PrimeNumberThread() {
		
	}
	
	
	
	public PrimeNumberThread(String threadName) {
		super(threadName);
		System.out.println(threadName);
		start();
	}
	
	public void run() {
		BigInteger currentPrimeNumber;
		PrimeNumberInfo primeNumberInfo = new PrimeNumberInfo();
		primeNumberInfo.setProbability(0.75, 4);
		currentPrimeNumber = primeNumber.add(TWO);
		millerRabin.setFeatureToggleTimeEnable(false);
		while(true) {
			currentPrimeNumber = currentPrimeNumber.add(TWO);
			if(currentPrimeNumber.mod(TEN).compareTo(FIVE) != 0) {
				primeNumberInfo.setPrimeNumber(currentPrimeNumber);
				
				try {
					boolean result = millerRabin.checkNumber(primeNumberInfo);
					if(result) {
						this.primeNumber = currentPrimeNumber;
					}
				} catch(ProbabilityAlgorithmException e) {
					System.out.println("Errrrrrosfjlksf");
				}
				
			}
			
			
		}
	}
	
	public BigInteger getPrimeNumber() {
		return primeNumber;
	}
	
	

}
