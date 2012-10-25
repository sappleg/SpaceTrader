package edu.gatech.statusquo.spacetrader.presenter;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;

import edu.gatech.statusquo.spacetrader.driver.*;
import edu.gatech.statusquo.spacetrader.model.Good;
import edu.gatech.statusquo.spacetrader.model.Player;
import edu.gatech.statusquo.spacetrader.model.Ship;
import edu.gatech.statusquo.spacetrader.view.*;

public class VitalsPresenter {
	Shell shell;
	Driver driver;
	VitalsView vitalsView;
	Player player;
	Ship ship;

	public VitalsPresenter(Shell s, Driver d, VitalsView vv, Player p) {
		this.shell = s;
		this.driver = d;
		this.vitalsView = vv;
		this.player = p;
		ship = player.getShip();
		
		setPlayerVitals();
		setShipVitals();
	}
	
	public void setPlayerVitals() {
		player.getShip();
		String[] playerState = {Integer.toString(Player.getCurrency()), Integer.toString(Ship.getFuelLevel())};
		vitalsView.tableItem.setText(playerState);
	}
	
	public void setShipVitals() {
		Good[] cargoBay = ship.getCargoBay();
		for (int i = 0; i < cargoBay.length; i++) {
			if (cargoBay[i] != null) {
				Good g = cargoBay[i];
				String cargo = g.toString();
				new TableItem(vitalsView.table_3, SWT.NONE).setText(cargo);
			}
		}
	}
}
