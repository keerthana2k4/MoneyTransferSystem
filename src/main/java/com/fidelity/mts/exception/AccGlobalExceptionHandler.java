package com.fidelity.mts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
 
//@RestControllerAdvice
@ControllerAdvice
public class AccGlobalExceptionHandler {
	@ExceptionHandler(value=AccountNotFoundException.class)
	public ResponseEntity<String> accNotFound(AccountNotFoundException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
 
    @ExceptionHandler(AccountNotActiveException.class)
    public ResponseEntity<String> handleNotActive(AccountNotActiveException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
 
    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<String> handleInsufficient(InsufficientBalanceException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
 
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArg(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
 
}


