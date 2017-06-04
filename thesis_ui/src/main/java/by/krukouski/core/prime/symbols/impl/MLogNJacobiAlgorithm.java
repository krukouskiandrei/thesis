package by.krukouski.core.prime.symbols.impl;

import java.math.BigInteger;

import org.apache.commons.math3.linear.BlockRealMatrix;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import by.krukouski.core.prime.exceptions.SymbolsException;
import by.krukouski.core.prime.symbols.Symbols;

@Component("mlognJacobiAlgorithm")
public class MLogNJacobiAlgorithm implements Symbols {

	private static Logger log = Logger.getLogger(MLogNJacobiAlgorithm.class);
	
	private static final BigInteger TWO = new BigInteger("2");
	private static final BigInteger EIGHT = new BigInteger("8");
	private static final BigInteger THREE = new BigInteger("3");
	private static final BigInteger NEGATIVEONE = new BigInteger("-1");
	private static final BigInteger FOUR = new BigInteger("4");
	private static final BigInteger FIVE = new BigInteger("5");
	
	//J(b,a)
	public int calculate(BigInteger b, BigInteger a) throws SymbolsException {
		//b > 0, a > 0 and a odd
		if(a.remainder(TWO).compareTo(BigInteger.ZERO) == 0 || a.compareTo(BigInteger.ZERO) < 0 || b.compareTo(BigInteger.ZERO) < 0) {
			log.info("second number shouldn't be even or negative");
			throw new SymbolsException();			
		}
				
		//v(a) = 0 and v(b) > 0
		if(secondValuation(a) == 0 && secondValuation(b) != 0) {
			BigInteger s = BigInteger.ZERO;
			int j = secondValuation(b);
			while(((TWO.pow(j)).multiply(a)).compareTo(b) != 0) {
				int k;
				if(secondValuation(b) > (b.bitLength()/3)) {
					k = secondValuation(b);
				}else {
					k = b.bitLength()/3;
				}
				HalfBinaryJacobi halfBinaryJacobi = new HalfBinaryJacobi(a, b, k);
				BigInteger sHatch = halfBinaryJacobi.getS();
				j = halfBinaryJacobi.getJ().intValue();
				BlockRealMatrix RR = halfBinaryJacobi.getR();
				s = (s.add(sHatch)).mod(TWO);
				BigInteger RR11 = new BigInteger(String.valueOf(new Double(RR.getEntry(0, 0)).intValue()));
				BigInteger RR12 = new BigInteger(String.valueOf(new Double(RR.getEntry(0, 1)).intValue()));
				BigInteger RR21 = new BigInteger(String.valueOf(new Double(RR.getEntry(1, 0)).intValue()));
				BigInteger RR22 = new BigInteger(String.valueOf(new Double(RR.getEntry(1, 1)).intValue()));
				a = (TWO.pow(-2*j)).multiply((RR11.multiply(a)).add(RR12.multiply(b)));
				b = (TWO.pow(-2*j)).multiply((RR21.multiply(a)).add(RR22.multiply(b)));
				j = secondValuation(b);				
			}
			if(a.compareTo(BigInteger.ONE) == 0) {
				return NEGATIVEONE.pow(s.intValue()).intValue();
			} else {
				return 0;
			}
		}
		throw new SymbolsException();
	}
	
	//v(a)
	private int secondValuation(BigInteger a) {
		int result = 0;
		//a = 0
		if(a.compareTo(BigInteger.ZERO) == 0) {
			//result = +infinity = -1
			result = -1;
			return result;
		}
		//a % 2 = 0
		while(a.mod(TWO).compareTo(BigInteger.ZERO) == 0) {
			a = a.divide(TWO);
			result++;
		}
		return result;
	}
	
	private class BinaryDividePos {
		
		private BigInteger q;
		private BigInteger r;
		
		public BinaryDividePos(BigInteger a, BigInteger b) {
			//v(a) = 0 and v(b) > 0
			if(secondValuation(a) == 0 && secondValuation(b) != 0) {
				int j = secondValuation(b);
				//q = (-a)/(b/2^j) (mod 2^j+1)
				this.q = ((a.negate()).divide(b.divide(TWO.pow(j)))).mod(TWO.pow(j+1));
				//r = a + qb/2^j
				this.r = a.add((this.q.multiply(b)).divide(TWO.pow(j)));				
			}
		}
		
		public BigInteger getQ() {
			return q;
		}
		
		public BigInteger getR() {
			return r;
		}
	}
	
	
	private class HalfBinaryJacobi {
		
		private BigInteger s;
		private BigInteger j;
		private BlockRealMatrix R = new BlockRealMatrix(2, 2);
		
