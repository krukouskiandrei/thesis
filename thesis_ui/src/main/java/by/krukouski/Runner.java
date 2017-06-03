package by.krukouski;

public class Runner {

	public static void main(String [] args) {
		double b = 1/(1-0.45);
		double a = 2;
		double result = Math.log(b)/Math.log(a);
		System.out.println(result);
		int fin = (int) result;
		System.out.println(fin);
	}
	
}
