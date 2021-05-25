package ee.bcs.valiit.controller;

import ee.bcs.valiit.service.BankService;
import ee.bcs.valiit.dto.BankAccoundCommand;
import ee.bcs.valiit.dto.BankAccountEntity;
import ee.bcs.valiit.dto.BankCreateTransferMoney;
import ee.bcs.valiit.dto.BankTransferEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class BankController {
    @Autowired
    BankService bankService;


    //SHOW ONE ACCOUNT BALANCE
    //http://localhost:8080/bank/showBalance/
    @CrossOrigin
    @GetMapping("bank/showBalance")
    public String showBalance(@RequestBody BankAccoundCommand accountDetails) {
        String accountNumber = accountDetails.getAccountNumber();
        return bankService.showBalance(accountNumber);
    }

    //SHOW ONE ACCOUNT BALANCE PATHVARIABLE
    //http://localhost:8080/bank/showBalance/ + EE
    @CrossOrigin
    @GetMapping("bank/showBalance/{accountNumber}")
    public String showBalancePath(@PathVariable ("accountNumber") String accountNumber) {

        return bankService.showBalance(accountNumber);
    }

    //GET ALL
    //http://localhost:8080/bank/allAccounts
    @CrossOrigin
    @GetMapping("bank/allAccounts")
    public List<BankAccountEntity> allAccounts() {

        return bankService.allAccounts();
    }

    //GET ALL TRANSACTIONS
    //http://localhost:8080/bank/allTransactions
    @CrossOrigin
    @GetMapping("bank/allTransactions")
    public List<BankTransferEntity> allTransactions() {
        return bankService.allTransactions();
    }

    //INSERT MONEY TO BANK ACCOUNT
    //http://localhost:8080/bank/deposit
    @CrossOrigin
    @PutMapping("bank/deposit")
    public String deposit(@RequestBody BankAccoundCommand depositDetails) {
        String accountNumber = depositDetails.getAccountNumber();
        Double amount = depositDetails.getAmountOfMoney();
        String type = depositDetails.getType();
        return bankService.deposit(accountNumber, amount, type);
    }

    //TAKE MONEY OUT FROM BANK ACCOUNT
    //http://localhost:8080/bank/withdraw
    @CrossOrigin
    @PutMapping("bank/withdraw")
    public String withdraw(@RequestBody BankAccoundCommand withdrawDetails) {
        String accountNumber = withdrawDetails.getAccountNumber();
        Double amount = withdrawDetails.getAmountOfMoney();
        String type = withdrawDetails.getType();
        return bankService.withdraw(accountNumber, amount, type);
    }

    //TRANSFER MONEY FROM ONE ACCOUNT TO ANOTHER
    //http://localhost:8080/bank/transfer
    @CrossOrigin
    @PutMapping("bank/transfer")
    public String transfer(@RequestBody BankCreateTransferMoney transferDetails) {
        String fromAccount = transferDetails.getFromAccount();
        Double amountOfMoney = transferDetails.getBalance();
        String toAccount = transferDetails.getToAccount();
        String type = transferDetails.getType();
        return bankService.transfer(fromAccount, amountOfMoney, toAccount, type);
    }

    //LOCK BANK ACCOUNT
    //http://localhost:8080/bank/lock/
    @PutMapping("bank/lock")
    public String lock(@RequestBody BankAccoundCommand lockAccountDetails) {
        String accountNumber = lockAccountDetails.getAccountNumber();
        return bankService.lock(accountNumber);
    }

    //UNLOCK BANK ACCOUNT
    //http://localhost:8080/bank/unlock
    @PutMapping("bank/unlock")
    public String unLock(@RequestBody BankAccoundCommand lockAccountDetails) {
        String accountNumber = lockAccountDetails.getAccountNumber();
        return bankService.unLock(accountNumber);
    }
}


//    //CREATE ACCOUNT
//    //http://localhost:8080/bank/createAccount
//    @CrossOrigin
//    @PostMapping("bank/createAccount")
//    public void createAccount(@RequestBody CreateAccount accountDetails) {
//        bankService.createAccount(accountDetails);
//    }















