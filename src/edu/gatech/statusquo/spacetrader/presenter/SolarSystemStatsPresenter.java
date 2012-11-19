package edu.gatech.statusquo.spacetrader.presenter;

import org.eclipse.swt.widgets.Shell;

import edu.gatech.statusquo.spacetrader.driver.*;
import edu.gatech.statusquo.spacetrader.model.SolarSystem;
import edu.gatech.statusquo.spacetrader.view.*;

public class SolarSystemStatsPresenter {
    Shell shell;
    Driver driver;
    SolarSystemStatsView solarSystemStatsView;

    /**
     * class constructor using listed parameters
     * 
     * @param s
     * @param d
     * @param sslv
     */

    public SolarSystemStatsPresenter(Shell s, Driver d,
            SolarSystemStatsView sslv) {
        this.shell = s;
        this.driver = d;
        this.solarSystemStatsView = sslv;
        setSystemInfo();
    }

    /**
     * Sets system info
     */

    public static void setSystemInfo() {

        SolarSystem currentSys = Driver.CurrentSystem;

        String[] name = { "Name", currentSys.getSystemName() };
        SolarSystemStatsView.nameItem.setText(name);

        String[] location = { "Location(X,Y)",
                currentSys.getxLocation() + ", " + currentSys.getyLocation() };
        SolarSystemStatsView.locationItem.setText(location);

        String[] techLevel = { "Tech Level",
                Integer.toString(currentSys.getTechLevel()) };
        SolarSystemStatsView.techLevelItem.setText(techLevel);

        String[] rLevel = { "Resource Level", currentSys.getResourceLevelName() };
        SolarSystemStatsView.resourceLevelItem.setText(rLevel);

    }

}
