/**
 * File: Gift.java
 * Author: Miller, Raymone
 * Class:  CMIS 242 - Assignment 2
 * Creation Date: (11JUN21)
 * Description: 
 */

import java.util.List;

public abstract class Gift {
    // used to create id
    private static int idCounter = 1;

    // unique for each gift object
    private final String id;
    // S, M, L
    private String size;
    // determined by the gift size
    private double price;
    // to be set by subclasses
    protected double extraCost;

    /**
     * Sole constructor for Gift class. Subclasses must call setPrice()
     * immediatly after calling this constructor to correctly set the price. 
     */
    protected Gift(String idPrefix, String size) {
        this.id = idPrefix + idCounter++;
        setSize(size);
    }

    /**
     * Set the price of the gift, based on its size.
     *
     * @param extraCost Any extra cost to add to the base price.
     */
    protected void setPrice(boolean useExtraCost) {
        switch(this.size) {
            case "S":
                this.price = 19.99;
                break;
            case "M":
                this.price = 29.99;
                break;
            case "L":
                this.price = 39.99;
                break;
            default:  // default to small size price if size not recognized
                this.price = 19.99;
                break;
        }
        if(useExtraCost)
            this.price += this.extraCost;
    }

    /**
     * Return the price of this gift.
     *
     * @return The price of this gift.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Return the id of this gift.
     *
     * @return The id of this gift.
     */
    public String getID() {
        return id;
    }

    /**
     * Set the size of the gift.
     *
     * @param size The new size of the gift.
     */
    public void setSize(String size) {
        if(List.of("S", "M", "L").contains(size.toUpperCase()))
            this.size = size.toUpperCase();
        else  // defualt size to S if not recognized
            this.size = "S";
        // default pass in false for extra cost
        setPrice(false);
    }

    /**
     * Return the size of the gift.
     *
     * @return The size of the gift.
     */
    public String getSize() {
        return size;
    }

    /**
     * Return a string representing this object.
     *
     * @return A string representing this object.
     */
    public abstract String toString();
}