package ee.bcs.valiit.controller;

import ee.bcs.valiit.dto.SampleAccount;
import ee.bcs.valiit.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class Lesson4Controller {
    @Autowired
    private BankService bankService;

    //http://localhost:8080/bank/createAccount
    @PostMapping("bank/createAccount")
    public void createAccount(@RequestBody SampleAccount accountDetails) {
        bankService.createAccount(accountDetails);
    }

    //http://localhost:8080/bank/showBalance/{accountNumber}
    @GetMapping("bank/showBalance/{accountNumber}")
    public String showBalance(@PathVariable("accountNumber") String accountNumber) {
        return bankService.showBalance(accountNumber);
    }

    //http://localhost:8080/bank/deposit/{accountNumber}/{amount}
    @PutMapping("bank/deposit/{accountNumber}/{amount}")
    public String deposit(@PathVariable("accountNumber") String accountNumber,
                          @PathVariable("amount") Double amount) {
        return bankService.deposit(accountNumber,amount);
    }

    //http://localhost:8080/bank/withdraw/{accountNumber}/{amount}
    @PutMapping("bank/withdraw/{accountNumber}/{amount}")
    public String withdraw(@PathVariable("accountNumber") String accountNumber,
                           @PathVariable("amount") Double amount) {
        return bankService.withdraw(accountNumber,amount);
    }

    //http://localhost:8080/bank/transfer/{fromAccount}/{amountOfMoney}/{toAccount}
    @PutMapping("bank/transfer/{fromAccount}/{amountOfMoney}/{toAccount}")
    public String transfer(@PathVariable("fromAccount") String fromAccount,
                           @PathVariable("amountOfMoney") Double amountOfMoney,
                           @PathVariable("toAccount") String toAccount) {
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














