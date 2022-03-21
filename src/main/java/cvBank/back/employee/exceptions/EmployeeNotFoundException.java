package cvBank.back.employee.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@ResponseStatus(code = HttpStatus.NOT_FOUND)

public class EmployeeNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7652808138363855324L;


	public EmployeeNotFoundException(String login) {
		super("User " + login + " not found");

	}
}
