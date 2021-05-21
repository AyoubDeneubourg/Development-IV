package Patterns.Observer.Supply;

import Interfaces.Supply.SupplySubject;
import Models.*;

import java.util.ArrayList;

public class SupplyObserver implements Interfaces.Supply.SupplyObserver {


    private ArrayList<Croissant> stockCroissant;
    private ArrayList<Bread> stockBread;
    private ArrayList<Cookie> stockCookie;
    private Wallet wallet;

    private static int observerIDTracker = 0;

    private int observerID;

    private SupplySubject supplyGrabber;

    public SupplyObserver(SupplySubject stockGrabber){

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

    //    printThePrices();

    }


    public void printThePrices(){

        System.out.println(observerID + "\nStock Croissant: " + stockCroissant + "\nStock Bread: " +
                stockBread + "\nStock Cookie:" + stockCookie + "\nBakery wallet has " + String.format("%.2f", wallet.getAmount())) ;

    }

}