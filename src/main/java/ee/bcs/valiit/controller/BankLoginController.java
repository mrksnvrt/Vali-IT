package ee.bcs.valiit.controller;
import ee.bcs.valiit.dto.BankLoginRequest;
import ee.bcs.valiit.service.BankLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class BankLoginController {
    @Autowired
    private BankLoginService bankLoginService;
    //http://localhost:8080/bank/login
    @CrossOrigin
    @PostMapping("bank/login")
    public String sampleLogin(@RequestBody BankLoginRequest bankLoginRequest){
        return bankLoginService.logIn(bankLoginRequest);
    }
}
