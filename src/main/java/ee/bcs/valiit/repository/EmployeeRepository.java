package ee.bcs.valiit.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void addEmployee(String first_name, String last_name, Integer birth_year, String job_title) {
        String sql = "INSERT INTO employee (first_name, last_name, birth_year , job_title) VALUES(:dbfirst_name, :dblast_name, :dbbirth_year, :dbjob_title)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbfirst_name", first_name);
        paramMap.put("dblast_name", last_name);
        paramMap.put("dbbirth_year", birth_year);
        paramMap.put("dbjob_title", job_title);
        jdbcTemplate.update(sql, paramMap);
    }

    public String showEmployee(String first_name) {
        String sql = "SELECT job_title FROM employee WHERE first_name = :dbfirst_name";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbfirst_name", first_name);
        String job_title = jdbcTemplate.queryForObject(sql, paramMap, String.class);
        return job_title;
    }
    public void deleteEmployee(String first_name){
        String sql = "DELETE FROM employee WHERE first_name = :dbfirst_name";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbfirst_name", first_name);
        jdbcTemplate.update(sql, paramMap);
    }


}
