package com.hcl.FundTransfer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hcl.FundTransfer.entity.Transaction;
import com.hcl.FundTransfer.entity.User;
import com.hcl.FundTransfer.repository.FundTransferRepository;
import com.hcl.FundTransfer.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	LoginRepository loginRepository;
	@Autowired
	FundTransferRepository fundTransferRepository;
	
	/**This method is use to get user based on username and password
	 * @param username is use for authentication and to fetch user object
	 * @param password is use for authentication and to fetch user object
	 * @return is returning user object
	 */
	public User getUser(String username ,String password) {
		
		List<User> users =loginRepository.findAll();
		for(User user:users) {
			if((username.equals(user.getUserName()))&& (password.equals(user.getPassword()))){
				return user;
			}
		}
		return null;
	}
	
	/**This method is use to get last 10 transaction
	 * @param user is use to fetch users transactions
	 * @return is returning list of transactions
	 */
	public List<Transaction> getTransactions(User user){
		/*int userId=0;
		List<User> userList =loginRepository.findAll();
		for(User user1:userList) {
			if (user1.getUserId()==user.getUserId()) {
				userId=user.getUserId();
			}
		}*/
		
		Pageable pageable = PageRequest.of(0, 10, Sort.by("transactionId").descending());
		
		return fundTransferRepository.findByUserId(user.getUserId(), pageable);
	}
}
