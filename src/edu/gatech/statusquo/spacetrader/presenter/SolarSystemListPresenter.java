package edu.gatech.statusquo.spacetrader.presenter;

import org.eclipse.swt.widgets.Shell;

import edu.gatech.statusquo.spacetrader.driver.*;
import edu.gatech.statusquo.spacetrader.view.*;

public class SolarSystemListPresenter {
	Shell shell;
	Driver driver;
	SolarSystemListView solarSystemListView;
	
	public SolarSystemListPresenter(Shell s, Driver d, SolarSystemListView sslv) {
		this.shell = s;
		this.driver = d;
		this.solarSystemListView = sslv;
	}
}
