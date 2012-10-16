package model;

public class SolarSystem {

	private static String systemName;
	private static int techLevel;
	private static int resourceLevel;
	private static int xLocation;
	private static int yLocation;
	private static Planet planet;
	
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

		this.systemName = systemName;
		this.planet = planet;
		this.techLevel = techLevel;
		this.resourceLevel = resourceLevel;
		this.xLocation = xLocation;
		this.yLocation = yLocation;
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
