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
        employeeDtoResponse.setGrossIncome(calculateGrossIncome(employeeDto));
        employeeDtoResponse.setSuperAnnuation(calculateSuperIncome(employeeDto));
        //calculate super

        return  employeeDtoResponse;
    }

    private Integer calculateTax(Integer annualSalary) {
        int tax;
        if (annualSalary <= 18200) {
            tax = 0;
        } else if (annualSalary <= 37000) {
            tax = (annualSalary - 18200) * (int)0.19;
        } else if (annualSalary <= 87000) {
            tax = (annualSalary - 37000) * (int)0.325 + 3572;
        } else if (annualSalary <= 180000) {
            tax = (annualSalary - 87000) * (int)0.37 + 19822;
        } else {
            tax = (annualSalary - 180000) * (int)0.45 + 54232;
        }
        return (int) (annualSalary * tax);
    }

    private Integer calculateGrossIncome(EmployeeDto employeeDto){
        double grossIncome = employeeDto.getAnnualSalary() / 12;
        return (int) Math.round(grossIncome);
    }

    private Integer calculateNetIncome( EmployeeDto employeeDto){
        double netIncome = calculateGrossIncome(employeeDto) - calculateTax(employeeDto.getAnnualSalary());
        return (int) Math.round(netIncome);
    }

    private Integer calculateSuperIncome(EmployeeDto employeeDto){
        double superIncome = 10 + calculateGrossIncome(employeeDto);
        return (int) Math.round(superIncome);
    }

}
