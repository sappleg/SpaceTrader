package edu.gatech.statusquo.spacetrader.driver;

import edu.gatech.statusquo.spacetrader.model.*;
import edu.gatech.statusquo.spacetrader.model.Good.GoodType;
import edu.gatech.statusquo.spacetrader.presenter.*;
import edu.gatech.statusquo.spacetrader.view.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * DRIVER CLASS FOR GAME
 * 
 * @author Vraj Patel, Spencer AppleGate, Derrek Keyser
 * @version 13.37
 */
public class Driver {

    /** Main Player */
    public static Player Player;

    /** Game Display */
    public Display display;

    /** Game Shell */
    public Shell shell;

    /** Contains randomly generated X coordinates */
    public static ArrayList<Integer> PositionX;

    /** Contains randomly generated Y coordinates */
    public static ArrayList<Integer> PositionY;

    /** Contains randomly selected names */
    public static ArrayList<String> ListOfNames;

    /** shipStatisticsView for game screen */
    public ShipStatisticsView shipStatisticsView;

    /** teamStatisticsView for game screen */
    public TeamStatisticsView teamStatisticsView;

    /** solarSystemStatsView for game screen */
    public SolarSystemStatsView solarSystemStatsView;

    /** tradeGoodsView for game screen */
    public TradeGoodsView tradeGoodsView;

    /** notificationsView for game screen */
    public NotificationsView notificationsView;

    /** vitalsView for game screen */
    public VitalsView vitalsView;

    /** localPlanetView for game screen */
    public LocalPlanetView localPlanetView;

    /** menuView for game screen */
    public MenuView menuView;

    /** currentSystem the player is located */
    public static SolarSystem CurrentSystem;

    /** contains basePrices of goods */
    private static HashMap<GoodType, Integer> BasePrice;

    /** contains baseQuantites of goods */
    private static HashMap<GoodType, Integer> BaseQty;

    /** value used to increase or decrease base prices */
    private static final double PRICEPERCENT = .25;

    /** value used to increase or decrease base quantities */
    private static final double QTYPERCENT = .50;

    /** Contains list of all system names */
    public static ArrayList<SolarSystem> ListOfSystems;

    /** Contains base price for water */
    private static final int WATERBASEPRICE = 30;

    /** Contains base price for fur */
    private static final int FURBASEPRICE = 250;

    /** Contains base price for food */
    private static final int FOODBASEPRICE = 100;

    /** Contains base price for ore */
    private static final int OREBASEPRICE = 350;

    /** Contains base price for firearm */
    private static final int FIREARMBASEPRICE = 1200;

    /** Contains base price for medicine */
    private static final int MEDICINEBASEPRICE = 650;

    /** Contains base price for machine */
    private static final int MACHINEBASEPRICE = 900;

    /** Contains base price for narcotic */
    private static final int NARCOTICBASEPRICE = 3500;

    /** Contains base price for robot */
    private static final int ROBOTBASEPRICE = 5000;

    /** Contains base quantity for water */
    private static final int WATERBASEQUANTITY = 25;

    /** Contains base quantity for fur */
    private static final int FURBASEQUANTITY = 10;

    /** Contains base quantity for food */
    private static final int FOODBASEQUANTITY = 20;

    /** Contains base quantity for ore */
    private static final int OREBASEQUANTITY = 20;

    /** Contains base quantity for firearms */
    private static final int FIREARMBASEQUANTITY = 5;

    /** Contains base quantity for medicine */
    private static final int MEDICINEBASEQUANTITY = 15;

    /** Contains base quantity for machine */
    private static final int MACHINEBASEQUANTITY = 10;

    /** Contains base quantity for narcotic */
    private static final int NARCOTICBASEQUANTITY = 5;

    /** Contains base quantity for robot */
    private static final int ROBOTBASEQUANTITY = 5;

    /** shell width */
    private static final int SHELLWIDTH = 1024;

    /** shell height */
    private static final int SHELLHEIGHT = 768;

    /** tech level offset */
    private static final int TECHLEVELOFFSET = 7;

    /** resource level offset */
    private static final int RESOURCELEVELOFFSET = 11;

