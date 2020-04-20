package com.fss.empdb.controller;

import com.fss.empdb.domain.Employee;
import com.fss.empdb.domain.SearchCriteria;
import com.fss.empdb.service.EmployeeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Log4j2
@RequestMapping("/empservice/v1")
public class EmployeeController {


    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        return ResponseEntity.ok().body(employeeService.getAllEmployees());
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId) {
        return ResponseEntity.ok().body(employeeService.getEmployeeById(employeeId));
    }

    @PostMapping(value = "/employee-search", produces = "application/json")
    public ResponseEntity<List<Employee>> getEmployeeBySearchCriteria(@RequestBody SearchCriteria empSearch)  {
        log.info("-------getEmployeeBySearchCriteria---------" + empSearch);
        //LOGGER.info("-------Controller---------" + empSearch);
        return ResponseEntity.ok().body(employeeService.findByEmp(empSearch));
    }

    //Add & Update Employee
    @PostMapping(value = "/emp-add-update")
    public ResponseEntity<Employee> createOrUpdateEmployee(@RequestBody Employee employee)  {
        log.info("-------createOrUpdateEmployee---------" + employee);
        Employee emp = employeeService.createOrUpdateEmployee(employee);
        return new ResponseEntity<Employee>(emp, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/employee/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable(value = "id") Long employeeId){
        log.info("-------deleteEmployee---------" + employeeId);
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<Employee>(new HttpHeaders(), HttpStatus.OK);
    }

}
