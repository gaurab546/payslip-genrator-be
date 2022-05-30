package com.example.payslipgenerator.dto;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class EmployeeDto {
    @NotBlank(message = "first name cannot be blank")
    private String firstName;
    @NotBlank(message = "last name cannot be blank")
    private String lastName;

    @Positive(message = "Please pass a non negative integer for annual salary")
    private Integer annualSalary;
    @Positive(message = "Please pass a non negative double value for Super Rate")
    private Double superRate;

    @Min(value = 0, message = "Must be between 0 (Jan) and 11 (Dec) including")
    @Max(value = 11, message = "Must be between 0 (Jan) and 11 (Dec) including")
    private Integer paymentMonth;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(Integer annualSalary) {
        this.annualSalary = annualSalary;
    }

    public Double getSuperRate() {
        return superRate;
    }

    public void setSuperRate(Double superRate) {
        this.superRate = superRate;
    }

    public EmployeeDto(String firstName, String lastName, Integer annualSalary, Double superRate, Integer paymentMonth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.annualSalary = annualSalary;
        this.superRate = superRate;
        this.paymentMonth = paymentMonth;
    }

    public EmployeeDto() {
    }

    public Integer getPaymentMonth() {
        return paymentMonth;
    }

    public void setPaymentMonth(Integer paymentMonth) {
        this.paymentMonth = paymentMonth;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", annualSalary=" + annualSalary +
                ", superRate=" + superRate +
                '}';
    }
}
