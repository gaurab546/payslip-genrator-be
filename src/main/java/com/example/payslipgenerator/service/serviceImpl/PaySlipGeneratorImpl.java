package com.example.payslipgenerator.service.serviceImpl;

import com.example.payslipgenerator.dto.EmployeeDto;
import com.example.payslipgenerator.dto.EmployeeDtoResponse;
import com.example.payslipgenerator.service.PaySlipGenerator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaySlipGeneratorImpl implements PaySlipGenerator {
    @Override
    public List<EmployeeDtoResponse> generatePaySlips(List<EmployeeDto> employeeDtoList) {
        employeeDtoList.forEach(System.out::println);
        List<EmployeeDtoResponse> list = new ArrayList<>();
        EmployeeDtoResponse employeeDtoResponse = new EmployeeDtoResponse();
        employeeDtoResponse.setEmployee(employeeDtoList.get(0));
        list.add(employeeDtoResponse);
        return list;
    }

    @Override
    public EmployeeDtoResponse generatePaySlip(EmployeeDto employeeDto) {
        return null;
    }
}
