package edu.gatech.statusquo.spacetrader.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

public class MenuView {
	Shell shell;
	Menu menuBar;
	MenuItem fileMenuHeader;
	Menu fileMenu;
	MenuItem fileSaveItem;
	MenuItem fileExitItem;
	MenuItem helpMenuHeader;
	Menu helpMenu;
	MenuItem helpGetHelpItem;

	public MenuView(Shell s) {
		//instantiate Menu for Main application
		this.shell = s;
	    menuBar = new Menu(shell, SWT.BAR);
	    fileMenuHeader = new MenuItem(menuBar, SWT.CASCADE);
	    fileMenu = new Menu(shell, SWT.DROP_DOWN);
	    fileSaveItem = new MenuItem(fileMenu, SWT.PUSH);
	    fileExitItem = new MenuItem(fileMenu, SWT.PUSH);
	    helpMenuHeader = new MenuItem(menuBar, SWT.CASCADE);
	    helpMenu = new Menu(shell, SWT.DROP_DOWN);
	    helpGetHelpItem = new MenuItem(helpMenu, SWT.PUSH);
		
	    createView();
	    shell.setMenuBar(menuBar);
	}
	
	public void createView() {
		//setters for menu
	    fileMenuHeader.setText("&File");
	    fileMenuHeader.setMenu(fileMenu);
	    fileSaveItem.setText("&Save");
	    fileExitItem.setText("E&xit");
	    helpMenuHeader.setText("&Help");
	    helpMenuHeader.setMenu(helpMenu);
	    helpGetHelpItem.setText("&Get Help");
	}
}
