package Models;

import java.util.ArrayList;

public class Client {

    private String name;
    private Wallet wallet = new Wallet();
    private ArrayList<Pastry> purchasedItems = new ArrayList<Pastry>();

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setWalletAmount(double amount) {
        this.wallet.setAmount(amount);
    }

    public Wallet getWallet() {
        return wallet;
    }
    public void buyPastry(Pastry pastry) {
        this.purchasedItems.add(pastry);
    }


    public ArrayList<Pastry> getPurchasedItems() {
        return purchasedItems;
    }

    @Override
    public String toString() {
        return name + " has " + String.format("%.2f", wallet.getAmount()) + " in his wallet. He bought also " + purchasedItems;
    }
}
