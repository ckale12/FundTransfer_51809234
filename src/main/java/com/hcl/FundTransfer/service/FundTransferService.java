package com.hcl.FundTransfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.FundTransfer.entity.Account;
import com.hcl.FundTransfer.entity.Transaction;
import com.hcl.FundTransfer.repository.AccountRepository;
import com.hcl.FundTransfer.repository.FundTransferRepository;



@Service
public class FundTransferService {

	@Autowired
	FundTransferRepository fundTransferRepository;
	@Autowired
	AccountRepository accountRepository;
	/**This method is use to add new transaction in datatbase
	 * @param transaction object is added to database
	 * @return is returning newly added transaction
	 */
	public Transaction craeteFundTransfer(Transaction transaction) {
		
		Transaction transaction1= fundTransferRepository.save(transaction);
		int userId=transaction.getUserId();
		
		Account account = accountRepository.findByaccountNo(transaction.getSenderAccountNo());
		account.setAmount(account.getAmount()-transaction.getAmount());
		accountRepository.save(account); 
		
		Account account1 = accountRepository.findByaccountNo(transaction.getReceiverAccountNo());
		account1.setAmount(account1.getAmount()+transaction.getAmount());
	    return transaction1;
	}
	
}
