package edu.gatech.statusquo.spacetrader.model;

import java.util.ArrayList;
import java.util.HashMap;

import edu.gatech.statusquo.spacetrader.model.Good.GoodType;

public class SolarSystem {

	private static String systemName;
	private static int techLevel;
	private static int resourceLevel;
	private static int xLocation;
	private static int yLocation;
	private static Planet planet;
	private static HashMap<GoodType, ArrayList<GoodType>> market;
	
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
		market = new HashMap<Good.GoodType, ArrayList<Good.GoodType>>();
		GoodType[] keys = GoodType.values();
		for (GoodType g: keys) {
			market.put(g, new ArrayList<GoodType>());
		}
	}
	
	public HashMap<GoodType, ArrayList<GoodType>> getMarket() {
		return market;
	}
	
	public void setMarket(HashMap<GoodType, ArrayList<GoodType>> hm) {
		market = hm;
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
