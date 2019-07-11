package com.hcl.FundTransfer.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.FundTransfer.entity.Transaction;
import com.hcl.FundTransfer.service.LoginService;


/**
 * @author 
 *
 */
@RestController
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	
	/**This method is use for authentication and if user logged in successfully then it will return last 10 transaction
	 * @param userName is use for login authentication
	 * @param password is use for login authentication
	 * @return is returning list of transactions
	 * @throws Exception
	 */
	@GetMapping("/authentication")
	public ResponseEntity<List<Transaction>> authentication(@PathParam("userName") String userName , @PathParam("password") String password) throws Exception{
		List<Transaction> transactionList=new ArrayList<>();
		if(userName==null || password==null) {
			throw new Exception("please Enter username or password");
		}
		else if(loginService.getUser(userName, password)==null) {
			throw new Exception("invalid username and password");
		}
		else {
			 transactionList=loginService.getTransactions(loginService.getUser(userName, password));
		}
		
		return new ResponseEntity<List<Transaction>>(transactionList,HttpStatus.OK);
		
	}

}
