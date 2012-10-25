package edu.gatech.statusquo.spacetrader.model;

public class Good {
    private int price;
    private boolean legality;
    private GoodType goodType;
    
    public enum GoodType {
    	WATER {
    	    public String toString() {
    	        return "WATER";
    	    }
    	}, FUR {
    	    public String toString() {
    	        return "FUR";
    	    }
    	}, FOOD {
    	    public String toString() {
    	        return "FOOD";
    	    }
    	}, ORE {
    	    public String toString() {
    	        return "ORE";
    	    }
    	}, FIREARM {
    	    public String toString() {
    	        return "FIREARM";
    	    }
    	}, MEDICINE {
    	    public String toString() {
    	        return "MEDICINE";
    	    }    		
    	}, MACHINE {
    	    public String toString() {
    	        return "MACHINE";
    	    }    		
    	}, NARCOTIC {
    	    public String toString() {
    	        return "NARCOTIC";
    	    }    	
    	}, ROBOT {
    	    public String toString() {
    	        return "ROBOT";
    	    }    		
    	}
    }
    
    /**
     * This is the constructor
     * @param pr - price
     * @param leg - legality
     */
    public Good(GoodType gt) {
		price = 0;
		legality = true;
		goodType = gt;
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
    
    public GoodType getGoodType() {
    	return goodType;
    }
    
    public String toString() {
    	return goodType.toString();
    }
}
