package edu.gatech.statusquo.spacetrader.presenter;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Shell;

import edu.gatech.statusquo.spacetrader.driver.*;
import edu.gatech.statusquo.spacetrader.model.Player;
import edu.gatech.statusquo.spacetrader.view.*;

public class TradeGoodsPresenter {
	Shell shell;
	Driver driver;
	TradeGoodsView tradeGoodsView;
	Player player;

	public TradeGoodsPresenter(Shell s, Driver d, TradeGoodsView tgv, Player p) {
		this.shell = s;
		this.driver = d;
		this.tradeGoodsView = tgv;
		this.player = p;
		
		setListeners();
	}
	
	private void setListeners() {
		tradeGoodsView.btnBuy.addMouseListener(new MouseAdapter() {
			public void mouseUp(MouseEvent e) {
				int quant = Integer.parseInt(tradeGoodsView.text.getText());
				if (tradeGoodsView.table_1.getSelection().length == 0) {
					NotificationsView.list_1.add("Please select an item from the market");
					return;
				}
				int price = Integer.parseInt(tradeGoodsView.table_1.getSelection()[0].getText(1));
				int mQuant = Integer.parseInt(tradeGoodsView.table_1.getSelection()[0].getText(3));
			    if(Player.getCurrency() < quant * price)
			    {
					NotificationsView.list_1.add("Sorry, you do not have enough currency to make this purchase");
					NotificationsView.list_1.select(NotificationsView.list_1.getItemCount() - 1);
					NotificationsView.list_1.showSelection();
			    }
			    else if(quant > mQuant)
			    {
					NotificationsView.list_1.add("Sorry, there is not enough of this item in the market.");
					NotificationsView.list_1.select(NotificationsView.list_1.getItemCount() - 1);
					NotificationsView.list_1.showSelection();
			    }
			}
		});

		// CURRENTLY CODE FOR BUY, WRITE FOR SELL
		tradeGoodsView.btnSell.addMouseListener(new MouseAdapter() {
			public void mouseUp(MouseEvent e) {
				int quant = Integer.parseInt(tradeGoodsView.text.getText());
				if (tradeGoodsView.table_1.getSelection().length == 0) {
					NotificationsView.list_1.add("Please select an item from the market");
					return;
				}
				int price = Integer.parseInt(tradeGoodsView.table_1.getSelection()[0].getText(1));
				int mQuant = Integer.parseInt(tradeGoodsView.table_1.getSelection()[0].getText(3));
			    if(Player.getCurrency() < quant * price)
			    {
					NotificationsView.list_1.add("Sorry, you do not have enough currency to make this purchase");
					NotificationsView.list_1.select(NotificationsView.list_1.getItemCount() - 1);
					NotificationsView.list_1.showSelection();
			    }
			    else if(quant > mQuant)
			    {
					NotificationsView.list_1.add("Sorry, there is not enough of this item in the market.");
					NotificationsView.list_1.select(NotificationsView.list_1.getItemCount() - 1);
					NotificationsView.list_1.showSelection();
			    }
			}
		});

		tradeGoodsView.text.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseDown(MouseEvent e) {
		    	tradeGoodsView.text.setText("");
		    }
		});

		tradeGoodsView.text_1.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseDown(MouseEvent e) {
		    	tradeGoodsView.text_1.setText("");
		    }
		});
	}
}
