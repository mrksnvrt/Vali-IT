package ee.bcs.valiit.service;


import ee.bcs.valiit.dto.BankAccountEntity;
import ee.bcs.valiit.dto.BankCreateAccount;
import ee.bcs.valiit.dto.BankUsernameEntity;
import ee.bcs.valiit.repository.BankAccountRepo;
import ee.bcs.valiit.repository.BankUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class BankCreateAccountService {
    @Autowired
    BankAccountRepo bankAccountRepo;
    @Autowired
    BankUserRepo bankUserRepo;
    @Autowired
    PasswordEncoder passwordEncoder;

    //CREATE ACCOUNT
    public String createAccount(BankCreateAccount accountDetails) {
        //BANK ACCOUNT DETAILS
        BankAccountEntity account = new BankAccountEntity();
        account.setAccountNumber(accountDetails.getAccountNumber());
        account.setBalance(accountDetails.getBalance());
        account.setFirstName(accountDetails.getFirstName());
        account.setLastName(accountDetails.getLastName());
        account.setDateTime(LocalDateTime.now());
        bankAccountRepo.save(account);

        //LOGIN USERNAME AND PASSWORD DETAILS
        BankUsernameEntity username = new BankUsernameEntity();
        String encodedPassword = passwordEncoder.encode(accountDetails.getPassword());
        username.setUsername(accountDetails.getUsername());
        username.setPassword(encodedPassword);
        bankUserRepo.save(username);
        return "Account added = " + accountDetails.getAccountNumber() + ", with balance of = " + accountDetails.getBalance();
    }
}
