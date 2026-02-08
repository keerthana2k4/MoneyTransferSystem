package com.fidelity.mts.exception;
 
import java.math.BigDecimal;
 
 
public class InsufficientBalanceException extends RuntimeException {
	private static final long serialVersionUID = 1L;
 
	public InsufficientBalanceException(String message) {
		super(message);
	}
	public InsufficientBalanceException(BigDecimal balance, BigDecimal amount) {
		super("Insufficient balance. Available: "+balance+", Required: "+amount);
	}
 
}