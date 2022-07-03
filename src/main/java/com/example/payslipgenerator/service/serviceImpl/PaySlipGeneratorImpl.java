package com.example.payslipgenerator.service.serviceImpl;

import com.example.payslipgenerator.dto.EmployeeDto;
import com.example.payslipgenerator.dto.EmployeeDtoResponse;
import com.example.payslipgenerator.service.PaySlipGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.*;

import static com.example.payslipgenerator.service.serviceImpl.TaxCalculatorImpl.calculateTax;

@Service
public class PaySlipGeneratorImpl implements PaySlipGenerator {

//value considered in application.properties
    @Value("${thresholdvalue_1}")
    private Double th1;

    @Value("${thresholdvalue_2}")
    private Double th2;

    @Value("${thresholdvalue_3}")
    private Double th3;

    @Value("${thresholdvalue_4}")
    private Double th4;

    @Value("${thresholdrate_1}")
    private Double thr1;
    @Value("${thresholdrate_2}")
    private Double thr2;
    @Value("${thresholdrate_3}")
    private Double thr3;
    @Value("${thresholdrate_4}")
    private Double thr4;

    @Value("${taxrate_1}")
    private Double tx1;
    @Value("${taxrate_2}")
    private Double tx2;
    @Value("${taxrate_3}")
    private Double tx3;




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
        employeeDtoResponse.setIncomeTax(calculateTax(BigDecimal.valueOf(employeeDto.getAnnualSalary())).get());
        employeeDtoResponse.setGrossIncome(calculateGrossIncome(employeeDto.getAnnualSalary()));
        employeeDtoResponse.setSuperAnnuation(calculateSuperIncome(employeeDto.getAnnualSalary(), employeeDto.getSuperRate()));
        employeeDtoResponse.setNetIncome(calculateNetIncome(employeeDto.getAnnualSalary()));

        //calculate date (start and end) 1 for start and 2 for end
        employeeDtoResponse.setFromDate("01 " + monthList(employeeDto.getPaymentMonth()));
        employeeDtoResponse.setToDate(calculateEndDate(employeeDto.getPaymentMonth()));

        return  employeeDtoResponse;
    }

//    private Double calculateTax(Integer annualSalary) {
//        double tax = 0.0;
//
//        if (annualSalary > th1)
//            if(annualSalary <= th2)
//                tax = (annualSalary - th1) * thr1;
//            else if (annualSalary > th2 && annualSalary <= th3)
//                tax = (annualSalary - th2) * thr2 + tx1;
//            else if (annualSalary > th3 && annualSalary <= th4)
//                tax = (annualSalary - th3) * thr3 + tx2;
//            else
//                tax = (annualSalary - th4) * thr3 + tx3;
//        return tax;
//    }

    private BigDecimal calculateGrossIncome(Integer annualSalary){
        return BigDecimal.valueOf(annualSalary / 12);
    }

    private BigDecimal calculateNetIncome(Integer annualSalary){
        Optional<BigDecimal> incomeTaxOptional = calculateTax(BigDecimal.valueOf(annualSalary));
        BigDecimal incomeTax = incomeTaxOptional.get().divide(BigDecimal.valueOf(12), 0, RoundingMode.HALF_UP);
        return calculateGrossIncome(annualSalary).subtract(incomeTax);
    }

    private BigDecimal calculateSuperIncome(Integer annualSalary, Double superRate){
        return calculateGrossIncome(annualSalary).multiply(BigDecimal.valueOf(superRate)).setScale(0,
                RoundingMode.HALF_UP);
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
