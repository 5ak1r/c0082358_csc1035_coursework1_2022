package CSC1035_proj1;

import java.util.ArrayList;
import java.util.Scanner;


public class ReportingIO {
    static Reporting report = new Reporting(new ArrayList<>());
    static Scanner input = new Scanner(System.in);

    //Empty private constructor to prevent multiple instantiations of ReportingIO.
    private ReportingIO() {};

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

        System.out.println("Would you like to add some items to " + newAH.getName() + " (y/n)?");
        String answer = String.valueOf(input.nextLine().charAt(0));
        if (answer.equalsIgnoreCase("y")) {
            System.out.println("How many would you like to add?");
            int amount = input.nextInt();
            input.nextLine();

            for (int i = 0; i < amount; i++) {
                System.out.println("Has the item already been recorded in the report (y/n)?");
                if (input.nextLine().charAt(0) == 'y') {
                    System.out.println("What is the lot number of the item: ");
                    try {
                        int lot_num = Integer.parseInt(input.nextLine());
                        for (Item ite: report.getItems()) {
                            if(ite.getLotNumber() == lot_num) {
                                newAH.addItem(ite);
                            }
                        }
                    } catch (Exception e) {
                        //Would also add verification for integer entered being in valid range if I had more time
                        System.out.println("That is not an integer.");
                        i -= 1;
                    }
                } else {
                    newAH.addItem(item());
                    System.out.println("\nItem successfully added to " + newAH.getName());
                }
            }
            report.addAuctionHouse(newAH);
        }
    }

    //Allows the user to enter new item information and returns the item to be accessed by ReportingIO.auctionHouse()
    public static Item item() {
        //Initiating invalid item values so that it collects user input immediately.
        int lot_number = 0;
        String buyer_name = "null";
        float price_sold = (float) -5.23;
        int year_sold = 0;
        String item_type = "null";

        System.out.println("The program will now take in your inputs regarding information about the item.\n" +
                "Any mistakes made will cause the program to ask about that input again.");

        //Continues asking for a value until validation succeeds.
        while (true) {
            try {
                Item new_item = new Item(lot_number, buyer_name, price_sold, year_sold, item_type);
                report.addItem(new_item);
                System.out.println("Item successfully created.");
                return new_item;
            } catch (Exception e) {
                switch (e.getMessage()) {
                    case "lot number" -> {
                        System.out.println("Lot number: ");
                        try {
                            lot_number = Integer.parseInt(input.nextLine());
                        } catch (NumberFormatException n){
                            System.out.println("That is not an integer.");
                        }
                    }
                    case "name" -> {
                        System.out.println("Buyer Full Name: ");
                        buyer_name = input.nextLine();
                    }
                    case "price" -> {
                        System.out.println("Price Sold: ");
                        try {
                            price_sold = Float.parseFloat(input.nextLine());
                        } catch (NumberFormatException n) {
                            System.out.println("That is not a float.");
                        }
                    }
                    case "year" -> {
                        System.out.println("Year Sold: ");
                        try {
                            year_sold = Integer.parseInt(input.nextLine());
                        } catch (NumberFormatException n) {
                            System.out.println("That is not an integer.");
                        }
                    }
                    case "item type" -> {
                        System.out.println("Item Type: ");
                        item_type = input.nextLine();
                    }
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
            case '2' -> {
                Item highest_price = report.mostExpensive();
                if (highest_price.getBuyerName().equals("No Items")) {
                    System.out.println("No Items have been sold yet.");
                } else {
                    System.out.println(highest_price);
                }
            }
            case '3' -> {
                while (true) {
                    System.out.println("Price: ");
                    try {
                        ArrayList<Item> total_arraylist = report.priceGreaterTotal(input.nextFloat());
                        input.nextLine();
                        if (total_arraylist.isEmpty()) {
                            System.out.println("No Items have been added yet.");
                        } else {
                            System.out.println(total_arraylist);
                        }
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
