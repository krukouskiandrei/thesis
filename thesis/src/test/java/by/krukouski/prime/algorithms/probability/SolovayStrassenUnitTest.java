package by.krukouski.prime.algorithms.probability;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

import by.krukouski.prime.algorithms.facades.SolovayStrassenFacades;

public class SolovayStrassenUnitTest {
	
	private static final String FILE_NAME = "prime_numbers.txt";
	
	private BigInteger getNumber(Scanner scanner) {
		return new BigInteger(scanner.nextLine());
	}
	
	private File getFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return new File(classLoader.getResource(FILE_NAME).getFile());
	}
	
	private Scanner getScanner(File file) throws FileNotFoundException {
		return new Scanner(file);
	}
	
	private void closeScanner(Scanner scanner) {
		scanner.close();
	}
	
	@Test
	public void checkPrimeNumberTest() throws Exception{
		Scanner reader = getScanner(getFile());
		while(reader.hasNextLine()){
			BigInteger number = getNumber(reader);
			Assert.assertTrue(SolovayStrassenFacades.checkNumberForTest(number, 10));
		}
	}

}
