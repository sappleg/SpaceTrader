package edu.gatech.statusquo.spacetrader.view;

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

public class TradeGoodsView {
    Shell shell;
    public Table table_1;
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
    TableColumn tblclmnMarketQuantity;
    TableCursor tableCursor_1;
    TableColumn tblclmnPersonalQty;
    public Text text;
    public Text text_1;
    
    Label label;
    
    public Button btnBuy;
    public Button btnSell;

    public TradeGoodsView(Shell s) {
		this.shell = s;
		table_1 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		tblclmnItems = new TableColumn(table_1, SWT.NONE);
		tblclmnPrice = new TableColumn(table_1, SWT.NONE);
		tblclmnMarketQuantity = new TableColumn(table_1, SWT.NONE);
		tblclmnPersonalQty = new TableColumn(table_1, SWT.NONE);
		tableCursor_1 = new TableCursor(table_1, SWT.NONE);
		label = new Label(shell, SWT.NONE);

		text = new Text(shell, SWT.BORDER);
		text_1 = new Text(shell, SWT.BORDER);

		waterItem = new TableItem(table_1, SWT.NONE);
		furItem = new TableItem(table_1, SWT.NONE);
		foodItem = new TableItem(table_1, SWT.NONE);
		oreItem = new TableItem(table_1, SWT.NONE);
		firearmsItem = new TableItem(table_1, SWT.NONE);
		medicineItem = new TableItem(table_1, SWT.NONE);
		machinesItem = new TableItem(table_1, SWT.NONE);
		narcoticsItem = new TableItem(table_1, SWT.NONE);
		robotsItem = new TableItem(table_1, SWT.NONE);
		
		btnBuy = new Button(shell, SWT.NONE);
		btnSell = new Button(shell, SWT.NONE);
	
		try {
		    createView();
		} catch (Exception e) {
		    e.printStackTrace();
		}
    }

    public void createView() {
		label.setAlignment(SWT.CENTER);
		label.setText("Trade Goods");
		label.setBounds(485, 0, 77, 15);
	
		table_1.setBounds(196, 21, 653, 505);
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);
	
		tblclmnItems.setWidth(394);
		tblclmnItems.setText("Item");
	
		tblclmnPrice.setWidth(79);
		tblclmnPrice.setText("Price");
	
		tblclmnPersonalQty.setWidth(97);
		tblclmnPersonalQty.setText("Personal Qty");
	
		tblclmnMarketQuantity.setWidth(79);
		tblclmnMarketQuantity.setText("Market Qty");
	
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
	
		btnBuy.setBounds(348, 554, 75, 25);
		btnBuy.setText("Buy");
	
		btnSell.setBounds(630, 554, 75, 25);
		btnSell.setText("Sell");
	
		text.setText("Enter Qty");
		text.setBounds(266, 558, 76, 21);
	
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
