package com.hcl.FundTransfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.FundTransfer.entity.User;

@Repository
public interface RegistrationRepository extends JpaRepository<User,Integer> {

}
