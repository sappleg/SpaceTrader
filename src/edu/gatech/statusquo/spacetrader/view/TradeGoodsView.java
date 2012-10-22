package edu.gatech.statusquo.spacetrader.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

public class TradeGoodsView {
	Shell shell;
	Table table_1;
	TableColumn tblclmnItems;
	TableColumn tblclmnPrice;
	TableColumn tblclmnNewColumn;
	TableCursor tableCursor_1;
	TableColumn tblclmnPersonalQty;
	Text text;
	Text text_1;
	
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

		table_1 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setBounds(196, 21, 653, 505);
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);

		TableColumn tblclmnItems = new TableColumn(table_1, SWT.NONE);
		tblclmnItems.setWidth(394);
		tblclmnItems.setText("Item");

		TableColumn tblclmnPrice = new TableColumn(table_1, SWT.NONE);
		tblclmnPrice.setWidth(79);
		tblclmnPrice.setText("Price");

		tblclmnPersonalQty = new TableColumn(table_1, SWT.NONE);
		tblclmnPersonalQty.setWidth(97);
		tblclmnPersonalQty.setText("Personal Qty");

		tblclmnNewColumn = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn.setWidth(79);
		tblclmnNewColumn.setText("Market Qty");

		tableCursor_1 = new TableCursor(table_1, SWT.NONE);
		
		Button btnBuy = new Button(shell, SWT.NONE);
		btnBuy.setBounds(348, 554, 75, 25);
		btnBuy.setText("Buy");

		Button btnSell = new Button(shell, SWT.NONE);
		btnSell.setBounds(630, 554, 75, 25);
		btnSell.setText("Sell");

		text = new Text(shell, SWT.BORDER);
		text.setText("Enter Qty");
		text.setBounds(266, 558, 76, 21);

		text_1 = new Text(shell, SWT.BORDER);
		text_1.setText("Enter Qty");
		text_1.setBounds(548, 558, 76, 21);
	}
}
