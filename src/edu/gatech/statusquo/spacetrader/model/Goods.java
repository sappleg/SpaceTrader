package edu.gatech.statusquo.spacetrader.model;

public class Goods {
    private int price;
    private boolean legality;
    private int minTechLevel;
    private int minSellLevel;
    private int lvlRequired;
    private int quantity;
    
    public Goods(int pr, boolean leg, int minTech, int minSell, int lvlReq, int qty)
    {
	price = pr;
	legality = leg;
	minTechLevel = minTech;
	minSellLevel = minSell;
	lvlRequired = lvlReq;
	quantity = qty;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isLegality() {
        return legality;
    }

    public void setLegality(boolean legality) {
        this.legality = legality;
    }

    public int getMinTechLevel() {
        return minTechLevel;
    }

    public void setMinTechLevel(int minTechLevel) {
        this.minTechLevel = minTechLevel;
    }

    public int getMinSellLevel() {
        return minSellLevel;
    }

    public void setMinSellLevel(int minSellLevel) {
        this.minSellLevel = minSellLevel;
    }

    public int getLvlRequired() {
        return lvlRequired;
    }

    public void setLvlRequired(int lvlRequired) {
        this.lvlRequired = lvlRequired;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
