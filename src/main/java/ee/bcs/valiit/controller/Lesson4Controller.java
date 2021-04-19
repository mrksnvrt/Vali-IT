package ee.bcs.valiit.controller;


import ee.bcs.valiit.dto.CreateAccountRequest;
import ee.bcs.valiit.dto.SampleAccount;
import ee.bcs.valiit.tasks.Lesson4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Lesson4Controller {

    @Autowired
    private NamedParameterJdbcTemplate jt;

    private Map<String, AccountDTO> account = new HashMap<>();

    private static Map<String, Double> accountBalanceMap = new HashMap<>();
    private static Map<String, SampleAccount> accountBalanceMap2 = new HashMap<>();

    @PostMapping ("bank/createAccount")
    public void createAccount(@RequestBody CreateAccountRequest accountDetails){
        accountBalanceMap.put(accountDetails.getAccountNumber(), accountDetails.getAmount());
    }

    //http://localhost:8080/bank/showBalance
    @GetMapping ("bank/showBalance")
    public Map<String, Double> showFullList(){
        return accountBalanceMap;
    }

    //http://localhost:8080/bank/showBalance/{accountNumber}
    @GetMapping ("bank/showBalance/{accountNumber}")
    public Double showBalance(@PathVariable ("accountNumber") String accountNumber){
        return accountBalanceMap.get(accountNumber);
    }

    //http://localhost:8080/bank/deposit/{accountNumber}/{amount}
    @PutMapping ("bank/deposit/{accountNumber}/{amount}")
    public void deposit(@PathVariable ("accountNumber") String accountNumber,
                               @PathVariable("amount") Double amount){
        double newbalance = accountBalanceMap.get(accountNumber) + amount;
        accountBalanceMap.put(accountNumber,newbalance);
    }

    //http://localhost:8080/bank/withdraw/{accountNumber}/{amount}
    @PutMapping ("bank/withdraw/{accountNumber}/{amount}")
    public void withdraw(@PathVariable ("accountNumber") String accountNumber,
                               @PathVariable("amount") Double amount){
        double newbalance = accountBalanceMap.get(accountNumber) - amount;
        accountBalanceMap.put(accountNumber,newbalance);
    }

    //http://localhost:8080/bank/transfer/{from}/{amount}/{to}
    @PutMapping("bank/transfer/{from}/{amount}/{to}")
    public void transfer(@PathVariable ("from") String from,
                         @PathVariable ("amount") Double amount,
                         @PathVariable ("to") String to){
        accountBalanceMap.put(from,accountBalanceMap.get(from) - amount);
        accountBalanceMap.put(to,accountBalanceMap.get(to) + amount);
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








