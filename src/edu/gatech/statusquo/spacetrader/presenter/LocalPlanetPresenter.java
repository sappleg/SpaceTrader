package edu.gatech.statusquo.spacetrader.presenter;

import org.eclipse.swt.widgets.Shell;

import edu.gatech.statusquo.spacetrader.model.Ship;
import edu.gatech.statusquo.spacetrader.model.SolarSystem;
import edu.gatech.statusquo.spacetrader.view.*;
import edu.gatech.statusquo.spacetrader.driver.Driver;


public class LocalPlanetPresenter {
	Shell shell;
	Driver driver;
	LocalPlanetView localPlanetView;
	final int distancePerFuelUnit = 11;
	/**
	 * class constructor using listed parameters
	 * @param s
	 * @param d
	 * @param lpv
	 */
	public LocalPlanetPresenter(Shell s, Driver d, LocalPlanetView lpv) {
		this.shell = s;
		this.driver = d;
		this.localPlanetView = lpv;
		setNewLocals();
	}
	
	/**
	 * Refreshes the local systems depending on player X and Y location.
	 */
	public void setNewLocals(){
	       /*
         * Take max fuel cap
         * Take current location
         * Calculate max distance player can travel
         * 
          */
	    
	        Ship currentShip = Driver.player.getShip();
	        int fuelCap = currentShip.getFuelCapacity();
	        int maxDistance = fuelCap * distancePerFuelUnit;
	        int playerX = Driver.player.getPlayerX();
	        int playerY = Driver.player.getPlayerY();
	

           // Collections.sort(Driver.listOfNames);
            for (int i = 0; i < Driver.listOfSystems.size(); i++)
            {
                SolarSystem sys = Driver.listOfSystems.get(i);  
                int sysX = sys.getxLocation();
                int sysY = sys.getyLocation();
                
                int distance = (int) ((Math.pow(playerX - sysX, 2)) + (Math
                        .pow(playerY - sysY, 2)));
                distance = (int) (Math.sqrt(distance));
                
                if(distance <= maxDistance){
                  LocalPlanetView.list_2.add(sys.getSystemName());        
                }
                
                
               
//                SolarSystem temp = Driver.listOfSystems.get(i);            
//                LocalPlanetView.list_2.add(temp.getSystemName());
            }
            

	}
}

