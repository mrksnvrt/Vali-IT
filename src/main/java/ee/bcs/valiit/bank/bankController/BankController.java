package ee.bcs.valiit.bank.bankController;

import ee.bcs.valiit.bank.bankDto.AccountEntity;
import ee.bcs.valiit.bank.bankDto.CreateTransferMoney;
import ee.bcs.valiit.bank.bankDto.AccoundCommand;
import ee.bcs.valiit.bank.bankDto.CreateAccount;
import ee.bcs.valiit.bank.bankService.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class BankController {
    @Autowired
    private BankService bankService;

    //CREATE ACCOUNT
    //http://localhost:8080/bank/createAccount
    @CrossOrigin
    @PostMapping("bank/createAccount")
    public void createAccount(@RequestBody CreateAccount accountDetails) {
        bankService.createAccount(accountDetails);
    }

    //SHOW ONE ACCOUNT BALANCE
    //http://localhost:8080/bank/showBalance/
    @GetMapping("bank/showBalance")
    public String showBalance(@RequestBody AccoundCommand accountDetails) {
        String accountNumber = accountDetails.getAccountNumber();
        return bankService.showBalance(accountNumber);
    }

    //GET ALL
    //http://localhost:8080/allAccounts
    @GetMapping("allAccounts")
    public List<AccountEntity> allAccounts() {
        return bankService.allAccounts();
    }

    //INSERT MONEY TO BANK ACCOUNT
    //http://localhost:8080/bank/deposit
    @CrossOrigin
    @PutMapping("bank/deposit")
    public String deposit(@RequestBody AccoundCommand depositDetails) {
        String accountNumber = depositDetails.getAccountNumber();
        Double amount = depositDetails.getAmountOfMoney();
        String type = depositDetails.getType();
        return bankService.deposit(accountNumber, amount, type);
    }

    //TAKE MONEY OUT FROM BANK ACCOUNT
    //http://localhost:8080/bank/withdraw
    @CrossOrigin
    @PutMapping("bank/withdraw")
    public String withdraw(@RequestBody AccoundCommand withdrawDetails) {
        String accountNumber = withdrawDetails.getAccountNumber();
        Double amount = withdrawDetails.getAmountOfMoney();
        String type = withdrawDetails.getType();
        return bankService.withdraw(accountNumber, amount, type);
    }

    //TRANSFER MONEY FROM ONE ACCOUNT TO ANOTHER
    //http://localhost:8080/bank/transfer
    @CrossOrigin
    @PutMapping("bank/transfer")
    public String transfer(@RequestBody CreateTransferMoney transferDetails) {
        String fromAccount = transferDetails.getFromAccount();
        Double amountOfMoney = transferDetails.getBalance();
        String toAccount = transferDetails.getToAccount();
        String type = transferDetails.getType();
        return bankService.transfer(fromAccount, amountOfMoney, toAccount, type);
    }

    //LOCK BANK ACCOUNT
    //http://localhost:8080/bank/lock/
    @PutMapping("bank/lock")
    public String lock(@RequestBody AccoundCommand lockAccountDetails) {
        String accountNumber = lockAccountDetails.getAccountNumber();
        return bankService.lock(accountNumber);
    }

    //UNLOCK BANK ACCOUNT
    //http://localhost:8080/bank/unlock
    @PutMapping("bank/unlock")
    public String unLock(@RequestBody AccoundCommand lockAccountDetails) {
        String accountNumber = lockAccountDetails.getAccountNumber();
        return bankService.unLock(accountNumber);
    }
}