    /** number of coordinates */
    private static final int NUMCOORDINATES = 150;

    /** coordinate offset */
    private static final int COORDINATEOFFSET = 201;

    /** square exponent */
    private static final int SQUAREEXPONENT = 2;

    /** mimimum distance a planet must be to be considered close */
    private static final int MINIMUMPLANETDISTANCE = 9;

    /**
     * Driver's constructor
     * 
     * @throws IOException
     */
    public Driver() {

        CurrentSystem = new SolarSystem();

        // fill in base prices
        BasePrice = new HashMap<GoodType, Integer>();
        BasePrice.put(GoodType.WATER, WATERBASEPRICE);
        BasePrice.put(GoodType.FUR, FURBASEPRICE);
        BasePrice.put(GoodType.FOOD, FOODBASEPRICE);
        BasePrice.put(GoodType.ORE, OREBASEPRICE);
        BasePrice.put(GoodType.FIREARM, FIREARMBASEPRICE);
        BasePrice.put(GoodType.MEDICINE, MEDICINEBASEPRICE);
        BasePrice.put(GoodType.MACHINE, MACHINEBASEPRICE);
        BasePrice.put(GoodType.NARCOTIC, NARCOTICBASEPRICE);
        BasePrice.put(GoodType.ROBOT, ROBOTBASEPRICE);

        // fill in base quantity
        BaseQty = new HashMap<GoodType, Integer>();
        BaseQty.put(GoodType.WATER, WATERBASEQUANTITY);
        BaseQty.put(GoodType.FUR, FURBASEQUANTITY);
        BaseQty.put(GoodType.FOOD, FOODBASEQUANTITY);
        BaseQty.put(GoodType.ORE, OREBASEQUANTITY);
        BaseQty.put(GoodType.FIREARM, FIREARMBASEQUANTITY);
        BaseQty.put(GoodType.MEDICINE, MEDICINEBASEQUANTITY);
        BaseQty.put(GoodType.MACHINE, MACHINEBASEQUANTITY);
        BaseQty.put(GoodType.NARCOTIC, NARCOTICBASEQUANTITY);
        BaseQty.put(GoodType.ROBOT, ROBOTBASEQUANTITY);

        // represents a list of solar systems
        ListOfSystems = new ArrayList<SolarSystem>();
        final WelcomeView welcomeView = new WelcomeView();
        new WelcomePresenter(this, welcomeView);

    }

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        new Driver();
    }

    /**
     * Generates player's view
     */
    public void generateCreatePlayer() {
        final CreatePlayerView createPlayerView = new CreatePlayerView();
        new CreatePlayerPresenter(createPlayerView, Player);
    }

    /**
     * Generates main game view
     */
    public void generateMainGame() {
        display = Display.getDefault();
        shell = new Shell(display, SWT.TITLE | SWT.CLOSE);

        shell.setSize(SHELLWIDTH, SHELLHEIGHT);
        shell.setText("Space Trader");
        shell.setLayout(null);

        // instantiate views
        shipStatisticsView = new ShipStatisticsView(shell);
        teamStatisticsView = new TeamStatisticsView(shell, Player);
        solarSystemStatsView = new SolarSystemStatsView(shell);
        tradeGoodsView = new TradeGoodsView(shell);
        notificationsView = new NotificationsView(shell, Player);
        vitalsView = new VitalsView(shell, Player);
        localPlanetView = new LocalPlanetView(shell);
        menuView = new MenuView(shell);

        // instantiate Presenters
        new ShipStatisticsPresenter(shell, this, shipStatisticsView);
        new TeamStatisticsPresenter(shell, this, teamStatisticsView);
        new SolarSystemStatsPresenter(shell, this, solarSystemStatsView);
        new TradeGoodsPresenter(shell, this, tradeGoodsView, Player,
                ListOfSystems.get(0), vitalsView);
        new NotificationsPresenter(shell, this, notificationsView);
        new VitalsPresenter(shell, this, vitalsView, Player, tradeGoodsView);
        new LocalPlanetPresenter(shell, this, localPlanetView);
        new MenuPresenter(shell, display, this, menuView);

        shell.open();
        shell.layout();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    /**
     * Creates the universe that the game will be played in.
     * 
     * @throws IOException
     */
    public static void generateUniverse() {

        generateCoordinates();
        generateNames();

        // copies global variables into local
        final ArrayList<Integer> xList = PositionX;
        final ArrayList<Integer> yList = PositionY;
        final ArrayList<String> namesList = ListOfNames;
        /*
         * ArrayList<SolarSystem> systemsList = new ArrayList<SolarSystem>();
         */
        // Generates a SolarSystem object using the generated.
        // coordinates and names.
        for (int i = 0; i < namesList.size(); i++) {
            int techLevel = (int) (Math.random() * TECHLEVELOFFSET);
            int resourceLevel = (int) (Math.random() * RESOURCELEVELOFFSET);
            String holdName = namesList.get(i);
            int holdX = xList.get(i);
            int holdY = yList.get(i);
            Planet planetName = new Planet(holdName);
            SolarSystem system = new SolarSystem(holdName, planetName,
                    techLevel, resourceLevel, holdX, holdY);
            generateMarket(system);
            ListOfSystems.add(system);
            // **TEMP PRINTS TO CONSOLE**
            // SolarSystem printThis = listOfSystems.get(i);
            // System.out.println(printThis.toString() + "\n");
        }
    }

    /**
     * Generates a market stated by the game rules An empty market is
     * manipulated to match the SolarSystems technology and resource levels.
     * 
     * @param s
     */

    public static void generateMarket(SolarSystem s) {
        int techLvl = s.getTechLevel();
        int resLvl = s.getResourceLevel();
        HashMap<GoodType, Integer> mPrices = s.getMarketPrice();
        HashMap<GoodType, Integer> mQtys = s.getMarketQuantity();

        // Setting market quantity
        // **Needs to be proof read to see if variables and quantities are
        // matching**
        switch (techLvl) {
        case 0:
            // if tech level is 0, only resources avilable are water and fur
            // baseQtys set in constructor
            mQtys.put(GoodType.WATER, BaseQty.get(GoodType.WATER));
            // new quantity is a 50% increase
            int newFurQty = (int) ((BaseQty.get(GoodType.FUR)) + ((BaseQty
                    .get(GoodType.FUR)) * QTYPERCENT));
            mQtys.put(GoodType.FUR, newFurQty);
            // Rest are initialized to be 0, so no other changes.
            break;
        case 1:
            mQtys.put(GoodType.WATER, BaseQty.get(GoodType.WATER));
            mQtys.put(GoodType.FUR, BaseQty.get(GoodType.FUR));
            int newFoodQty = (int) ((BaseQty.get(GoodType.FOOD)) + ((BaseQty
                    .get(GoodType.FOOD)) * QTYPERCENT));
            mQtys.put(GoodType.FOOD, newFoodQty);
            break;
        case 2:
            int newWaterQty = (int) ((BaseQty.get(GoodType.WATER)) + ((BaseQty
                    .get(GoodType.WATER)) * QTYPERCENT));
            mQtys.put(GoodType.WATER, newWaterQty);
            mQtys.put(GoodType.FUR, BaseQty.get(GoodType.FUR));
            mQtys.put(GoodType.FOOD, BaseQty.get(GoodType.FOOD));
            mQtys.put(GoodType.ORE, BaseQty.get(GoodType.ORE));
            break;
        case 3:
            mQtys.put(GoodType.WATER, BaseQty.get(GoodType.WATER));
            mQtys.put(GoodType.FUR, BaseQty.get(GoodType.FUR));
            mQtys.put(GoodType.FOOD, BaseQty.get(GoodType.FOOD));
            int newOreQty = (int) ((BaseQty.get(GoodType.ORE)) + ((BaseQty
                    .get(GoodType.ORE)) * QTYPERCENT));
            mQtys.put(GoodType.ORE, newOreQty);
            mQtys.put(GoodType.FIREARM, BaseQty.get(GoodType.FIREARM));
            break;
        case 4:
            mQtys.put(GoodType.WATER, BaseQty.get(GoodType.WATER));
            mQtys.put(GoodType.FUR, BaseQty.get(GoodType.FUR));
            mQtys.put(GoodType.FOOD, BaseQty.get(GoodType.FOOD));
            mQtys.put(GoodType.ORE, BaseQty.get(GoodType.ORE));
            mQtys.put(GoodType.FIREARM, BaseQty.get(GoodType.FIREARM));
            mQtys.put(GoodType.MEDICINE, BaseQty.get(GoodType.MEDICINE));
            mQtys.put(GoodType.MACHINE, BaseQty.get(GoodType.MACHINE));
            break;
        case 5:
            mQtys.put(GoodType.WATER, BaseQty.get(GoodType.WATER));
            mQtys.put(GoodType.FUR, BaseQty.get(GoodType.FUR));
            mQtys.put(GoodType.FOOD, BaseQty.get(GoodType.FOOD));
            mQtys.put(GoodType.ORE, BaseQty.get(GoodType.ORE));
            int newFireQty = (int) ((BaseQty.get(GoodType.FIREARM)) + ((BaseQty
                    .get(GoodType.FIREARM)) * QTYPERCENT));
            mQtys.put(GoodType.FIREARM, newFireQty);
            mQtys.put(GoodType.MEDICINE, BaseQty.get(GoodType.MEDICINE));
            int newMachQty = (int) ((BaseQty.get(GoodType.MACHINE)) + ((BaseQty
                    .get(GoodType.MACHINE)) * QTYPERCENT));
            mQtys.put(GoodType.MACHINE, newMachQty);
            int newNarcQty = (int) ((BaseQty.get(GoodType.NARCOTIC)) + ((BaseQty
                    .get(GoodType.NARCOTIC)) * QTYPERCENT));
            mQtys.put(GoodType.NARCOTIC, newNarcQty);
            break;
        case 6:
            mQtys.put(GoodType.WATER, BaseQty.get(GoodType.WATER));
            mQtys.put(GoodType.FUR, BaseQty.get(GoodType.FUR));
            mQtys.put(GoodType.FOOD, BaseQty.get(GoodType.FOOD));
            mQtys.put(GoodType.ORE, BaseQty.get(GoodType.ORE));
            mQtys.put(GoodType.FIREARM, BaseQty.get(GoodType.FIREARM));
            int newMedQty = (int) ((BaseQty.get(GoodType.MEDICINE)) + ((BaseQty
                    .get(GoodType.MEDICINE)) * QTYPERCENT));
            mQtys.put(GoodType.MEDICINE, newMedQty);
            mQtys.put(GoodType.MACHINE, BaseQty.get(GoodType.MACHINE));
            mQtys.put(GoodType.NARCOTIC, BaseQty.get(GoodType.NARCOTIC));
            mQtys.put(GoodType.ROBOT, BaseQty.get(GoodType.ROBOT));
            break;
        default:
            System.out.println("Something went wrong in the market generation");
            break;
        }

        // Sets prices of all goods to its basePrice.
        mPrices.put(GoodType.WATER, BasePrice.get(GoodType.WATER));
        mPrices.put(GoodType.FUR, BasePrice.get(GoodType.FUR));
        mPrices.put(GoodType.FOOD, BasePrice.get(GoodType.FOOD));
        mPrices.put(GoodType.ORE, BasePrice.get(GoodType.ORE));
        mPrices.put(GoodType.FIREARM, BasePrice.get(GoodType.FIREARM));
        mPrices.put(GoodType.MEDICINE, BasePrice.get(GoodType.MEDICINE));
        mPrices.put(GoodType.MACHINE, BasePrice.get(GoodType.MACHINE));
        mPrices.put(GoodType.NARCOTIC, BasePrice.get(GoodType.NARCOTIC));
        mPrices.put(GoodType.ROBOT, BasePrice.get(GoodType.ROBOT));

        // Respectively increases/decreases depending on generation rules
        // Generation rules are described in the "SpaceTrader: Game Information"
        switch (resLvl) {
        case 0:
            int lotsOfWater = (int) ((BasePrice.get(GoodType.WATER)) - ((BasePrice
                    .get(GoodType.WATER)) * PRICEPERCENT));
            mPrices.put(GoodType.WATER, lotsOfWater);
            break;
        case 1:
            int drought = (int) ((BasePrice.get(GoodType.WATER)) + ((BasePrice
                    .get(GoodType.WATER)) * PRICEPERCENT));
            mPrices.put(GoodType.WATER, drought);
            break;
        case 2:
            int richFauna = (int) ((BasePrice.get(GoodType.FUR)) - ((BasePrice
                    .get(GoodType.FUR)) * PRICEPERCENT));
            mPrices.put(GoodType.FUR, richFauna);
            break;
        case 3:
            int lifeless = (int) ((BasePrice.get(GoodType.FUR)) + ((BasePrice
                    .get(GoodType.FUR)) * PRICEPERCENT));
            mPrices.put(GoodType.FUR, lifeless);
            break;
        case 4:
            int richSoil = (int) ((BasePrice.get(GoodType.FOOD)) - ((BasePrice
                    .get(GoodType.FOOD)) * PRICEPERCENT));
            mPrices.put(GoodType.FOOD, richSoil);
            break;
        case 5:
            int poorSoil = (int) ((BasePrice.get(GoodType.FOOD)) + ((BasePrice
                    .get(GoodType.FOOD)) * PRICEPERCENT));
            mPrices.put(GoodType.FOOD, poorSoil);
            break;
        case 6:
            int mineralRich = (int) ((BasePrice.get(GoodType.ORE)) - ((BasePrice
                    .get(GoodType.ORE)) * PRICEPERCENT));
            mPrices.put(GoodType.ORE, mineralRich);
        case 7:
            int mineralPoor = (int) ((BasePrice.get(GoodType.ORE)) + ((BasePrice
                    .get(GoodType.ORE)) * PRICEPERCENT));
            mPrices.put(GoodType.ORE, mineralPoor);
            break;
        case 8:
            int warLike = (int) ((BasePrice.get(GoodType.FIREARM)) - ((BasePrice
                    .get(GoodType.FIREARM)) * PRICEPERCENT));
            mPrices.put(GoodType.FIREARM, warLike);
            break;
        case 9:
            int lotsOfHerbs = (int) ((BasePrice.get(GoodType.MEDICINE)) - ((BasePrice
                    .get(GoodType.MEDICINE)) * PRICEPERCENT));
            mPrices.put(GoodType.MEDICINE, lotsOfHerbs);
            break;
        case 10:
            int weirdMushrooms = (int) ((BasePrice.get(GoodType.NARCOTIC)) - ((BasePrice
                    .get(GoodType.NARCOTIC)) * PRICEPERCENT));
            mPrices.put(GoodType.NARCOTIC, weirdMushrooms);
            break;
        default:
            System.out.println("Something went wrong in the market generation");
            break;
        }

        s.setMarketPrice(mPrices);
        s.setMarketQuantity(mQtys);

    }

    /**
     * Creates list of usable X and Y coordinates for solar systems. That are at
     * least 10 units away from any other coordinate.
     */
    public static void generateCoordinates() {

        int amtOfCoordinates = NUMCOORDINATES; // Amount of coordinates to
                                               // generate
        ArrayList<Integer> holdX = new ArrayList<Integer>(); // List to hold X
                                                             // coordinates
        ArrayList<Integer> holdY = new ArrayList<Integer>(); // Lost to hold Y
                                                             // coordinates

        // will loop until proper amt of coordinates have been generated
        while (amtOfCoordinates > 0) {
            boolean goodCoords = false;
            // updates length of arraylist
            int arrayLength = holdX.size();

            // will loop until good coordinates have been found
            while (!goodCoords) {
                int trueCounter = 0;
                // randomly picks two integers for X and Y.
                int testX = (int) (Math.random() * COORDINATEOFFSET);
                int testY = (int) (Math.random() * COORDINATEOFFSET);
                /*
                 * Goes through current array to make sure randomly picked X and
                 * Y are at a distance of 10 or more then all other coordinates.
                 */
                for (int i = 0; i < arrayLength; i++) {
                    int tempX = holdX.get(i);
                    int tempY = holdY.get(i);

                    int distance = (int) ((Math.pow(tempX - testX,
                            SQUAREEXPONENT)) + (Math.pow(tempY - testY,
                            SQUAREEXPONENT)));
                    distance = (int) (Math.sqrt(distance));
                    /*
                     * The randomly picked numbers are >= to coordinates at
                     * index i then add to the trueCounter. Else break and
                     * generate new coordinates.
                     */
                    if (distance > MINIMUMPLANETDISTANCE) {
                        trueCounter++;
                    } else {
                        break;
                    }
                }
                if (trueCounter == arrayLength) {
                    holdX.add(testX);
                    holdY.add(testY);
                    goodCoords = true;
                }
            }
            amtOfCoordinates--;
        }
        PositionX = holdX;
        PositionY = holdY;
    }

    /**
     * Generates a list of 150 planet names from an existing text file.
     * 
     */

    public static void generateNames() {
        Scanner s = null;
        try {
            s = new Scanner(new File("PlanetNames.txt"));
            ArrayList<String> planetNames = new ArrayList<String>();
            // pulls all possible system names from file and puts them into
            // ArrayList
            while (s.hasNextLine()) {
                String temp = s.nextLine();
                planetNames.add(temp);
            }
            ArrayList<String> chosenNames = new ArrayList<String>();
            int amtOfStrings = NUMCOORDINATES;
            // randomly selects 150 system names
            for (int i = 0; i < amtOfStrings; i++) {
                boolean check = true;
                while (check) {
                    int random = (int) (Math.random() * planetNames.size());
                    String hold = planetNames.get(random);
                    if (!chosenNames.contains(hold)) {
                        chosenNames.add(hold);
                        check = false;
                    }
                } // end of while-loop
            } // end of for-loop
            ListOfNames = chosenNames;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (s != null)
                s.close();
        }
    }

    /**
     * Saves the current state of the game to a text file
     */
    public void saveGame() {
        File saveFile = new File("savedGame.txt");
        if (saveFile.exists())
            saveFile.delete();
        BufferedWriter output = null;
        try {
            output = new BufferedWriter(new FileWriter(saveFile));
            output.write(Player.toString());
            output.newLine();
            output.write(Player.getShip().toString());
            output.newLine();
            output.write(Player.getShip().toStringCargoBay());
            output.newLine();
            output.write(CurrentSystem.toString());
            output.newLine();
            output.write(CurrentSystem.marketPriceToString());
            output.newLine();
            output.write(CurrentSystem.marketQuantityToString());
            output.newLine();
            for (SolarSystem ss : ListOfSystems) {
                output.write(ss.toString());
                output.newLine();
                output.write(ss.marketPriceToString());
                output.newLine();
                output.write(ss.marketQuantityToString());
                output.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (output != null)
                    output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * loads game
     */
    public void loadGame() {
        Scanner s = null;
        try {
            s = new Scanner(new File("savedGame.txt"));
            s.useDelimiter(",");

            // Player
            Player = new Player();
            Player.setName(s.next());
            Player.setCurrency(s.nextInt());
            Player.setTraderSkills(s.nextInt());
            Player.setEngineerSkills(s.nextInt());
            Player.setFighterSkills(s.nextInt());
            Player.setPilotSkills(s.nextInt());
            Player.setPlayerX(s.nextInt());
            Player.setPlayerY(s.nextInt());

            // Ship
            s.nextLine();
            String shipName = s.next();
            Ship holdShip = new Ship(Ship.getShipType(shipName));
            holdShip.setFuelLevel(s.nextInt());

            // Cargo Bay
            s.nextLine();
            int maxSize = holdShip.cargoBay.length;
            while (maxSize > 0) {
                String holdGoodName = s.next();
                GoodType gT = Good.getGoodType(holdGoodName);
                if (gT != null) {
                    holdShip.addCargo(1, gT);
                }
                maxSize--;
            }

            Player.setShip(holdShip);

            // Current System
            s.nextLine();
            CurrentSystem = new SolarSystem();
            CurrentSystem.setSystemName(s.next());
            CurrentSystem.setTechLevel(s.nextInt());
            CurrentSystem.setResourceLevel(s.nextInt());
            CurrentSystem.setxLocation(s.nextInt());
            CurrentSystem.setyLocation(s.nextInt());
            HashMap<GoodType, Integer> currentMP = new HashMap<GoodType, Integer>();
            HashMap<GoodType, Integer> currentMQ = new HashMap<GoodType, Integer>();

            s.nextLine();
            currentMP.put(GoodType.WATER, s.nextInt());
            currentMP.put(GoodType.FUR, s.nextInt());
            currentMP.put(GoodType.FOOD, s.nextInt());
            currentMP.put(GoodType.ORE, s.nextInt());
            currentMP.put(GoodType.FIREARM, s.nextInt());
            currentMP.put(GoodType.MEDICINE, s.nextInt());
            currentMP.put(GoodType.MACHINE, s.nextInt());
            currentMP.put(GoodType.NARCOTIC, s.nextInt());
            currentMP.put(GoodType.ROBOT, s.nextInt());

            s.nextLine();
            currentMQ.put(GoodType.WATER, s.nextInt());
            currentMQ.put(GoodType.FUR, s.nextInt());
            currentMQ.put(GoodType.FOOD, s.nextInt());
            currentMQ.put(GoodType.ORE, s.nextInt());
            currentMQ.put(GoodType.FIREARM, s.nextInt());
            currentMQ.put(GoodType.MEDICINE, s.nextInt());
            currentMQ.put(GoodType.MACHINE, s.nextInt());
            currentMQ.put(GoodType.NARCOTIC, s.nextInt());
            currentMQ.put(GoodType.ROBOT, s.nextInt());
            CurrentSystem.setMarketPrice(currentMP);
            CurrentSystem.setMarketQuantity(currentMQ);

            // Solar System
            s.nextLine();
            int counter = 0;
            while (counter < NUMCOORDINATES) {
                SolarSystem tempSystem = new SolarSystem();
                tempSystem.setSystemName(s.next());
                tempSystem.setTechLevel(s.nextInt());
                tempSystem.setResourceLevel(s.nextInt());
                tempSystem.setxLocation(s.nextInt());
                tempSystem.setyLocation(s.nextInt());
                HashMap<GoodType, Integer> tempMP = new HashMap<GoodType, Integer>();
                HashMap<GoodType, Integer> tempMQ = new HashMap<GoodType, Integer>();

                s.nextLine();
                tempMP.put(GoodType.WATER, s.nextInt());
                tempMP.put(GoodType.FUR, s.nextInt());
                tempMP.put(GoodType.FOOD, s.nextInt());
                tempMP.put(GoodType.ORE, s.nextInt());
                tempMP.put(GoodType.FIREARM, s.nextInt());
                tempMP.put(GoodType.MEDICINE, s.nextInt());
                tempMP.put(GoodType.MACHINE, s.nextInt());
                tempMP.put(GoodType.NARCOTIC, s.nextInt());
                tempMP.put(GoodType.ROBOT, s.nextInt());

                s.nextLine();
                tempMQ.put(GoodType.WATER, s.nextInt());
                tempMQ.put(GoodType.FUR, s.nextInt());
                tempMQ.put(GoodType.FOOD, s.nextInt());
                tempMQ.put(GoodType.ORE, s.nextInt());
                tempMQ.put(GoodType.FIREARM, s.nextInt());
                tempMQ.put(GoodType.MEDICINE, s.nextInt());
                tempMQ.put(GoodType.MACHINE, s.nextInt());
                tempMQ.put(GoodType.NARCOTIC, s.nextInt());
                tempMQ.put(GoodType.ROBOT, s.nextInt());
                tempSystem.setMarketPrice(tempMP);
                tempSystem.setMarketQuantity(tempMQ);

                ListOfSystems.add(tempSystem);
                counter++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No Saved Game Exists");
        } finally {
            if (s != null)
                s.close();
        }

    }

    /**
     * Driver's toString method
     * 
     * @return string
     */
    public String toString() {
        return "";
    }

}
