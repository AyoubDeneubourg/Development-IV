package Patterns.Observer;

import Interfaces.Observer;
import Interfaces.Subject;
import Models.*;

import java.util.ArrayList;

public class SupplyObserver implements Observer {

    private ArrayList<Croissant> stockCroissant;
    private ArrayList<Bread> stockBread;
    private ArrayList<Cookie> stockCookie;
    private Wallet wallet;

    private static int observerIDTracker = 0;

    private int observerID;

    private Subject supplyGrabber;

    public SupplyObserver(Subject stockGrabber){
        this.supplyGrabber = stockGrabber;
        this.observerID = ++observerIDTracker;
        System.out.println("New Observer " + this.observerID);
        stockGrabber.register(this);
    }

    public void update(ArrayList<Croissant> stockCroissant, ArrayList<Bread> stockBread, ArrayList<Cookie> stockCookie, Wallet wallet) {
        this.wallet = wallet;
        this.stockCroissant = stockCroissant;
        this.stockBread = stockBread;
        this.stockCookie = stockCookie;
    }

    public static final String ANSI_YELLOW = "\u001B[33m";

    public void printThePrices(){
        System.out.println(ANSI_YELLOW + observerID  +"\n" + ANSI_YELLOW + "Stock Croissant: " + stockCroissant + "\n" +  ANSI_YELLOW +"Stock Bread: " +
                stockBread + "\n" +  ANSI_YELLOW + "Stock Cookie:" + stockCookie + "\n" + ANSI_YELLOW + "Bakery wallet has " + String.format("%.2f", wallet.getAmount()) ) ;
    }

}