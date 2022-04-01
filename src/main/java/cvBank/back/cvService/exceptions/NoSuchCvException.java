package cvBank.back.cvService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@ResponseStatus(code = HttpStatus.NOT_FOUND)

public class NoSuchCvException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2486023194074263420L;
	public NoSuchCvException(String cvId){
		super("cv " + cvId+" not found");
	}

}
