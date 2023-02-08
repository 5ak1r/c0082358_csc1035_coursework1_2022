import java.util.Locale;

public class Item {
    private int lot_number;
    private String buyer_name;
    private float price_sold;
    private int year_sold;
    private String item_type;

    public Item(int lot_number, String buyer_name, float price_sold, int year_sold, String item_type) {
        //Verifies input for lot_number; should be 6 digits starting with a 1
        this.lot_number = lot_number;
        this.buyer_name = buyer_name;
        this.price_sold = price_sold;
        this.year_sold = year_sold;

        //Verifies input for item_type; should be either 'f', 'p', 's' or the full words.
        if (item_type.length() == 1) {
            if (!(item_type.toLowerCase() == "f"||item_type.toLowerCase() == "p"||item_type.toLowerCase() == "s")) {
                throw new IllegalArgumentException("That is not a valid item type.");
            } else {
                this.item_type = item_type;
            }
        } else {
            if (!(item_type.toLowerCase() == "furniture"||item_type.toLowerCase() == "sculpture"||
                    item_type.toLowerCase() == "painting")) {
                throw new IllegalArgumentException("That is not a valid item type.");

            } else {
                this.item_type = item_type;
            }
        }
    }
}