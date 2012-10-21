package edu.gatech.statusquo.spacetrader.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class ShipStatisticsView {
	Shell shell;
	Table table;
	TableColumn tblclmnAttribute;
	TableColumn tblclmnQuantity;
	TableCursor tableCursor;
	
	public ShipStatisticsView(Shell shell) {
		this.shell = shell;
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		tblclmnAttribute = new TableColumn(table, SWT.CENTER);
		tblclmnQuantity = new TableColumn(table, SWT.CENTER);
		tableCursor = new TableCursor(table, SWT.NONE);
		
		try {
			createView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createView() {
		Label lblShipStatistics = new Label(shell, SWT.NONE);
		lblShipStatistics.setAlignment(SWT.CENTER);
		lblShipStatistics.setBounds(53, 0, 77, 15);
		lblShipStatistics.setText("Ship Statistics");

		table.setBounds(0, 21, 190, 198);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		tblclmnAttribute.setWidth(89);
		tblclmnAttribute.setText("Attribute");

		tblclmnQuantity.setWidth(97);
		tblclmnQuantity.setText("Quantity");
	}
}
