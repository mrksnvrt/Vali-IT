package ee.bcs.valiit.controller;


import ee.bcs.valiit.dto.CreateAccountRequest;
import ee.bcs.valiit.dto.SampleAccount;
import ee.bcs.valiit.tasks.Lesson4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Lesson4Controller {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    private static Map<String, Double> accountBalanceMap = new HashMap<>();
    private static Map<String, SampleAccount> accountBalanceMap2 = new HashMap<>();

    @PostMapping ("bank/createAccount")
    public void createAccount(@RequestBody SampleAccount accountDetails){

        String sql = "INSERT INTO account (first_name, last_name, account_number, balance, block) VALUES(:dbfirst_name, :dblast:name, :dbaccountNumber, :dbbalance, :dbblock)";
        Map <String, Object> paramMap = new HashMap<>();
        paramMap.put("dbfirst_name",accountDetails.getFirstName());
        paramMap.put("dblast_name", accountDetails.getLastName());
        paramMap.put("dbaccountNumber", accountDetails.getAccountNumber());
        paramMap.put("dbbalance", accountDetails.getBalance());
        paramMap.put("dbblock", accountDetails.isLocked());
        jdbcTemplate.update(sql, paramMap);
    }

    //http://localhost:8080/bank/showBalance
    @GetMapping ("bank/showBalance")
    public Map<String, Double> showFullList(){
        return accountBalanceMap;
    }

    //http://localhost:8080/bank/showBalance/{accountNumber}
    @GetMapping ("bank/showBalance/{accountNumber}")
    public String showBalance(@PathVariable ("accountNumber") String accountNumber){
        String sql = "SELECT balance FROM account WHERE account_number = :dbaccountNumber";
        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("dbaccountNumber", accountNumber);
        Double balance = jdbcTemplate.queryForObject(sql, paraMap, Double.class);
        return "konto saldo on" + balance + "eur";
    }

    //http://localhost:8080/bank/deposit/{accountNumber}/{amount}
    @PutMapping ("bank/deposit/{accountNumber}/{amount}")

    public String deposit(@PathVariable ("accountNumber") String accountNumber,
                           @PathVariable("amount") Double amount){
        String sql = "SELECT balance FROM account WHERE account_number = :dbAccno";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbAccno", accountNumber);
        Double currentBalance = jdbcTemplate.queryForObject(sql, paramMap, Double.class);
        if (amount < 0){
            return "kankel";
        } else {
            String sql1 = "UPDATE account SET balance = :newBalance WHERE account_number = :dbAccno";
            Map<String,Object> paramMap1 = new HashMap<>();
            paramMap1.put("dbAccno", accountNumber);
            Double newBalance = currentBalance + amount;
            paramMap1.put("newBalance", newBalance);
            jdbcTemplate.update(sql1, paramMap1);
            return "Youre money has been deposited, new balance is " + newBalance;
        }
    }
    //http://localhost:8080/bank/withdraw/{accountNumber}/{amount}
    @PutMapping ("bank/withdraw/{accountNumber}/{amount}")
    public String withdraw(@PathVariable ("accountNumber") String accountNumber,
                               @PathVariable("amount") Double amount){
        String sql = "SELECT balance FROM account WHERE account_number = :dbAccno";
        Map<String,Object>paramMap = new HashMap<>();
        paramMap.put("dbAccno", accountNumber);
        Double currentBalance = jdbcTemplate.queryForObject(sql, paramMap, Double.class);
        String sql1 = "UPDATE account SET balance = :newBalance WHERE account_number = :dbAccno";
        Map<String,Object> paramMap1 = new HashMap<>();
        paramMap1.put("dbAccno", accountNumber);
        Double newBalance = currentBalance - amount;
        paramMap1.put("newBalance",newBalance);
        jdbcTemplate.update(sql1,paramMap1);
        return "Youre money has been withdrawed, ned balance is" + newBalance;

        //double newbalance = accountBalanceMap.get(accountNumber) - amount;
        //accountBalanceMap.put(accountNumber,newbalance);
    }

    //http://localhost:8080/bank/transfer/{from}/{amount}/{to}
    @PutMapping("bank/transfer/{from}/{amount}/{to}")
    public String transfer(@PathVariable ("from") String from,
                         @PathVariable ("amount") Double amount,
                         @PathVariable ("to") String to){


        String sql = "SELECT balance FROM account WHERE account_number = :dbAccno";
        Map<String,Object>paramMap = new HashMap<>();
        paramMap.put("dbAccno", from);
        paramMap.put("dbAccno1", to);
        Double currentBalance = jdbcTemplate.queryForObject(sql, paramMap, Double.class);
        String sql1 = "UPDATE account SET balance = :newBalance WHERE account_number = :dbAccno";
        Map<String,Object> paramMap1 = new HashMap<>();
        paramMap1.put("dbAccno", from);
        Double newBalance = currentBalance - amount;
        Double newBalance1 = currentBalance + amount;
        paramMap1.put("newBalance",newBalance);
        Map<String,Object>paramMap2 = new HashMap<>();
        paramMap2.put("dbAccno1", to);
        paramMap2.put("newBalance1", newBalance1);
        String sql2 = "UPDATE account SET balance = :newBalance1 WHERE account_number = :dbAccno1";
        jdbcTemplate.update(sql1, paramMap1);
        jdbcTemplate.update(sql2, paramMap2);
        return "Balance from " + from +  "is reduced, new balance is" + newBalance + "& account " + to + "balance is" + newBalance1;





        //accountBalanceMap.put(from,accountBalanceMap.get(from) - amount);
        //accountBalanceMap.put(to,accountBalanceMap.get(to) + amount);
    }

    //************************************************************************************
    //Pank 2.0

    @GetMapping ("newbank/createAccount/{accountNumber}/{balance}/{ownerName}")
    public void createNewBankAccount (@PathVariable("accountNumber") String accountNumber,
                                      @PathVariable ("balance") Double balance,
                                      @PathVariable("ownerName")String ownerName){
        SampleAccount account = new SampleAccount();
        account.setAccountNumber(accountNumber);
        account.setBalance(balance);
        account.setOwnerName(ownerName);
        account.setLocked(false);
        accountBalanceMap2.put(accountNumber, account);
    }

    @GetMapping("newbank/list")
    public Map<String, SampleAccount> showList(){
        return accountBalanceMap2;
    }





}








