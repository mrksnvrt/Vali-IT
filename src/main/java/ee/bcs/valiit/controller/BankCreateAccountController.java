package ee.bcs.valiit.controller;


import ee.bcs.valiit.dto.BankCreateAccount;
import ee.bcs.valiit.service.BankCreateAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankCreateAccountController {
    @Autowired
    BankCreateAccountService bankCreateAccountService;

    //CREATE ACCOUNT
    //http://localhost:8080/bank/createAccount
    @CrossOrigin
    @PostMapping("bank/createAccount")
    public String createAccount(@RequestBody BankCreateAccount accountDetails) {

        return bankCreateAccountService.createAccount(accountDetails);
    }

}
