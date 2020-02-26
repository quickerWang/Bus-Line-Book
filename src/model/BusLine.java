package model;

//the information of the busLine
public class BusLine {
    private int busnumber;
    private String start;  //the start station of busLine
    private String destination; //the destination of busLine
    private int price;  //the price of busLine
    private String currency;   //currency, EUR,JPY,USD

    //Constructor method
    public BusLine(int busnumber, String start, String destination, int price, String currency) {
        this.busnumber = busnumber;
        this.start = start;
        this.destination = destination;
        this.price = price;
        this.currency = currency;
    }

    public int getBusnumber() {
        return busnumber;
    }

    //override the toString of Object class
    @Override
    public String toString() {
        return String.format("%0" + 4 + "d" , busnumber) + ";" + start + ";" + destination + ";"
                + String.format("%.2f", (double) price) + ";" + currency;
    }


}
