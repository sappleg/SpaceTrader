package edu.gatech.statusquo.spacetrader.presenter;

import org.eclipse.swt.widgets.Shell;

import edu.gatech.statusquo.spacetrader.driver.Driver;
import edu.gatech.statusquo.spacetrader.view.*;

public class TeamStatisticsPresenter {
	Shell shell;
	Driver driver;
	TeamStatisticsView teamStatisticsView;

	public TeamStatisticsPresenter(Shell s, Driver d, TeamStatisticsView tsv) {
		this.shell = s;
		this.driver = d;
		this.teamStatisticsView = tsv;
	}
}
