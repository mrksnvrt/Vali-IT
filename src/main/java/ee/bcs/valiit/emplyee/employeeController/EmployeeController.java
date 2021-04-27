package ee.bcs.valiit.emplyee.employeeController;

import ee.bcs.valiit.emplyee.employeeDto.DtoEmployee;
import ee.bcs.valiit.emplyee.employeeService.EmployeeService;
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

//    public static List<Employee> employeesList = new ArrayList<>();
//    //http://localhost:8080/employees/listfull
//    @GetMapping("employees/listfull")
//    public List<Employee> rosterGet(){
//        return employeesList;
//    }
//
//    //http://localhost:8080/employees/list/2
//    @GetMapping("employees/list/{a}")
//    public Employee rosterGet(@PathVariable("a")int a){
//        return employeesList.get(a);
//    }
//
//    //http://localhost:8080/employees/add
//    @PostMapping("employees/add")
//    public void rosterPost(@RequestBody Employee employeeData){
//        employeesList.add(employeeData);
//    }
//
//    //http://localhost:8080/employees/put/1
//    @PutMapping("employees/put/{a}")
//    public void rosterPut(@RequestBody Employee employeeData,
//                          @PathVariable ("a")int a){
//        employeesList.set(a,employeeData);
//    }
//
//    //http://localhost:8080/employees/delete/1
//    @DeleteMapping("employees/delete/{a}")
//    public void rosterDelete(@PathVariable ("a")int a){
//        employeesList.remove(a);
//    }
//}

