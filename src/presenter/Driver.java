package presenter;
import main.Ship;
import model.Player;

public class Driver 
{
    Player playerOne;
    
    /**
     * Creates the universe that the game will be played in.
     */
	public void generateUniverse()
	{
		
	}
	
	/**
	 * Creates the player
	 * @param name - the name of the player
	 * @param traderUsed - points assigned for trader
	 * @param engineerUsed - points assigned for engineer
	 * @param pilotUsed - points assigned for pilot
	 * @param fighterUsed - points assigned for fighter
	 */
	public void createPlayer(String name, int traderUsed, int engineerUsed, int pilotUsed, int fighterUsed)
	{
		playerOne = new Player(1000, Ship.ShipType.GNAT, name, pilotUsed, fighterUsed, traderUsed, engineerUsed);
	}
	
}
