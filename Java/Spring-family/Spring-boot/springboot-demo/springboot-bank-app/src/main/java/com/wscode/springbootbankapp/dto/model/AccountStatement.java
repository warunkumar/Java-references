package com.wscode.springbootbankapp.dto.model;

import com.wscode.springbootbankapp.entity.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Warun
 * @createdOn 18-10-2021
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountStatement {
    BigDecimal currentBalance;
    List<Transaction> transactionHistory;
}
