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
    @PutMapping("bank/deposit")
    public String deposit(@RequestBody DepositWithdraw accountDetails) {
        String accountNumber = accountDetails.getAccountNumber();
        Double amount = accountDetails.getBalance();
        return bankService.deposit(accountNumber, amount);
    }

    //http://localhost:8080/bank/withdraw
    @PutMapping("bank/withdraw")
    public String withdraw(@RequestBody DepositWithdraw accountDetails) {
        String accountNumber = accountDetails.getAccountNumber();
        Double amount = accountDetails.getBalance();
        return bankService.withdraw(accountNumber,amount);
    }

    //http://localhost:8080/bank/transfer
    @PutMapping("bank/transfer")
    public String transfer(@RequestBody CreateTransferMoney accountDetails) {

        String fromAccount = accountDetails.getFromAccount();
        Double amountOfMoney = accountDetails.getBalance();
        String toAccount = accountDetails.getToAccount();
        return bankService.transfer(fromAccount,amountOfMoney,toAccount);
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














