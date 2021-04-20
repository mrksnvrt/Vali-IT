package ee.bcs.valiit.controller;


import ee.bcs.valiit.dto.SampleAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
public class Lesson4Controller {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @PostMapping("bank/createAccount")
    public void createAccount(@RequestBody SampleAccount accountDetails) {
        String sql = "INSERT INTO account (first_name, last_name, account_number, balance, block) VALUES(:dbfirst_name, :dblast_name, :dbaccountNumber, :dbbalance, :dbblock)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbfirst_name", accountDetails.getFirstName());
        paramMap.put("dblast_name", accountDetails.getLastName());
        paramMap.put("dbaccountNumber", accountDetails.getAccountNumber());
        paramMap.put("dbbalance", accountDetails.getBalance());
        paramMap.put("dbblock", accountDetails.isLocked());
        jdbcTemplate.update(sql, paramMap);
    }
    //http://localhost:8080/bank/showBalance/{accountNumber}
    @GetMapping("bank/showBalance/{accountNumber}")
    public String showBalance(@PathVariable("accountNumber") String accountNumber) {
        String sql = "SELECT balance FROM account WHERE account_number = :dbAccountNumber";
        String sql1 = "SELECT first_name FROM account WHERE account_number = :dbAccountNumber";
        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("dbAccountNumber", accountNumber);
        Double balance = jdbcTemplate.queryForObject(sql, paraMap, Double.class);
        String first_name = jdbcTemplate.queryForObject(sql1, paraMap, String.class);
        return "Hello " + first_name + ". You're account balance is = " + balance + " eur. Have a lovely day!";
    }
    //http://localhost:8080/bank/deposit/{accountNumber}/{amount}
    @PutMapping("bank/deposit/{accountNumber}/{amount}")
    public String deposit(@PathVariable("accountNumber") String accountNumber,
                          @PathVariable("amount") Double amount) {
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
    //http://localhost:8080/bank/withdraw/{accountNumber}/{amount}
    @PutMapping("bank/withdraw/{accountNumber}/{amount}")
    public String withdraw(@PathVariable("accountNumber") String accountNumber,
                           @PathVariable("amount") Double amount) {
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
    //http://localhost:8080/bank/transfer/{fromAccount}/{amountOfMoney}/{toAccount}
    @PutMapping("bank/transfer/{fromAccount}/{amountOfMoney}/{toAccount}")
    public String transfer(@PathVariable("fromAccount") String fromAccount,
                           @PathVariable("amountOfMoney") Double amountOfMoney,
                           @PathVariable("toAccount") String toAccount) {
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
}
//    ************************************************************************************
//    Pank 2.0
//    @GetMapping ("newbank/createAccount/{accountNumber}/{balance}/{ownerName}")
//    public void createNewBankAccount (@PathVariable("accountNumber") String accountNumber,
//                                      @PathVariable ("balance") Double balance,
//                                      @PathVariable("ownerName")String ownerName){
//        SampleAccount account = new SampleAccount();
//        account.setAccountNumber(accountNumber);
//        account.setBalance(balance);
//        //account.setOwnerName(ownerName);
//        account.setLocked(false);
//        accountBalanceMap2.put(accountNumber, account);
//    }
//
//    @GetMapping("newbank/list")
//    public Map<String, SampleAccount> showList(){
//        return accountBalanceMap2;
//    }
//    private static Map<String, Double> accountBalanceMap = new HashMap<>();
//    private static Map<String, SampleAccount> accountBalanceMap2 = new HashMap<>();
//    http://localhost:8080/bank/showBalance
//    @GetMapping ("bank/showBalance")
//    public Map<String, Double> showFullList(){
//        return accountBalanceMap;}














