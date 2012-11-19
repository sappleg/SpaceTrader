package edu.gatech.statusquo.spacetrader.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

public class LocalPlanetView {
    Shell shell;
    Label lblLocalPlanets;
    public static List list_2;
    public Button btnTravel;

    /**
     * shell parameter
     * 
     * @param s
     */
    public LocalPlanetView(Shell s) {
        this.shell = s;
        lblLocalPlanets = new Label(shell, SWT.NONE);
        list_2 = new List(shell, SWT.BORDER | SWT.V_SCROLL);
        btnTravel = new Button(shell, SWT.NONE);

        try {
            createView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates contents of the local planets view
     */
    public void createView() {
        lblLocalPlanets.setBounds(891, 365, 77, 15);
        lblLocalPlanets.setText("Local Planets");
        list_2.setBounds(855, 390, 143, 275);

        btnTravel.setBounds(890, 675, 75, 25);
        btnTravel.setText("Travel");
    }
}
