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
	
	public HashMap<GoodType, Integer> getMarketPrice() {
		return marketPrice;
	}
	
	public void setMarketPrice(HashMap<GoodType, Integer> hm) {
		marketPrice = hm;
	}	
	public HashMap<GoodType, Integer> getMarketQuantity() {
		return marketQuantity;
	}
	
	public void setMarketQuantity(HashMap<GoodType, Integer> hm) {
		marketQuantity = hm;
	}
	
	

	public int getTechLevel() {
		return techLevel;
	}

	public void setTechLevel(int techLevel) {
		SolarSystem.techLevel = techLevel;
	}

	public int getResourceLevel() {
		return resourceLevel;
	}

	public void setResourceLevel(int resourceLevel) {
		SolarSystem.resourceLevel = resourceLevel;
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
}
