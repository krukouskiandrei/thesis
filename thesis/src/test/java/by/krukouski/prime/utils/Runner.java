package by.krukouski.prime.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Runner {
	
	public static void main(String args[]) throws Exception{
		ParserFile parserFile = new ParserFile();
		parserFile.writeNumbersInFile();
		/*try {
			File file = new File("test1.txt");
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write("This is ");
			fileWriter.write("a test");
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}

}
