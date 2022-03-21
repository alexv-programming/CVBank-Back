package cvBank.back.employee.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@ResponseStatus(code = HttpStatus.CONFLICT)

public class EmployeeExistsException extends RuntimeException {/**
	 * 
	 */
	private static final long serialVersionUID = 3818417819445759116L;
	
	
	public EmployeeExistsException(String login) {
		super("Employee " + login +" exists");
	}

}
