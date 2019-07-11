package com.hcl.FundTransfer.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.FundTransfer.entity.Account;
import com.hcl.FundTransfer.entity.User;
import com.hcl.FundTransfer.repository.AccountRepository;
import com.hcl.FundTransfer.repository.RegistrationRepository;

@Service
public class RegistrationService {
	
	@Autowired
	RegistrationRepository registrationRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	public User registration(User user) {
		
	  User user1= registrationRepository.save(user);
	  
	  Random rand = new Random();
      long accountNumber = rand.nextLong() + 1000000000;
	  
      Account account=new Account();
	  account.setAccountNo(accountNumber);
	  account.setUserId(user1.getUserId());
	  account.setAmount(10000);
	  accountRepository.save(account);
	  return user1;
	
	}

}
