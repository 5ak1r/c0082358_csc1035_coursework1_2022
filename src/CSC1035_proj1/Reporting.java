package CSC1035_proj1;

import java.util.ArrayList;

public class Reporting {
    private ArrayList<AuctionHouse> AuctionHouses = new ArrayList<>();
    private ArrayList<Item> Items = new ArrayList<>();

    //Setter

    /**
     * Setter
     * @param auction_houses ArrayList of AuctionHouse objects to be reported on
     */
    public void setAuctionHouses(ArrayList<AuctionHouse> auction_houses) {
        this.AuctionHouses = auction_houses;
    }

    /**
     * Setter
     * @param items ArrayList of items contained within the AuctionHouse objects as well as those not yet placed
     *              within AuctionHouse objects yet
     */
    public void setItems(ArrayList<Item> items) {
        this.Items = items;
    }

    //Getter

    /**
     * Getter
     * @return ArrayList of AuctionHouse objects within the report
     */
    public ArrayList<AuctionHouse> getAuctionHouses() {
        return this.AuctionHouses;
    }

    /**
     * Getter
     * @return ArrayList of Item objects within the report
     */
    public ArrayList<Item> getItems() {
        return this.Items;
    }


    //Constructor
    public Reporting(ArrayList<AuctionHouse> auction_houses) {
        setAuctionHouses(auction_houses);

        for(AuctionHouse ahs: auction_houses) {
            for(Item item_ahs: ahs.getItemsSold()) {
                addItem(item_ahs);
            }
        }
    }


    /**
     * addAuctionHouse and addItem could both be merged into the same method, would do this if I had more time.
     * Adds a newly created auction house to the Reporting class
     * @param ah AuctionHouse object to be added to the report
     */
    public void addAuctionHouse(AuctionHouse ah) {
        ArrayList<AuctionHouse> temp_list = new ArrayList<>();
        try {
            temp_list = getAuctionHouses();
        } catch(Exception ignored) {}

        temp_list.add(ah);
        setAuctionHouses(temp_list);

        for(Item item_ah: ah.getItemsSold()) {
            addItem(item_ah);
        }
    }

    /**
     * Adds a newly created item to the Reporting class
     * @param new_item Item object to be added to the report
     */

    public void addItem(Item new_item) {
        ArrayList<Item> temp_list = new ArrayList<>();
        try {
            temp_list = getItems();
        } catch(Exception ignored) {}

        temp_list.add(new_item);
        setItems(temp_list);
    }

    /**
     * @return Item object with the highest price ever recorded
     * @throws Exception Item input validation
     */
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

    /**
     * @param year year for the highest average to be compared for
     * @return the auction house with the largest average price for a given year
     * @throws Exception Item input validation
     */
    public AuctionHouse highestAverage(int year) throws Exception {
        //Temporary empty AuctionHouse to begin comparing
        AuctionHouse highest_average = new AuctionHouse("No Auction Houses have been added yet");
        highest_average.addItem(new Item(199999, "S A", 0.00F, year, "f"));
        for (AuctionHouse ahs: getAuctionHouses()) {
            if(ahs.averagePrice(year) > highest_average.averagePrice(year)) {
                highest_average = ahs;
            }
        }
        return highest_average;
    }

    /**
     * Calculates which Item objects within the AuctionHouse objects that have been sold for more than the price given
     * @param price price to be compared to
     * @return ArrayList of all items sold with price greater than a given amount of money
     */
    public ArrayList<Item> priceGreaterTotal(float price) {
        //Empty ArrayList to add all the values
        ArrayList<Item> total_arraylist = new ArrayList<>();

        for (AuctionHouse ahs: getAuctionHouses()) {
            total_arraylist.addAll(ahs.priceGreater(price));
        }

        return total_arraylist;
    }
}
