package ee.bcs.valiit.controller;

import ee.bcs.valiit.dto.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class DtoEmployee {


    public static List<Employee> employeesList = new ArrayList<>();
    //http://localhost:8080/employees
    @GetMapping("employees")
    public List<Employee> rosterGet(){
        return employeesList;
    }

    @GetMapping("employees/{a}")
    public Employee rosterGet(@PathVariable("a")int a){
        Employee tagastus = employeesList.get(a);
        return tagastus;

    }
    @PostMapping("employees")
    public void rosterPost(@RequestBody Employee employeeData){
        employeesList.add(employeeData);
    }
    @PutMapping("employees/{a}")
    public void rosterPut(@RequestBody Employee employeeData, @PathVariable ("a")int a){
        employeesList.set(a,employeeData);
    }

    @DeleteMapping("employees/{a}")
    public void rosterDelete(@PathVariable ("a")int a){
        employeesList.remove(a);
    }

}
