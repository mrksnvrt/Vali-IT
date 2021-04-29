package ee.bcs.valiit.bank.bankRepository;

import ee.bcs.valiit.bank.bankDto.TransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TransActionRepo extends JpaRepository<TransferEntity, Integer>{

}
