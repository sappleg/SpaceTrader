package edu.gatech.statusquo.spacetrader.presenter;

import java.util.HashMap;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Shell;

import edu.gatech.statusquo.spacetrader.driver.*;
import edu.gatech.statusquo.spacetrader.model.*;
import edu.gatech.statusquo.spacetrader.model.Good.GoodType;
import edu.gatech.statusquo.spacetrader.view.*;
import edu.gatech.statusquo.spacetrader.presenter.VitalsPresenter;

public class TradeGoodsPresenter {
	Shell shell;
	Driver driver;
	TradeGoodsView tradeGoodsView;
	VitalsView vitalsView;
	Player player;
	SolarSystem solarSystem;
	Ship ship;
	HashMap<GoodType, Integer> marketQuantity;
	HashMap<GoodType, Integer> marketPrice;

	public TradeGoodsPresenter(Shell s, Driver d, TradeGoodsView tgv, Player p, SolarSystem ss, VitalsView vv) {
		this.shell = s;
		this.driver = d;
		this.tradeGoodsView = tgv;
		this.vitalsView = vv;
		this.player = p;
		this.solarSystem = ss;
		ship = player.getShip();
		marketQuantity = solarSystem.getMarketQuantity();
		marketPrice = solarSystem.getMarketPrice();
		
		setListeners();
		fillTradeGoodsTable();
	}
	
	private void setListeners() {
		tradeGoodsView.btnBuy.addMouseListener(new MouseAdapter() {
			public void mouseUp(MouseEvent e) {
				String quantText = tradeGoodsView.text.getText();
				if (quantText.equals("") || quantText.equals("Enter Qty")) {
					NotificationsView.list_1.add("Please enter an amount in the text box");
					return;
				}
				int quant = Integer.parseInt(quantText);
				if (tradeGoodsView.table_1.getSelection().length == 0) {
					NotificationsView.list_1.add("Please select an item from the market");
					return;
				} else {
//					int price = Integer.parseInt(tradeGoodsView.table_1.getSelection()[0].getText(1));
					GoodType goodType = GoodType.valueOf(tradeGoodsView.table_1.getSelection()[0].getText(0));
					int price = marketPrice.get(goodType);
					int marketCount = marketQuantity.get(goodType);
					int cargoCountLeft = ship.countCargoLeft();
				    if(Player.getCurrency() < quant * price){
						NotificationsView.list_1.add("Sorry, you do not have enough currency to make this purchase");
						NotificationsView.list_1.select(NotificationsView.list_1.getItemCount() - 1);
						NotificationsView.list_1.showSelection();
						return;
				    } else if(quant > marketCount) {
						NotificationsView.list_1.add("Sorry, there is not enough of this item in the market.");
						NotificationsView.list_1.select(NotificationsView.list_1.getItemCount() - 1);
						NotificationsView.list_1.showSelection();
						return;
				    } else if(quant > cargoCountLeft){
						NotificationsView.list_1.add("Sorry, you do not have enough space in your cargo bay.");
						NotificationsView.list_1.select(NotificationsView.list_1.getItemCount() - 1);
						NotificationsView.list_1.showSelection();
						return;
				    } else {
				    	ship.addCargo(quant, goodType);
				    	player.setCurrency(Player.getCurrency() - (quant*price));
				    	VitalsPresenter.setPlayerVitals();
				    	VitalsPresenter.setShipVitals();
				    }
				}
			}
		});

		// CURRENTLY CODE FOR BUY, WRITE FOR SELL
		tradeGoodsView.btnSell.addMouseListener(new MouseAdapter() {
			public void mouseUp(MouseEvent e) {
				String quantText = tradeGoodsView.text_1.getText();
				if (quantText.equals("") || quantText.equals("Enter Qty")) {
					NotificationsView.list_1.add("Please enter an amount in the text box");
					return;
				}
				int quant = Integer.parseInt(quantText);
				if (tradeGoodsView.table_1.getSelection().length == 0) {
					NotificationsView.list_1.add("Please select an item from the market");
					return;
				} else {
//					int price = Integer.parseInt(tradeGoodsView.table_1.getSelection()[0].getText(1));
					GoodType goodType = GoodType.valueOf(tradeGoodsView.table_1.getSelection()[0].getText(0));
					int price = marketPrice.get(goodType);
					int cargoCount = ship.countCargo(goodType);
				    if (quant > cargoCount){
				    	String msg = "Sorry, you do not have enough " 
				    			+ tradeGoodsView.table_1.getSelection()[0].getText(0)
				    			+ " items in your cargo bay to sell";
						NotificationsView.list_1.add(msg);
						NotificationsView.list_1.select(NotificationsView.list_1.getItemCount() - 1);
						NotificationsView.list_1.showSelection();
						return;
				    } else {
				    	ship.removeCargo(quant, goodType);
				    	player.setCurrency(Player.getCurrency() + (quant*price));
				    	VitalsPresenter.setPlayerVitals();
				    	VitalsPresenter.setShipVitals();
				    }
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
	
	private void fillTradeGoodsTable() {
		HashMap<GoodType, Integer> marketPrice = solarSystem.getMarketPrice();
		HashMap<GoodType, Integer> marketQuantity = solarSystem.getMarketQuantity();
		String[] water = {"WATER", Integer.toString(marketPrice.get(GoodType.WATER)), Integer.toString(marketQuantity.get(GoodType.WATER)), "N/A"};
		tradeGoodsView.waterItem.setText(water);
		String[] fur = {"FUR", Integer.toString(marketPrice.get(GoodType.FUR)), Integer.toString(marketQuantity.get(GoodType.FUR)), "N/A"};
		tradeGoodsView.furItem.setText(fur);
		String[] food = {"FOOD", Integer.toString(marketPrice.get(GoodType.FOOD)), Integer.toString(marketQuantity.get(GoodType.FOOD)), "N/A"};
		tradeGoodsView.foodItem.setText(food);
		String[] ore = {"ORE", Integer.toString(marketPrice.get(GoodType.ORE)), Integer.toString(marketQuantity.get(GoodType.ORE)), "N/A"};
		tradeGoodsView.oreItem.setText(ore);
		String[] firearms = {"FIREARM", Integer.toString(marketPrice.get(GoodType.FIREARM)), Integer.toString(marketQuantity.get(GoodType.FIREARM)), "N/A"};
		tradeGoodsView.firearmsItem.setText(firearms);
		String[] medicine = {"MEDICINE", Integer.toString(marketPrice.get(GoodType.MEDICINE)), Integer.toString(marketQuantity.get(GoodType.MEDICINE)), "N/A"};
		tradeGoodsView.medicineItem.setText(medicine);
		String[] machines = {"MACHINE", Integer.toString(marketPrice.get(GoodType.MACHINE)), Integer.toString(marketQuantity.get(GoodType.MACHINE)), "N/A"};
		tradeGoodsView.machinesItem.setText(machines);
		String[] narcotics = {"NARCOTIC", Integer.toString(marketPrice.get(GoodType.NARCOTIC)), Integer.toString(marketQuantity.get(GoodType.NARCOTIC)), "N/A"};
		tradeGoodsView.narcoticsItem.setText(narcotics);
		String[] robots = {"ROBOT", Integer.toString(marketPrice.get(GoodType.ROBOT)), Integer.toString(marketQuantity.get(GoodType.ROBOT)), "N/A"};
		tradeGoodsView.robotsItem.setText(robots);
	}
}
