package edu.gatech.statusquo.spacetrader.model;

import edu.gatech.statusquo.spacetrader.model.Good.GoodType;

public class Ship {
	Good[] cargoBay;
	ShipType shipType;
	final int fuelCapacity;
	static int fuelLevel;
	
	
    public enum ShipType {
    	FLEA, GNAT, FIREFLY, MOSQUITO, BUMBLEBEE, BEETLE, HORNET, GRASSHOPPER, TERMITE, WASP
    }
    
    /**
     * 
     * @param st
     */
    public Ship (ShipType st) {
    	this.shipType = st;
    	
    	switch(st) {
	    	case FLEA:
	    		cargoBay = new Good[10];
	    		fuelCapacity = 10;
	    		fuelLevel = 10;
	    		break;
	    	case GNAT:
	    		cargoBay = new Good[15];
	    		fuelCapacity = 14;
	    		fuelLevel = 14;
	    		break;
	    	case FIREFLY:
	    		cargoBay = new Good[20];
	    		fuelCapacity = 17;
	    		fuelLevel = 17;
	    		break;
	    	case MOSQUITO:
	    		cargoBay = new Good[15];
	    		fuelCapacity = 13;
	    		fuelLevel = 13;
	    		break;
	    	case BUMBLEBEE:
	    		cargoBay = new Good[25];
	    		fuelCapacity = 15;
	    		fuelLevel = 15;
	    		break;
	    	case BEETLE:
	    		cargoBay = new Good[25];
	    		fuelCapacity = 16;
	    		fuelLevel = 16;
	    		break;
	    	case HORNET:
	    		cargoBay = new Good[30];
	    		fuelCapacity = 17;
	    		fuelLevel = 17;
	    		break;
	    	case GRASSHOPPER:
	    		cargoBay = new Good[35];
	    		fuelCapacity = 19;
	    		fuelLevel = 19;
	    		break;
	    	case TERMITE: 
	    		cargoBay = new Good[40];
	    		fuelCapacity = 22;
	    		fuelLevel = 22;
	    		break;
	    	case WASP:
	    		cargoBay = new Good[50];
	    		fuelCapacity = 25;
	    		fuelLevel = 25;
	    		break;
	    	default:
	    		//GIVE ERROR
	    		cargoBay = new Good[0];
	    		fuelCapacity = 0;
	    		fuelLevel = 0;
	    		break;
	    		
    	}
    }
    
    /**
     * 
     * @return fuelLevel
     */
    
    public static int getFuelLevel() {
    	return fuelLevel;
    }
    
    /**
     * 
     * @return cargoBay
     */
    public Good[] getCargoBay() {
    	return cargoBay;
    }
	
    /**
     * 
     * @param gt
     * @return count
     */
	public int countGoodType(GoodType gt) {
		int count = 0;
		for (Good g: cargoBay) {
			if (g.getGoodType() == gt) count++;
		}
		return count;
	}
	
	/**
	 * 
	 * @return count
	 */
	public int countCargoLeft() {
		int count = 0;
		for (int i = 0; i < cargoBay.length; i++) {
			if (cargoBay[i] == null) count++;
		}
		return count;
	}
	
	/**
	 * 
	 * @param gt
	 * @return count
	 */
	public int countCargo(GoodType gt) {
		int count = 0;
		for (int i = 0; i < cargoBay.length; i++) {
			if (cargoBay[i] != null) {
				if (cargoBay[i].getGoodType() == gt) count++;
			}
		}
		return count;
	}
	
	/**
	 * 
	 * @param amt
	 * @param gt
	 */
	public void addCargo(int amt, GoodType gt) {
		while (amt > 0) {
			for (int i = 0; i < cargoBay.length; i++) {
				if (cargoBay[i] == null) {
					cargoBay[i] = new Good(gt);
					break;
				}
			}
			amt--;
		}
	}
	/**
	 * 
	 * @param amt
	 * @param gt
	 */
	public void removeCargo(int amt, GoodType gt) {
		while (amt > 0) {
			for (int i = 0; i < cargoBay.length; i++) {
				if (cargoBay[i] != null) {
					if (cargoBay[i].getGoodType() == gt) {
						cargoBay[i] = null;
						break;
					}
				}
			}
			amt--;
		}
	}
}
