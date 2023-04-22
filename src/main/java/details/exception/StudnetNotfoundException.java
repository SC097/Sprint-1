package details.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_MODIFIED)
public class StudnetNotfoundException extends RuntimeException {
	public StudnetNotfoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public StudnetNotfoundException(String message) {
		super(message);
	}

}
