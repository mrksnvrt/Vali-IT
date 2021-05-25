package ee.bcs.valiit.dto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "transaction_history")
@Entity
public class BankTransferEntity {

    @Id
    //auto increment not ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fromAccount;
    private String toAccount;
    private LocalDateTime dateTime;
    private double transferAmount;
    private String transferType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public double getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(double transferAmount) {
        this.transferAmount = transferAmount;
    }

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }
}
