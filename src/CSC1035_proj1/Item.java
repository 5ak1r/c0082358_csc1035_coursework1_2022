package CSC1035_proj1;

import java.time.Year;
import java.util.Objects;

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

    //Setters
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

    public void setBuyerName(String buyer_name) throws Exception {
        //Verifies input for buyer_name; should be two words separated by a space (first name and last name)
        if (!(buyer_name.contains(" ")) || (buyer_name.equals("null"))) {
            throw new Exception("name");
        } else {
            this.buyer_name = TitleCase.toTitleCase(buyer_name);
        }
    }

    public void setPriceSold(float price_sold) throws Exception {
        //Verifies input for price_sold; should be positive and only two decimal places - rounds down if otherwise
        //This is due to the possibility of accidentally typing more numbers than intended; if >5 would normally round
        //Up but more likely to be a typo
        if (price_sold < 0) {
            throw new Exception("price");
        } else {
            this.price_sold = (float) (Math.floor(price_sold*100)/100);
        }
    }

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

        switch(item_type) {
            case "f":
            case "furniture":
                this.item_type = "furniture";
                break;
            case "p":
            case "painting":
                this.item_type = "painting";
                break;
            case "s":
            case "sculpture":
                this.item_type = "sculpture";
                break;
            default:
                throw new Exception("item type");
        }
    }

    //Getters
    public int getLotNumber() {
        return this.lot_number;
    }

    public String getBuyerName() {
        return this.buyer_name;
    }

    public float getPriceSold(){
        return this.price_sold;
    }

    public int getYearSold(){
        return this.year_sold;
    }

    public String getItemType(){
        return this.item_type;
    }
}