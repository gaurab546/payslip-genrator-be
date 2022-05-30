package com.example.payslipgenerator.dto;


import java.time.LocalDate;

public class EmployeeDtoResponse {

    private EmployeeDto employee;
    private String fromDate;
    private String toDate;
    private Integer grossIncome;
    private Integer incomeTax;
    private Integer superAnnuation;

    private Integer netIncome;


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

    public Integer getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(Integer grossIncome) {
        this.grossIncome = grossIncome;
    }

    public Integer getIncomeTax() {
        return incomeTax;
    }

    public void setIncomeTax(Integer incomeTax) {
        this.incomeTax = incomeTax;
    }

    public Integer getSuperAnnuation() {
        return superAnnuation;
    }

    public void setSuperAnnuation(Integer superAnnuation) {
        this.superAnnuation = superAnnuation;
    }

    public Integer getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(Integer netIncome) {
        this.netIncome = netIncome;
    }

}
