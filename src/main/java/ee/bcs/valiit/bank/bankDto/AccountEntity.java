package ee.bcs.valiit.bank.bankDto;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Table(name = "account")
@Entity

public class AccountEntity {
        //auto increment not ID
        //@GeneratedValue (strategy = GenerationType.IDENTITY)
        @Id
        private String accountNumber;
        private double balance;
        private boolean block;
        private String firstName;
        private String lastName;
        private LocalDateTime dateTime;

        public String getAccountNumber() {
                return accountNumber;
        }

        public void setAccountNumber(String accountNumber) {
                this.accountNumber = accountNumber;
        }

        public double getBalance() {
                return balance;
        }

        public void setBalance(double balance) {
                this.balance = balance;
        }

        public boolean isBlock() {
                return block;
        }

        public void setBlock(boolean block) {
                this.block = block;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public LocalDateTime getDateTime() {
                return dateTime;
        }

        public void setDateTime(LocalDateTime dateTime) {
                this.dateTime = dateTime;
        }
}