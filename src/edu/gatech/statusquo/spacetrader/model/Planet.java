package edu.gatech.statusquo.spacetrader.model;

public class Planet {

	private String planetName;

	/**
	 * Class constructor using listed parameters.
	 * 
	 * @param planetName
	 */

	public Planet(String planetName) {
		this.planetName = planetName;
	}

	/**
	 * @return Information about Planet in a String
	 * 
	 */
	public String toString() {
		return ("PlanetName: " + planetName + "\n");
	}

}
