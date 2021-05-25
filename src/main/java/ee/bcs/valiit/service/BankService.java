package ee.bcs.valiit.service;
import ee.bcs.valiit.dto.BankAccountEntity;
import ee.bcs.valiit.dto.BankTransferEntity;
import ee.bcs.valiit.repository.BankAccountRepo;
import ee.bcs.valiit.repository.BankTransActionRepo;
import ee.bcs.valiit.repository.BankUserRepo;
import ee.bcs.valiit.solution.exception.SampleApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.time.LocalDateTime;

@Service
public class BankService {
    @Autowired
    BankAccountRepo bankAccountRepo;
    @Autowired
    BankTransActionRepo bankTransActionRepo;
    @Autowired
    BankUserRepo bankUserRepo;

    //SHOW BALANCE
    public String showBalance(String accountNumber) {
        BankAccountEntity account = bankAccountRepo.getOne(accountNumber);
        if (account.isBlock() == true) {
            throw new SampleApplicationException("You can not take any action with this account, because it is blocked");
        } else {
            return "Hello " + account.getFirstName() + ".\n" +
                    "You're account balance is " + account.getBalance() + " eur." + "\n" +
                    "Have a lovely day!";
        }
    }

    //SHOW ALL ACCOUNTS
    public List<BankAccountEntity> allAccounts() {
        return bankAccountRepo.findAll();
    }

    //SHOW ALL TRANSACTION HISTORY
    public List<BankTransferEntity> allTransactions() {
        return bankTransActionRepo.findAll();
    }

    //DEPOSIT
    public String deposit(String accountNumber, Double amount, String type) {
        BankAccountEntity account = bankAccountRepo.getOne(accountNumber);
        BankTransferEntity transfer = new BankTransferEntity();
        if (account.isBlock() == true) {
            throw new SampleApplicationException("You can not take any action with this account, because it is blocked");
        } else if (amount <= 0) {
            throw new SampleApplicationException("You have to insert amount, which is higher than 0.");
        } else {
            Double afterDeposit = account.getBalance() + amount;
            account.setBalance(afterDeposit);
            bankAccountRepo.save(account);
            //TRANSACTIONHISTORY
            transfer.setFromAccount(accountNumber);
            transfer.setTransferAmount(amount);
            transfer.setTransferType(type);
            transfer.setDateTime(LocalDateTime.now());
            bankTransActionRepo.save(transfer);
            //RETURN STATEMENT
            return "Hello " + account.getFirstName() + "\n" +
                    "You added " + amount + " eur to " + accountNumber + "\n" +
                    "New balance is " + afterDeposit + " eur.";
        }
    }

    //WITHDRAW
    public String withdraw(String accountNumber, Double amount, String type) {
        BankAccountEntity account = bankAccountRepo.getOne(accountNumber);
        BankTransferEntity transfer = new BankTransferEntity();
        if (account.isBlock() == true) {
            throw new SampleApplicationException("You can not take any action with this account, because it is blocked");
        } else if (amount <= 0) {
            throw new SampleApplicationException("You have to insert amount, which is higher than 0.");
        } else {
            Double afterWithdraw = account.getBalance() - amount;
            account.setBalance(afterWithdraw);
            bankAccountRepo.save(account);
            //TRANSACTIONHISTORY
            transfer.setFromAccount(accountNumber);
            transfer.setTransferAmount(amount);
            transfer.setTransferType(type);
            transfer.setDateTime(LocalDateTime.now());
            bankTransActionRepo.save(transfer);
            //RETURN STATEMENT
            return "Hello " + account.getFirstName() + "\n" +
                    "You withdrawn " + amount + " eur from " + accountNumber + "\n" +
                    "New balance is " + afterWithdraw + " eur.";
        }
    }

    //TRANSFER MONEY FROM ONE ACCOUNT TO ANOTHER
    public String transfer(String fromAccount, Double amountOfMoney, String toAccount, String type) {
        BankAccountEntity account = bankAccountRepo.getOne(fromAccount);
        BankAccountEntity secondAccountTo = bankAccountRepo.getOne(toAccount);
        BankTransferEntity transfer = new BankTransferEntity();
        if (account.isBlock() == true || secondAccountTo.isBlock() == true) {
            throw new SampleApplicationException("You can not take this action, because one of the accounts is blocked");
        } else if (amountOfMoney <= 0) {
            throw new SampleApplicationException("You have to insert amount, which is higher than 0.");
        } else if (amountOfMoney > account.getBalance()) {
            throw new SampleApplicationException("You do not have that much money on your account." +
                    "If you want to send money from you're account to another, you need to make sure that the amount you inserted aint no biggga than you're balance" +
                    "Have a lovely day!");
        } else {
            Double fromAccountNewBalance = account.getBalance() - amountOfMoney;
            Double toAccountNewBalance = secondAccountTo.getBalance() + amountOfMoney;
            account.setBalance(fromAccountNewBalance);
            secondAccountTo.setBalance(toAccountNewBalance);
            bankAccountRepo.save(account);
            bankAccountRepo.save(secondAccountTo);
            //TRANSACTIONHISTORY
            transfer.setFromAccount(fromAccount);
            transfer.setToAccount(toAccount);
            transfer.setTransferAmount(amountOfMoney);
            transfer.setTransferType(type);
            transfer.setDateTime(LocalDateTime.now());
            bankTransActionRepo.save(transfer);
            //RETURN STATEMENT
            return "Hello " + account.getFirstName() + "\n" +
                    "You transfered " + amountOfMoney + " eur from " + fromAccount + " to " + toAccount + "\n" +
                    "Account " + fromAccount + " new balance is " + fromAccountNewBalance + " eur. \n" +
                    "Account " + toAccount + " new balance is " + toAccountNewBalance + " eur.\n" +
                    "Have a lovely day!!";
        }
    }

    //LOCK ACCOUNT
    public String lock(String accountNumber) {
        BankAccountEntity account = bankAccountRepo.getOne(accountNumber);
        account.setBlock(true);
        bankAccountRepo.save(account);
        return "Account: " + accountNumber + " is blocked.";
    }

    //UNLOCK ACCOUNT
    public String unLock(String accountNumber) {
        BankAccountEntity account = bankAccountRepo.getOne(accountNumber);
        account.setBlock(false);
        bankAccountRepo.save(account);
        return "account: " + accountNumber + " is unlocked";
    }
}




//    //CREATE ACCOUNT
//    public String createAccount(CreateAccount accountDetails) {
//        AccountEntity account = new AccountEntity();
//        account.setAccountNumber(accountDetails.getAccountNumber());
//        account.setBalance(accountDetails.getBalance());
//        account.setFirstName(accountDetails.getFirstName());
//        account.setLastName(accountDetails.getLastName());
//        accountRepo.save(account);
//
//        //LOGIN USERNAME AND PASSWORD DETAILS
//        UsernameEntity username = new UsernameEntity();
//        username.setUsername(accountDetails.getUsername());
//        username.setPassword(accountDetails.getUsername());
//        userRepo.save(username);
//
//        return "Account added = " + accountDetails.getAccountNumber() + ", with balance of = " + accountDetails.getBalance();
//    }
