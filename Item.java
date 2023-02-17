
public class Item {
    private int lot_number;
    private String buyer_name;
    private float price_sold;
    private int year_sold;
    private String item_type;

    public Item(int lot_number, String buyer_name, float price_sold, int year_sold, String item_type) {
        setLotNumber(lot_number);
        setBuyerName(buyer_name);
        setPriceSold(price_sold);
        setYearSold(year_sold);
        setItemType(item_type);
    }

    public void setLotNumber(int lot_number) {
        //Verifies input for lot_number; should be 6 digits starting with a 1

        // Originally started with this, realized I could have done it in a lot easier way as shown below
        /*if (!(Integer.parseInt(Integer.toString(lot_number).substring(0, 1)) == 1)) {
            throw new IllegalArgumentException("That is not a valid lot number.");
        } else {
           if (lot_number) {
        }*/

        if (!(100000 <= lot_number && lot_number <= 199999)) {
            throw new IllegalArgumentException("That is not a valid lot number.");
        } else {
            this.lot_number = lot_number;
        }
    }

    public void setBuyerName(String buyer_name) {
        //Verifies input for buyer_name; should be two words separated by a space (first name and last name)
        if (!(buyer_name.contains(" "))) {
            throw new IllegalArgumentException("That is not a valid name; must contain a first and last name.");
        } else {
            this.buyer_name = ;
        }
    }

    public void setItemType(String item_type) {
            //Verifies input for item_type; should be either 'f', 'p', 's' or the full words.
            if (item_type.length() == 1) {
                if (!(item_type.toLowerCase() == "f" || item_type.toLowerCase() == "p" || item_type.toLowerCase() == "s")) {
                    throw new IllegalArgumentException("That is not a valid item type.");
                } else {
                    this.item_type = item_type;
                }
            } else {
                if (!(item_type.toLowerCase() == "furniture" || item_type.toLowerCase() == "sculpture" ||
                        item_type.toLowerCase() == "painting")) {
                    throw new IllegalArgumentException("That is not a valid item type.");

                } else {
                    this.item_type = item_type;
                }
            }
        }
}