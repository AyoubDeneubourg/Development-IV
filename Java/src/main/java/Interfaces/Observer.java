package Interfaces;
import Models.*;
import java.util.ArrayList;

public interface Observer {
    void update(ArrayList<Croissant> stockCroissant, ArrayList<Bread> stockBread, ArrayList<Cookie> stockCookie , Wallet wallet);
}
