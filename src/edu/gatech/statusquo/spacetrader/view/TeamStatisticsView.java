package edu.gatech.statusquo.spacetrader.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import edu.gatech.statusquo.spacetrader.model.*;

public class TeamStatisticsView {
    Player player;
    Shell shell;
    Table table;
    TableColumn tblclmnAttribute_1;
    TableColumn tblclmnPoints;
    TableItem tableItem_1;
    TableItem tableItem_2;
    TableItem tableItem_3;
    TableItem tableItem_4;

    /**
     * Shell s Player p
     * 
     * @param s
     * @param p
     */
    public TeamStatisticsView(Shell s, Player p) {
        this.shell = s;
        this.player = p;
        table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
        tblclmnAttribute_1 = new TableColumn(table, SWT.NONE);
        tblclmnPoints = new TableColumn(table, SWT.NONE);
        tableItem_1 = new TableItem(table, SWT.NONE);
        tableItem_2 = new TableItem(table, SWT.NONE);
        tableItem_3 = new TableItem(table, SWT.NONE);
        tableItem_4 = new TableItem(table, SWT.NONE);

        try {
            createView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates the contents of the team statistics view
     */
    public void createView() {
        Label lblTeamStatistics = new Label(shell, SWT.NONE);
        lblTeamStatistics.setBounds(53, 231, 94, 15);
        lblTeamStatistics.setText("Team Statistics");

        table.setBounds(0, 252, 190, 165);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        tblclmnAttribute_1.setWidth(85);
        tblclmnAttribute_1.setText("Attribute");

        tblclmnPoints.setWidth(100);
        tblclmnPoints.setText("Points");

        String[] traderArray = { "Trader",
                Integer.toString(Player.getTraderSkills()) };
        tableItem_1.setText(traderArray);

        String[] engineerArray = { "Engineer",
                Integer.toString(Player.getEngineerSkills()) };
        tableItem_2.setText(engineerArray);

        String[] pilotArray = { "Pilot",
                Integer.toString(Player.getPilotSkills()) };
        tableItem_3.setText(pilotArray);

        String[] fighterArray = { "Fighter",
                Integer.toString(Player.getFighterSkills()) };
        tableItem_4.setText(fighterArray);
    }
}
