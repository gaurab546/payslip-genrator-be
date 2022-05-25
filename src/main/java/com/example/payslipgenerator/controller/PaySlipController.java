package com.example.payslipgenerator.controller;

import com.example.payslipgenerator.dto.EmployeeDto;
import com.example.payslipgenerator.dto.EmployeeDtoResponse;
import com.example.payslipgenerator.service.PaySlipGenerator;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/payslip/v1/")
@Validated
public class PaySlipController {

    private PaySlipGenerator paySlipGenerator;

    public PaySlipController(PaySlipGenerator paySlipGenerator) {
        this.paySlipGenerator = paySlipGenerator;
    }

    @RequestMapping(method = RequestMethod.POST, value = "generate")
    public ResponseEntity<List<EmployeeDtoResponse>> generatePaySlip(@RequestBody @Valid List<EmployeeDto> employeeDtoList){
       return new ResponseEntity(paySlipGenerator.generatePaySlips(employeeDtoList), HttpStatusCode.valueOf(200));
    }

    @RequestMapping(method = RequestMethod.GET, value = "hello")
    public String hello(){
        return "hello";
    }
}
