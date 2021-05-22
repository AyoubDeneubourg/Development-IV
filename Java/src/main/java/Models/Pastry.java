package Models;

import Interfaces.SoundBehavior;
import Patterns.Strategy.Grill;
import Patterns.Strategy.MicroWave;

public abstract class Pastry {


    private String name;
    private  double sellPrice;
    private  double cost;

    protected SoundBehavior soundBehavior;

    public Pastry() {
        soundBehavior = new MicroWave();
    }

    public void eat() {
        soundBehavior.eat();
    }


    public void setBehavior(SoundBehavior soundBehavior) {
        if (soundBehavior != null)
            this.soundBehavior = soundBehavior;
    }


    public void setCost(double cost) {
        this.cost = cost;
    }
    public  double getCost() {
        return cost;
    }


    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }
    public  double getPrice() {
        return sellPrice;
    }






}
