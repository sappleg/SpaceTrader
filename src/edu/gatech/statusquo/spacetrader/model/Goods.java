package edu.gatech.statusquo.spacetrader.model;

public class Goods {
    private int price;
    private boolean legality;
    private int minTechLevel;
    private int minSellLevel;
    private int lvlRequired;
    private int quantity;
    
    /**
     * This is the constructor
     * @param pr - price
     * @param leg - legality
     * @param minTech - minimum tech level
     * @param minSell - minimum sell level
     * @param lvlReq - minimum level required to multiply the qty
     * @param qty - the quantity
     */
    public Goods(int minTech, int minSell, int lvlReq, int pr, int qty, boolean leg)
    {
    	
	price = pr;
	legality = leg;
	minTechLevel = minTech;
	minSellLevel = minSell;
	lvlRequired = lvlReq;
	quantity = qty;
    }
    
    /**
     * Gets the price
     * @return int price
     */
    public int getPrice() {
        return price;
    }
    
    /**
     * Sets the price
     * @param price - sets the price of the good.
     */
    public void setPrice(int price) {
        this.price = price;
    }
    
    /**
     * gets the legality
     * @return boolean legality
     */
    public boolean isLegality() {
        return legality;
    }
    
    /**
     * sets the legality
     * @param legality - the legality.
     */
    public void setLegality(boolean legality) {
        this.legality = legality;
    }
    
    /**
     * Gets the minimum tech level required to produce the good.
     * @return an int that is the minimum tech level.
     */
    public int getMinTechLevel() {
        return minTechLevel;
    }
    
    /**
     * This sets the minimum tech level.
     * @param minTechLevel - the minimum tech level.
     */
    public void setMinTechLevel(int minTechLevel) {
        this.minTechLevel = minTechLevel;
    }

    /**
     * This gets the minimum sell level.
     * @return the minimum sell level.
     */
    public int getMinSellLevel() {
        return minSellLevel;
    }
    
    /**
     * This sets the minimum sell level
     * @param minSellLevel the minimum sell level.
     */
    public void setMinSellLevel(int minSellLevel) {
        this.minSellLevel = minSellLevel;
    }

    /**
     * gets the level required to multiply the amount of a good created.
     * @return the multiplier.
     */
    public int getLvlRequired() {
        return lvlRequired;
    }

    /**
     * sets the level required to multiply a good.
     * @param lvlRequired - the level required to multiply a good.
     */
    public void setLvlRequired(int lvlRequired) {
        this.lvlRequired = lvlRequired;
    }

    /**
     * Gets the quantity available.
     * @return the quantity available.
     */
    public int getQuantity() {
        return quantity;
    }
    
    /**
     * This will set the quantity available.
     * @param quantity the quantity available.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
