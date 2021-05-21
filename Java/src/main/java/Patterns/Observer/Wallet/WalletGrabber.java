package Patterns.Observer.Wallet;

import Interfaces.Wallet.WalletObserver;
import Interfaces.Wallet.WalletSubject;
import Models.Bread;
import Models.Croissant;
import Models.Wallet;
import java.util.ArrayList;

public class WalletGrabber implements WalletSubject {

    private ArrayList<WalletObserver> observers;

    private ArrayList<Croissant> stockCroissant;
    private ArrayList<Bread> stockBread;

    private int wallet;

    public WalletGrabber() {

        observers = new ArrayList<WalletObserver>();
        stockCroissant = new ArrayList<Croissant>();
        stockBread = new ArrayList<Bread>();

    }

    @Override
    public void register(WalletObserver newObserver) {
        observers.add(newObserver);

    }




    @Override
    public void unregister(WalletObserver deleteObserver) {
        int observerIndex = observers.indexOf(deleteObserver);
        System.out.println("Observer" + (observerIndex + 1) + "is deleted." );

        observers.remove(observerIndex);
    }

    @Override
    public void notifyObserver() {

        for (WalletObserver observer: observers) {
          //  observer.update(stockCroissant, stockBread);
        }

    }

    public void setStockCroissant(Croissant newStockCroissant) {
        stockCroissant.add(newStockCroissant);
        notifyObserver();
    }


    public void setStockBread(Bread newStockBread) {
        this.stockBread.add(newStockBread);
        notifyObserver();
    }


    public void sellCroissant() {
        this.stockCroissant.remove(0); // FIFO

        notifyObserver();

    }

    public void sellBread() {
        this.stockBread.remove(0); // FIFO
        notifyObserver();

    }

}
