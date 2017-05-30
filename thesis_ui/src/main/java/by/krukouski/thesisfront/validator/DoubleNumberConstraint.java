package by.krukouski.thesisfront.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = DoubleNumberValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DoubleNumberConstraint {

	String message() default "Invalid number format";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
}
