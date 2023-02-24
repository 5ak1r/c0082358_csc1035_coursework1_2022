package CSC1035_proj1;

import java.util.ArrayList;

public class AuctionHouse {
    private String name;
    private ArrayList<Item> items_sold;

    //Constructor
    public AuctionHouse(String name) {
        setName(name);
        setItemsSold(new ArrayList<>());
    }

    //String Representation of AuctionHouse
    @Override
    public String toString() {
        return this.getName();
    }

    //Setters

    /**
     * Setter
     * @param name Name of the AuctionHouse
     */
    public void setName(String name) {
        this.name = TitleCase.toTitleCase(name);
    }

    /**
     * Setter
     * @param items_sold ArrayList of Item objects sold within this AuctionHouse
     */
    public void setItemsSold(ArrayList<Item> items_sold) {
        this.items_sold = items_sold;
    }

    //Getters

    /**
     * Getter
     * @return Name of the AuctionHouse
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter
     * @return ArrayList of Item objects sold within this AuctionHouse
     */
    public ArrayList<Item> getItemsSold() {
        return this.items_sold;
    }


    /**
     * Method to add an item sold to the auction house
     * @param item Item to be added to the list of items sold by AuctionHouse
     */
    public void addItem(Item item) {
        this.items_sold.add(item);
    }


    /**
     * Returns the most expensive Item and the price it sold for
     * @return Item with the highest price sold by this AuctionHouse
     * @throws Exception verification
     */
    public Item highestPrice() throws Exception {
        //Initiating variables that return name and price of most expensive item
        //Temporary Item with 0 price to begin comparison
        Item highest_item = new Item(199999, "Test Item",0,2000,"p");

        for (Item price: getItemsSold()) {
            if (price.getPriceSold() > highest_item.getPriceSold()) {
                highest_item = price;
            }
        }

        return highest_item;
    }

    /**
     * Returns the average item price recorded by the auction house in the given year
     * @param year year that the items were sold
     * @return average item price
     */
    public float averagePrice(int year) {
        float avg = 0;
        int counter = 0;
        float sum = 0;

        for (Item average: getItemsSold()) {
            if (average.getYearSold() == year) {
                sum += average.getPriceSold();
                counter += 1;
            }
        }

        try {
            avg = Float.parseFloat(String.valueOf(sum / counter));
        } catch(Exception ignored) {}

        return avg;
    }

    /**
     * Returns a list of all items sold by the auction house with a price greater than a given amount of money
     * @param value price to be compared to
     * @return all Item objects that had a price sold greater than value
     */
    public ArrayList<Item> priceGreater(float value) {
        ArrayList<Item> items_greater = new ArrayList<>();

        for (Item price: getItemsSold()) {
            if (price.getPriceSold() > value) {
                items_greater.add(price);
            }
        }

        return items_greater;
    }
}

