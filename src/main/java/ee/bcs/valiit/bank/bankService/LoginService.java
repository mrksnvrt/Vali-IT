package ee.bcs.valiit.bank.bankService;
import ee.bcs.valiit.bank.bankDto.LoginRequest;
import ee.bcs.valiit.bank.bankRepository.UserRepo;
import ee.bcs.valiit.solution.exception.SampleApplicationException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
@Service
public class LoginService {
    @Autowired
    UserRepo userRepo;

    public String logIn(LoginRequest loginRequest) {
        String password = userRepo.getOne(loginRequest.getUsername()).getPassword();

        if (loginRequest.getPassword().equals(password)) {
            Date tokenExpirationDate = new Date(new Date().getTime() + 1000 * 60 * 60 * 24);
            JwtBuilder jwtBuilder = Jwts.builder()
                    .setExpiration(tokenExpirationDate)
                    .setIssuedAt(new Date())
                    .signWith(SignatureAlgorithm.HS256, "c2VjcmV0")
                    .claim("username", loginRequest.getUsername());
            return jwtBuilder.compact();
        } else {
            throw new SampleApplicationException("Vale parool");
        }
    }
}
