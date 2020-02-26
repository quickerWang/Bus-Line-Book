package model;

import edu.kit.informatik.Terminal;

public class Main {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        while (true) {
            String str = Terminal.readLine();
            try {
                //quit the program
                if (str.equals("quit")) {
                    break;
                }
                //call the dispacher method of customerService
                customerService.dispacher(str);
            } catch (Exception e) {
                Terminal.printError(e.getMessage());
            }
        }
    }
}
