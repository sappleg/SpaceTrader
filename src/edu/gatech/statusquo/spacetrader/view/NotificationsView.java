package edu.gatech.statusquo.spacetrader.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

import edu.gatech.statusquo.spacetrader.model.*;

public class NotificationsView {
	Shell shell;
	Player player;
	Label lblNotifications;
	public static List list_1;
	
	public NotificationsView(Shell s, Player p) {
		this.shell = s;
		this.player = p;
		lblNotifications = new Label(shell, SWT.NONE);
		list_1 = new List(shell, SWT.BORDER | SWT.V_SCROLL);
		try {
			createView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createView() {
		lblNotifications.setAlignment(SWT.CENTER);
		lblNotifications.setBounds(485, 604, 77, 15);
		lblNotifications.setText("Notifications");
		
		list_1.setBounds(196, 628, 653, 96);
		list_1.add("Welcome to Space Trader " + Player.getName());
	}
}
