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
        List<EmployeeDtoResponse> list = new ArrayList<>();
        employeeDtoList.forEach(
                employeeDto -> list.add(generatePaySlip(employeeDto))

        );

        return list;
    }

    @Override
    public EmployeeDtoResponse generatePaySlip(EmployeeDto employeeDto) {
        EmployeeDtoResponse employeeDtoResponse = new EmployeeDtoResponse();
        //calculate tax
        employeeDtoResponse.setEmployee(employeeDto);
        employeeDtoResponse.setIncomeTax(calculateTax(employeeDto.getAnnualSalary()));
        //calculate super

        return  employeeDtoResponse;
    }

    private Integer calculateTax(Integer annualSalary) {

        return (int) (annualSalary * 0.20);
    }
}
