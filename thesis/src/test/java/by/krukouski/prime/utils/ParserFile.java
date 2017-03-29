package by.krukouski.prime.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class ParserFile {
	
	private static final String INPUT_FILE_NAME = "numbers.txt";
	private static final String OUTPUT_FILE_NAME = "prime_numbers.txt";
	
	private BigInteger getNumber(Scanner scanner) {
		return new BigInteger(scanner.next());
	}
	
	private File getFile(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		return new File(classLoader.getResource(fileName).getFile());
	}
	
	private Scanner getScanner(File file) throws FileNotFoundException {
		return new Scanner(file);
	}
	
	private void closeScanner(Scanner scanner) {
		if(scanner != null){
			scanner.close();
		}
	}
	
	private FileWriter getFileWriter(String fileName) throws IOException{
		return new FileWriter(fileName);
	}
	
	private BufferedWriter getBufferdWriter(FileWriter fileWriter){
		return new BufferedWriter(fileWriter);
	}
	
	private void writeNumber(FileWriter fileWriter, BigInteger number) throws IOException{
		fileWriter.write(number.toString() + "\n");
	}
	private void closeFileWriter(FileWriter fileWriter) throws IOException{
		if(fileWriter != null){
			fileWriter.close();
		}
	}
	private void closeBufferedWriter(BufferedWriter bufferedWriter) throws IOException{
		if(bufferedWriter != null){
			bufferedWriter.close();
		}
	}
	public void printNumbers() throws Exception{
		Scanner scanner = getScanner(getFile(INPUT_FILE_NAME));
		while(scanner.hasNext()){
			BigInteger number = getNumber(scanner);
			System.out.print(number.toString() + "\n");
		}
		closeScanner(scanner);
	}

	public void writeNumbersInFile() throws Exception{
		

		Scanner reader = getScanner(getFile(INPUT_FILE_NAME));
		File file = new File(OUTPUT_FILE_NAME);
		FileWriter fileWriter = new FileWriter(file);
		while(reader.hasNext()){
			BigInteger number = getNumber(reader);
			writeNumber(fileWriter, number);
		}
		fileWriter.flush();
		fileWriter.close();

				//
		/*FileWriter fileWriter = getFileWriter(OUTPUT_FILE_NAME);
		BufferedWriter writer = getBufferdWriter(fileWriter);
		writer.write("Fuck");
		*//*while(reader.hasNext()){
			BigInteger number = getNumber(reader);
			writeNumber(writer, number);
		}*/
		//closeFileWriter(fileWriter);
		//closeBufferedWriter(writer);
	}
	
	
	

}
