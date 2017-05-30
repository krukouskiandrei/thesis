package by.krukouski.thesisfront.dto;

import java.io.Serializable;
import java.math.BigInteger;

import by.krukouski.thesisfront.validator.BigNumberConstraint;
import by.krukouski.thesisfront.validator.DoubleNumberConstraint;

public class AlgorithmInfo implements Serializable {

	private static final long serialVersionUID = 8382927492947593153L;
	
	@BigNumberConstraint
	private BigInteger number;
	@DoubleNumberConstraint
	private Double probability;
	private String testName;
	private String jacobiAlgorithm;
	private Boolean allAlgorithms;
	
	public AlgorithmInfo() {}
	
	public BigInteger getNumber() {
		return number;
	}
	public void setNumber(BigInteger number) {
		this.number = number;
	}
	
	public Double getProbability() {
		return probability;
	}
	public void setProbability(Double probability) {
		this.probability = probability;
	}
	
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	
	public String getJacobiAlgorithm() {
		return jacobiAlgorithm;
	}
	public void setJacobiAlgorithm(String jacobiAlgorithm) {
		this.jacobiAlgorithm = jacobiAlgorithm;
	}
	
	public Boolean getAllAlgorithms() {
		return allAlgorithms;
	}
	public void setAllAlgorithms(Boolean allAlgorithms) {
		this.allAlgorithms = allAlgorithms;
	}
	
	@Override
    public boolean equals(Object object) {
        if(this == object){
            return true;
        }
        if(object == null || getClass() !=  object.getClass()){
            return false;
        }
        AlgorithmInfo algorithmInfo = (AlgorithmInfo) object;
        if(number != null ? !number.equals(algorithmInfo.getNumber()) : algorithmInfo.getNumber() != null){
        	return false;
        }
        if(probability != null ? !probability.equals(algorithmInfo.getProbability()) : algorithmInfo.getProbability() != null){
        	return false;
        }
        if(testName != null ? !testName.equals(algorithmInfo.getTestName()) : algorithmInfo.getTestName() != null){
        	return false;
        }
        if(jacobiAlgorithm != null ? !jacobiAlgorithm.equals(algorithmInfo.getJacobiAlgorithm()) : algorithmInfo.getJacobiAlgorithm() != null){
        	return false;
        }
        if(allAlgorithms != null ? !allAlgorithms.equals(algorithmInfo.getAllAlgorithms()) : algorithmInfo.getAllAlgorithms() != null){
        	return false;
        }
        return true;
	}
	
	@Override
	public int hashCode() {
		int hash = number != null ? number.hashCode() : 0;
		hash = hash*41 + (probability != null ? probability.hashCode() : 0);
		hash = hash*41 + (testName != null ? testName.hashCode() : 0);
		hash = hash*41 + (jacobiAlgorithm != null ? jacobiAlgorithm.hashCode() : 0);
		hash = hash*41 + (allAlgorithms != null ? allAlgorithms.hashCode() : 0);
		return hash;
	}
	
	@Override
	public String toString() {
		return "AlgotithmInfo [number=" + number + ", probability=" + probability + ", testName=" + testName + ", jacobiAlgorithm=" + jacobiAlgorithm + ", allAlgorithms=" + allAlgorithms + "]";
	}
}
