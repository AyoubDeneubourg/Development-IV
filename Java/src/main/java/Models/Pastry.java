package Models;

public class Pastry {


    private String name;
    private  double sellPrice;
    private String sound;
    private  double cost;

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


    public void setSound(String sound) {
        this.sound = sound;
    }

    private String getSound() {
        return sound;
    }

    public void eatsProduct() {

        System.out.println(getSound()+ " is the sound of" + getName());

    }




}
