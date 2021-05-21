package Patterns.Observer.Wallet;
import Interfaces.Wallet.WalletSubject;


public class WalletObserver implements Interfaces.Wallet.WalletObserver {

    private static int observerIDTracker = 0;

    private int observerID;

    private WalletSubject supplyGrabber;

    public WalletObserver(WalletSubject stockGrabber){

        this.supplyGrabber = stockGrabber;
        this.observerID = ++observerIDTracker;
        System.out.println("New Observer " + this.observerID);

        stockGrabber.register(this);

    }

    public void update(int item) {

    }

    public void printThePrices(){

        System.out.println(observerID + "\n Wallet ");

    }

}