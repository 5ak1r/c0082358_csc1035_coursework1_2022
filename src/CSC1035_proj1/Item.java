package CSC1035_proj1;

import java.time.Year;

public class Item {
    //Making variables private
    //Float chosen over double as they are take up less storage, and we do not need 64-bit
    //floating points in this project
    private int lot_number;
    private String buyer_name;
    private float price_sold;
    private int year_sold;
    private String item_type;

    //Constructor
    public Item(int lot_number, String buyer_name, float price_sold, int year_sold, String item_type) throws Exception {
        setLotNumber(lot_number);
        setBuyerName(buyer_name);
        setPriceSold(price_sold);
        setYearSold(year_sold);
        setItemType(item_type);
    }

    //String Representation of Item
    @Override
    public String toString() {
        return String.format("Item("+this.getLotNumber()+", "+this.getBuyerName()+", "+this.getPriceSold()+", "+
                this.getYearSold()+", "+this.getItemType()+")");
    }

    //Setters

    /**
     * Setter with verification
     * @param lot_number Unique number identifier for each Item object
     * @throws Exception Item verification
     */
    public void setLotNumber(int lot_number) throws Exception {
        //Verifies input for lot_number; should be 6 digits starting with a 1

        // Originally started with this, realized I could have done it in a lot easier way as shown below
        /*if (!(Integer.parseInt(Integer.toString(lot_number).substring(0, 1)) == 1)) {
            throw new IllegalArgumentException("That is not a valid lot number.");
        } else {
           if (lot_number) {
        }*/

        if (!(100000 <= lot_number && lot_number <= 199999)) {
            throw new Exception("lot number");
        } else {
            this.lot_number = lot_number;
        }
    }

    /**
     * Setter with verification
     * @param buyer_name Full name of the buyer who purchased the item
     * @throws Exception Item verification
     */
    public void setBuyerName(String buyer_name) throws Exception {
        //Verifies input for buyer_name; should be two words separated by a space (first name and last name)
        if (!(buyer_name.contains(" ")) || (buyer_name.equals("null"))) {
            throw new Exception("name");
        } else {
            this.buyer_name = TitleCase.toTitleCase(buyer_name);
        }
    }

    /**
     * Setter with verification
     * @param price_sold Price that the item sold for as a float
     * @throws Exception Item verification
     */
    public void setPriceSold(float price_sold) throws Exception {
        //Verifies input for price_sold; should be positive and only two decimal places - rounds down if otherwise
        //This is due to the possibility of accidentally typing more numbers than intended; if >5 would normally round
        //Up but more likely to be a typo
        if (price_sold < (float) 0) {
            throw new Exception("price");
        } else {
            this.price_sold = (float) (Math.floor(price_sold*100)/100);
        }
    }

    /**
     * Setter with verification
     * @param year_sold Year that the item was sold in
     * @throws Exception Item verification
     */
    public void setYearSold(int year_sold) throws Exception {
        //Verifies input for year_sold, should be greater than 1950 (this is the year I decided) and less than or
        //equal to the current year
        int year = Year.now().getValue();
        if (!(1950 <= year_sold || year_sold <= year)) {
            throw new Exception("year");
        } else {
            this.year_sold = year_sold;
        }
    }

    /**
     * Setter with verification
     * @param item_type The type of item (furniture, sculpture, painting)
     * @throws Exception Item verification
     */
    public void setItemType(String item_type) throws Exception {
        //Verifies input for item_type; should be either 'f', 'p', 's' or the full words.
        //Previous strategy did not work as it creates more possible outputs for getItemType rather than just 3; new
        //switch case method fixes this. Old code kept in to show comparison
        /*
            if (item_type.length() == 1) {
                if (!(item_type.equalsIgnoreCase("f") || item_type.equalsIgnoreCase("p") ||
                        item_type.equalsIgnoreCase("s"))) {
                    throw new IllegalArgumentException("That is not a valid item type.");
                } else {
                    this.item_type = item_type;
                }
            } else {
                if (!(item_type.equalsIgnoreCase("furniture") || item_type.equalsIgnoreCase("sculpture") ||
                        item_type.equalsIgnoreCase("painting"))) {
                    throw new IllegalArgumentException("That is not a valid item type.");

                } else {
                    this.item_type = item_type;
                }
            }*/

        switch (item_type) {
            case "f", "furniture" -> this.item_type = "furniture";
            case "p", "painting" -> this.item_type = "painting";
            case "s", "sculpture" -> this.item_type = "sculpture";
            default -> throw new Exception("item type");
        }
    }

    //Getters

    /**
     * Getter
     * @return Item object's lot number
     */
    public int getLotNumber() {
        return this.lot_number;
    }

    /**
     * Getter
     * @return Item object's lot number
     */
    public String getBuyerName() {
        return this.buyer_name;
    }

    /**
     * Getter
     * @return Item object's price sold
     */
    public float getPriceSold(){
        return this.price_sold;
    }

    /**
     * Getter
     * @return Item object's year sold
     */
    public int getYearSold(){
        return this.year_sold;
    }

    /**
     * Getter
     * @return Item object's item type
     */
    public String getItemType(){
        return this.item_type;
    }
}