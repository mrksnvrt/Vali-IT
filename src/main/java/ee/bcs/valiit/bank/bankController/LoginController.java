package ee.bcs.valiit.bank.bankController;
import ee.bcs.valiit.bank.bankDto.LoginRequest;
import ee.bcs.valiit.bank.bankService.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    //http://localhost:8080/bank/login
    @PostMapping("bank/login")
    public String sampleLogin(@RequestBody LoginRequest loginRequest){
        return loginService.logIn(loginRequest);
    }
}
