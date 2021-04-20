package ee.bcs.valiit.service;

import ee.bcs.valiit.dto.SampleAccount;
import ee.bcs.valiit.tasks.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {
    @Autowired
    AccountRepository accountRepository;

    public void createAccount(SampleAccount accountDetails) {
        accountRepository.createAccount(accountDetails);
    }

    public String showBalance(String accountNumber) {
        return accountRepository.showBalance(accountNumber);
    }

    public String deposit(String accountNumber, Double amount) {
        return accountRepository.deposit(accountNumber,amount);
    }

    public String withdraw(String accountNumber, Double amount) {
        return accountRepository.withdraw(accountNumber,amount);
    }

    public String transfer( String fromAccount, Double amountOfMoney, String toAccount) {
        return accountRepository.transfer(fromAccount,amountOfMoney,toAccount);
    }

    public String isLocked(String accountNumber){
        return accountRepository.isLocked(accountNumber);
    }

    public String unLock(String accountNumber){
        return accountRepository.unLock(accountNumber);
    }



}
