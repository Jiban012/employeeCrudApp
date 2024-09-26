package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.EmployeeRequest;
import com.employee.dto.TaxDeductionResponse;
import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody @Valid EmployeeRequest employeeRequest) {
        Employee savedEmployee = employeeService.saveEmployee(employeeRequest);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{employeeId}/tax-deductions")
    public ResponseEntity<TaxDeductionResponse> getTaxDeductions(@PathVariable String employeeId) {
        TaxDeductionResponse response = employeeService.getTaxDeductions(employeeId);
        return ResponseEntity.ok(response);
    }
}