		public HalfBinaryJacobi(BigInteger a, BigInteger b, int k) {
			//v(a) = 0 and v(b) > 0
			if(secondValuation(a) == 0 && secondValuation(b) != 0) {
				//v(b) > k
				if(secondValuation(b) > k || secondValuation(b) == -1) {
					this.s = BigInteger.ZERO;
					this.j = BigInteger.ZERO;
					this.R.addToEntry(0, 0, 1);
					this.R.addToEntry(0, 1, 0);
					this.R.addToEntry(1, 0, 0);
					this.R.addToEntry(1, 1, 1);
				} else {
					int k1 = k/2;
					//a1 = a (mod 2^(2*k1 + 2))
					BigInteger a1 = a.mod(TWO.pow(2*k1 + 2));
					//b1 = b (mod 2^(2*k1 + 2))
					BigInteger b1 = b.mod(TWO.pow(2*k1 + 2));
					HalfBinaryJacobi halfBinaryJacobi = new HalfBinaryJacobi(a1, b1, k1);
					BigInteger s1 = halfBinaryJacobi.getS();
					BigInteger j1 = halfBinaryJacobi.getJ();
					BlockRealMatrix RR = halfBinaryJacobi.getR();
					BigInteger RR11 = new BigInteger(String.valueOf(new Double(RR.getEntry(0, 0)).intValue()));
					BigInteger RR12 = new BigInteger(String.valueOf(new Double(RR.getEntry(0, 1)).intValue()));
					BigInteger RR21 = new BigInteger(String.valueOf(new Double(RR.getEntry(1, 0)).intValue()));
					BigInteger RR22 = new BigInteger(String.valueOf(new Double(RR.getEntry(1, 1)).intValue()));
					BigInteger aHatch = (TWO.pow(-2*j1.intValue())).multiply((RR11.multiply(a)).add(RR12.multiply(b)));
					BigInteger bHatch = (TWO.pow(-2*j1.intValue())).multiply((RR21.multiply(a)).add(RR22.multiply(b)));
					int j0 = secondValuation(bHatch);
					if(j0 + j1.intValue() > k) {
						this.s = s1;
						this.j = j1;
						this.R = RR;
					} else {
						//s0 = j0(a'^2 -1)/8 (mod 2)
						BigInteger s0 = (((aHatch.pow(2).subtract(BigInteger.ONE)).multiply(new BigInteger(String.valueOf(j0)))).divide(EIGHT)).mod(TWO);
						BinaryDividePos binaryDividePos = new BinaryDividePos(aHatch, bHatch);
						BigInteger q = binaryDividePos.getQ();
						BigInteger r = binaryDividePos.getR();
						//b'' = b'/2^j0
						BigInteger bDoubleHatch = bHatch.divide(TWO.pow(j0));
						BlockRealMatrix Q = new BlockRealMatrix(2, 2);
						BigInteger a2;
						BigInteger b2;
						BigInteger m;
						if(j0 == 1 && q.compareTo(THREE) == 0) {
							//d = a' - b''
							BigInteger d = aHatch.subtract(bDoubleHatch);
							//m = min(v(d)/2, k-j1)
							if(secondValuation(d)/2 < k - j1.intValue()) {
								m = new BigInteger(String.valueOf(secondValuation(d)/2));
							}else {
								m = new BigInteger(String.valueOf(k - j1.intValue()));
							}
							//c = (d - (-1)^m *d / 4^m)/5
							BigInteger c = (d.subtract(((NEGATIVEONE.pow(m.intValue())).multiply(d)).divide(FOUR.pow(m.intValue())))).divide(FIVE);
						    //s0 = s0 + m(a'-1)/2 (mod 2)
							s0 = (s0.add((m.multiply(aHatch.subtract(BigInteger.ONE))).divide(TWO))).mod(TWO);
						    //a2 = a' - 4c
						    a2 = aHatch.subtract(FOUR.multiply(c));
						    b2 = TWO.multiply(bDoubleHatch.add(c));
						    Q.addToEntry(0, 0, (((FOUR.pow(m.intValue())).add(FOUR.multiply(NEGATIVEONE.pow(m.intValue())))).divide(FIVE)).intValue());
						    Q.addToEntry(0, 1, ((TWO.multiply((FOUR.pow(m.intValue())).subtract(NEGATIVEONE.pow(m.intValue())))).divide(FIVE)).intValue());
						    Q.addToEntry(1, 0, ((TWO.multiply((FOUR.pow(m.intValue())).subtract(NEGATIVEONE.pow(m.intValue())))).divide(FIVE)).intValue());
						    Q.addToEntry(1, 1, (((FOUR.pow(m.intValue())).add(NEGATIVEONE.pow(m.intValue()))).divide(FIVE)).intValue());
						} else {
							s0 = (s0.add(((aHatch.subtract(BigInteger.ONE)).multiply(bDoubleHatch.subtract(BigInteger.ONE))).divide(FOUR))).mod(TWO);
							a2 = bDoubleHatch;
							b2 = r.divide(TWO.pow(j0));
							Q.addToEntry(0, 0, 0);
							Q.addToEntry(0, 1, TWO.pow(j0).intValue());
							Q.addToEntry(1, 0, TWO.pow(j0).intValue());
							Q.addToEntry(1, 1, q.intValue());
							m = new BigInteger(String.valueOf(j0));
						}
						
						s0 = ((s0.add(((a2.pow(2)).subtract(BigInteger.ONE)).multiply(new BigInteger(String.valueOf(j0))))).divide(EIGHT)).mod(TWO);
						int k2 = k - (m.intValue() + j1.intValue());
						HalfBinaryJacobi halfBinaryJacobi2 = new HalfBinaryJacobi(a2.mod(TWO.pow(2*k2 + 2)), b2.mod(TWO.pow(2*k2 + 2)), k2);
						BigInteger s2 = halfBinaryJacobi2.getS();
						BigInteger j2 = halfBinaryJacobi2.getJ();
						BlockRealMatrix S = halfBinaryJacobi2.getR();
						this.s = ((s0.add(s1)).add(s2)).mod(TWO);
						this.j = (j1.add(j2)).add(m);
						this.R = (S.multiply(Q)).multiply(RR);						
					}
				}
			}
		}
		
		public BigInteger getS() {
			return s;
		}
		public BigInteger getJ() {
			return j;
		}
		public BlockRealMatrix getR() {
			return R;
		}
		
	}
}
