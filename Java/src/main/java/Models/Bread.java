package Models;

public class Bread extends Pastry {

    private int breadId;
    private static int breadIdCounter = 0;

    public Bread() {

        setName("Bread");
        setPrice(1.80);
        setCost(-0.70);
        setSound("Miam miam!");
        this.breadId = breadIdCounter++;

    }

    @Override
    public String toString() {
        // return "Bread" + hashCode();
        return "Bread " + breadId;
    }

}
