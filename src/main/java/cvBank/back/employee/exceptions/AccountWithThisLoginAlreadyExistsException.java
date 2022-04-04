package cvBank.back.employee.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@ResponseStatus(code = HttpStatus.CONFLICT)

public class AccountWithThisLoginAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5727305465432605952L;
	
	public AccountWithThisLoginAlreadyExistsException(String login) {
		super("Account with " + login +" already exists");
	}

}
