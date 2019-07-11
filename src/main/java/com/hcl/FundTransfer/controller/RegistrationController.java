package com.hcl.FundTransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.FundTransfer.entity.User;
import com.hcl.FundTransfer.service.RegistrationService;

@RestController
public class RegistrationController {

	@Autowired
	RegistrationService registrationService;
	
	/**This method is use for new user registration
	 * @param user is use to add new user in database
	 * @return is returning newly added user in database
	 * @throws Exception
	 */
	@PostMapping("/registration")
	public ResponseEntity<User>registration(@RequestBody User user) throws Exception {
		
		if(user.getUserName()==null||user.getPassword()==null ||user.getGender()==null||
				user.getEmail()==null||user.getDob()==null||user.getPhoneNo()==null) {
			throw new Exception("Please fill all details");
		}
		
		return new ResponseEntity<User>(registrationService.registration(user),HttpStatus.OK);
		
	}
}
