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
        },
        FUR {
            public String toString() {
                return "FUR";
            }
        },
        FOOD {
            public String toString() {
                return "FOOD";
            }
        },
        ORE {
            public String toString() {
                return "ORE";
            }
        },
        FIREARM {
            public String toString() {
                return "FIREARM";
            }
        },
        MEDICINE {
            public String toString() {
                return "MEDICINE";
            }
        },
        MACHINE {
            public String toString() {
                return "MACHINE";
            }
        },
        NARCOTIC {
            public String toString() {
                return "NARCOTIC";
            }
        },
        ROBOT {
            public String toString() {
                return "ROBOT";
            }
        }
    }

    /**
     * This is the constructor
     * 
     * @param pr
     *            - price
     * @param leg
     *            - legality
     */
    public Good(GoodType gt) {
        price = 0;
        legality = true;
        goodType = gt;
    }

    /**
     * Gets the price
     * 
     * @return int price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the price
     * 
     * @param price
     *            - sets the price of the good.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * gets the legality
     * 
     * @return boolean legality
     */
    public boolean isLegality() {
        return legality;
    }

    /**
     * sets the legality
     * 
     * @param legality
     *            - the legality.
     */
    public void setLegality(boolean legality) {
        this.legality = legality;
    }

    /**
     * returns goodType
     * 
     * @return
     */
    public GoodType getGoodType() {
        return goodType;
    }

    /**
     * returns String of goodType
     */
    public String toString() {
        return goodType.toString();
    }

    /**
     * 
     * @param goodName
     * @return goodType
     */
    public static GoodType getGoodType(String goodName) {
        switch (goodName) {
        case "WATER":
            return GoodType.WATER;
        case "FUR":
            return GoodType.FUR;
        case "FOOD":
            return GoodType.FOOD;
        case "ORE":
            return GoodType.ORE;
        case "FIREARM":
            return GoodType.FIREARM;
        case "MEDICINE":
            return GoodType.MEDICINE;
        case "MACHINE":
            return GoodType.MACHINE;
        case "NARCOTIC":
            return GoodType.NARCOTIC;
        case "ROBOT":
            return GoodType.ROBOT;
        }

        // default good type
        return null;
    }
}
