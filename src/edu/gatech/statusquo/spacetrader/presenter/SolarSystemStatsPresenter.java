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
	}
	
}


