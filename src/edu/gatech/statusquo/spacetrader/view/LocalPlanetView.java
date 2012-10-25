package edu.gatech.statusquo.spacetrader.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

public class LocalPlanetView {
	Shell shell;
	Label lblLocalPlanets;
	List list_2;
	
	/**
	 * shell parameter
	 * @param s
	 */
	public LocalPlanetView(Shell s) {
		this.shell = s;
		lblLocalPlanets = new Label(shell, SWT.NONE);
		list_2 = new List(shell, SWT.BORDER);
		
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
		lblLocalPlanets.setBounds(891, 604, 77, 15);
		lblLocalPlanets.setText("Local Planets");

		list_2.setBounds(855, 625, 143, 99);
	}
}
