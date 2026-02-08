package com.fidelity.mts.exception;
 
public class DuplicateTransferException extends RuntimeException {
	private static final long serialVersionUID = 1L;
 
	
	public DuplicateTransferException(String idempotencyKey) {
		super("Duplicate transfer detected for transaction id: "+ idempotencyKey);
	}
 
}