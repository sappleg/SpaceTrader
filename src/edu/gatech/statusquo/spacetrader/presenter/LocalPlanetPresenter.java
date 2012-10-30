package edu.gatech.statusquo.spacetrader.presenter;

import org.eclipse.swt.widgets.Shell;

import edu.gatech.statusquo.spacetrader.driver.*;
import edu.gatech.statusquo.spacetrader.view.*;

public class LocalPlanetPresenter {
	Shell shell;
	Driver driver;
	LocalPlanetView localPlanetView;
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
	}
}

