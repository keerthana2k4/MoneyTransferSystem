package com.fidelity.mts.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fidelity.mts.dto.TransferRequest;
import com.fidelity.mts.dto.TransferResponse;
import com.fidelity.mts.servcie.TransferService;
import com.fidelity.mts.entity.TransactionLog;

@RestController
@RequestMapping("/transfer")
public class TransferController {
	
	@Autowired 
	TransferService service;
	@PutMapping("/transfers")
	
	public ResponseEntity<TransferResponse> findByAccountStatus(@RequestBody TransferRequest transferRequest){
		return ResponseEntity.status(HttpStatus.OK).body(service.transferMoney(transferRequest));
    }
	
	@GetMapping("/{id}/transactions")
	public ResponseEntity<List<TransactionLog>> getTransactions(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(service.getTransaction(id));
	}
	
//	@GetMapping("/{id}/transactions/sent")
//	public ResponseEntity<List<TransactionLog>> getSentTransactions(@PathVariable Long id){
//		return ResponseEntity.status(HttpStatus.OK).body(service.findByFromAccountId(id));
//	}
//	
//	@GetMapping("/{id}/transactions/received")
//	public ResponseEntity<List<TransactionLog>> getReceivedTransactions(@PathVariable Long id){
//		return ResponseEntity.status(HttpStatus.OK).body(service.findByToAccountId(id));
//	}

}
