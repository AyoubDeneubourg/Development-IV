package Models;

public class Cookie extends Pastry {

    private int cookieId;
    private static int cookieIdCounter = 0;

    public Cookie() {

        setName("Cookie");
        setPrice(1.20);
        setCost(-0.20);
        setSound("Cook Cook!");
        this.cookieId = cookieIdCounter++;

    }

    @Override
    public String toString() {
        // return "Cookie" + hashCode();
        return "Cookie " + cookieId;
    }

}
