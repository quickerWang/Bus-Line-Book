package model;

//The information of customer
public class Customer {
    private String name; //The last name
    private String surName; //The first name
    private int customerNumber;  //the customerId of customer

    public Customer(String name, String surName, int customerNumber) {
        this.name = name;
        this.surName = surName;
        this.customerNumber = customerNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }
}
