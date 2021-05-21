package Patterns.Factory;

import Models.*;
import Patterns.Observer.SupplyGrabber;
import Patterns.Observer.SupplyObserver;

import java.util.ArrayList;
import java.util.List;

public class PastryFactory {


    SupplyGrabber supplyGrabber = new SupplyGrabber();
    SupplyObserver observer = new SupplyObserver(supplyGrabber);


    public void sellPastry(String deletePastryType, int amount, Client client) {


        if (deletePastryType.equals("Croissant")) {

            for (int i = 0; i < amount; i++) {
                supplyGrabber.sellCroissant(client);
            }
            observer.printThePrices();


        } else if (deletePastryType.equals("Bread")) {

            for (int i = 0; i < amount; i++) {
                supplyGrabber.sellBread(client);
            }
            observer.printThePrices();

        } else if (deletePastryType.equals("Cookie")) {

            for (int i = 0; i < amount; i++) {
                supplyGrabber.sellCookie(client);
            }
            observer.printThePrices();

        } else throw new IllegalArgumentException("You can't sell " + deletePastryType);


    }

    public List<Pastry> makePastry(String newPastryType, int amount) {

    ArrayList croissantList = new ArrayList<Pastry>();
    ArrayList breadList = new ArrayList<Pastry>();
    ArrayList cookieList = new ArrayList<Pastry>();


        if (newPastryType.equals("Croissant")) {

            for (int i = 0; i < amount; i++) {
                Croissant croissant = new Croissant();
                supplyGrabber.setStockCroissant(croissant);
                croissantList.add(croissant);
            }

            observer.printThePrices();
            return croissantList;


        } else if (newPastryType.equals("Bread")) {

            for (int i = 0; i < amount; i++) {
                Bread bread = new Bread();
                supplyGrabber.setStockBread(bread);
                breadList.add(bread);

            }
            observer.printThePrices();
            return breadList;

        } else if (newPastryType.equals("Cookie")) {

            for (int i = 0; i < amount; i++) {
                Cookie cookie = new Cookie();
                supplyGrabber.setStockCookie(cookie);
                cookieList.add(cookie);

            }
            observer.printThePrices();
            return cookieList;
        }
            else throw new IllegalArgumentException("You don't have the ingredients to cook " + newPastryType);

    }
}
