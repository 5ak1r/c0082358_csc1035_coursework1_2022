package CSC1035_proj1;

import java.util.Scanner;


public class ReportingIO {

    public static void main() {
        while(true) {
            mainMenu();
        }
    }

    public static void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Main Menu\nSelect an option using the corresponding number:\n" +
                "1. Enter AuctionHouse data\n" +
                "2. Enter Item data\n" +
                "3. Provide Reporting Statistics\n" +
                "4. Exit");
        Character choice = scanner.nextLine().charAt(0);

        switch(choice) {
            case 1:
                auctionHouse();
                break;
            case 2:
                item();
                break;
            case 3:
                reporting();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                throw new IllegalArgumentException("That is not a valid option");

        }
    }
}
