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
    public TableItem waterItem;
    public TableItem furItem;
    public TableItem foodItem;
    public TableItem oreItem;
    public TableItem firearmsItem;
    public TableItem medicineItem;
    public TableItem machinesItem;
    public TableItem narcoticsItem;
    public TableItem robotsItem;

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

    /**
     * Shell s
     * @param s
     */
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
    
    /**
     * Blank Market set up with prices and quantities to be filled
     */
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
	
		String[] water = { "", "", "", "" };
		waterItem.setText(water);
	
		String[] fur = { "", "", "", "" };
		furItem.setText(fur);
	
		String[] food = { "", "", "", "" };
		foodItem.setText(food);
	
		String[] ore = { "", "", "", "" };
		oreItem.setText(ore);
	
		String[] firearms = { "", "", "", "" };
		firearmsItem.setText(firearms);
	
		String[] medicine = { "", "", "", "" };
		medicineItem.setText(medicine);
	
		String[] machines = { "", "", "", "" };
		machinesItem.setText(machines);
	
		String[] narcotics = { "", "", "", "" };
		narcoticsItem.setText(narcotics);
	
		String[] robots = { "", "", "", "" };
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
