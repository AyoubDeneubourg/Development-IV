package Models;

public class Croissant extends Pastry {

    private int croissantId;
    private static int croissantIdCounter = 0;

    public Croissant() {
        setName("Croissant");
        setPrice(0.90);
        setCost(-0.15);
        this.croissantId = croissantIdCounter++;
    }

    @Override
    public String toString() {
        return "Croissant " + croissantId;
    }
}

