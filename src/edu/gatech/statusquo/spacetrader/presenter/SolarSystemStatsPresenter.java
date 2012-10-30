package edu.gatech.statusquo.spacetrader.presenter;

import org.eclipse.swt.widgets.Shell;

import edu.gatech.statusquo.spacetrader.driver.*;
import edu.gatech.statusquo.spacetrader.model.Player;
import edu.gatech.statusquo.spacetrader.model.Ship;
import edu.gatech.statusquo.spacetrader.model.SolarSystem;
import edu.gatech.statusquo.spacetrader.view.*;

public class SolarSystemStatsPresenter {
	Shell shell;
	Driver driver;
	SolarSystemStatsView solarSystemStatsView;
	static SolarSystem cSys;
	/**
	 * class constructor using listed parameters
	 * @param s
	 * @param d
	 * @param sslv
	 */

    public SolarSystemStatsPresenter(Shell s, Driver d, SolarSystemStatsView sslv) {
		this.shell = s;
		this.driver = d;
		this.solarSystemStatsView = sslv;
		cSys = d.currentSystem;
		setSystemInfo();
	}
    
    /**
     * Sets system info
     */
	
	   public static void setSystemInfo() {

           String[] name = {"Name", cSys.getSystemName()};
           SolarSystemStatsView.nameItem.setText(name);
           
           String[] location = {"Location(X,Y)", cSys.getxLocation() + ", " + cSys.getyLocation()};
           SolarSystemStatsView.locationItem.setText(location);
           
           String[] techLevel = {"Tech Level", Integer.toString(cSys.getTechLevel())};
           SolarSystemStatsView.techLevelItem.setText(techLevel);
           
           String[] rLevel = {"Resource Level", cSys.getResourceLevelName()};
           SolarSystemStatsView.resourceLevelItem.setText(rLevel);
           
           
	   }
	   
	
}


