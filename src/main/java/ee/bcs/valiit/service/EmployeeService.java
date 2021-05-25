package ee.bcs.valiit.service;

import ee.bcs.valiit.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    public void addEmployee(String first_name, String last_name, Integer birth_year, String job_title) {
        employeeRepository.addEmployee(first_name,last_name,birth_year,job_title);
    }
    public String showEmployee(String fist_name){
        String job_title = employeeRepository.showEmployee(fist_name);
        return "Hello " + fist_name + " you're job title is " + job_title;
    }
    public void deleteEmployee(String fist_name){
        employeeRepository.deleteEmployee(fist_name);
    }
}
