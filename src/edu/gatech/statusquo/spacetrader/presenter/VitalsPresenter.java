package edu.gatech.statusquo.spacetrader.presenter;

import org.eclipse.swt.widgets.Shell;

import edu.gatech.statusquo.spacetrader.driver.*;
import edu.gatech.statusquo.spacetrader.view.*;

public class VitalsPresenter {
	Shell shell;
	Driver driver;
	VitalsView vitalsView;

	public VitalsPresenter(Shell s, Driver d, VitalsView vv) {
		this.shell = s;
		this.driver = d;
		this.vitalsView = vv;
	}
}
