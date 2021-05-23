package Models;

import Patterns.Strategy.Grill;

public class Cookie extends Pastry {

    private int cookieId;
    private static int cookieIdCounter = 0;

    public Cookie() {
        super.soundBehavior = new Grill();
        setName("Cookie");
        setPrice(1.20);
        setCost(-0.20);
        this.cookieId = cookieIdCounter++;
    }

    @Override
    public String toString() {
        return "Cookie " + cookieId;
    }
}
