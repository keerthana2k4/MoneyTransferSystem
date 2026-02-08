package com.fidelity.mts.exception;
 

public class AccountNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public AccountNotFoundException(String message) {
		super(message);
	}
	public AccountNotFoundException(Long accountId) {
		super("Account with ID "+accountId+" is not found");
	}
}