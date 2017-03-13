package thesis;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.SQLException;

import org.apache.commons.math3.primes.Primes;
import org.apache.commons.math3.util.ArithmeticUtils;
import org.apache.log4j.Logger;

//import by.krukouski.prime.algorithms.probability.SolovayStrassen;
//import by.krukouski.prime.utils.symbols.Jacobi;
//import by.krukouski.prime.utils.symbols.Legendre;
import by.krukouski.prime.algorithms.probability.SolovayStrassen;
public class log4jExample{

	   /* Get actual class name to be printed on */
	   static Logger log = Logger.getLogger(log4jExample.class.getName());
	   
	   public static void main(String[] args)throws IOException,SQLException{
	      log.debug("Hello this is a debug message");
	      log.info("Hello this is an info message");
	      System.out.println("Hi");
	      
	      /*BigInteger num = new BigInteger("12234253453453453453453453452342342342342342342342342342342342342342342342354235345345345345345345346");
	      System.out.println(num.bitLength());
	      BigInteger n1 = new BigInteger(new Integer(123456234).toString());
	      BigInteger n2 = new BigInteger(new Integer(123456*3).toString());
	      int result = ArithmeticUtils.gcd(n1.intValue(), n2.intValue());
	      System.out.println(n1 + "   " + n2);
	      System.out.println(result);
	      System.out.println(Integer.MAX_VALUE);
	      System.out.println(num.mod(new BigInteger("2")));
	      
	      BigInteger as = new BigInteger("2");
	      if(as.equals(new BigInteger(new Integer(2).toString()))){
	    	  System.out.println("_______@#@##@#@##");
	      }*/
	      
	      
	     /* int res = Legendre.calculate(new BigInteger("21"), new BigInteger("3"));*/
	      /*Legendre legendre = new Legendre(new BigInteger("11"));
	      int res = legendre.calculate(new BigInteger("11"));
	      System.out.println(res);*/
	      //System.out.println(Primes.primeFactors(345625));
	      //System.out.println(Jacobi.calculate(new BigInteger("7"), new BigInteger("15")));
	      System.out.println(SolovayStrassen.check(new BigInteger("20988936657440586486151264256610222593863911"), 9824));
	      
	   }
	}