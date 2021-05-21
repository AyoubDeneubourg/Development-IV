package Models;

public class Client {

    private String name;
    private Wallet wallet = new Wallet();

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

    @Override
    public String toString() {
        return name + " has " + String.format("%.2f", wallet.getAmount()) + " in his wallet";
    }
}
