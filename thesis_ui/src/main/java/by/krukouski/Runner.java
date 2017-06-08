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

	public static void main(String [] args) {
		
		PrimeNumberThread thread = new PrimeNumberThread();
		thread.start();
		
		try{
			Thread.currentThread().sleep(1000);
		} catch(InterruptedException e) {
			
		}
	
	}	
	
	
	
	
}
