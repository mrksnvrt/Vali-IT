package ee.bcs.valiit.service;

import ee.bcs.valiit.dto.CreateAccount;
import ee.bcs.valiit.tasks.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {
    @Autowired
    AccountRepository accountRepository;

    public void createAccount(CreateAccount accountDetails) {
        accountRepository.createAccount(accountDetails);
    }

    public String showBalance(String accountNumber) {
        if (accountRepository.showIsBlocked(accountNumber)==true){
            return "You're account is blocked";
        }else {
            String firstName = accountRepository.showFirstName(accountNumber);
            Double balance = accountRepository.showBalance(accountNumber);
            return "Hello " + firstName + ".\n" +
                    " You're account balance is = " + balance + " eur." + "\n" +
                    " Have a lovely day!";
        }
    }

    public String deposit(String accountNumber, Double amount) {
        if (accountRepository.showIsBlocked(accountNumber)==true){
            return "You're account is blocked";
        }
        else if (amount <= 0) {
            return "You Did not insert any amount of money.";
        } else {
            Double beforeDeposit = accountRepository.showBalance(accountNumber);
            Double afterDeposit = beforeDeposit + amount;
            accountRepository.update(accountNumber,afterDeposit);
            return "Youre money has been deposited, new balance is " + afterDeposit;
        }
    }

    public String withdraw(String accountNumber, Double amount) {
        if (accountRepository.showIsBlocked(accountNumber)==true){
            return "You're account is blocked";
        }
        else if (amount <= 0) {
            return "You Did not insert any amount of money.";
        } else {
            Double beforeWithdraw = accountRepository.showBalance(accountNumber);
            Double afterWithdraw = beforeWithdraw - amount;
            accountRepository.update(accountNumber,afterWithdraw);
            return "Youre money has been withdrawed, new balance is " + afterWithdraw;
        }
    }
    public String transfer( String fromAccount, Double amountOfMoney, String toAccount) {
        Double fromAccountBalance = accountRepository.showBalance(fromAccount);
        if (accountRepository.showIsBlocked(fromAccount)==true || accountRepository.showIsBlocked(toAccount)==true){
            return "One of the accounts is blocked";
        }
        else if (amountOfMoney <= 0) {
            return "You Did not insert any amount of money.";
        }else if (amountOfMoney > fromAccountBalance) {
            return "Amount is higher of you're capability";
        } else {
            accountRepository.addTransAction(fromAccount,amountOfMoney,toAccount);
            Double toAccountBalance = accountRepository.showBalance(toAccount);
            Double fromAccountNewBalance = fromAccountBalance - amountOfMoney;
            Double toAccountNewBalance = toAccountBalance + amountOfMoney;
            accountRepository.update(fromAccount,fromAccountNewBalance);
            accountRepository.update(toAccount,toAccountNewBalance);
            return "Balance from account: " + fromAccount + " is lowered by" + amountOfMoney + "EUR. \n" +
                    "New balance is: " + fromAccountNewBalance + "EUR. Second account: " + toAccount + "\n" +
                    " new balance is " + toAccountBalance + "EUR";
        }
    }
    public String isLocked(String accountNumber){
        accountRepository.isLocked(accountNumber);
        return "Account: " + accountNumber + "is blocked.";
    }
    public String unLock(String accountNumber){
        accountRepository.unLock(accountNumber);
        return "account: " + accountNumber + "is unlocked";
    }
}
