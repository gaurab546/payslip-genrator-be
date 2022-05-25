//package com.example.payslipgenerator;
//
//import com.example.payslipgenerator.model.Employee;
//
//public class EmployeePaySlip {
//
//
//    private int grossIncome;
//
//    private int netIncome;
//
//    private int superIncome;
//
//    private int incomeTax;
//
//    private String payPeriod;
//
//    public EmployeePaySlip(){
//        grossIncome = 0;
//        netIncome = 0;
//        superIncome = 0;
//        incomeTax = 0;
//    }
//
//    public EmployeePaySlip(com.example.payslipgenerator.model.Employee.Employee employee, String payPeriod){
//    this();
//    this.employee = employee;
//    this.payPeriod = payPeriod;
//    }
//
//    public com.example.payslipgenerator.model.Employee.Employee getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(Employee.Employee employee) {
//        this.employee = employee;
//    }
//
//    public int getGrossIncome() {
//        return grossIncome;
//    }
//
//    public void setGrossIncome(int grossIncome) {
//        this.grossIncome = grossIncome;
//    }
//
//    public int getNetIncome() {
//        return netIncome;
//    }
//
//    public void setNetIncome(int netIncome) {
//        this.netIncome = netIncome;
//    }
//
//    public int getSuperIncome() {
//        return superIncome;
//    }
//
//    public void setSuperIncome(int superIncome) {
//        this.superIncome = superIncome;
//    }
//
//    public int getIncomeTax() {
//        return incomeTax;
//    }
//
//    public void setIncomeTax(int incomeTax) {
//        this.incomeTax = incomeTax;
//    }
//
//    public String getPayPeriod() {
//        return payPeriod;
//    }
//
//    public void setPayPeriod(String payPeriod) {
//        this.payPeriod = payPeriod;
//    }
//
//    @Override
//    public String toString() {
//        return "EmployeePaySlip{" +
//                "employee=" + employee +
//                ", grossIncome=" + grossIncome +
//                ", netIncome=" + netIncome +
//                ", superIncome=" + superIncome +
//                ", incomeTax=" + incomeTax +
//                ", payPeriod='" + payPeriod + '\'' +
//                '}';
//    }
//}
