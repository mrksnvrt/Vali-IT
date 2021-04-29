package ee.bcs.valiit.bank.bankRepository;

import ee.bcs.valiit.bank.bankDto.UsernameEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UsernameEntity, String> {
}
