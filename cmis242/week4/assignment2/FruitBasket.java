/**
 * File: FruitBasket.java
 * Author: Miller, Raymone
 * Class:  CMIS 242 - Assignment 2
 * Creation Date: (11JUN21)
 * Description: 
 */
 
public class FruitBasket extends Gift {
    private static final String ID_PREFIX = "FB";
    private static final double CITRUS_COST = 5.99;
    private static final int SMALL_FRUIT_COUNT = 6;
    private static final int MEDIUM_FRUIT_COUNT = 9;
    private static final int LARGE_FRUIT_COUNT = 15;

    private int numOfFruits;
    private boolean includeCitrus;

    public FruitBasket(String size, boolean includeCitrus) {
        super(ID_PREFIX, size);
        // setPrice() ends up being called twice. Not sure how to fix
        setIncludeCitrus(includeCitrus);
        this.extraCost = 5.99;
    }

    /**
     * Set whether this fruit basket includes citrus fruits. Citrus
     * fruits have a $5.99 surcharge.
     *
     * @param includeCitrus whether this fruit basket includes citrus fruits.
     */
    public void setIncludeCitrus(boolean includeCitrus) {
        this.includeCitrus = includeCitrus;
        setPrice(includeCitrus);
    }

    /**
     * Return whether this fruit basket includes citrus fruits.
     *
     * @return Whether this fruit basket includes citrus fruits.
     */
    public boolean isIncludeCitrus() {
        return includeCitrus;
    }

    @Override
    public void setSize(String size) {
        super.setSize(size);
        switch(size) {
            case "S":
                this.numOfFruits = SMALL_FRUIT_COUNT;
                break;
            case "M":
                this.numOfFruits = MEDIUM_FRUIT_COUNT;
                break;
            case "L":
                this.numOfFruits = LARGE_FRUIT_COUNT;
                break;
            default:  // default to small size price if size not recognized
                this.numOfFruits = SMALL_FRUIT_COUNT;
                break;
            }
    }

    /**
     * Return the number of fruits in the fruits basket.
     *
     * @return The number of fruits in the fruits basket.
     */
    public int getNumOfFruits() {
        return numOfFruits;
    }

    @Override
    public String toString() {
        return String.format("FruitBasket [numFruits=%d haveCitrus=%b size=%s id=%s price=$%.2f]", numOfFruits, includeCitrus, getSize(), getID(), getPrice());
    }
}