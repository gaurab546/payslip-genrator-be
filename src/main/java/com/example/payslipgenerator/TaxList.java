//package com.example.payslipgenerator;
//
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class TaxList {
//    private NavigableMap<Double, List<Double>> taxList = new TreeMap<Double, List<Double>>();
//    private String taxListFilePath;
//    private String csvSplitBy = ",";
//    private List<String> taxListInStrings;
//    private static Logger logger = Logger.getLogger("TaxList");
//
//    /**
//     * Class constructor with default location of tax List file
//     */
//    public TaxList() {
//        this.taxListFilePath = "src/main/resources/tax_List.csv";
//    }
//
//    /**
//     * Class constructor specifying file location where to load tax List
//     * @param taxListFilePath path of tax List file
//     */
//    public TaxList(String taxListFilePath) {
//        this.taxListFilePath = taxListFilePath;
//    }
//
//    /**
//     * Set taxList directly
//     * @param taxList the ATO tax Lists in a navigable map
//     */
//    public void setTaxList(NavigableMap<Double,List<Double>> taxList) {
//        this.taxList = taxList;
//    }
//
//    /**
//     * Get tax List directly
//     * @return the ATO tax Lists in a navigable map
//     */
//    public NavigableMap<Double,List<Double>> getTaxList() {
//        return this.taxList;
//    }
//
//    /**
//     * Load tax List from File
//     * @throws IOException if an input error occurs
//     */
//    public void loadTaxListFromFile() throws IOException {
//        // Read tax List file from disk
//        List<String> taxListDataStrings = Files.readAllLines(Paths.get(taxListFilePath), StandardCharsets.UTF_8);
//        this.taxList = parseTaxListFileData(taxListDataStrings);
//    }
//
//    /**
//     * Parse tax table data and store it in a navigable map
//     * @param taxTableData a list of String that contains tax table data read from file
//     * @return tax table data that's parsed
//     */
//    public NavigableMap<Double,List<Double>> parseTaxListFileData(List<String> taxTableData) {
//        NavigableMap<Double,List<Double>> taxTable = new TreeMap<Double, List<Double>>();
//
//        // Process each line of the file
//        if (taxTableData != null) {
//            for (String line: taxTableData) {
//                String[] tokens = line.split(csvSplitBy);
//
//                try {
//
//                    double lowerBound = Double.parseDouble(tokens[0]);
//                    // Store tax info in taxInfo
//                    List<String> tokensList = new ArrayList<String>(Arrays.asList(tokens));
//                    tokensList.remove(0);
//                    List<Double> taxInfo = new ArrayList<Double>();
//                    for (String s : tokensList) {
//                        taxInfo.add(Double.parseDouble(s));
//                    }
//
//                    taxTable.put(lowerBound, taxInfo);
//                } catch (Exception e) {
//                    logger.log(Level.WARNING, "Tax table row doesn't appear to be correct\n" + "Error message: "
//                            + e.getMessage() + "\n");
//                    return null;
//                }
//            }
//        }
//
//        return taxTable;
//    }
//
//    /**
//     * Return the relevant info from ATO tax table as per the salary amount given
//     * @param salary employee salary
//     * @return the tax table data corresponding to the employee salary needed to calculate income tax
//     */
//    public List<Double> getTaxInfo(Double salary) {
//        if (this.taxList == null) {
//            return null;
//        } else {
//            return this.taxList.get(taxList.floorKey(salary));
//        }
//    }
//
//    /**
//     * String representation of the tab table, retaining the original format from the file where it's extracted.
//     */
//    public String toString() {
//        String taxTableString = "";
//        for (String s : this.taxListInStrings) {
//            taxTableString += s + "\n";
//        }
//        return taxTableString;
//    }
//}
//
