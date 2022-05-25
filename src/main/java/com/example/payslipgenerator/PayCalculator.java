//package com.example.payslipgenerator;
//
//import com.example.payslipgenerator.model.Employee;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class PayCalculator {
//
//    private  TaxList taxList;
//    private List<EmployeePaySlip> employeePaySlipList;
//
//    private String inputDirectoryPath = "input" ;
//
//    private String outputDirectoryPath = "output";
//
//    private static Logger logger = Logger.getLogger("PayCalculator");
//
//
////    public PayCalculator() throws IOException{
////
////        taxList = new TaxList();
////        taxList.loadTaxListFromFile();
////
////        InputParser inputs = new InputParser();
////        this.employeePaySlipList = inputs.loadEmployeeData(this.inputDirectoryPath);
////    }
//
//    public PayCalculator (List<EmployeePaySlip> employeePaySlips, TaxList taxList){
//        this.taxList = taxList;
//        this.employeePaySlipList = employeePaySlips;
//    }
//
//    public static int calculateGrossIncome(com.example.payslipgenerator.model.Employee.Employee employee){
//        double grossIncome = employee.getSalary() / 12;
//
//        return (int) Math.round(grossIncome);
//    }
//
//    public static int calculateIncomeTax(com.example.payslipgenerator.model.Employee.Employee employee, List<Double> taxInfo) {
//        Double incomeTax;
//        incomeTax = (taxInfo.get(1) + (employee.getSalary() - taxInfo.get(3)) * taxInfo.get(2)) / 12;
//
//        return (int) Math.round(incomeTax);
//    }
//
//    public static int calculateNetIncome( int grossIncome, int incomeTax){
//        return  grossIncome - incomeTax;
//    }
//
//    public static int calculateSuperIncome(com.example.payslipgenerator.model.Employee.Employee employee, int grossIncome){
//      Double superIncome = grossIncome * employee.getSuperRate();
//      return (int) Math.round(superIncome);
//    }
//
//    public void dumpEmployeePayReportToDisk() throws IOException {
//        // If output directory doesn't exist
//        File outputDirectory = new File(this.outputDirectoryPath);
//        if ( ! outputDirectory.exists()) {
//            logger.log(Level.INFO, "Output directory doesn't exist. Creating it...\n");
//            new File(this.outputDirectoryPath).mkdirs();
//        }
//
//        File outputFile = new File(this.outputDirectoryPath + "/output.csv");
//        FileWriter fw = new FileWriter(outputFile, false);
//        for (EmployeePaySlip employeePayReport : this.employeePaySlipList) {
//            fw.write(employeePayReport.toString());
//        }
//        fw.close();
//
//        logger.log(Level.INFO, "Payment report has been generated. Please find it at: " + outputFile.getAbsolutePath());
//    }
//
//    public void dumpEmployeePayReportToStdout() {
//        for (EmployeePaySlip employeePaySlip : this.employeePaySlipList) {
//            System.out.print(employeePaySlipList.toString());
//        }
//
//   }
//
//    public void processEmployeePayments() throws IOException {
//
//        // Process Income numbers for all employees we've collected
//        if ( this.employeePaySlipList != null) {
//            Employee.Employee employee;
//            List<Double> taxInfo;
//
//            for (EmployeePaySlip employeePayReport : this.employeePaySlipList) {
//
//                // Load employee
//                employee = employeePayReport.getEmployee();
//                logger.info("Processing tax for employee " + employee.getFirstName() + " "
//                        + employee.getLastName() + "\n");
//
//                // Load data from tax table
//                taxInfo = this.taxList.getTaxInfo(employee.getSalary());
//                // If tax table cannot be loaded, return immediately
//                if (taxInfo == null) {
//                    logger.log(Level.SEVERE, "Could not load data from tax table! Stopping further processing");
//                    return;
//                }
//
//                // Calculate required numbers
//                int grossIncome = calculateGrossIncome(employee);
//                int incomeTax = calculateIncomeTax(employee, taxInfo);
//                int netIncome = calculateNetIncome(grossIncome, incomeTax);
//                int superIncome = calculateSuperIncome(employee, grossIncome);
//
//                employeePayReport.setGrossIncome(grossIncome);
//                employeePayReport.setIncomeTax(incomeTax);
//                employeePayReport.setNetIncome(netIncome);
//                employeePayReport.setSuperIncome(superIncome);
//            }
//        }
//    }
//}
