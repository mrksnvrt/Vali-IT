package ee.bcs.valiit.employee;

import ee.bcs.valiit.controller.DepositWithdraw;
import ee.bcs.valiit.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //http://localhost:8080/mrksnvrt/addEmployee
    @PostMapping("mrksnvrt/addEmployee")
    public void addEmployee(@RequestBody DtoEmployee employeeData) {
        String first_name = employeeData.getFirst_name();
        String last_name = employeeData.getLast_name();
        Integer birth_year = employeeData.getBirth_year();
        String job_title = employeeData.getJob_title();
        employeeService.addEmployee(first_name, last_name, birth_year, job_title);
    }
    //http://localhost:8080/mrksnvrt/showEmployee
    @GetMapping("mrksnvrt/showEmployee")
    public String showEmployee(@RequestBody DtoEmployee employeeData) {
        String first_name = employeeData.getFirst_name();
        return employeeService.showEmployee(first_name);
    }
    //http://localhost:8080/mrksnvrt/showEmployee
    @DeleteMapping  ("mrksnvrt/deleteEmployee")
    public String deleteEmployee(@RequestBody DtoEmployee employeeData) {
        String first_name = employeeData.getFirst_name();
        return employeeService.showEmployee(first_name);
    }

}

