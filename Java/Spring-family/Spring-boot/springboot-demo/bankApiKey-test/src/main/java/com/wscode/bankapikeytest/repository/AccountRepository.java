package com.wscode.bankapikeytest.repository;

import com.wscode.bankapikeytest.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Warun
 * @createdOn 18-10-2021
 **/
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByAccountNumberEquals(String accountNumber);

}
