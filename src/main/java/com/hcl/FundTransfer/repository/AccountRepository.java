package com.hcl.FundTransfer.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.FundTransfer.entity.Account;
import com.hcl.FundTransfer.entity.Transaction;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

	Account findByaccountNo(long receiverAccountNo);

}
