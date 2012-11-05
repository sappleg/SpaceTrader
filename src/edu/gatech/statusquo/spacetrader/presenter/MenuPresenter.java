package edu.gatech.statusquo.spacetrader.presenter;

import org.eclipse.swt.widgets.Shell;

import edu.gatech.statusquo.spacetrader.driver.*;
import edu.gatech.statusquo.spacetrader.view.*;

public class MenuPresenter {
	Shell shell;
	Driver driver;
	MenuView menuView;

	public MenuPresenter(Shell s, Driver d, MenuView mv) {
		this.shell = s;
		this.driver = d;
		this.menuView = mv;
	}
}
