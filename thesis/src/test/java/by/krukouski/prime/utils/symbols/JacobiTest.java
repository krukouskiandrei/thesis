package by.krukouski.prime.utils.symbols;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

public class JacobiTest {

	
	public int calculateCurentSymbols(BigInteger a, BigInteger p){
		return Jacobi.calculate(a, p);
	}
	
	@Test
	public void calculate(){
		Assert.assertEquals(calculateCurentSymbols(new BigInteger("7"), new BigInteger("15")), -1);
		Assert.assertEquals(calculateCurentSymbols(new BigInteger("219"), new BigInteger("383")), 1);
	}
	
	
}
