package edu.gatech.statusquo.spacetrader.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class SolarSystemStatsView {
	Shell shell;
	Label lblNewLabel;
	List list;
	Table table;
	TableColumn tblclmnAtt;
	TableColumn tblclmnValue;
	TableItem nameItem;
	TableItem locationItem;
	TableItem techLevelItem;
	TableItem resourceLevelItem;
	
	/**
	 * Shell s
	 * @param s
	 */
	
	public SolarSystemStatsView(Shell s) {
		this.shell = s;
		lblNewLabel = new Label(shell, SWT.NONE);
		list = new List(shell, SWT.BORDER | SWT.V_SCROLL);
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		tblclmnAtt = new TableColumn(table, SWT.CENTER);
		tblclmnValue = new TableColumn(table, SWT.CENTER);
		nameItem = new TableItem(table, SWT.NONE);
		locationItem = new TableItem(table, SWT.NONE);
		techLevelItem = new TableItem(table, SWT.NONE);
		resourceLevelItem = new TableItem(table, SWT.NONE);
		
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
		lblNewLabel.setText("Solar System Stats");

		table.setBounds(0, 444, 190, 255);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		tblclmnAtt.setWidth(108);
		tblclmnAtt.setText("Attribute");

		tblclmnValue.setWidth(79);
		tblclmnValue.setText("Value");
		
		String[] name = {"Name","0"};
		nameItem.setText(name);
		
		String[] location = {"Location(X,Y)","0"};
		locationItem.setText(location);
		
		String[] techLevel = {"Tech Level","0"};
		techLevelItem.setText(techLevel);
		
		String[] rLevel = {"Resource Level","0"};
		resourceLevelItem.setText(rLevel);
	}
}
