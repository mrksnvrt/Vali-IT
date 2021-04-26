package ee.bcs.valiit.controller;

import ee.bcs.valiit.dto.CreateAccount;
import ee.bcs.valiit.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class Lesson4Controller {
    @Autowired
    private BankService bankService;

    //http://localhost:8080/bank/createAccount
    @CrossOrigin
    @PostMapping("bank/createAccount")
    public void createAccount(@RequestBody CreateAccount accountDetails) {
        bankService.createAccount(accountDetails);
    }

    //http://localhost:8080/bank/showBalance/
    @GetMapping("bank/showBalance")
    public String showBalance(@RequestBody DepositWithdraw accountDetails) {
        String accountNumber = accountDetails.getAccountNumber();
        return bankService.showBalance(accountNumber);
    }

    //http://localhost:8080/bank/deposit
    @CrossOrigin
    @PutMapping("bank/deposit")
    public String deposit(@RequestBody DepositWithdraw accountDetails) {
        String accountNumber = accountDetails.getAccountNumber();
        Double amount = accountDetails.getAmountOfMoney();
        String type = accountDetails.getType();
        return bankService.deposit(accountNumber, amount, type);
    }

    //http://localhost:8080/bank/withdraw
    @CrossOrigin
    @PutMapping("bank/withdraw")
    public String withdraw(@RequestBody DepositWithdraw accountDetails) {
        String accountNumber = accountDetails.getAccountNumber();
        Double amount = accountDetails.getAmountOfMoney();
        String type = accountDetails.getType();
        return bankService.withdraw(accountNumber,amount, type);
    }

    //http://localhost:8080/bank/transfer
    @PutMapping("bank/transfer")
    public String transfer(@RequestBody CreateTransferMoney accountDetails) {

        String fromAccount = accountDetails.getFromAccount();
        Double amountOfMoney = accountDetails.getBalance();
        String toAccount = accountDetails.getToAccount();
        String type = accountDetails.getType();
        return bankService.transfer(fromAccount,amountOfMoney,toAccount, type);
    }

    //http://localhost:8080/bank/lock/{accountNumber}
    @PutMapping("bank/lock/{accountNumber}")
    public String isLocked(@PathVariable("accountNumber")String accountNumber){
        return bankService.isLocked(accountNumber);
    }

    //http://localhost:8080/bank/unlock/{accountNumber}
    @PutMapping("bank/unlock/{accountNumber}")
    public String unLock(@PathVariable("accountNumber")String accountNumber){
        return bankService.unLock(accountNumber);
    }
}














