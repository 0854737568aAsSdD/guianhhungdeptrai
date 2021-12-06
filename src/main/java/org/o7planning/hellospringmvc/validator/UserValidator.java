package org.o7planning.hellospringmvc.validator;

import org.o7planning.hellospringmvc.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		if(user.getName() == null || user.getName().length() == 0)
		{
			errors.rejectValue("name", "field.required");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", "field.required");
        if(user.getPwd().length()<6 || user.getPwd().length()>=12)
        {
			errors.rejectValue("pwd", "password.invalid");

        }
	}

}
