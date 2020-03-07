package uk.co.aaditech.validation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import uk.co.aaditech.validation.entities.UserNotBlank;

import javax.validation.Validation;
import javax.validation.Validator;

@SpringBootApplication
public class ValidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ValidationApplication.class, args);
		Validator validator = Validation.buildDefaultValidatorFactory()
				.getValidator();
		UserNotBlank user = new UserNotBlank(" ");
		validator.validate(user)
				.stream()
				.forEach(violation -> System.out.println(violation.getMessage()));
	}

}
