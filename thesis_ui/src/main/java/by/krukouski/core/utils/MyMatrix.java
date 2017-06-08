package by.krukouski.core.utils;

import java.math.BigInteger;

public class MyMatrix {
	
	private BigInteger a1;
	private BigInteger a2;
	private BigInteger a3;
	private BigInteger a4;
	
	public MyMatrix() {
		
	}
	
	public void setA1(BigInteger a1) {
		this.a1 = a1;
	}
	public BigInteger getA1() {
		return a1;
	}
	
	public void setA2(BigInteger a2) {
		this.a2 = a2;
	}
	public BigInteger getA2() {
		return a2;
	}
	
	public void setA3(BigInteger a3) {
		this.a3 = a3;
	}
	public BigInteger getA3() {
		return a3;
	}
	
	public void setA4(BigInteger a4) {
		this.a4 = a4;
	}
	public BigInteger getA4() {
		return a4;
	}
	
	public MyMatrix calculate(MyMatrix b) {
		MyMatrix result = new MyMatrix();
		
		result.setA1((this.a1.multiply(b.getA1())).add(this.a2.multiply(b.getA3())));
		result.setA2((this.a1.multiply(b.getA2())).add(this.a2.multiply(b.getA4())));
		result.setA3((this.a3.multiply(b.getA1())).add(this.a4.multiply(b.getA3())));
		result.setA4((this.a3.multiply(b.getA2())).add(this.a4.multiply(b.getA4())));
		
		return result;
		
	}
	
	@Override
	public String toString() {
		return "{" + this.a1 + ", " + this.a2 + "}, {" + this.a3 + ", " + this.a4 + "}";
	}
}
