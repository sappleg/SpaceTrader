package edu.gatech.statusquo.spacetrader.presenter;

import org.eclipse.swt.widgets.Shell;

import edu.gatech.statusquo.spacetrader.driver.*;
import edu.gatech.statusquo.spacetrader.view.*;

public class ShipStatisticsPresenter {
	Shell shell;
	Driver driver;
	ShipStatisticsView shipStatisticsView;

	public ShipStatisticsPresenter(Shell s, Driver d, ShipStatisticsView ssv) {
		this.shell = s;
		this.driver = d;
		this.shipStatisticsView = ssv;
	}
}
