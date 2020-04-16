package com.fss.empdb.controller;

import com.fss.empdb.domain.Account;
import com.fss.empdb.domain.Employee;
import com.fss.empdb.domain.SearchCriteria;
import com.fss.empdb.service.CustomerService;
import com.fss.empdb.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private static Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    CustomerService customerService;

    //Get All Employee
    @GetMapping("/get-all-customer")
    public ResponseEntity<List<Account>> getAllEmployee() {
        return ResponseEntity.ok().body(customerService.getAllAccount());
    }

    @GetMapping("/get-all-customer/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable(value = "id") Long employeeId) {
        return ResponseEntity.ok().body(customerService.getAccountById(employeeId));
    }

    @PostMapping(value = "/customer-search-criteria", produces = "application/json")
    public ResponseEntity<List<Account>> getAccountBySearch(String empSearch)  {
        LOGGER.info("-------Controller---------" + empSearch);


        return ResponseEntity.ok().body(customerService.findByAccount(empSearch));

    }




}
