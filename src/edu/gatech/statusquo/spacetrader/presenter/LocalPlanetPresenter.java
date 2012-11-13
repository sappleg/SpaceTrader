package edu.gatech.statusquo.spacetrader.presenter;

import org.eclipse.swt.widgets.Shell;

import edu.gatech.statusquo.spacetrader.model.Good;
import edu.gatech.statusquo.spacetrader.model.Player;
import edu.gatech.statusquo.spacetrader.model.Ship;
import edu.gatech.statusquo.spacetrader.model.SolarSystem;
import edu.gatech.statusquo.spacetrader.model.Good.GoodType;
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
                    NotificationsView.list_1.select(NotificationsView.list_1.getItemCount() - 1);
                    NotificationsView.list_1.showSelection();
					return;
				}
				
				int selectedPlanet = LocalPlanetView.list_2.getSelectionIndex();
				String sys = LocalPlanetView.list_2.getItem(selectedPlanet);
				SolarSystem destination = new SolarSystem();
				
				for(int i=0; i < Driver.ListOfSystems.size(); i++){
					SolarSystem temp = Driver.ListOfSystems.get(i);
					String tempName = temp.getSystemName();
					
					if(tempName.equals(sys)){
						destination = temp;
						break;
					}
				}
				
				int destinationX = destination.getxLocation();
				int destinationY = destination.getyLocation();
				int playerX = Driver.Player.getPlayerX();
				int playerY = Driver.Player.getPlayerY();
				
				int distance = (int) ((Math.pow(playerX - destinationX, 2)) + (Math
                        .pow(playerY - destinationY, 2)));
                distance = (int) (Math.sqrt(distance));
                
                int fuelNeeded = distance/DISTANCEPERFUELUNIT;
                Ship currentShip = Driver.Player.getShip();
                int playerFuel = currentShip.getFuelLevel();
                
                if(fuelNeeded > playerFuel){
                	NotificationsView.list_1.add("You do not have enough fuel to travel here");
                    NotificationsView.list_1.select(NotificationsView.list_1.getItemCount() - 1);
                    NotificationsView.list_1.showSelection();
                	return;
                }
                
                
                //updating UI information since you have traveled. 
                 
                else{
                    
                    
                    currentShip.subFuel(fuelNeeded);
                    Driver.Player.setPlayerX(destinationX);
                    Driver.Player.setPlayerY(destinationY);
            
                    //random events
                    int randomEvent = (int) ((Math.random())*100);
                    
                    
                    if (randomEvent >=50 && randomEvent <= 69){
                        //police encounter, narcotics are removed
                        int narcoticsAmt = currentShip.countCargo(GoodType.NARCOTIC);
                        currentShip.removeCargo(narcoticsAmt, GoodType.NARCOTIC);
    					NotificationsView.list_1.add("You got pulled over by Space Police who checked for and removed any and all illegal cargo");
                        NotificationsView.list_1.select(NotificationsView.list_1.getItemCount() - 1);
                        NotificationsView.list_1.showSelection();
                    }
                    
                    else if (randomEvent >= 70 && randomEvent <= 77){
                        //pirate encounter, all goods are removed
                        Good[] empty = new Good[0];
                        currentShip.cargoBay = empty;
    					NotificationsView.list_1.add("You were raided by pirates! They cleaned you out of all your cargo.");
                        NotificationsView.list_1.select(NotificationsView.list_1.getItemCount() - 1);
                        NotificationsView.list_1.showSelection();
                    }
                    
                    else if(randomEvent >= 78 && randomEvent <= 89){
                        //merchant encounter, rewards player with 1000 credits
                        int newCurrency = Player.getCurrency() + 1000;
                        Driver.Player.setCurrency(newCurrency);
    					NotificationsView.list_1.add("You picked up a stranded merchant and took him to the nearest planet. He gave you 1000 credits for your troubles.");
                        NotificationsView.list_1.select(NotificationsView.list_1.getItemCount() - 1);
                        NotificationsView.list_1.showSelection();
                    }
                    
                    else if(randomEvent >= 90 && randomEvent <= 94){
                        //worm hole, no fuel is used
                    	fuelNeeded = 0;
                        currentShip.addFuel(fuelNeeded);
    					NotificationsView.list_1.add("During your travels a wormhole suddenly appeared. You flew through the wormhole and used no fuel.");
                        NotificationsView.list_1.select(NotificationsView.list_1.getItemCount() - 1);
                        NotificationsView.list_1.showSelection();
                    }
                    
                    else if(randomEvent >= 95 && randomEvent <= 98){
                        //asteroid collision, all fuel is depleted
                        int currentFuel = currentShip.getFuelLevel();
                        currentShip.subFuel(currentFuel);
                        fuelNeeded = playerFuel;
    					NotificationsView.list_1.add("While approaching the planet your gas tank was suddenly struck by an meteorite. Your remaining fuel was drained as a result.");
                        NotificationsView.list_1.select(NotificationsView.list_1.getItemCount() - 1);
                        NotificationsView.list_1.showSelection();
                        
                    }
                    
                    else if(randomEvent == 99){
                        //treasure encounter, 1000*(1..10) credits are added to currency
                        int randomMult = (int) (Math.random()*10)+1;
                        int reward = 1000*randomMult;
                        int newCurrency = Player.getCurrency() + reward;
                        Driver.Player.setCurrency(newCurrency);
    					NotificationsView.list_1.add("You found a pirates treasure cash! You recieved "+ reward + " credits.");
                        NotificationsView.list_1.select(NotificationsView.list_1.getItemCount() - 1);
                        NotificationsView.list_1.showSelection();
                    }
                    
                 
                    else{
                        //print notification that nothing happened
    					NotificationsView.list_1.add("Nothing interesting happened on your travels.");
                        NotificationsView.list_1.select(NotificationsView.list_1.getItemCount() - 1);
                        NotificationsView.list_1.showSelection();
                    }
                    
                    Driver.CurrentSystem = Driver.Player.findSystem(Driver.Player.getPlayerX(),Driver.Player.getPlayerY());
                    NotificationsView.list_1.add("You have moved to planet: "+Driver.CurrentSystem.getSystemName());
                    NotificationsView.list_1.add("Fuel Consumed Traveling: "+fuelNeeded);
                    NotificationsView.list_1.select(NotificationsView.list_1.getItemCount() - 1);
                    NotificationsView.list_1.showSelection();
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
	        Ship currentShip = Driver.Player.getShip();
	        int fuelCap = currentShip.getFuelCapacity();
	        int maxDistance = fuelCap * DISTANCEPERFUELUNIT;
	        int playerX = Driver.Player.getPlayerX();
	        int playerY = Driver.Player.getPlayerY();
	

       
            for (int i = 0; i < Driver.ListOfSystems.size(); i++)
            {
                SolarSystem sys = Driver.ListOfSystems.get(i);  
                int sysX = sys.getxLocation();
                int sysY = sys.getyLocation();
                
                int distance = (int) ((Math.pow(playerX - sysX, 2)) + (Math
                        .pow(playerY - sysY, 2)));
                distance = (int) (Math.sqrt(distance));
                
                if(distance < maxDistance){
                  LocalPlanetView.list_2.add(sys.getSystemName());   
                }
                
            }
            

	}
}

