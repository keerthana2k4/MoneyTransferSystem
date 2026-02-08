package com.fidelity.mts.exception;
 
/**
* This will be the Exception thrown when an account is LOCKED or CLOSED
*/
 
public class AccountNotActiveException extends RuntimeException {
	private static final long serialVersionUID = 1L;
 
	public AccountNotActiveException(String message) {
		super(message);
	}
	public AccountNotActiveException(Long accountId, String status) {
		super("Account with ID "+accountId+" is "+status+" and cannot perform transactions.");
	}
 
}