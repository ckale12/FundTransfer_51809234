package com.hcl.FundTransfer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hcl.FundTransfer.entity.Transaction;

@Repository
public interface FundTransferRepository extends JpaRepository<Transaction,Integer> ,PagingAndSortingRepository<Transaction ,Integer> {

	List<Transaction> findByUserId(int userId, Pageable pageable);



}
	


