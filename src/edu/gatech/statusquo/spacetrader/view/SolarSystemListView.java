package edu.gatech.statusquo.spacetrader.view;

import java.util.Collections;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;

import edu.gatech.statusquo.spacetrader.driver.Driver;

public class SolarSystemListView {
	Shell shell;
	Label lblNewLabel;
	List list;
	
	/**
	 * Shell s
	 * @param s
	 */
	
	public SolarSystemListView(Shell s) {
		this.shell = s;
		lblNewLabel = new Label(shell, SWT.NONE);
		list = new List(shell, SWT.BORDER | SWT.V_SCROLL);
		
		try {
			createView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Creates the contents of the solar system list view
	 */
	public void createView() {
		lblNewLabel.setBounds(53, 423, 94, 15);
		lblNewLabel.setText("Solar System List");
		list.setBounds(0, 444, 190, 245);		
		Collections.sort(Driver.listOfNames);
		for (int i = 0; i < Driver.listOfNames.size(); i++)
		{
		list.add(Driver.listOfNames.get(i));
		}
		
		Button btnTravel = new Button(shell, SWT.NONE);
		btnTravel.setBounds(55, 695, 75, 25);
		btnTravel.setText("Travel");
	}
}
