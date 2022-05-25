package com.example.payslipgenerator.service;

import com.example.payslipgenerator.dto.EmployeeDto;
import com.example.payslipgenerator.dto.EmployeeDtoResponse;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
public interface PaySlipGenerator {

    List<EmployeeDtoResponse> generatePaySlips(List<EmployeeDto> employeeDtoList);

    EmployeeDtoResponse generatePaySlip(EmployeeDto employeeDto);


}
