package by.krukouski.thesisfront.validator;

import java.math.BigInteger;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BigNumberValidator implements ConstraintValidator<BigNumberConstraint, BigInteger> {
	
	public void initialize(BigNumberConstraint bigNumber) {
		
	}
	
	public boolean isValid(BigInteger number, ConstraintValidatorContext ctx) {
		if(number == null){
			return false;
		}
		return true;
	}
}
