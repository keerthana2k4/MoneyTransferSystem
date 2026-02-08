package com.fidelity.mts.servcie;



import java.math.BigDecimal;

import com.fidelity.mts.dto.TransferRequest;
import com.fidelity.mts.entity.Account;
import com.fidelity.mts.enums.AccountStatus;


public interface AccountService {
	
	String addAccount(Account act);
	AccountStatus findByAccountStatus(Long id);
	String transferMoney(TransferRequest transferRequest, BigDecimal amount);

}
