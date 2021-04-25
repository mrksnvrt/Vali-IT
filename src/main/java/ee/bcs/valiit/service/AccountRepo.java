package ee.bcs.valiit.service;

import ee.bcs.valiit.solution.hibernate.SampleAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<AccountEntity, String> {
}
