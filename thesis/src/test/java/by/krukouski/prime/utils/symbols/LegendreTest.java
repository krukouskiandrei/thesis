package by.krukouski.prime.utils.symbols;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LegendreTest {
	
	
	private Legendre legendre;
	
	public LegendreTest(){
		legendre = new Legendre(BigInteger.ONE);
	}
	
	public int calculateCurentSymbols(BigInteger p, BigInteger a){
		legendre.setP(p);
		return legendre.calculate(a);
	}
	
	@Test
	public void calculate(){
		Assert.assertEquals(calculateCurentSymbols(new BigInteger("11"), new BigInteger("11")), 0);
		Assert.assertEquals(calculateCurentSymbols(new BigInteger("11"), new BigInteger("12")), 1);
		Assert.assertEquals(calculateCurentSymbols(new BigInteger("11"), new BigInteger("121231231")), 0);
		Assert.assertEquals(calculateCurentSymbols(new BigInteger("1123"), new BigInteger("121231231")), -1);
		Assert.assertEquals(calculateCurentSymbols(new BigInteger("7"), new BigInteger("4")), 1);
		Assert.assertEquals(calculateCurentSymbols(new BigInteger("7"), new BigInteger("1")), 1);
		Assert.assertEquals(calculateCurentSymbols(new BigInteger("7"), new BigInteger("2")), 1);
		Assert.assertEquals(calculateCurentSymbols(new BigInteger("7"), new BigInteger("3")), -1);
		Assert.assertEquals(calculateCurentSymbols(new BigInteger("7"), new BigInteger("5")), -1);
		Assert.assertEquals(calculateCurentSymbols(new BigInteger("7"), new BigInteger("6")), -1);
	}
	
	

}
