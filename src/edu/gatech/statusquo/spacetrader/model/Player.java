package edu.gatech.statusquo.spacetrader.model;

import java.util.ArrayList;
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
		currency = 0;
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

	/**
	 * Set the skill points.
	 * 
	 * @param pi pilot skill points
	 * @param fi fighter skill points
	 * @param tr trader skill points
	 * @param en engineer skill points.
	 */
	public void setSkills(int pi, int fi, int tr, int en) {
		pilot = pi;
		fighter = fi;
		trader = tr;
		engineer = en;
	}

	/**
	 * Will return an ArrayList of the player's skill points.
	 * 
	 * @return ArrayList<Integer> of the player's skill points.
	 */
	public static ArrayList<Integer> getSkills() {
		ArrayList<Integer> skills = new ArrayList<Integer>();
		skills.add(pilot);
		skills.add(fighter);
		skills.add(trader);
		skills.add(engineer);
		return skills;
	}
}
