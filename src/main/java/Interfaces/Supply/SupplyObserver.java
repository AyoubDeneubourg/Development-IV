package Interfaces.Supply;
import Models.*;
import java.util.ArrayList;
import java.util.List;

public interface SupplyObserver {
    public void update(ArrayList<Croissant> stockCroissant, ArrayList<Bread> stockBread, ArrayList<Cookie> stockCookie , Wallet wallet);
}
