package ee.bcs.valiit.bank.bankController;


import ee.bcs.valiit.bank.bankDto.CreateAccount;
import ee.bcs.valiit.bank.bankService.CreateAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateAccountController {
    @Autowired
    CreateAccountService createAccountService;

    //CREATE ACCOUNT
    //http://localhost:8080/createAccount
    @CrossOrigin
    @PostMapping("createAccount")
    public void createAccount(@RequestBody CreateAccount accountDetails) {

        createAccountService.createAccount(accountDetails);
    }

}
