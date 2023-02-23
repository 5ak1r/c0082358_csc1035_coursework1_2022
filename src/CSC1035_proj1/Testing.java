package CSC1035_proj1;

import java.util.ArrayList;

public class Testing {

    public static void main(String[] args) {
        ArrayList<Item> test_items = testItem();
        ArrayList<AuctionHouse> test_auction_houses = testAuctionHouse(test_items);
        testReporting(test_auction_houses);
    }

    public static ArrayList<Item> testItem() {
        //Create empty ArrayList to move creates test Item objects into the testAuctionHouse method
        ArrayList<Item> test_items = new ArrayList<>();
        //Error messages are very simple as they're used as conditions in a switch case
        //Comment out errors to see the rest of the tests as raising errors usually makes the program halt
        try {
            //This should succeed as none of the inputs are invalid
            Item test_item = new Item(100000, "Sakir Azimkar", 2.33F, 2022, "f");
            System.out.println(test_item.getBuyerName()); //Should output "Sakir Azimkar"
            System.out.println(test_item.getItemType()); //Should output "furniture"
            test_item.setItemType("p"); //Should change the value of test_item.item_type to "painting"
            System.out.println(test_item.getItemType()); //Should output "painting"
            //test_item.setYearSold(3000); //Should raise an error as 3000 is not a valid year, output="year"
            System.out.println(test_item.getYearSold()); //Should be unchanged due to fail above, output=2022
            //test_item.setBuyerName("John"); //Should raise an error as the buyer's full name is not input, output="Name"
            test_item.setBuyerName("bORis jOhn'soN"); //Should change test_item.buyer_name to Boris John'Son
            System.out.println(test_item.getBuyerName()); //Should output "Boris John'Son" with correct title casing

            //Testing successful instantiation of multiple valid Items
            Item test_item_1 = new Item(100001, "Owen Pritchard", 32.55F, 2010, "s");
            System.out.println(test_item_1); //Should output "Item(100001, Owen Pritchard, 32.55, 2010, statue)"
            Item test_item_2 = new Item(100002, "Denis Dysen", 425.34F, 2005, "f");
            System.out.println(test_item_2); //Should output "Item(100002, Denis Dysen, 425.34F, 2005, furniture)"
            Item test_item_3 = new Item(100003, "Harvey Proctor", 65.37F, 2019, "p");
            System.out.println(test_item_3); //Should output "Item(100003, Harvey Proctor, 65.37F, 2019, painting)"
            Item test_item_4 = new Item(100004, "Adam Lenahan", 36.88F, 2004, "s");
            System.out.println(test_item_4); //Should output "Item(100004, Adam Lenahan, 36.88F, 2004, statue)"

            test_items.add(test_item_1);
            test_items.add(test_item_2);
            test_items.add(test_item_3);
            test_items.add(test_item_4);


        } catch (Exception e) {
            System.out.println(e.getMessage()); //Should output the error message created by the failed verification
        }
        return test_items;
    }

    public static ArrayList<AuctionHouse> testAuctionHouse(ArrayList<Item> test_items) {
        //Create empty ArrayList to move created AuctionHouse objects into the testReporting method
        ArrayList<AuctionHouse> test_auction_houses = new ArrayList<>();
        try {
            //Should instantiate an AuctionHouse object with the attribute test_auction_house.name = "Auction House 1"
            AuctionHouse test_auction_house = new AuctionHouse("Auction House 1");
            System.out.println(test_auction_house); //Should output "Auction House 1"
            test_auction_house.addItem(test_items.get(0)); //Should add test_item_1 to test_auction_house
            System.out.println(test_auction_house.getItemsSold()); //Should output array containing test_item_1 only
            test_auction_house.addItem(test_items.get(2)); //Should add test_item_3 to test_auction_house
            //Should output an array containing test_item_1 and test_item_3
            System.out.println(test_auction_house.getItemsSold());

            //Testing successful instantiation of multiple AuctionHouse objects
            AuctionHouse test_auction_house_1 = new AuctionHouse("Auction House 2");
            AuctionHouse test_auction_house_2 = new AuctionHouse("Auction House 3");

            test_auction_house_1.addItem(test_items.get(1)); //Should add test_item_2 to test_auction_house
            test_auction_house_2.addItem(test_items.get(3)); //Should add test_item_4 to test_auction_house
            System.out.println(test_auction_house_1.getItemsSold()); //Should output array containing test_item_2 only
            System.out.println(test_auction_house_2.getItemsSold()); //Should output array containing test_item_4 only

            //Testing AuctionHouse methods using test_auction_house
            System.out.println(test_auction_house.priceGreater(33.44F)); //Should only output test_item_3
            System.out.println(test_auction_house.priceGreater(22.33F)); //Should output both
            System.out.println(test_auction_house.priceGreater(300.55F)); //Should output neither

            System.out.println(test_auction_house.averagePrice(2010)); //Should output 32.55F

            //Changing the year of test_item_1 to match test_item_3 and making another instance
            test_items.get(0).setYearSold(2019);
            test_auction_house.addItem(test_items.get(0));

            //Should contain test_item_3 and two variants of test_item_1 all with year
            System.out.println(test_auction_house.getItemsSold());
            System.out.println(test_auction_house.averagePrice(2019)); //Should output 43.49F


            //Should output "Item(100003, Harvey Proctor, 65.37F, 2019, painting)" as this has the highest price
            System.out.println(test_auction_house.highestPrice());

            test_auction_houses.add(test_auction_house);
            test_auction_houses.add(test_auction_house_1);
            test_auction_houses.add(test_auction_house_2);

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return test_auction_houses;
    }

    public static void testReporting(ArrayList<AuctionHouse> test_auction_houses) {

    }
}
