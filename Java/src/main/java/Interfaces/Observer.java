package Interfaces;
import Models.*;
import java.util.ArrayList;
import java.util.List;

public interface Observer {
    public void update(ArrayList<Croissant> stockCroissant, ArrayList<Bread> stockBread, ArrayList<Cookie> stockCookie , Wallet wallet);
}
