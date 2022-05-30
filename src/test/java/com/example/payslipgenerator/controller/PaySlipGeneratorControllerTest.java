package com.example.payslipgenerator.controller;

import com.example.payslipgenerator.dto.EmployeeDto;
import com.example.payslipgenerator.dto.EmployeeDtoResponse;
import com.example.payslipgenerator.service.serviceImpl.PaySlipGeneratorImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PaySlipGeneratorControllerTest {


    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void generatePaySlips()  {
        List<EmployeeDto> list = new ArrayList<>();
        list.add(createEmployee());
        ResponseEntity<List> response =
                restTemplate.postForEntity(URI.create("/payslip/v1/generate"),
                list, List.class);
        assertEquals(200, response.getStatusCode().value());

    }

    @Test
    public void generatePaySlipsValidationFailure()  {
        List<EmployeeDto> list = new ArrayList<>();
        EmployeeDto employeeDto = createEmployee();
        employeeDto.setFirstName("");
        employeeDto.setLastName("");
        list.add(employeeDto);
        ResponseEntity<List> response =
                restTemplate.postForEntity(URI.create("/payslip/v1/generate"),
                        list, List.class);
        assertEquals(400, response.getStatusCode().value());

    }

    private EmployeeDto createEmployee(){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setFirstName("Gaurav");
        employeeDto.setLastName("Karki");
        employeeDto.setAnnualSalary(20000);
        employeeDto.setSuperRate(0.5);
        employeeDto.setPaymentMonth(5);

        return employeeDto;
    }
}
