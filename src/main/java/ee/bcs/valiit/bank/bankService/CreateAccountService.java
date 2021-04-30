package ee.bcs.valiit.bank.bankService;


import ee.bcs.valiit.bank.bankDto.AccountEntity;
import ee.bcs.valiit.bank.bankDto.CreateAccount;
import ee.bcs.valiit.bank.bankDto.UsernameEntity;
import ee.bcs.valiit.bank.bankRepository.AccountRepo;
import ee.bcs.valiit.bank.bankRepository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class CreateAccountService {
    @Autowired
    AccountRepo accountRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    PasswordEncoder passwordEncoder;

    //CREATE ACCOUNT
    public String createAccount(CreateAccount accountDetails) {
        //BANK ACCOUNT DETAILS
        AccountEntity account = new AccountEntity();
        account.setAccountNumber(accountDetails.getAccountNumber());
        account.setBalance(accountDetails.getBalance());
        account.setFirstName(accountDetails.getFirstName());
        account.setLastName(accountDetails.getLastName());
        account.setDateTime(LocalDateTime.now());
        accountRepo.save(account);

        //LOGIN USERNAME AND PASSWORD DETAILS
        UsernameEntity username = new UsernameEntity();
        String encodedPassword = passwordEncoder.encode(accountDetails.getPassword());
        username.setUsername(accountDetails.getUsername());
        username.setPassword(encodedPassword);
        userRepo.save(username);
        return "Account added = " + accountDetails.getAccountNumber() + ", with balance of = " + accountDetails.getBalance();
    }
}
