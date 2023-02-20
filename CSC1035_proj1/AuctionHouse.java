package CSC1035_proj1;

import java.util.ArrayList;

public class AuctionHouse {
    private String name;
    private ArrayList<Item> items_sold;

    //Constructor
    public AuctionHouse(String name) {
        setName(name);
        setItemsSold(new ArrayList<Item>());
    }

    //Setters
    public void setName(String name) {
        this.name = TitleCase.toTitleCase(name);
    }

    public void setItemsSold(ArrayList<Item> items_sold) {
        this.items_sold = items_sold;
    }

    //Getters
    public String getName() {
        return this.name;
    }

    public ArrayList<Item> getItemsSold() {
        return this.items_sold;
    }

    //Method to add an item sold to the auction house
    public void addItem(Item item) {
        this.items_sold.add(item);
    }

    //Returns the most expensive Item and the price it sold for
    public Item highestPrice() {
        //Initiating variables that return name and price of most expensive item
        //Temporary Item with 0 price to begin comparison
        Item highest_item = new Item(199999, "",0,2000,"");

        for (Item price: getItemsSold()) {
            if (price.getPriceSold() > highest_item.getPriceSold()) {
                highest_item = price;
            }
        }

        return highest_item;
    }

    //Returns the average item price recorded by the auction house in the given year
    public float averagePrice(int year) {
        int counter = 0;
        float sum = 0;

        for (Item average: getItemsSold()) {
            if (average.getYearSold() == year) {
                sum += average.getPriceSold();
                counter += 1;
            }
        }

        return(sum / counter);
    }

    //Returns a list of all items sold by the auction house with a price greater than a given amount of money
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

