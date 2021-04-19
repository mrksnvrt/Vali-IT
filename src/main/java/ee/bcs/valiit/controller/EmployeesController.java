package ee.bcs.valiit.controller;

import ee.bcs.valiit.dto.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class EmployeesController {

    public static List<Employee> employeesList = new ArrayList<>();
    //http://localhost:8080/employees/listfull
    @GetMapping("employees/listfull")
    public List<Employee> rosterGet(){
        return employeesList;
    }

    //http://localhost:8080/employees/list/2
    @GetMapping("employees/list/{a}")
    public Employee rosterGet(@PathVariable("a")int a){
        return employeesList.get(a);
    }

    //http://localhost:8080/employees/add
    @PostMapping("employees/add")
    public void rosterPost(@RequestBody Employee employeeData){
        employeesList.add(employeeData);
    }

    //http://localhost:8080/employees/put/1
    @PutMapping("employees/put/{a}")
    public void rosterPut(@RequestBody Employee employeeData,
                          @PathVariable ("a")int a){
        employeesList.set(a,employeeData);
    }

    //http://localhost:8080/employees/delete/1
    @DeleteMapping("employees/delete/{a}")
    public void rosterDelete(@PathVariable ("a")int a){
        employeesList.remove(a);
    }
}
