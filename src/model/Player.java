package model;
import main.Ship;
import main.Ship.ShipType;

public class Player {
	
	private static int currency;
	private Ship.ShipType ship;
	private static String name;
	private int pilot;
	private int fighter;
	private int trader;
	private int engineer;
	
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
	
	public void setShip(ShipType sh)
	{
		ship = sh;
	}
	
	public ShipType getShip()
	{
		return ship;
	}
	
	public static int getCurrency()
	{
		return currency;
	}
	
	public void setCurrency(int curr)
	{
		currency = curr;
	}
	
	public static String getName()
	{
		return name;
	}
	
	public void setName(String nm)
	{
		name = nm;
	}
	
	public void setSkills(int pi, int fi, int tr, int en)
	{
		pilot = pi;
		fighter = fi;
		trader = tr;
		engineer = en;
	}
}
