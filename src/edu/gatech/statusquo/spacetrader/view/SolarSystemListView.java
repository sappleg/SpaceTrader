package edu.gatech.statusquo.spacetrader.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;

public class SolarSystemListView {
	Shell shell;
	Label lblNewLabel;
	List list;
	
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
	
	public void createView() {
		lblNewLabel.setBounds(53, 423, 94, 15);
		lblNewLabel.setText("Solar System List");

		list.setBounds(0, 444, 190, 286);
	}
}
