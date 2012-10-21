package edu.gatech.statusquo.spacetrader.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class TradeGoodsView {
	Shell shell;
	Table table_1;
	TableColumn tblclmnItems;
	TableColumn tblclmnPrice;
	TableColumn tblclmnNewColumn;
	TableCursor tableCursor_1;
	
	public TradeGoodsView(Shell s) {
		this.shell = s;
		table_1 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		tblclmnItems = new TableColumn(table_1, SWT.NONE);
		tblclmnPrice = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn = new TableColumn(table_1, SWT.NONE);
		tableCursor_1 = new TableCursor(table_1, SWT.NONE);
		
		try {
			createView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createView() {
		Label label = new Label(shell, SWT.NONE);
		label.setAlignment(SWT.CENTER);
		label.setText("Trade Goods");
		label.setBounds(485, 0, 77, 15);

		table_1.setBounds(196, 21, 653, 579);
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);

		tblclmnItems.setWidth(521);
		tblclmnItems.setText("Item");

		tblclmnPrice.setWidth(64);
		tblclmnPrice.setText("Price");

		tblclmnNewColumn.setWidth(63);
		tblclmnNewColumn.setText("Quantity");
	}
}
