package ee.bcs.valiit.bank.bankService;

import ee.bcs.valiit.bank.bankDto.CreateAccount;
import ee.bcs.valiit.bank.bankDto.AccountEntity;
import ee.bcs.valiit.bank.bankDto.TransferEntity;
import ee.bcs.valiit.bank.bankRepository.AccountRepo;
import ee.bcs.valiit.bank.bankRepository.TransActionRepo;
import ee.bcs.valiit.solution.exception.SampleApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.time.LocalDateTime;

@Service
public class BankService {
    @Autowired
    AccountRepo accountRepo;
    @Autowired
    TransActionRepo transActionRepo;

    //CREATE ACCOUNT
    public String createAccount(CreateAccount accountDetails) {
        AccountEntity account = new AccountEntity();
        account.setAccountNumber(accountDetails.getAccountNumber());
        account.setBalance(accountDetails.getBalance());
        account.setFirstName(accountDetails.getFirstName());
        account.setLastName(accountDetails.getLastName());
        accountRepo.save(account);
        return "Account added = " + accountDetails.getAccountNumber() + ", with balance of = " + accountDetails.getBalance();
    }

    //SHOW BALANCE
    public String showBalance(String accountNumber) {
        AccountEntity account = accountRepo.getOne(accountNumber);
        if (account.isBlock() == true) {
            throw new SampleApplicationException("You can not take any action with this account, because it is blocked");
        } else {
            return "Hello " + account.getFirstName() + ".\n" +
                    "You're account balance is " + account.getBalance() + " eur." + "\n" +
                    "Have a lovely day!";
        }
    }

    //SHOW ALL ACCOUNTS
    public List<AccountEntity> allAccounts() {
        return accountRepo.findAll();
    }

    //SHOW ALL TRANSACTION HISTORY
    public List<TransferEntity> allTransactions() {
        return transActionRepo.findAll();
    }

    //DEPOSIT
    public String deposit(String accountNumber, Double amount, String type) {
        AccountEntity account = accountRepo.getOne(accountNumber);
        TransferEntity transfer = new TransferEntity();
        if (account.isBlock() == true) {
            throw new SampleApplicationException("You can not take any action with this account, because it is blocked");
        } else if (amount <= 0) {
            throw new SampleApplicationException("You have to insert amount, which is higher than 0.");
        } else {
            Double afterDeposit = account.getBalance() + amount;
            account.setBalance(afterDeposit);
            accountRepo.save(account);
            //TRANSACTIONHISTORY
            transfer.setFromAccount(accountNumber);
            transfer.setTransferAmount(amount);
            transfer.setTransferType(type);
            transfer.setDateTime(LocalDateTime.now());
            transActionRepo.save(transfer);
            //RETURN STATEMENT
            return "Hello " + account.getFirstName() + "\n" +
                    "You added " + amount + " eur to " + accountNumber + "\n" +
                    "New balance is " + afterDeposit + " eur.";
        }
    }

    //WITHDRAW
    public String withdraw(String accountNumber, Double amount, String type) {
        AccountEntity account = accountRepo.getOne(accountNumber);
        TransferEntity transfer = new TransferEntity();
        if (account.isBlock() == true) {
            throw new SampleApplicationException("You can not take any action with this account, because it is blocked");
        } else if (amount <= 0) {
            throw new SampleApplicationException("You have to insert amount, which is higher than 0.");
        } else {
            Double afterWithdraw = account.getBalance() - amount;
            account.setBalance(afterWithdraw);
            accountRepo.save(account);
            //TRANSACTIONHISTORY
            transfer.setFromAccount(accountNumber);
            transfer.setTransferAmount(amount);
            transfer.setTransferType(type);
            transfer.setDateTime(LocalDateTime.now());
            transActionRepo.save(transfer);
            //RETURN STATEMENT
            return "Hello " + account.getFirstName() + "\n" +
                    "You withdrawn " + amount + " eur from " + accountNumber + "\n" +
                    "New balance is " + afterWithdraw + " eur.";
        }
    }

    //TRANSFER MONEY FROM ONE ACCOUNT TO ANOTHER
    public String transfer(String fromAccount, Double amountOfMoney, String toAccount, String type) {
        AccountEntity account = accountRepo.getOne(fromAccount);
        AccountEntity secondAccountTo = accountRepo.getOne(toAccount);
        TransferEntity transfer = new TransferEntity();
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
            accountRepo.save(account);
            accountRepo.save(secondAccountTo);
            //TRANSACTIONHISTORY
            transfer.setFromAccount(fromAccount);
            transfer.setToAccount(toAccount);
            transfer.setTransferAmount(amountOfMoney);
            transfer.setTransferType(type);
            transfer.setDateTime(LocalDateTime.now());
            transActionRepo.save(transfer);
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
        AccountEntity account = accountRepo.getOne(accountNumber);
        account.setBlock(true);
        accountRepo.save(account);
        return "Account: " + accountNumber + " is blocked.";
    }

    //UNLOCK ACCOUNT
    public String unLock(String accountNumber) {
        AccountEntity account = accountRepo.getOne(accountNumber);
        account.setBlock(false);
        accountRepo.save(account);
        return "account: " + accountNumber + " is unlocked";
    }
}
