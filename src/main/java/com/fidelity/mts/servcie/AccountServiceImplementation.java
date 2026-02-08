package com.fidelity.mts.servcie;
import java.math.BigDecimal;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fidelity.mts.dto.TransferRequest;
import com.fidelity.mts.entity.Account;
import com.fidelity.mts.enums.AccountStatus;
import com.fidelity.mts.exception.AccountNotActiveException;
import com.fidelity.mts.exception.AccountNotFoundException;
import com.fidelity.mts.repo.AccountRepo;
@Service
public class AccountServiceImplementation implements AccountService{
	
	@Autowired AccountRepo repo;
	
	@Override
	public String addAccount(Account act)
	{
		repo.save(act);
		return "Added Account with id: "+act.getId();
	}
	
	
	@Override
	public AccountStatus findByAccountStatus(Long id)  {
		
		Optional<Account> accountStatus = repo.findById(id);
		if(!accountStatus.isPresent()) {
			System.out.println("Account Not Found");
		}
		return accountStatus.get().getStatus();
	}
	public void credit(Account act, BigDecimal amt) {
		BigDecimal final_amt = act.getBalance().add(amt);
		act.setBalance(final_amt);
		Instant curr_time = Instant.now();
		act.setLastUpdated(curr_time);
	}
	public void debit(Account act, BigDecimal amt) {
		BigDecimal final_amt = act.getBalance().subtract(amt);
		act.setBalance(final_amt);
		Instant curr_time = Instant.now();
		act.setLastUpdated(curr_time);
	}
	
	@Override
	public String transferMoney(TransferRequest transferRequest, BigDecimal amount) {
		
		Optional<Account> fromAcc = repo.findById(transferRequest.getFromId());
		if(fromAcc.isEmpty()) {
			throw new AccountNotFoundException(fromAcc.get().getId());
		}
		
		Optional<Account> toAcc = repo.findById(transferRequest.getToId());
		if(!toAcc.isEmpty()) {
			throw new AccountNotFoundException(fromAcc.get().getId());
		}
		
		Account foundFromAcc = fromAcc.get();
		Account foundToAcc = toAcc.get();
		
		this.debit(foundFromAcc, amount);
		this.credit(foundToAcc, amount);
		
		repo.save(foundFromAcc);
		repo.save(foundFromAcc);
		
		return "Amount Transferred Successfully";
		
	}

}

