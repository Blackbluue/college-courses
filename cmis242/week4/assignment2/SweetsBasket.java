/**
 * File: SweetsBasket.java
 * Author: Miller, Raymone
 * Class:  CMIS 242 - Assignment 2
 * Creation Date: (11JUN21)
 * Description: 
 */
 
public class SweetsBasket extends Gift {
    private static String idPrefix = "SB";

    private boolean includeNuts;

    /**
     * Sole constructor for SweetsBasket
     */
    public SweetsBasket(String size, boolean includeNuts) {
        super(idPrefix, size);
        this.includeNuts = includeNuts;
    }

    /**
     * Set whether this sweets basket includes nuts.
     *
     * @param includeNuts whether this sweets basket includes nuts.
     */
    public void setIncludeNuts(boolean includeNuts) {
        this.includeNuts = includeNuts;
    }

    /**
     * Return whether this sweets basket includes nuts.
     *
     * @return Whether this sweets basket includes nuts.
     */
    public boolean isIncludeNuts() {
        return includeNuts;
    }

    @Override
    public String toString() {
        return String.format("SweetsBasket [haveNuts=%b size=%s id=%s price=$%.2f]", includeNuts, getSize(), getID(), getPrice());
    }
}