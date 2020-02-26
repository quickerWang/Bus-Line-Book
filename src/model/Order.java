package model;

//The information of order
public class Order {
    private int invoiceNumber;  //the invoiceNumber of Invoice
    private int customerId;  //the id of customer

    public Order(int invoiceNumber, int customerId) {
        this.invoiceNumber = invoiceNumber;
        this.customerId = customerId;
    }
}
