package ee.bcs.valiit.tasks;

import ee.bcs.valiit.dto.SampleAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;


@Repository
public class AccountRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createAccount(SampleAccount accountDetails) {
        String sql = "INSERT INTO account (first_name, last_name, account_number, balance, block) VALUES(:dbfirst_name, :dblast_name, :dbaccountNumber, :dbbalance, :dbblock)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbfirst_name", accountDetails.getFirstName());
        paramMap.put("dblast_name", accountDetails.getLastName());
        paramMap.put("dbaccountNumber", accountDetails.getAccountNumber());
        paramMap.put("dbbalance", accountDetails.getBalance());
        paramMap.put("dbblock", accountDetails.isLocked());
        jdbcTemplate.update(sql, paramMap);
    }

    public Double showBalance(String accountNumber) {
        String sql = "SELECT balance FROM account WHERE account_number = :dbAccountNumber";
        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("dbAccountNumber", accountNumber);
        double balance = jdbcTemplate.queryForObject(sql, paraMap, Double.class);
        return balance;
    }
    public String showFirstName(String accountNumber){
        String sql1 = "SELECT first_name FROM account WHERE account_number = :dbAccountNumber";
        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("dbAccountNumber", accountNumber);
        String first_name = jdbcTemplate.queryForObject(sql1, paraMap, String.class);
        return first_name;
    }
    public Boolean showIsBlocked(String accountNumber){
        String sql = "SELECT block FROM account WHERE account_number = :dbAccountNumber";
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("dbAccountNumber", accountNumber);
        Boolean blocked = jdbcTemplate.queryForObject(sql, paramMap, Boolean.class);
        return blocked;
    }
    public void update(String accountNumber, Double amount) {
        Map<String, Object> paramMap1 = new HashMap<>();
        paramMap1.put("dbAccno", accountNumber);
        paramMap1.put("newBalance", amount);
        String sql1 = "UPDATE account SET balance = :newBalance WHERE account_number = :dbAccno";
        jdbcTemplate.update(sql1, paramMap1);
    }
    public String isLocked(String accountNumber){
        Map<String, Object> parmMap = new HashMap<>();
        String sql = ("UPDATE account  SET block = true WHERE account_number = :dbAccountNumber ");
        parmMap.put("dbAccountNumber", accountNumber);
        jdbcTemplate.update(sql, parmMap);
        return "You're account " + accountNumber + "is Blocked. Have a nice day!";
    }
    public String unLock(String accountNumber) {
        Map<String, Object> parmMap = new HashMap<>();
        String sql = ("UPDATE account SET block = false WHERE account_number = :dbAccountNumber");
        parmMap.put("dbAccountNumber", accountNumber);
        jdbcTemplate.update(sql, parmMap);
        return "You're account " + accountNumber + "is unlocked. Have a nice day!";
    }
    public void withdraw(String accountNumber, Double amount) {

//        Double accountBalance = showBalance(accountNumber);
//        Double newBalance = accountBalance - amount;
//        Map<String, Object> paramMap1 = new HashMap<>();
//        paramMap1.put("dbAccno", accountNumber);
//        paramMap1.put("newBalance", newBalance);
//        String sql1 = "UPDATE account SET balance = :newBalance WHERE account_number = :dbAccno";
//        jdbcTemplate.update(sql1, paramMap1);
    }
    public void transfer( String fromAccount, Double amountOfMoney, String toAccount) {

    }

}