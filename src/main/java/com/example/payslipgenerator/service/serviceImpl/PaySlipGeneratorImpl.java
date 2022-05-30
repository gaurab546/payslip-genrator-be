package com.example.payslipgenerator.service.serviceImpl;

import com.example.payslipgenerator.dto.EmployeeDto;
import com.example.payslipgenerator.dto.EmployeeDtoResponse;
import com.example.payslipgenerator.service.PaySlipGenerator;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        employeeDtoResponse.setIncomeTax((int) Math.round(calculateTax(employeeDto.getAnnualSalary())));
        employeeDtoResponse.setGrossIncome(calculateGrossIncome(employeeDto.getAnnualSalary()));
        employeeDtoResponse.setSuperAnnuation(calculateSuperIncome(employeeDto.getAnnualSalary(), employeeDto.getSuperRate()));
        employeeDtoResponse.setNetIncome(calculateNetIncome(employeeDto.getAnnualSalary()));

        //calculate date (start and end) 1 for start and 2 for end
        employeeDtoResponse.setFromDate("01 " + monthList(employeeDto.getPaymentMonth()));
        employeeDtoResponse.setToDate(calculateEndDate(employeeDto.getPaymentMonth()));

        return  employeeDtoResponse;
    }

    private Double calculateTax(Integer annualSalary) {
        double tax = 0.0;

        if (annualSalary > 18200)
            if(annualSalary <= 37000)
                tax = (annualSalary - 18200) * 0.19;
            else if (annualSalary > 37001 && annualSalary <= 87000)
                tax = (annualSalary - 37000) * 0.325 + 3572;
            else if (annualSalary > 87000 && annualSalary <= 180000)
                tax = (annualSalary - 87000) * 0.37 + 19822;
            else
                tax = (annualSalary - 180000) * 0.45 + 54232;
        return tax;
    }

    private Integer calculateGrossIncome(Integer annualSalary){
        return Math.round(annualSalary / 12);
    }

    private Integer calculateNetIncome( Integer annualSalary){
        double netIncome = calculateGrossIncome(annualSalary) - (calculateTax(annualSalary)/12);
        return (int) Math.round(netIncome);
    }

    private Integer calculateSuperIncome(Integer annualSalary, Double superRate){
        return (int) Math.round(calculateGrossIncome(annualSalary) * (superRate/100));
    }

    private String calculateEndDate(Integer paymentMonth){
        //get last day of month and add the month name
        switch (paymentMonth) {
            case 3:
            case 5:
            case 8:
            case 10:
                return 30 + " " + monthList(paymentMonth);
            case 1:
                if(LocalDate.now().getYear() % 4 == 0)
                    return 29 + " " + monthList(paymentMonth);
                return 28 + " " + monthList(paymentMonth);
            default:
                return 31 + " " + monthList(paymentMonth);
        }
    }

    private String monthList(Integer key){
        Map<Integer, String> months = new HashMap<>(){{
            put(0, "January");
            put(1, "February");
            put(2, "March");
            put(3, "April");
            put(4, "May");
            put(5, "June");
            put(6, "July");
            put(7, "August");
            put(8, "September");
            put(9, "October");
            put(10, "November");
            put(11, "December");
        }};
        return months.get(key);

    }

}
