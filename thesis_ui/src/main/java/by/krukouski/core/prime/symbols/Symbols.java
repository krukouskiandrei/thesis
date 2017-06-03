package by.krukouski.core.prime.symbols;

import java.math.BigInteger;

import by.krukouski.core.prime.exceptions.SymbolsException;

public interface Symbols {

	public int calculate(BigInteger a, BigInteger p) throws SymbolsException;
	
}
