package ee.bcs.valiit.repository;

import ee.bcs.valiit.dto.BankUsernameEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankUserRepo extends JpaRepository<BankUsernameEntity, String> {
}
