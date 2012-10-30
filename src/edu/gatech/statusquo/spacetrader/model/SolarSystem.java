package edu.gatech.statusquo.spacetrader.model;

import java.util.HashMap;

import edu.gatech.statusquo.spacetrader.model.Good.GoodType;

public class SolarSystem {

	private static String systemName;
	private static int techLevel;
	private static int resourceLevel;
	private static int xLocation;
	private static int yLocation;
	private static Planet planet;
	private static HashMap<GoodType, Integer> marketPrice;
	private static HashMap<GoodType, Integer> marketQuantity;
	
	/**
	 * Class constructor using listed parameters
	 * @param systemName
	 * @param planet
	 * @param techLevel
	 * @param resourceLevel
	 * @param xLocation
	 * @param yLocation
	 */
	public SolarSystem() {
	        // TODO Auto-generated constructor stub
	    }
	public SolarSystem(String systemName, Planet planet, int techLevel,
			int resourceLevel, int xLocation, int yLocation) {

		SolarSystem.systemName = systemName;
		SolarSystem.planet = planet;
		SolarSystem.techLevel = techLevel;
		SolarSystem.resourceLevel = resourceLevel;
		SolarSystem.xLocation = xLocation;
		SolarSystem.yLocation = yLocation;
		marketPrice = new HashMap<Good.GoodType, Integer>();
		marketQuantity = new HashMap<Good.GoodType, Integer>();
		GoodType[] keys = GoodType.values();
		for (GoodType g: keys) {
			marketPrice.put(g, 0);
			marketQuantity.put(g, 0);
		}
	}
	


    /**
	 * 
	 * @return marketPrice
	 */
	public HashMap<GoodType, Integer> getMarketPrice() {
		return marketPrice;
	}
	
	/**
	 * 
	 * @param hm
	 */
	public void setMarketPrice(HashMap<GoodType, Integer> hm) {
		marketPrice = hm;
	}	
	
	/**
	 * 
	 * @return market Quantity
	 */
	public HashMap<GoodType, Integer> getMarketQuantity() {
		return marketQuantity;
	}
	
	/**
	 * 
	 * @param hm
	 */
	public void setMarketQuantity(HashMap<GoodType, Integer> hm) {
		marketQuantity = hm;
	}
	
	/**
	 * 
	 * @return techLevel
	 */
	public int getTechLevel() {
		return techLevel;
	}
	
	/**
	 * 
	 * @param techLevel
	 */
	public void setTechLevel(int techLevel) {
		SolarSystem.techLevel = techLevel;
	}
	
	/**
	 * 
	 * @return resourceLevel
	 */
	public int getResourceLevel() {
		return resourceLevel;
	}
	
	/**
	 * 
	 * @param resourceLevel
	 */
	public void setResourceLevel(int resourceLevel) {
		SolarSystem.resourceLevel = resourceLevel;
	}
	
	public String getResourceLevelName(){
		
		if(resourceLevel == 0){
			return "Lots of Water";
		}
		if(resourceLevel == 1){
			return "Drought";
		}
		if(resourceLevel == 2){
			return "Rich Fauna";
		}
		if(resourceLevel == 3){
			return "Lifeless";
		}
		if(resourceLevel == 4){
			return "Rich Soil";
		}
		if(resourceLevel == 5){
			return "Poor Soil";
		}
		if(resourceLevel == 6){
			return "Mineral Rich";
		}
		if(resourceLevel == 7){
			return "Mineral Poor";
		}
		if(resourceLevel == 8){
			return "Warlike";
		}
		if(resourceLevel == 9){
			return "Lots of Herbs";
		}
		if(resourceLevel == 10){
			return "Weird Mushrooms";
		}
		else return null;
		
		
	}

	/**
	 * @return Information of the SolarSystem in a String.
	 */
	public String toString() {
		return ("SystemName: " + systemName + "\n" + planet.toString()
				+ "TechLevel: " + techLevel + "\n" + "ResourceLevel: "
				+ resourceLevel + "\n" + "X-Position: " + xLocation + "\n"
				+ "Y-Position: " + yLocation + "\n");
	}

	public int getxLocation() {
		return xLocation;
	}

	public int getyLocation() {
		return yLocation;
	}

	public String getSystemName() {
		return systemName;
	}
}
