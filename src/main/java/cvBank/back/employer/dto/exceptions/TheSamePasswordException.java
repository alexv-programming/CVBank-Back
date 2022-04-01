package cvBank.back.employer.dto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;


@ResponseStatus(code = HttpStatus.CONFLICT)
public class TheSamePasswordException extends RuntimeException {/**
	 * 
	 */
	private static final long serialVersionUID = 6644401847229350175L;

	public TheSamePasswordException() {
		super("this is the same password"); 
	}
}
