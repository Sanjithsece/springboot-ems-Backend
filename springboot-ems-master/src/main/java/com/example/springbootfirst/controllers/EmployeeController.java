package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.models.UserDetailsDto;
import com.example.springbootfirst.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private AuthService aus;


    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/employee")
    public List<RegisterDetails> getMethod() {
        return aus.getMethod();
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/employee/{empID}")
    public RegisterDetails getEmployeeById(@PathVariable int empID) {
        return aus.getRegisterById(empID);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/employee/add")
    public String postMethod(@RequestBody RegisterDetails registerDetails) {
        return aus.saveRegister(registerDetails);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/employee/update")
    public String putMethod(@RequestBody RegisterDetails registerDetails) {
        return aus.updateRegister(registerDetails);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/employee/{empID}")
    public String deleteMethod(@PathVariable int empID) {
        return aus.deleteRegisterById(empID);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/employee/role/{roleName}")
    public List<RegisterDetails> getUsersByRole(@PathVariable String roleName) {
        return aus.getUsersByRole(roleName);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/employee/assign-work/{empId}")
    public String assignWorkToEmployee(@PathVariable int empId, @RequestBody List<String> workDescriptions) {
        return aus.assignWorkToEmployee(empId, workDescriptions);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PutMapping("/employee/edit-work/{empId}")
    public String updateWorkEmployee(@PathVariable int empId, @RequestBody List<String> workDescriptions) {
        return aus.updateWorkEmployee(empId, workDescriptions);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/employee/{empId}")
    public String updateRecord(@PathVariable int empId, @RequestBody UserDetailsDto updateDetails){
        return aus.updateRecord(empId, updateDetails);
    }

    public String route() {
        return "springboot";
    }

//    @PreAuthorize("hasAnyRole('ADMIN','USER')")
//    @GetMapping("/")
//    public String route(){
//        return "Employee Management ";
//    }
//
//    @PreAuthorize("hasRole('ADMIN')")
//    @GetMapping("/employee")
//    public List<Employee> getMethod(){
//        return hws.getMethod();
//    }
//
//    @PreAuthorize("hasRole('ADMIN')")
//    @GetMapping("/employee/{empID}")
//    public Employee getEmployeeById(@PathVariable int empID){
//        return hws.getEmployeeById(empID);
//    }
//
//    @PreAuthorize("hasRole('ADMIN')")
//    @PostMapping("/employee/add")
//    public String postMethod(@RequestBody Employee employee){
//        return hws.addEmployee(employee);
//    }
//
//    @PreAuthorize("hasRole('ADMIN')")
//    @PutMapping("/employee/update")
//    public String putMethod(@RequestBody Employee employee){
//        return hws.updateEmployee(employee);
//    }
//
//    @PreAuthorize("hasRole('ADMIN')")
//    @DeleteMapping("/employee/{empID}")
//    public String deleteMethod(@PathVariable int empID){
//        return hws.deleteEmployeeById(empID);
//    }


}
