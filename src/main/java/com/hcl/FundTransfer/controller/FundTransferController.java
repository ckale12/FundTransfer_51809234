package com.hcl.FundTransfer.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.FundTransfer.entity.Transaction;
import com.hcl.FundTransfer.repository.FundTransferRepository;
import com.hcl.FundTransfer.service.FundTransferService;

@RestController
public class FundTransferController {
	
	@Autowired
	FundTransferService fundTransferService;
	
	/**This method is use to add new transaction in database
	 * @param transaction is use to add new transaction in database
	 * @return is returning transaction which is added in database
	 * @throws Exception
	 */
	@PostMapping("/fundTransfer/{id}")
	public ResponseEntity<Transaction> craeteFundTransfer(@RequestBody Transaction transaction ,@PathVariable("id") int userId) throws Exception {
	
		if(transaction.getAccountType()==null||Objects.isNull(transaction.getAmount())||Objects.isNull(transaction.getReceiverAccountNo())||
				Objects.isNull(transaction.getSenderAccountNo())||Objects.isNull(transaction.getUserId())) {
			throw new Exception("Enter all details");
		}
	   else if(userId==transaction.getReceiverAccountNo()) {
		 throw new Exception("Receiver account number should be different");
	    }
	   
		 return new ResponseEntity<Transaction> (fundTransferService.craeteFundTransfer(transaction),HttpStatus.OK);	
	}

}
