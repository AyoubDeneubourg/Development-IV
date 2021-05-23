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

    // Constructor

    public SupplyGrabber() {
        wallet = new Wallet();
        observers = new ArrayList<Observer>();
        stockCroissant = new ArrayList<Croissant>();
        stockBread = new ArrayList<Bread>();
        stockCookie = new ArrayList<Cookie>();
    }

    //add observer to list of observers

    @Override
    public void register(Observer newObserver) {
        observers.add(newObserver);
    }

    //has to be in observer pattern, but we did not used it

    @Override
    public void unregister(Observer deleteObserver) {
        int observerIndex = observers.indexOf(deleteObserver);
        System.out.println("Observer" + (observerIndex + 1) + "is deleted." );
        observers.remove(observerIndex);
    }

    //Loop through all observers and updates what has to be updated

    @Override
    public void notifyObserver() {
        for (Observer observer: observers) {
            observer.update(stockCroissant, stockBread, stockCookie, wallet);
        }
    }

    // adds the pastry to bakery's stock, also updates his wallet because the pastry has production costs

    public void setStockCroissant(Croissant newStockCroissant) {
        stockCroissant.add(newStockCroissant);
        updateBakeryWallet(croissant.getCost());
        notifyObserver();
    }

    // adds the pastry to bakery's stock, also updates his wallet because the pastry has production costs

    public void setStockBread(Bread newStockBread) {
        this.stockBread.add(newStockBread);
        updateBakeryWallet(bread.getCost());
        notifyObserver();
    }

    // adds the pastry to bakery's stock, also updates his wallet because the pastry has production costs

    public void setStockCookie(Cookie newStockCookie) {
        this.stockCookie.add(newStockCookie);
        updateBakeryWallet(cookie.getCost());
        notifyObserver();
    }

    // checks if client has money and the baker has enough stock, if yes, it updates the client wallet, the client purchased items list, the bakery stock and the bakery wallet

    public void sellCroissant(Client client) {
        if(!check(client, stockCroissant, croissant.getPrice())) return;
        updateClient(client, stockCroissant, croissant.getPrice());
        updateBakery(stockCroissant, croissant.getPrice());
        notifyObserver();
    }

    // checks if client has money and the baker has enough stock, if yes, it updates the client wallet, the client purchased items list, the bakery stock and the bakery wallet

    public void sellBread(Client client) {
        if(!check(client, stockBread, bread.getPrice())) return;
        updateClient(client, stockBread, bread.getPrice());
        updateBakery(stockBread, bread.getPrice());
        notifyObserver();
    }

    // checks if client has money and the baker has enough stock, if yes, it updates the client wallet, the client purchased items list, the bakery stock and the bakery wallet

    public void sellCookie(Client client) {
        if(!check(client, stockCookie, cookie.getPrice())) return;
        updateClient(client, stockCookie, cookie.getPrice());
        updateBakery(stockCookie, cookie.getPrice());
        notifyObserver();
    }

    // updates the wallet of the bakery

    public void updateBakeryWallet(double price) {
        Double updatedAmount = Double.sum(wallet.getAmount(), price);
        wallet.setAmount(updatedAmount);
    }

    // updates the wallet of the client

    public void updateClientWallet(Client client, double price) {
        Double updatedAmount = Double.sum(client.getWallet().getAmount(), -price);
        client.setWalletAmount(updatedAmount);
    }

    //updates the list of purchased item and wallet of client

    public void updateClient(Client client, ArrayList productStock, double productPrice) {
        client.buyPastry((Pastry) productStock.get(0)); // FIFO // CAST PARAMETER
        updateClientWallet(client, productPrice);
    }

    // Updates the bakery when a product has been selled

    public void updateBakery(ArrayList productStock, double productPrice) {
        productStock.remove(0); // FIFO
        updateBakeryWallet(productPrice);
    }

    // Checks if client has money and products are available

    public boolean check(Client client, ArrayList productStock, double productPrice) {
        if(productsAvailable(productStock) && clientHasMoney(client, productStock, productPrice)) return true;
        return false;
    }

    // Checks if the stock is greater than the amount the client wants to buy and returns it

    public boolean productsAvailable(ArrayList productStock) {
        if(!productStock.isEmpty()) return true;
        else {
            String productName = getProductsName(productStock);
           throw new IllegalArgumentException(ANSI_GREEN + "Sorry, the bakery '" + BakerySingleton.getInstance().getName() + "' has no more " + productName  + " available");
          //  return false;
        }
    }

    // Returns if the client has money or not

    public boolean clientHasMoney(Client client, ArrayList productStock, double productPrice) {
        if(client.getWallet().getAmount() > productPrice) return true;
        else {
            String productName = getProductsName(productStock);
            System.out.println();
           // return false;
            throw new IllegalArgumentException( ANSI_GREEN + "Sorry, the client '" + client.getName() + "' has not enough money to buy " + productName);
        }
    }

    // Returns the name of the product

    public String getProductsName(ArrayList productStock) {
        return productStock == stockCookie ? "cookies" : productStock == stockBread ? "breads" : "croissants";
    }



}
