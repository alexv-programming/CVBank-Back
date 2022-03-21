package cvBank.back.employer.dto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@ResponseStatus(code = HttpStatus.CONFLICT)
public class EmployerNotFoundException extends RuntimeException {/**
	 * 
	 */
	private static final long serialVersionUID = -1507153963651745342L;

	public EmployerNotFoundException(String login)  {
		super("User " + login +" not founde");
	}
}