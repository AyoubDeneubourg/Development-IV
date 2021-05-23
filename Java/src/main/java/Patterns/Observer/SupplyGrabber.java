package Patterns.Observer;

import Interfaces.Observer;
import Interfaces.Subject;
import Models.*;
import Patterns.Singleton.BakerySingleton;

import java.lang.Double;

import java.lang.reflect.Array;
import java.util.ArrayList;
public class SupplyGrabber implements Subject {

    private ArrayList<Observer> observers;

    private ArrayList<Croissant> stockCroissant;
    private ArrayList<Bread> stockBread;
    private ArrayList<Cookie> stockCookie;

    private Cookie cookie = new Cookie();
    private Bread bread = new Bread();
    private Croissant croissant = new Croissant();

    private Wallet wallet;


    public static final String ANSI_GREEN = "\u001B[32m";



    public SupplyGrabber() {
        wallet = new Wallet();
        observers = new ArrayList<Observer>();
        stockCroissant = new ArrayList<Croissant>();
        stockBread = new ArrayList<Bread>();
        stockCookie = new ArrayList<Cookie>();

    }

    @Override
    public void register(Observer newObserver) {
        observers.add(newObserver);

    }


    @Override
    public void unregister(Observer deleteObserver) {
        int observerIndex = observers.indexOf(deleteObserver);
        System.out.println("Observer" + (observerIndex + 1) + "is deleted." );

        observers.remove(observerIndex);
    }

    @Override
    public void notifyObserver() {

        for (Observer observer: observers) {
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
        if(!check(client, stockCroissant, croissant.getPrice())) return;

        updateClient(client, stockCroissant, croissant.getPrice());
        updateBakery(stockCroissant, croissant.getPrice());
        notifyObserver();

    }

    public void sellBread(Client client) {
        if(!check(client, stockBread, bread.getPrice())) return;

        updateClient(client, stockBread, bread.getPrice());
        updateBakery(stockBread, bread.getPrice());
        notifyObserver();
    }



    public void sellCookie(Client client) {
        if(!check(client, stockCookie, cookie.getPrice())) return;

        updateClient(client, stockCookie, cookie.getPrice());
        updateBakery(stockCookie, cookie.getPrice());

        notifyObserver();
    }



    public void updateClient(Client client, ArrayList productStock, double productPrice) {
        client.buyPastry((Pastry) productStock.get(0)); // FIFO // CAST PARAMETER
        updateClientWallet(client, productPrice);
    }


    public void updateBakery(ArrayList productStock, double productPrice) {
        productStock.remove(0); // FIFO
        updateBakeryWallet(productPrice);

    }




    public boolean check(Client client, ArrayList productStock, double productPrice) {
        if(productsAvailable(productStock) && clientHasMoney(client, productStock, productPrice)) return true;
        return false; // Goed
    }



    public boolean productsAvailable(ArrayList productStock) {
        if(!productStock.isEmpty()) return true;
        else {
            String productName = getProductsName(productStock);
            System.out.println(ANSI_GREEN + "Sorry, the bakery '" + BakerySingleton.getInstance().getName() + "' has no more " + productName  + " available");
            return false;
        }
    }


    public boolean clientHasMoney(Client client, ArrayList productStock, double productPrice) {

        if(client.getWallet().getAmount() > productPrice) return true;
        else {
            String productName = getProductsName(productStock);
            System.out.println( ANSI_GREEN + "Sorry, the client '" + client.getName() + "' has not enough money to buy " + productName);
            return false;
        }
    }


    public String getProductsName(ArrayList productStock) {
        return productStock == stockCookie ? "cookies" : productStock == stockBread ? "breads" : "croissants";
    }



}
