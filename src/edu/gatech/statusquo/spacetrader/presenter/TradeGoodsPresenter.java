package edu.gatech.statusquo.spacetrader.presenter;

import org.eclipse.swt.widgets.Shell;

import edu.gatech.statusquo.spacetrader.driver.*;
import edu.gatech.statusquo.spacetrader.view.*;

public class TradeGoodsPresenter {
	Shell shell;
	Driver driver;
	TradeGoodsView tradeGoodsView;

	public TradeGoodsPresenter(Shell s, Driver d, TradeGoodsView tgv) {
		this.shell = s;
		this.driver = d;
		this.tradeGoodsView = tgv;
	}
}
