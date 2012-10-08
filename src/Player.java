
public class Player {
	
	private int currency;
	private int ship;
	private String name;
	private int pilot;
	private int fighter;
	private int trader;
	private int engineer;
	
	public Player(int amount, int sh, String nm, int pi, int fi, int tr, int en)
	{
		currency = amount;
		ship = sh;
		name = nm;
		pilot = pi;
		fighter = fi;
		trader = tr;
		engineer = en;
	}
	
	public void setShip(int sh)
	{
		ship = sh;
	}
	
	public int getShip()
	{
		return ship;
	}
	
	public int getCurrency()
	{
		return currency;
	}
	
	public void setCurrency(int curr)
	{
		currency = curr;
	}
	
	public String getName()
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
