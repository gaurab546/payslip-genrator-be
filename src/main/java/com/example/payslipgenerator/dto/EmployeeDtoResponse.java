package com.example.payslipgenerator.dto;


import java.math.BigDecimal;

public class EmployeeDtoResponse {

    private EmployeeDto employee;
    private String fromDate;
    private String toDate;
    private BigDecimal grossIncome;
    private BigDecimal incomeTax;
    private BigDecimal superAnnuation;

    private BigDecimal netIncome;


    public EmployeeDto getEmployee() {
        return employee;
    }


    public void setEmployee(EmployeeDto employee) {
        this.employee = employee;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String  fromDate) {
        this.fromDate = fromDate;
    }

    public String  getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public BigDecimal getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(BigDecimal grossIncome) {
        this.grossIncome = grossIncome;
    }

    public BigDecimal getIncomeTax() {
        return incomeTax;
    }

    public void setIncomeTax(BigDecimal incomeTax) {
        this.incomeTax = incomeTax;
    }

    public BigDecimal getSuperAnnuation() {
        return superAnnuation;
    }

    public void setSuperAnnuation(BigDecimal superAnnuation) {
        this.superAnnuation = superAnnuation;
    }

    public BigDecimal getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(BigDecimal netIncome) {
        this.netIncome = netIncome;
    }

}
