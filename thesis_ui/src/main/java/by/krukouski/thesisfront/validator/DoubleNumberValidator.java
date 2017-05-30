package by.krukouski.thesisfront.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DoubleNumberValidator implements ConstraintValidator<DoubleNumberConstraint, Double> {
	
	public void initialize(DoubleNumberConstraint doubleNumber) {
		
	}
	
	public boolean isValid(Double number, ConstraintValidatorContext ctx) {
		if(number == null){
			return false;
		}
		if(number > 1 || number < 0){
			return false;
		}
		return true;
	}

}
