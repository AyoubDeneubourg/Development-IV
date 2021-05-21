package Patterns.Observer.Supply;

import Interfaces.Supply.SupplyObserver;
import Interfaces.Supply.SupplySubject;
import Models.*;
import java.lang.Double;

import java.util.ArrayList;
public class SupplyGrabber implements SupplySubject {

    private ArrayList<SupplyObserver> observers;

    private ArrayList<Croissant> stockCroissant;
    private ArrayList<Bread> stockBread;
    private ArrayList<Cookie> stockCookie;
    private Croissant croissant = new Croissant();
    private Bread bread = new Bread();
    private Cookie cookie = new Cookie();
    private Wallet wallet;

    public SupplyGrabber() {

        wallet = new Wallet();
        observers = new ArrayList<SupplyObserver>();
        stockCroissant = new ArrayList<Croissant>();
        stockBread = new ArrayList<Bread>();
        stockCookie = new ArrayList<Cookie>();

    }

    @Override
    public void register(SupplyObserver newObserver) {
    observers.add(newObserver);

    }


    @Override
    public void unregister(SupplyObserver deleteObserver) {
        int observerIndex = observers.indexOf(deleteObserver);
        System.out.println("Observer" + (observerIndex + 1) + "is deleted." );

        observers.remove(observerIndex);
    }

    @Override
    public void notifyObserver() {

        for (SupplyObserver observer: observers) {
            observer.update(stockCroissant, stockBread, stockCookie, wallet);
        }

    }

    public void updateBakeryWallet(double price) {
       Double updatedAmount = Double.sum(wallet.getAmount(), price);
        wallet.setAmount(updatedAmount);
    }

    public void updateClientWallet(Client client, double price) {
        Double updatedAmount = Double.sum(client.getWallet().getAmount(), -price);
        client.setWalletAmount(updatedAmount);
    }

    public void setStockCroissant(Croissant newStockCroissant) {
        stockCroissant.add(newStockCroissant);
        updateBakeryWallet(croissant.getCost());
        notifyObserver();
    }


    public void setStockBread(Bread newStockBread) {
        this.stockBread.add(newStockBread);
        updateBakeryWallet(bread.getCost());
        notifyObserver();
    }

    public void setStockCookie(Cookie newStockCookie) {
        this.stockCookie.add(newStockCookie);
        updateBakeryWallet(cookie.getCost());
        notifyObserver();
    }

    public void sellCroissant(Client client) {
        this.stockCroissant.remove(0); // FIFO
        updateBakeryWallet(croissant.getPrice());
        updateClientWallet(client, croissant.getPrice());
        notifyObserver();
    }

    public void sellBread(Client client) {
        this.stockBread.remove(0); // FIFO
        updateBakeryWallet(bread.getPrice());
        updateClientWallet(client, bread.getPrice());
        notifyObserver();
    }

    public void sellCookie(Client client) {
        this.stockCookie.remove(0); // FIFO
        updateBakeryWallet(cookie.getPrice());
        updateClientWallet(client, cookie.getPrice());
        notifyObserver();
    }



}
