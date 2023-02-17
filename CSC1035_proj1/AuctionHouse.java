package CSC1035_proj1;

import java.util.ArrayList;

public class AuctionHouse {
    private String name;
    private ArrayList<Item> items_sold;

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
}
