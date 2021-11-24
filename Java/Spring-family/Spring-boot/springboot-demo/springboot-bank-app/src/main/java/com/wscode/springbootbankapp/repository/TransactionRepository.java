package com.wscode.springbootbankapp.repository;

import com.wscode.springbootbankapp.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Warun
 * @createdOn 18-10-2021
 **/
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByAccountNumberEquals(String accountNumber);

}
