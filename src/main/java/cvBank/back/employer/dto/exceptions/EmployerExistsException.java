package cvBank.back.employer.dto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@ResponseStatus(code = HttpStatus.CONFLICT)
public class EmployerExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8046745034163003426L;

	public EmployerExistsException(String login)  {
		super("User " + login +" exists");
	}
}
