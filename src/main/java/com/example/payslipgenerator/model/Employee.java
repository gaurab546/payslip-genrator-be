package com.example.payslipgenerator.model;

public class Employee {

        private String firstName;

        private String lastName;

        private Integer annualSalary;


        private Double superRate;

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public double getSalary() {
            return annualSalary;
        }

        public double getSuperRate() {
            return superRate;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", salary=" + annualSalary +
                    ", superRate=" + superRate +
                    '}';
        }
}
