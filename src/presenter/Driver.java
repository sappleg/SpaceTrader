package presenter;

import java.util.ArrayList;
import java.util.Iterator;

import main.Ship;
import model.Player;

public class Driver {
    Player playerOne;
    static int currCurrency = 1000;
    static ArrayList<Integer> totalSkills;
    ArrayList<Integer> partySkills;
    ArrayList<Integer> X;
    ArrayList<Integer> Y;
    
    
    public Driver()
    {
	totalSkills = new ArrayList<Integer>();
	partySkills = new ArrayList<Integer>();
    }
    /**
     * Creates the universe that the game will be played in.
     */
    public void generateUniverse() {

    }

    /**
     * Creates list of usable X and Y coordinates for solar systems.
     * That are at least 10 units away from any other System.
     */
    public void generateCoordinates(){
    	
    	int amtOfCoordinates = 150;			//Amount of coordinates to generate
        ArrayList<Integer> X = new ArrayList<Integer>();
        ArrayList<Integer> Y = new ArrayList<Integer>();

    	
    	
    	while(amtOfCoordinates > 0){
    		boolean goodCoords = false;
        	int arrayLength = X.size();				//List of arrayLength 
        	
    		while(goodCoords!=true){
    			int trueCounter = 0;
    			int testX = (int) (Math.random()*201);
    			int testY = (int) (Math.random()*201);
    		
    			for(int i=0; i<arrayLength; i++){
    				int tempX = X.get(i);
    				int tempY = Y.get(i);
    			
    				int distance = (int)((Math.pow(tempX-testX, 2)) +(Math.pow(tempY-testY, 2)));
    				distance = (int) (Math.sqrt(distance));
    				
    				if (distance >= 10){
    					trueCounter++;
    				}
    			}
    			
    			if (trueCounter==arrayLength){
    				X.add(testX);
    				Y.add(testY);
    				goodCoords=true;
    			}
    		}
    		amtOfCoordinates++;
    	}
    	
    	
    	
    	
    }
    
    
    /**
     * Creates the player
     * 
     * @param name
     *            - the name of the player
     * @param traderUsed
     *            - points assigned for trader
     * @param engineerUsed
     *            - points assigned for engineer
     * @param pilotUsed
     *            - points assigned for pilot
     * @param fighterUsed
     *            - points assigned for fighter
     */
    public void createPlayer(String name, int traderUsed, int engineerUsed,
	    int pilotUsed, int fighterUsed) {
	playerOne = new Player(currCurrency, Ship.ShipType.GNAT, name,
		pilotUsed, fighterUsed, traderUsed, engineerUsed);
	totalSkills.add(traderUsed);
	totalSkills.add(engineerUsed);
	totalSkills.add(pilotUsed);
	totalSkills.add(fighterUsed);
    }

    /**
     * Returns the current player's money.
     * 
     * @return an int that contains the player's money.
     */
    public static int getCurrency() {
	return currCurrency;
    }

    /**
     * Gets the entire party's skills.
     * 
     * @return an ArrayList<Integer> that contains all the skills.
     */
    public static ArrayList<Integer> getSkills() {
	return totalSkills;
    }

    /**
     * This method is to boost the player's statistics in case he/she purchases
     * a mercenary.
     * 
     * @param tr
     *            number of trader points.
     * @param en
     *            number of engineer points.
     * @param pi
     *            number of pilot points.
     * @param fi
     *            number of fighter points.
     */
    public void boostSkillPoints(int tr, int en, int pi, int fi) {
	int[] boostPoints = { tr, en, pi, fi };
	ArrayList<Integer> newTotalSkills = new ArrayList<Integer>();
	for (int i = 0; i < boostPoints.length; i++) {
	    newTotalSkills.add(totalSkills.get(i) + boostPoints[i]);
	}
	totalSkills = newTotalSkills;
    }
}
