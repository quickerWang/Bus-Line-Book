package model;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//The main service
public class CustomerService {

    private static int customerId = 0;  //static customer number
    private static int invoiceNumber = 0; //static invoice number
    private List<Customer> customerList = new LinkedList<>(); //customer list
    private List<BusLine> busList = new LinkedList<>();  //bus list
    private List<Order> orderList = new LinkedList<>(); //order list

    //dispacher method
    public void dispacher(String command) throws Exception {

        Queue<Double> queue = new LinkedList<>();
        StringBuilder s = new StringBuilder();

        String[] cs = command.split(" ");
        //Judge the operation
        switch(cs[0]) {
            case "add":

                String str = null;
                str.replaceAll();
                //Call the add method by parameters
                String[] parameters = cs[1].split(" ; ");
                add(parameters);
                List<Integer> hour = new LinkedList<>();
                break;
            case "remove":
                //Call the remove method by parameters
                String[] parameters1 = cs[1].split(";");
                remove(parameters1);
                break;
            case "list-route":
                //Print the information of busLine
                for (BusLine busLine:busList) {
                    System.out.println(busLine);
                }
                break;
            case "book":
                //Call the book method by parameters
                String[] parameters2 = cs[1].split(";");
                book(parameters2);
                break;
            default:
                throw new Exception("Wrong command");
        }
    }

    //Add a busLine to busList
    public void add(String[] parameters) throws Exception {
        try {
            //Handle the value of busNumber
            for (int i = 0; i < parameters[0].length(); i++) {
                if (parameters[0].charAt(i) != '0') {
                    parameters[0] = parameters[0].substring(i);
                    break;
                }
            }
            int busNumber = Integer.valueOf(parameters[0]);
            if (busNumber < 0 || busNumber > 1000) {
                throw new Exception("busNumber exceed the range(0,1000)");
            }
            //Handle the value of price
            String[] pricesInt = parameters[3].split("\\.");
            int price = Integer.parseInt(pricesInt[0]);
            if (!(pricesInt[1].equals("00"))) {
                throw new Exception("Price pattern is wrong");
            }
            //Handle the value of currency
            if (!parameters[4].equals("EUR") && !parameters[4].equals("USD") && !parameters[4].equals("JPY")) {
                throw new Exception("Currency is wrong");
            }
            //Add busLine to busList
            busList.add(new BusLine(busNumber, parameters[1], parameters[2], price, parameters[4]));
        } catch (Exception e ) {
            throw e;
        }
        System.out.println("OK");
    }

    // Remove remove a busLine to busList

    public void remove(String[] parameters)throws Exception {
        try {
            //Handle the value of busNumber
            for (int i = 0; i < parameters[0].length(); i++) {
                if (parameters[0].charAt(i) != '0') {
                    parameters[0] = parameters[0].substring(i);
                    break;
                }
            }
            String businessNumber = parameters[0];
            int x = Integer.parseInt(businessNumber);
            //Judge if there have a busNumber which equals given busNumber
            for (BusLine busLine : busList) {
                if (busLine.getBusnumber() == x) {
                    busList.remove(busLine);
                    System.out.println("OK");
                    return;
                }
            }
            throw new Exception("The Bus which busNumber equals " + businessNumber + " not exists");
        } catch (Exception e) {
            throw e;
        }
    }


    //Book the busLine
    public void book(String[] parameters)throws Exception {
        try {
            //Handle the value of busNumber
            for (int i = 0; i < parameters[0].length(); i++) {
                if (parameters[0].charAt(i) != '0') {
                    parameters[0] = parameters[0].substring(i);
                    break;
                }
            }
            String businessNumber = parameters[0];
            int x = Integer.parseInt(businessNumber);
            Boolean flag = false;
            //Judge if there have a busNumber which equals given busNumber
            for (BusLine busLine:busList) {
                if (busLine.getBusnumber() == x) {
                    flag = true;
                }
            }
            if (!flag) {
                throw new Exception("The Bus which busNumber equals " + businessNumber + " not exists");
            }
            boolean isCustomerExists = false;
            for (Customer customer:customerList) {
                if ((parameters[1] + parameters[2]).equals(customer.getName() + customer.getSurName())) {
                    //If customerList have this customer
                    isCustomerExists = true;
                    orderList.add(new Order(++invoiceNumber, customer.getCustomerNumber()));
                    System.out.println(invoiceNumber + ";" + customer.getCustomerNumber());
                }
            }
            //If customerList do not have this customer
            if (!isCustomerExists) {
                customerList.add(new Customer(parameters[1], parameters[2], (++customerId)));
                orderList.add(new Order(++invoiceNumber, customerId));
                System.out.println(invoiceNumber + ";" + customerId);
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
