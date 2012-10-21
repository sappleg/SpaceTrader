package edu.gatech.statusquo.spacetrader.model;

import edu.gatech.statusquo.spacetrader.model.Ship.ShipType;

public class Player {

	private Ship.ShipType ship;
	private static String name;
	private static int currency;
	private static int trader;
	private static int engineer;
	private static int pilot;
	private static int fighter;

	public Player() {
		ship = ShipType.GNAT;
		name = "Player";
		currency = 1000;
		trader = 0;
		engineer = 0;
		pilot = 0;
		fighter = 0;
	}

	/**
	 * Sets the ship type.
	 * 
	 * @param sh
	 *            the ship type.
	 */
	public void setShip(ShipType sh) {
		ship = sh;
	}

	/**
	 * Gets the ship type.
	 * 
	 * @return the ship type.
	 */
	public ShipType getShip() {
		return ship;
	}

	/**
	 * Gets the amount of money the player has currently.
	 * 
	 * @return an integer that is the amount of currency.
	 */
	public static int getCurrency() {
		return currency;
	}

	/**
	 * Set the currency to be a particular value.
	 * 
	 * @param curr an integer that is the amount of money.
	 */
	public void setCurrency(int curr) {
		currency = curr;
	}

	/**
	 * Get the player's name.
	 * 
	 * @return String that contains the player's name.
	 */
	public static String getName() {
		return name;
	}

	/**
	 * Set the player's name.
	 * 
	 * @param nm
	 *            - String - set the player's name to this.
	 */
	public void setName(String nm) {
		name = nm;
	}
	
	public void setTraderSkills(int i) {
		trader = i;
	}
	
	public void setEngineerSkills(int i) {
		engineer = i;
	}
	
	public void setPilotSkills(int i) {
		pilot = i;
	}
	
	public void setFighterSkills(int i) {
		fighter = i;
	}
	
	public static int getTraderSkills() {
		return trader;
	}
	
	public static int getEngineerSkills() {
		return engineer;
	}
	
	public static int getPilotSkills() {
		return pilot;
	}
	
	public static int getFighterSkills() {
		return fighter;
	}
}
