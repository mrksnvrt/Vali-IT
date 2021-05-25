package ee.bcs.valiit.repository;

import ee.bcs.valiit.dto.BankAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepo extends JpaRepository<BankAccountEntity, String> {
}
