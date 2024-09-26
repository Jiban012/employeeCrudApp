package com.employee.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dto.EmployeeRequest;
import com.employee.dto.TaxDeductionResponse;
import com.employee.entity.Employee;
import com.employee.exceptionHandler.ResourceNotFoundException;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    public Employee saveEmployee(EmployeeRequest employeeRequest) {
    	if (employeeRepository.existsById(employeeRequest.getEmployeeId())) {
            throw new IllegalArgumentException("Employee ID " + employeeRequest.getEmployeeId() + " already exists.");
        }
    	Employee employee = new Employee(employeeRequest.getEmployeeId(), employeeRequest.getFirstName(),employeeRequest.getLastName(),employeeRequest.getEmail(), employeeRequest.getPhoneNumbers(), employeeRequest.getDoj(), employeeRequest.getSalary());
        return employeeRepository.save(employee);
    }

    public TaxDeductionResponse getTaxDeductions(String employeeId) {
    	Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with ID " + employeeId + " not found"));

        double yearlySalary = calculateYearlySalary(employee);
        double taxAmount = calculateTax(yearlySalary);
        double cessAmount = calculateCess(yearlySalary);

        return new TaxDeductionResponse(employeeId, employee.getFirstName(), employee.getLastName(), yearlySalary, taxAmount, cessAmount);
    }

    public double calculateYearlySalary(Employee employee) {
        return employee.getSalary() * 12;
    }

    public double calculateTax(double yearlySalary) {
        double tax = 0;
        if (yearlySalary <= 250000) {
            return tax;
        }
        if (yearlySalary > 250000 && yearlySalary <= 500000) {
            tax = (yearlySalary - 250000) * 0.05;
        }
        else if (yearlySalary > 500000 && yearlySalary <= 1000000) {
            tax = (250000 * 0.05) + ((yearlySalary - 500000) * 0.10);
        }
        else if (yearlySalary > 1000000) {
            tax = (250000 * 0.05) + (500000 * 0.10) + ((yearlySalary - 1000000) * 0.20);
        }

        return tax;
    }

    public double calculateCess(double yearlySalary) {
        if (yearlySalary > 2500000) {
            return (yearlySalary - 2500000) * 0.02;
        }
        return 0;
    }
}

