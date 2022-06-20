package com.example.payslipgenerator.controller;

import com.example.payslipgenerator.dto.EmployeeDto;
import com.example.payslipgenerator.dto.EmployeeDtoResponse;
import com.example.payslipgenerator.service.PaySlipGenerator;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/payslip/v1/")
@Validated
//payslip controller
public class PaySlipController {

    private PaySlipGenerator paySlipGenerator;

    public PaySlipController(PaySlipGenerator paySlipGenerator) {
        this.paySlipGenerator = paySlipGenerator;
    }
    //    public PaySlipController(PaySlipGenerator paySlipGenerator) {
//        this.paySlipGenerator = paySlipGenerator;
//    }

    @RequestMapping(method = RequestMethod.POST, value = "generate")
    public ResponseEntity<List<EmployeeDtoResponse>> generatePaySlip(@RequestBody @Valid List<EmployeeDto> employeeDtoList){
       return ResponseEntity.ok(paySlipGenerator.generatePaySlips(employeeDtoList));
    }


}
