package edu.gatech.statusquo.spacetrader.presenter;

import org.eclipse.swt.widgets.Shell;

import edu.gatech.statusquo.spacetrader.model.Ship;
import edu.gatech.statusquo.spacetrader.model.SolarSystem;
import edu.gatech.statusquo.spacetrader.view.*;
import edu.gatech.statusquo.spacetrader.driver.Driver;
import org.eclipse.swt.events.*;

public class LocalPlanetPresenter {
	Shell shell;
	Driver driver;
	LocalPlanetView localPlanetView;
	final static int DISTANCEPERFUELUNIT = 11;
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
		setListeners();
	}
	
	/**
	 * Sets listeners
	 */
	private void setListeners() {

		localPlanetView.btnTravel.addMouseListener(new MouseAdapter(){
			public void mouseUp(MouseEvent e) {
				/*
				 * get selection from local planets list
				 * get players x y
				 * calculate distance difference
				 * calculate fuel needed
				 * check that player has necessary fuel
				 * change player location
				 * update player vitals
				 * update market
				 * update local planet list
				 * update ss stats
				 */
				
				if (LocalPlanetView.list_2.getSelection().length == 0) {
					NotificationsView.list_1.add("Please select an solar system from the list");
					return;
				}
				
				int selectedPlanet = LocalPlanetView.list_2.getSelectionIndex();
				String sys = LocalPlanetView.list_2.getItem(selectedPlanet);
				SolarSystem destination = new SolarSystem();
				
				for(int i=0; i < Driver.listOfSystems.size(); i++){
					SolarSystem temp = Driver.listOfSystems.get(i);
					String tempName = temp.getSystemName();
					
					if(tempName.equals(sys)){
						destination = temp;
						break;
					}
				}
				
				int destinationX = destination.getxLocation();
				int destinationY = destination.getyLocation();
				int playerX = Driver.player.getPlayerX();
				int playerY = Driver.player.getPlayerY();
				
				int distance = (int) ((Math.pow(playerX - destinationX, 2)) + (Math
                        .pow(playerY - destinationY, 2)));
                distance = (int) (Math.sqrt(distance));
                
                int fuelNeeded = distance/DISTANCEPERFUELUNIT;
                Ship currentShip = Driver.player.getShip();
                int playerFuel = currentShip.getFuelLevel();
                
                if(fuelNeeded > playerFuel){
                	NotificationsView.list_1.add("You do not have enough fuel to travel here");
                	return;
                }
                
                 
                else{
                    currentShip.subFuel(fuelNeeded);
                    Driver.player.setPlayerX(destinationX);
                    Driver.player.setPlayerY(destinationY);
                    Driver.currentSystem = Driver.player.findSystem(Driver.player.getPlayerX(),Driver.player.getPlayerY());
                    NotificationsView.list_1.add("You have moved to planet: "+Driver.currentSystem.getSystemName());
                    NotificationsView.list_1.add("Fuel Consumed Traveling: "+fuelNeeded);
                    setNewLocals();
                    SolarSystemStatsPresenter.setSystemInfo();
                    VitalsPresenter.setShipVitals();
                    VitalsPresenter.setPlayerVitals();
                    TradeGoodsPresenter.fillTradeGoodsTable();
                    
                    
                    
                    
                    
                    
                }
				
			}
		});
	}	
	
	/**
	 * Refreshes the local systems depending on player X and Y location.
	 */
	
	public static void setNewLocals(){
	       /*
         * Take max fuel cap
         * Take current location
         * Calculate max distance player can travel
         * 
          */
	    
	        LocalPlanetView.list_2.removeAll();
	        Ship currentShip = Driver.player.getShip();
	        int fuelCap = currentShip.getFuelCapacity();
	        int maxDistance = fuelCap * DISTANCEPERFUELUNIT;
	        int playerX = Driver.player.getPlayerX();
	        int playerY = Driver.player.getPlayerY();
	

       
            for (int i = 0; i < Driver.listOfSystems.size(); i++)
            {
                SolarSystem sys = Driver.listOfSystems.get(i);  
                int sysX = sys.getxLocation();
                int sysY = sys.getyLocation();
                
                int distance = (int) ((Math.pow(playerX - sysX, 2)) + (Math
                        .pow(playerY - sysY, 2)));
                distance = (int) (Math.sqrt(distance));
                
                if(distance < maxDistance){
                  LocalPlanetView.list_2.add(sys.getSystemName());   
                  System.out.println(sys.toString());
                }
                
            }
            

	}
}

