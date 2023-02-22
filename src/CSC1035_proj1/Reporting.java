package CSC1035_proj1;

import java.util.ArrayList;

public class Reporting {
    private ArrayList<AuctionHouse> AuctionHouses;

    //Setter
    public void setAuctionHouses(ArrayList<AuctionHouse> auction_houses) {
        this.AuctionHouses = auction_houses;
    }

    //Getter
    public ArrayList<AuctionHouse> getAuctionHouses() {
        return this.AuctionHouses;
    }

    //Constructor
    public Reporting(ArrayList<AuctionHouse> auction_houses) {
        setAuctionHouses(auction_houses);
    }

    //Adds a newly created auction house to the Reporting class
    public void addAuctionHouse(AuctionHouse ah) {
        ArrayList<AuctionHouse> temp_list = new ArrayList<>(getAuctionHouses());
        temp_list.add(ah);
        setAuctionHouses(temp_list);
    }

    //Returns the Item with the highest price ever recorded
    public Item mostExpensive() throws Exception {
        //Temporary Item with 0 price to begin comparing
        Item highest_price = new Item(199999, "No Items", (float) 0, 2000, "f");

        for (AuctionHouse ahs : getAuctionHouses()) {
            if (ahs.highestPrice().getPriceSold() > highest_price.getPriceSold()) {
                highest_price = ahs.highestPrice();
            }
        }

        return highest_price;
    }

    //Returns the auction house with the largest average price for a given year
    public AuctionHouse highestAverage(int year) {
        //Temporary empty AuctionHouse to begin comparing
        AuctionHouse highest_average = new AuctionHouse("No Auction Houses have been added yet");

        for (AuctionHouse ahs: getAuctionHouses()) {
            if(ahs.averagePrice(year) > highest_average.averagePrice(year)) {
                highest_average = ahs;
            }
        }
        return highest_average;
    }

    //Returns a list of all items sold with price greater than a given amount of money
    public ArrayList<Item> priceGreaterTotal(float price) {
        //Empty ArrayList to add all the values
        ArrayList<Item> total_arraylist = new ArrayList<>();

        for (AuctionHouse ahs: getAuctionHouses()) {
            total_arraylist.addAll(ahs.priceGreater(price));
        }

        return total_arraylist;
    }
}
