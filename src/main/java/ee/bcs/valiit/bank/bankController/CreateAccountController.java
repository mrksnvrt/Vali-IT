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
    //http://localhost:8080/bank/createAccount
    @CrossOrigin
    @PostMapping("bank/createAccount")
    public String createAccount(@RequestBody CreateAccount accountDetails) {

        return createAccountService.createAccount(accountDetails);
    }

}
