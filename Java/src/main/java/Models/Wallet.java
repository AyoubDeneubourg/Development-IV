package Models;

public class Wallet {

    double amount = 0;

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Wallet has " + String.format("%.2f", amount) + " euros";
    }
}
