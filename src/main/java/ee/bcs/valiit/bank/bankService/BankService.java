package ee.bcs.valiit.bank.bankService;

import ee.bcs.valiit.bank.bankDto.CreateAccount;
import ee.bcs.valiit.bank.bankDto.AccountEntity;
import ee.bcs.valiit.bank.bankRepository.AccountRepo;
import ee.bcs.valiit.solution.exception.SampleApplicationException;
import ee.bcs.valiit.bank.bankRepository.AccountRepository;
import ee.bcs.valiit.solution.hibernate.SampleHibernateAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    AccountRepo accountRepo;

    @Autowired
    private SampleHibernateAccountRepository hibernateAccountRepository;





    public String createAccount(CreateAccount accountDetails) {

        //if(accountRepository.showIfExistOrNah(accountDetails.getAccountNumber()) == false) {
            //throw new SampleApplicationException("You have to insert amount, which is higher than 0.");
       // }

        AccountEntity account = new AccountEntity();
        account.setAccountNumber(accountDetails.getAccountNumber());
        account.setBalance(accountDetails.getBalance());
        account.setFirstName(accountDetails.getFirstName());
        account.setLastName(accountDetails.getLastName());
        accountRepo.save(account);
        return "Account added = " + accountDetails.getAccountNumber() + ", with balance of = " + accountDetails.getBalance();




        //accountRepository.createAccount(accountDetails);
    }

    public String showBalance(String accountNumber) {
        if (accountRepo.getOne(accountNumber).isBlock()==true){
            throw new SampleApplicationException("You can not take any action with this account, because it is blocked");
        }else {
            String firstName = accountRepo.getOne(accountNumber).getFirstName();
            //Double balance = accountRepository.showBalance(accountNumber);

            Double balance = accountRepo.getOne(accountNumber).getBalance();
            return "Hello " + firstName + ".\n" +
                    "You're account balance is " + balance + " eur." + "\n" +
                    "Have a lovely day!";
        }
    }




    public String deposit(String accountNumber, Double amount, String type) {
        AccountEntity account = accountRepo.getOne(accountNumber);
        if (account.isBlock()==true){
            throw new SampleApplicationException("You can not take any action with this account, because it is blocked");
        }
        else if (amount <= 0) {
            throw new SampleApplicationException("You have to insert amount, which is higher than 0.");
        } else {
            accountRepository.addTransAction(accountNumber,amount, accountNumber, type);
            Double afterDeposit = account.getBalance() + amount;
            account.setBalance(afterDeposit);
            accountRepo.save(account);
            return "Hello " + account.getFirstName() + "\n" +
                    "You added " + amount + " eur to " + accountNumber + "\n" +
                    "New balance is " + afterDeposit + " eur.";
        }
    }

    public String withdraw(String accountNumber, Double amount, String type) {
        AccountEntity account = accountRepo.getOne(accountNumber);
        if (account.isBlock()==true){
            throw new SampleApplicationException("You can not take any action with this account, because it is blocked");
        }
        else if (amount <= 0) {
            throw new SampleApplicationException("You have to insert amount, which is higher than 0.");
        } else {
            accountRepository.addTransAction(accountNumber,amount, accountNumber, type);
            Double afterWithdraw = account.getBalance() - amount;
            account.setBalance(afterWithdraw);
            accountRepo.save(account);
            //accountRepository.update(accountNumber,afterWithdraw);
            return "Hello " + account.getFirstName() + "\n" +
                    "You withdrawn " + amount + " eur from " + accountNumber + "\n" +
                    "New balance is " + afterWithdraw + " eur.";
        }
    }
    public String transfer( String fromAccount, Double amountOfMoney, String toAccount, String type) {
        AccountEntity account = accountRepo.getOne(fromAccount);
        Double fromAccountBalance = account.getBalance();
        //Double fromAccountBalance = accountRepository.showBalance(fromAccount);
        if (accountRepository.showIsBlocked(fromAccount)==true || accountRepository.showIsBlocked(toAccount)==true){
            throw new SampleApplicationException("You can not take this action, because one of the accounts is blocked");
        }
        else if (amountOfMoney <= 0) {
            throw new SampleApplicationException("You have to insert amount, which is higher than 0.");
        }else if (amountOfMoney > fromAccountBalance) {
            throw new SampleApplicationException("You do not have that much money on your account." +
                    "If you want to send money from you're account to another, you need to make sure that the amount you inserted aint no biggga than you're balance" +
                    "Have a lovely day!");
        } else {
            //Double toAccountBalance = account1.getBalance();
            //String firstName = accountRepository.showFirstName(fromAccount);
            accountRepository.addTransAction(fromAccount,amountOfMoney,toAccount,type);
            AccountEntity secondAccountTo = accountRepo.getOne(fromAccount);
            Double fromAccountNewBalance = account.getBalance() - amountOfMoney;
            Double toAccountNewBalance = secondAccountTo.getBalance() + amountOfMoney;
            accountRepository.update(fromAccount,fromAccountNewBalance);
            accountRepository.update(toAccount,toAccountNewBalance);
            return "Hello " + account.getFirstName() + "\n" +
                    "You transfered " + amountOfMoney + " eur from " + fromAccount + " to " + toAccount +"\n" +
                    "Account " + fromAccount + " new balance is " + fromAccountNewBalance + " eur. \n" +
                    "Account " + toAccount + " new balance is " + toAccountNewBalance + " eur.\n" +
                    "Have a lovely day!!";
        }
    }
    public String isLocked(String accountNumber){
        AccountEntity account = accountRepo.getOne(accountNumber);
        account.setBlock(true);
        accountRepo.save(account);
        return "Account: " + accountNumber + "is blocked.";
    }
    public String unLock(String accountNumber){
        AccountEntity account = accountRepo.getOne(accountNumber);
        account.setBlock(false);
        //accountRepository.unLock(accountNumber);
        return "account: " + accountNumber + "is unlocked";
    }
}
