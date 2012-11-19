package edu.gatech.statusquo.spacetrader.presenter;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import edu.gatech.statusquo.spacetrader.driver.*;
import edu.gatech.statusquo.spacetrader.view.*;

public class MenuPresenter {
    Shell shell;
    Display display;
    Driver driver;
    MenuView menuView;
    URI uri;
    Desktop desktop;

    public MenuPresenter(Shell s, Display di, Driver d, MenuView mv) {
        this.shell = s;
        this.display = di;
        this.driver = d;
        this.menuView = mv;
        try {
            uri = new URI("https://github.com/spencerapplegate/SpaceTrader");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        desktop = Desktop.getDesktop();

        setListeners();
    }

    public void setListeners() {
        menuView.fileExitItem.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent e) {
                shell.close();
                display.dispose();
            }

            public void widgetDefaultSelected(SelectionEvent e) {
                shell.close();
                display.dispose();
            }
        });

        menuView.fileSaveItem.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent e) {
                driver.saveGame();
            }

            public void widgetDefaultSelected(SelectionEvent e) {
                driver.saveGame();
            }
        });

        menuView.helpGetHelpItem.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                try {
                    desktop.browse(uri);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

            public void widgetDefaultSelected(SelectionEvent e) {
                try {
                    desktop.browse(uri);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
