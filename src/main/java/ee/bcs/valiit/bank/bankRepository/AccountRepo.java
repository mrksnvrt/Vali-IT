package ee.bcs.valiit.bank.bankRepository;

import ee.bcs.valiit.bank.bankDto.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<AccountEntity, String> {
}
