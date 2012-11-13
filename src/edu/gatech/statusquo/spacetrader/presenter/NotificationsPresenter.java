package edu.gatech.statusquo.spacetrader.presenter;

import org.eclipse.swt.widgets.Shell;

import edu.gatech.statusquo.spacetrader.driver.*;
import edu.gatech.statusquo.spacetrader.model.Player;
import edu.gatech.statusquo.spacetrader.view.*;

public class NotificationsPresenter {

	Shell shell;
	Driver driver;
	NotificationsView notificationsView;
	
	/**
	 * Class constructor using listed parameters
	 * @param s
	 * @param d
	 * @param nv
	 */
	public NotificationsPresenter(Shell s, Driver d, NotificationsView nv) {
		this.shell = s;
		this.driver = d;
		this.notificationsView = nv;
		setNotifications();
	}
	
	
	/**
	 * Sets notifications
	 */
	public static void setNotifications(){
	    NotificationsView.list_1.add("Welcome to Space Trader " + Player.getName());
	    NotificationsView.list_1.add("Your starting planet: "+Driver.CurrentSystem.getSystemName());
	    
	}
}
