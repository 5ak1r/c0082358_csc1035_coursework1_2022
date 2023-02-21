package CSC1035_proj1;

import java.util.ArrayList;
import java.util.Scanner;


public class ReportingIO {
    static Reporting report = new Reporting(new ArrayList<>());
    static Scanner input = new Scanner(System.in);

    //Calls the main menu every time a method has finished until the user tells the program to exit
    public static void main(String[] args) {
        while(true) {
            mainMenu();
        }
    }

    //Main menu
    private static void mainMenu() {
        System.out.println("Main Menu\nSelect an option using the corresponding number:\n" +
                "1. Enter AuctionHouse data\n" +
                "2. Enter Item data\n" +
                "3. Provide Reporting Statistics\n" +
                "4. Exit");
        char choice = input.nextLine().charAt(0);

        switch (choice) {
            case '1' -> auctionHouse();
            case '2' -> item();
            case '3' -> reporting();
            case '4' -> System.exit(0);
            default -> throw new IllegalArgumentException("That is not a valid option");
        }
    }

    //Create new auction house using user inputs
    public static void auctionHouse() {

        System.out.println("What is the name of the Auction House?\nName: ");
        new AuctionHouse(TitleCase.toTitleCase(input.nextLine()));

        System.out.println("Would you like to add some items to the Auction House (y/n)?\n");
        String answer = String.valueOf(input.nextLine().charAt(0));
        if (answer.equalsIgnoreCase("y")) {
            System.out.println("How many would you like to add?\n");
            int amount = input.nextInt();

            for(int i = 0; i < amount; i++) {
                Item current_item = item();
            }
        }
    }

    public static Item item() {
        int lot_number = 0;
        String buyer_name = "null";
        float price_sold = (float) -5.23;
        int year_sold = 0;
        String item_type = "null";

        try {
            Item current_item = new Item(lot_number, buyer_name, price_sold, year_sold, item_type);
        }
        catch (Exception e) {
            switch (e.getMessage()) {
                case "name":
                    System.out.println("Lot number: ");


            }
        }
    }

    public static void reporting() {

    }
}
