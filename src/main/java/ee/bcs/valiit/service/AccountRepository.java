package ee.bcs.valiit.tasks;

import ee.bcs.valiit.dto.SampleAccount;
import ee.bcs.valiit.solution.repository.SampleAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;


@Repository
public class AccountRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createAccount(SampleAccount accountDetails) {
        String sql = "INSERT INTO account (first_name, last_name, account_number, balance, block) VALUES(:dbfirst_name, :dblast_name, :dbaccountNumber, :dbbalance, :dbblock)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbfirst_name", accountDetails.getFirstName());
        paramMap.put("dblast_name", accountDetails.getLastName());
        paramMap.put("dbaccountNumber", accountDetails.getAccountNumber());
        paramMap.put("dbbalance", accountDetails.getBalance());
        paramMap.put("dbblock", accountDetails.isLocked());
        jdbcTemplate.update(sql, paramMap);
    }
    public String showBalance(String accountNumber) {
        String sql = "SELECT balance FROM account WHERE account_number = :dbAccountNumber";
        String sql1 = "SELECT first_name FROM account WHERE account_number = :dbAccountNumber";
        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("dbAccountNumber", accountNumber);
        Double balance = jdbcTemplate.queryForObject(sql, paraMap, Double.class);
        String first_name = jdbcTemplate.queryForObject(sql1, paraMap, String.class);
        return "Hello " + first_name + ". You're account balance is = " + balance + " eur. Have a lovely day!";
    }

    public String deposit(String accountNumber, Double amount) {
        if (amount <= 0) {
            return "You Did not insert any amount of money.";
        } else {
            String sql = "SELECT balance FROM account WHERE account_number = :dbAccno";
            String sql1 = "UPDATE account SET balance = :newBalance WHERE account_number = :dbAccno";
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("dbAccno", accountNumber);
            Double currentBalance = jdbcTemplate.queryForObject(sql, paramMap, Double.class);
            Double newBalance = currentBalance + amount;
            Map<String, Object> paramMap1 = new HashMap<>();
            paramMap1.put("dbAccno", accountNumber);
            paramMap1.put("newBalance", newBalance);
            jdbcTemplate.update(sql1, paramMap1);
            return "Youre money has been deposited, new balance is " + newBalance;
        }
    }
    public String withdraw(String accountNumber, Double amount) {
        if (amount <= 0) {
            return "You Did not insert any amount of money.";
        } else {
            String sql = "SELECT balance FROM account WHERE account_number = :dbAccno";
            String sql1 = "UPDATE account SET balance = :newBalance WHERE account_number = :dbAccno";
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("dbAccno", accountNumber);
            Double currentBalance = jdbcTemplate.queryForObject(sql, paramMap, Double.class);
            if (amount > currentBalance) {
                return "Amount is higher of you're capability";
            }
            Double newBalance = currentBalance - amount;
            Map<String, Object> paramMap1 = new HashMap<>();
            paramMap1.put("dbAccno", accountNumber);
            paramMap1.put("newBalance", newBalance);
            jdbcTemplate.update(sql1, paramMap1);
            return "Youre money has been withdrawed, new balance is" + newBalance;
        }
    }
    public String transfer( String fromAccount, Double amountOfMoney, String toAccount) {
        if (amountOfMoney <= 0) {
            return "You Did not insert any amountOfMoney of money.";
        } else {
            String sql = "SELECT balance FROM account WHERE account_number = :dbFromAccount";
            String sql1 = "UPDATE account SET balance = :fromAccountSecondBalance WHERE account_number = :dbFromAccount";
            String sql2 = "UPDATE account SET balance = :toAccountNewBalance WHERE account_number = :dbToAccount";
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("dbFromAccount", fromAccount);
            Double fromAccountFirstBalance = jdbcTemplate.queryForObject(sql, paramMap, Double.class);
            if (amountOfMoney > fromAccountFirstBalance) {
                return "The amount you inserted is bigger of the amount you hold";
            } else {
                Double fromAccountSecondBalance = fromAccountFirstBalance - amountOfMoney;
                Double toAccountNewBalance = fromAccountFirstBalance + amountOfMoney;
                Map<String, Object> paramMap1 = new HashMap<>();
                paramMap1.put("dbFromAccount", fromAccount);
                paramMap1.put("fromAccountSecondBalance", fromAccountSecondBalance);
                jdbcTemplate.update(sql1, paramMap1);
                Map<String, Object> paramMap2 = new HashMap<>();
                paramMap2.put("dbToAccount", toAccount);
                paramMap2.put("toAccountNewBalance", toAccountNewBalance);
                jdbcTemplate.update(sql2, paramMap2);
                return "Balance from account: " + fromAccount + " is lowered by" + amountOfMoney + "EUR. \n" +
                        "New balance is: " + fromAccountSecondBalance + "EUR. Second account: " + toAccount + "\n" +
                        " new balance is " + toAccountNewBalance + "EUR";
            }
        }
    }

    public String isLocked(String accountNumber){
        Map<String, Object> parmMap = new HashMap<>();
        String sql = ("UPDATE account SET block = true WHERE :dbAccountNumber");
        parmMap.put("dbAccountNumber", accountNumber);
        jdbcTemplate.update(sql, parmMap);
        return "You're account " + accountNumber + "is Blocked. Have a nice day!";
    }

    public String unLock(String accountNumber) {
        Map<String, Object> parmMap = new HashMap<>();
        String sql = ("UPDATE account SET block = false WHERE :dbAccountNumber");
        parmMap.put("dbAccountNumber", accountNumber);
        jdbcTemplate.update(sql, parmMap);
        return "You're account " + accountNumber + "is unlocked. Have a nice day!";
    }

}