package edu.gatech.statusquo.spacetrader.view;

import javax.swing.JOptionPane;
import java.awt.*;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import com.ibm.icu.util.Currency;

import edu.gatech.statusquo.spacetrader.model.Player;

public class TradeGoodsView {
    Shell shell;
    Table table_1;
    TableItem waterItem;
    TableItem furItem;
    TableItem foodItem;
    TableItem oreItem;
    TableItem firearmsItem;
    TableItem medicineItem;
    TableItem machinesItem;
    TableItem narcoticsItem;
    TableItem robotsItem;

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

	waterItem = new TableItem(table_1, SWT.NONE);
	furItem = new TableItem(table_1, SWT.NONE);
	foodItem = new TableItem(table_1, SWT.NONE);
	oreItem = new TableItem(table_1, SWT.NONE);
	firearmsItem = new TableItem(table_1, SWT.NONE);
	medicineItem = new TableItem(table_1, SWT.NONE);
	;
	machinesItem = new TableItem(table_1, SWT.NONE);
	narcoticsItem = new TableItem(table_1, SWT.NONE);
	robotsItem = new TableItem(table_1, SWT.NONE);

	String[] water = { "Water", "1", "2", "3" };
	waterItem.setText(water);

	String[] fur = { "Fur", "1", "2", "3" };
	furItem.setText(fur);

	String[] food = { "Food", "1", "2", "3" };
	foodItem.setText(food);

	String[] ore = { "Ore", "1", "2", "3" };
	oreItem.setText(ore);

	String[] firearms = { "Firearms", "1", "2", "3" };
	firearmsItem.setText(firearms);

	String[] medicine = { "Medicine", "1", "2", "3" };
	medicineItem.setText(medicine);

	String[] machines = { "Machines", "1", "2", "3" };
	machinesItem.setText(machines);

	String[] narcotics = { "Narcotics", "1", "2", "3" };
	narcoticsItem.setText(narcotics);

	String[] robots = { "Robots", "1", "2", "3" };
	robotsItem.setText(robots);

	tableCursor_1 = new TableCursor(table_1, SWT.NONE);

	Button btnBuy = new Button(shell, SWT.NONE);
	btnBuy.setBounds(348, 554, 75, 25);
	btnBuy.setText("Buy");
	btnBuy.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseUp(MouseEvent e) {
		    if(Player.getCurrency() < (Integer.parseInt(text.getText()) * Integer.parseInt(table_1.getSelection()[0].getText(1))))
		    {
			NotificationsView.list_1.add("Sorry, you do not have enough currency to make this purchase");
			NotificationsView.list_1.select(NotificationsView.list_1.getItemCount() - 1);
			NotificationsView.list_1.showSelection();
		    }
		    else if((Integer.parseInt(text.getText()) > Integer.parseInt(table_1.getSelection()[0].getText(3))))
		    {
			NotificationsView.list_1.add("Sorry, there is not enough of this item in the market.");
			NotificationsView.list_1.select(NotificationsView.list_1.getItemCount() - 1);
			NotificationsView.list_1.showSelection();
		    }
		}
	});

	Button btnSell = new Button(shell, SWT.NONE);
	btnSell.setBounds(630, 554, 75, 25);
	btnSell.setText("Sell");

	text = new Text(shell, SWT.BORDER);
	text.setText("Enter Qty");
	text.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseDown(MouseEvent e) {
		text.setText("");
	    }
	});
	text.setBounds(266, 558, 76, 21);

	text_1 = new Text(shell, SWT.BORDER);
	text_1.setText("Enter Qty");
	text_1.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseDown(MouseEvent e) {
		text_1.setText("");
	    }
	});
	text_1.setBounds(548, 558, 76, 21);
    }
}
