package ee.bcs.valiit.service;
import ee.bcs.valiit.dto.BankLoginRequest;
import ee.bcs.valiit.repository.BankUserRepo;
import ee.bcs.valiit.solution.exception.SampleApplicationException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Date;
@Service
public class BankLoginService {
    @Autowired
    BankUserRepo bankUserRepo;
    @Autowired
    PasswordEncoder passwordEncoder;

    public String logIn(BankLoginRequest bankLoginRequest) {
        String password = bankUserRepo.getOne(bankLoginRequest.getUsername()).getPassword();

        if (passwordEncoder.matches(bankLoginRequest.getPassword(),password)) {
            Date tokenExpirationDate = new Date(new Date().getTime() + 1000 * 60 * 60 * 24);
            JwtBuilder jwtBuilder = Jwts.builder()
                    .setExpiration(tokenExpirationDate)
                    .setIssuedAt(new Date())
                    .signWith(SignatureAlgorithm.HS256, "c2VjcmV0")
                    .claim("username", bankLoginRequest.getUsername());
            return jwtBuilder.compact();
        } else {
            throw new SampleApplicationException("Vale parool");
        }
    }
}
