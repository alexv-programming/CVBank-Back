package cvBank.back.employer.dto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class WrongPasswordException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3492923435949539409L;

	public WrongPasswordException() {
		super("wrong password");
	}
}
