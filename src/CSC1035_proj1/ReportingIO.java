package CSC1035_proj1;

import java.util.ArrayList;
import java.util.Scanner;


public class ReportingIO {
    static Reporting report = new Reporting(new ArrayList<>());
    static Scanner input = new Scanner(System.in);

    //Calls the main menu every time a method has finished until the user tells the program to exit
    public static void main(String[] args) throws Exception {
        while(true) {
            mainMenu();
        }
    }

    //Main menu
    private static void mainMenu() throws Exception {
        System.out.println("""
                Main Menu
                Select an option using the corresponding number:
                1. Enter AuctionHouse data
                2. Enter Item data
                3. Provide Reporting Statistics
                4. Exit""");
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
        AuctionHouse newAH = new AuctionHouse(TitleCase.toTitleCase(input.nextLine()));

        System.out.println("Would you like to add some items to "+newAH.getName()+" (y/n)?");
        String answer = String.valueOf(input.nextLine().charAt(0));
        if (answer.equalsIgnoreCase("y")) {
            System.out.println("How many would you like to add?");
            int amount = input.nextInt();
            input.nextLine();

            for(int i = 0; i < amount; i++) {
                newAH.addItem(item());
            }
        }
    }

    public static Item item() {
        int lot_number = 0;
        String buyer_name = "null";
        float price_sold = (float) -5.23;
        int year_sold = 0;
        String item_type = "null";

        System.out.println("The program will now take in your inputs regarding information about the item.\n" +
                "Any mistakes made will cause the program to ask about that input again.");

        while (true) {
            try {
                return new Item(lot_number, buyer_name, price_sold, year_sold, item_type);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                switch (e.getMessage()) {
                    case "lot number" -> {
                        System.out.println("Lot number: ");
                        lot_number = Integer.parseInt(input.nextLine());
                    }
                    case "name" -> {
                        System.out.println("Buyer Full Name: ");
                        buyer_name = input.nextLine();
                    }
                    case "price" -> {
                        System.out.println("Price Sold: ");
                        price_sold = Float.parseFloat(input.nextLine());
                        System.out.println(price_sold);
                    }
                    case "year" -> {
                        System.out.println("Year Sold: ");
                        year_sold = Integer.parseInt(input.nextLine());
                    }
                    case "item type" -> {
                        System.out.println("Item Type: ");
                        item_type = input.nextLine();
                    }
                    default -> System.out.println("Item successfully added.\n");
                }
            }
        }
    }

    public static void reporting() throws Exception {
        System.out.println("""
                Reporting Main Menu
                Select optional reporting statistics using the corresponding number:
                1. Auction House with largest average item price for a given year
                2. Highest price item ever reported
                3. All items sold with a price greater than a given amount
                4. Go back""");

        switch(input.nextLine().charAt(0)){
            case '1' -> {
                while (true) {
                    System.out.println("Year: ");
                    try {
                        System.out.println(report.highestAverage(input.nextInt()));
                        input.nextLine();
                        break;
                    } catch (Exception e) {
                        System.out.println("That is not an integer.");
                    }
                }
            }
            case '2' -> System.out.println(report.mostExpensive());
            case '3' -> {
                while (true) {
                    System.out.println("Price: ");
                    try {
                        System.out.println(report.priceGreaterTotal(input.nextFloat()));
                        input.nextLine();
                        break;
                    } catch (Exception e) {
                        System.out.println("That is not a valid float.");
                    }
                }
            }
            case '4' -> mainMenu();
        }

    }
}
