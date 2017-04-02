package thesis;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.math3.primes.Primes;
import org.apache.commons.math3.util.ArithmeticUtils;
import org.apache.log4j.Logger;

import by.krukouski.prime.algorithms.facades.MillerRabinFacades;
import by.krukouski.prime.algorithms.facades.SolovayStrassenFacades;
//import by.krukouski.prime.algorithms.probability.SolovayStrassen;
//import by.krukouski.prime.utils.symbols.Jacobi;
//import by.krukouski.prime.utils.symbols.Legendre;
import by.krukouski.prime.algorithms.probability.SolovayStrassen;
import by.krukouski.prime.utils.symbols.TimeTracker;
public class log4jExample{

	   /* Get actual class name to be printed on */
	   static Logger log = Logger.getLogger(log4jExample.class);
	   
	   public static void main(String[] args)throws IOException,SQLException, Exception{
	     /* log.debug("Hello this is a debug message");
	      log.info("Hello this is an info message");
	      System.out.println("Hi");*/
	      
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
	      System.out.println(SolovayStrassenFacades.checkNumber(new BigInteger("101"), 23));
		   System.out.println(MillerRabinFacades.checkNumber(new BigInteger("101"), 23));
		   System.out.println(TimeTracker.getInstance().getTracker());
		   /*List<BigInteger> array = new ArrayList<BigInteger>();
		   boolean goout = false;
		   int iteration = 0;
		   BigInteger n = new BigInteger("223");
		   Random rnd = new Random();
		   BigInteger r;
		   array.add(n);
		   while(!goout && iteration < 3){
			   do {
				   r = new BigInteger(n.bitLength(), rnd);
			   } while (r.compareTo(n) >= 0);
			   if(array.contains(r)){
				   goout = false;
				   continue;
			   }
			   iteration++;
			   array.add(r);
		   }
	      System.out.println(array);
	      System.out.println(iteration);*/
		   /*BigInteger num = new BigInteger("22");
		   int count = 0;
		   while(num.remainder(new BigInteger("2")).compareTo(BigInteger.ZERO) == 0){
			   System.out.println(num);
			   num = num.divide(new BigInteger("2"));
			   count++;
		   }
		   System.out.println(num);
		   System.out.println(count);*/
		   
		  /* LocalDateTime currentTime1 = LocalDateTime.now();
		   System.out.println("Current DateTime: " + currentTime1);
		   Thread.sleep(1322);
		   LocalDateTime currentTime2 = LocalDateTime.now();
		   System.out.println("Current DateTime: " + currentTime2);
		   System.out.println("Current DateTime nono: " + currentTime2.getNano());
		   //LocalDateTime result = currentTime2.minus(Period.of(currentTime1.getYear(), currentTime1.getMonthValue(), currentTime1.getDayOfMonth()));
		   		   
		   Duration result = Duration.between(currentTime1, currentTime2);
		   System.out.println("Current DateTime between " + result.toMillis());
		   
		   class Local {};
		   String name = Local.class.getEnclosingMethod().getName();
		   System.out.println(name);
		   String name2 = new Object(){}.getClass().getEnclosingMethod().getName();
		   System.out.println(name2);
		   Map<String, Integer> map = new HashMap<String, Integer>();
		   map.put("S1", 1);
		   map.put("S2", 2);
		   map.put("S3", 3);
		   System.out.println(map);
		   map.put("S1", 11);
		   map.put("S2", 22);
		   System.out.println(map);*/
		   
	   }
	}