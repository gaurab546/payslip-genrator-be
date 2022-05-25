package com.example.payslipgenerator.dto;


import java.time.LocalDate;

public class EmployeeDtoResponse {

    private EmployeeDto employee;
    private LocalDate fromDate;
    private LocalDate toDate;
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

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
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
