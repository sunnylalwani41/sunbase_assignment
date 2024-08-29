package sunbase.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(AdminException.class)
	public ResponseEntity<MyErrorDetails> adminExceptionHandler(AdminException adminException, WebRequest webRequest){
		MyErrorDetails err= new MyErrorDetails();
		err.setLocalDateTime(LocalDateTime.now());
		err.setMessage(adminException.getMessage());
		err.setDetails(webRequest.getDescription(false));
	
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<MyErrorDetails> customerExceptionHandler(CustomerException customerException, WebRequest webRequest){
		MyErrorDetails err= new MyErrorDetails();
		err.setLocalDateTime(LocalDateTime.now());
		err.setMessage(customerException.getMessage());
		err.setDetails(webRequest.getDescription(false));
	
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> otherExceptionHandler(Exception se, WebRequest req){
		MyErrorDetails err= new MyErrorDetails();
		err.setLocalDateTime(LocalDateTime.now());
		err.setMessage(se.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
