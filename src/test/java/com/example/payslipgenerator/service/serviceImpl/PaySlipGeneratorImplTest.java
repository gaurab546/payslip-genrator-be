package com.example.payslipgenerator.service.serviceImpl;

import com.example.payslipgenerator.dto.EmployeeDto;
import com.example.payslipgenerator.dto.EmployeeDtoResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PaySlipGeneratorImplTest {

    @Autowired
    private PaySlipGeneratorImpl paySlipGenerator;


    @BeforeEach
    void setup(){
        paySlipGenerator = new PaySlipGeneratorImpl();
    }


    @Test
    void generatePaySlips() {

    }

    @Test
    void generatePaySlip() {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setAnnualSalary(20000);
        employeeDto.setSuperRate(0.5);

        EmployeeDtoResponse employeeDtoResponse = paySlipGenerator.generatePaySlip(employeeDto);

        assertEquals(employeeDtoResponse.getEmployee().getAnnualSalary(), employeeDto.getAnnualSalary());

    }
}