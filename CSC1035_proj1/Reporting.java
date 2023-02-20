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
    public Item mostExpensive() {
        //Temporary Item with 0 price to begin comparing
        Item highest_price = new Item(199999, "",0,2000,"");
        float temp_price = 0;

        for (AuctionHouse ahs: getAuctionHouses()) {
            if(ahs.highestPrice().getPriceSold() > temp_price) {
                temp_price = ahs.highestPrice().getPriceSold();
                highest_price = ahs.highestPrice();
            }
        }
        return highest_price;
    }

    //Returns the auction house with the largest average price for a given year
    public AuctionHouse highestAverage(int year) {
        //Temporary empty AuctionHouse to begin comparing
        AuctionHouse highest_average = new AuctionHouse("temp");
        float temp_average = 0;

        for (AuctionHouse ahs: getAuctionHouses()) {
            if(ahs.averagePrice(year) > temp_average) {
                highest_average = ahs;
                temp_average = ahs.averagePrice(year);
            }
        }
        return highest_average;
    }

    //Returns a list of all items sold with price greater than a given amount of money
    public ArrayList<Item> priceGreaterTotal(float price) {
        //Empty ArrayList to add all the values
        ArrayList<Item> total_arraylist = new ArrayList<>();

        for (AuctionHouse ahs: getAuctionHouses()) {
            for (Item item: ahs.priceGreater(price)) {
                total_arraylist.add(item);
            }
        }
        return total_arraylist;
    }
}
