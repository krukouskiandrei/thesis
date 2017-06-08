package by.krukouski;

import java.math.BigInteger;

import org.apache.commons.math3.linear.BlockRealMatrix;

import by.krukouski.core.prime.algorithms.impl.SolovayStrassen;
import by.krukouski.core.prime.exceptions.SymbolsException;
import by.krukouski.core.prime.symbols.impl.LebesgueJacobiAlgorithm;
import by.krukouski.core.prime.symbols.impl.MLogNJacobiAlgorithm;
import by.krukouski.core.prime.symbols.impl.OrdinaryJacobiAlgorithm;
import by.krukouski.core.utils.MyMatrix;
import by.krukouski.thesisfront.dto.PrimeNumberInfo;

public class Runner {

	int a = 8;
	int b = 5;
	int x = 0;
	int y = 0;
	
	public static void main(String [] args) {
		/*MLogNJacobiAlgorithm mLogNJacobiAlgorithm = new MLogNJacobiAlgorithm();
		try {
			int result = mLogNJacobiAlgorithm.calculate(new BigInteger("12345"), new BigInteger("2342347"));
			System.out.println(result);
		}catch(SymbolsException e) {
			
		}*/
		
		/*PrimeNumberInfo primeNumberInfo = new PrimeNumberInfo();
		
		primeNumberInfo.setPrimeNumber(new BigInteger("134018557978203030902914228584548574807340677870227093875548414731838242033808783440682895571"));
		primeNumberInfo.setProbability(0.75, 2);
		MLogNJacobiAlgorithm mLogNJacobiAlgorithm = new MLogNJacobiAlgorithm();
		primeNumberInfo.setJacobiAlgorithm(mLogNJacobiAlgorithm);
		SolovayStrassen solovayStrassen = new SolovayStrassen();
		try{
			boolean result = solovayStrassen.checkNumber(primeNumberInfo);
			System.out.println(result);
		} catch(Exception e) {
			
		}*/
		
		BlockRealMatrix matrix1 = new BlockRealMatrix(2, 2);
		matrix1.addToEntry(0, 0, 123);
		matrix1.addToEntry(0, 1, 321);
		matrix1.addToEntry(1, 0, 456);
		matrix1.addToEntry(1, 1, 654);
		
		BlockRealMatrix matrix2 = new BlockRealMatrix(2, 2);
		matrix2.addToEntry(0, 0, 567);
		matrix2.addToEntry(0, 1, 876);
		matrix2.addToEntry(1, 0, 987);
		matrix2.addToEntry(1, 1, 357);
	
		MyMatrix myMatrix1 = new MyMatrix();
		myMatrix1.setA1(new BigInteger("123"));
		myMatrix1.setA2(new BigInteger("321"));
		myMatrix1.setA3(new BigInteger("456"));
		myMatrix1.setA4(new BigInteger("654"));
		
		MyMatrix myMatrix2 = new MyMatrix();
		myMatrix2.setA1(new BigInteger("567"));
		myMatrix2.setA2(new BigInteger("876"));
		myMatrix2.setA3(new BigInteger("987"));
		myMatrix2.setA4(new BigInteger("357"));

		System.out.println(matrix1.multiply(matrix2));
		
		System.out.println(myMatrix1.calculate(myMatrix2));
		
		
	}
	
	
	
	
	
}
