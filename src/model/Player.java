package model;
import java.util.ArrayList;

import main.Ship;
import main.Ship.ShipType;

public class Player {
	
	private static int currency;
	private Ship.ShipType ship;
	private static String name;
	private static int pilot;
	private static int fighter;
	private static int trader;
	private static int engineer;
	
	public Player(int amount, Ship.ShipType sh, String nm, int pi, int fi, int tr, int en)
	{
		currency = amount;
		ship = sh;
		name = nm;
		pilot = pi;
		fighter = fi;
		trader = tr;
		engineer = en;
	}
	
	/**
	 * Sets the ship type.
	 * @param sh the ship type.
	 */
	public void setShip(ShipType sh)
	{
		ship = sh;
	}
	
	/**
	 * Gets the ship type.
	 * @return the ship type.
	 */
	public ShipType getShip()
	{
		return ship;
	}
	
	/**
	 * Gets the amount of money the player has currently.
	 * @return an int that is the amount of currency.
	 */
	public static int getCurrency()
	{
		return currency;
	}
	
	/**
	 * Set the currency to be a particular value.
	 * @param curr an int that is the amount of money.
	 */
	public void setCurrency(int curr)
	{
		currency = curr;
	}
	
	/**
	 * Get the player's name.
	 * @return String that contains the player's name.
	 */
	public static String getName()
	{
		return name;
	}
	
	/**
	 * Set the player's name.
	 * @param nm - String - set the player's name to this.
	 */
	public void setName(String nm)
	{
		name = nm;
	}
	
	/**
	 * Set the skill points.
	 * @param pi - pilot skill points
	 * @param fi - fighter skill points
	 * @param tr - trader skill points
	 * @param en - engineer skill points.
	 */
	public void setSkills(int pi, int fi, int tr, int en)
	{
		pilot = pi;
		fighter = fi;
		trader = tr;
		engineer = en;
	}
	
	public static ArrayList<Integer> getSkills()
	{
	    ArrayList<Integer> skills = new ArrayList<Integer>();
	    skills.add(pilot);
	    skills.add(fighter);
	    skills.add(trader);
	    skills.add(engineer);
	    return skills;
	}
}
