package ee.bcs.valiit.repository;

import ee.bcs.valiit.dto.BankTransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankTransActionRepo extends JpaRepository<BankTransferEntity, Integer>{

}
