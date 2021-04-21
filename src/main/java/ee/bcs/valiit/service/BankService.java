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
                    "You're account balance is " + balance + " eur." + "\n" +
                    "Have a lovely day!";
        }
    }

    public String deposit(String accountNumber, Double amount) {
        if (accountRepository.showIsBlocked(accountNumber)==true){
            return "You're account is blocked";
        }
        else if (amount <= 0) {
            return "Please insert amount, which is higher than 0.";
        } else {
            String firstName = accountRepository.showFirstName(accountNumber);
            Double beforeDeposit = accountRepository.showBalance(accountNumber);
            Double afterDeposit = beforeDeposit + amount;
            accountRepository.update(accountNumber,afterDeposit);
            return "Hello " + firstName + "\n" +
                    "You added " + amount + " eur to " + accountNumber + "\n" +
                    "New balance is " + afterDeposit + " eur.";
        }
    }

    public String withdraw(String accountNumber, Double amount) {
        if (accountRepository.showIsBlocked(accountNumber)==true){
            return "You're account is blocked";
        }
        else if (amount <= 0) {
            return "Please insert amount, which is higher than 0.";
        } else {
            String firstName = accountRepository.showFirstName(accountNumber);
            Double beforeWithdraw = accountRepository.showBalance(accountNumber);
            Double afterWithdraw = beforeWithdraw - amount;
            accountRepository.update(accountNumber,afterWithdraw);
            return "Hello " + firstName + "\n" +
                    "You withdrawn " + amount + " eur from " + accountNumber + "\n" +
                    "New balance is " + afterWithdraw + " eur.";
        }
    }
    public String transfer( String fromAccount, Double amountOfMoney, String toAccount) {
        Double fromAccountBalance = accountRepository.showBalance(fromAccount);
        if (accountRepository.showIsBlocked(fromAccount)==true || accountRepository.showIsBlocked(toAccount)==true){
            return "One of the accounts is blocked";
        }
        else if (amountOfMoney <= 0) {
            return "Please insert amount, which is higher than 0.";
        }else if (amountOfMoney > fromAccountBalance) {
            return "You do not have that much money on your account.";
        } else {
            String firstName = accountRepository.showFirstName(fromAccount);
            accountRepository.addTransAction(fromAccount,amountOfMoney,toAccount);
            Double toAccountBalance = accountRepository.showBalance(toAccount);
            Double fromAccountNewBalance = fromAccountBalance - amountOfMoney;
            Double toAccountNewBalance = toAccountBalance + amountOfMoney;
            accountRepository.update(fromAccount,fromAccountNewBalance);
            accountRepository.update(toAccount,toAccountNewBalance);
            return "Hello " + firstName + "\n" +
                    "You transfered " + amountOfMoney + " eur from " + fromAccount + " to " + toAccount +"\n" +
                    "Account " + fromAccount + " new balance is " + fromAccountNewBalance + " eur. \n" +
                    "Account " + toAccount + " new balance is " + toAccountNewBalance + " eur.\n" +
                    "Have a lovely day!!";
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
