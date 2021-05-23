import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import Interfaces.SoundBehavior;
import Models.*;
import Patterns.Factory.PastryFactory;
import Patterns.Strategy.Grill;
import Patterns.Strategy.MicroWave;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PastryTest {

    PastryFactory pastryFactory = new PastryFactory();

    @Test
    public void chronoTests() {
        makePastry();
        sellPastry();
    }

    @Test
    public void makePastry() { // Factory

        List<Pastry> ma = pastryFactory.makePastry("Croissant", 10);
        pastryFactory.makePastry("Bread", 10);
        pastryFactory.makePastry("Cookie", 10);
        // - 10.50


        assertThrows(IllegalArgumentException.class, () -> pastryFactory.makePastry("Spaghetti", 5));
    }
/*
    0.90 0.15
    1.80 0.70
    1.20 0.20
*/

    @Test
    public void sellPastry() {
        makePastry();
        Client client = new Client();
        client.setName("Dirk");
        client.setWalletAmount(5);

       pastryFactory.sellPastry("Croissant", 2, client);
       pastryFactory.sellPastry("Bread", 1, client);

        System.out.println(client);



        Client clientTwo = new Client();
        clientTwo.setName("Ayoub");
        clientTwo.setWalletAmount(5);

        pastryFactory.sellPastry("Croissant", 1, clientTwo);
        pastryFactory.sellPastry("Cookie", 1, clientTwo);
        pastryFactory.sellPastry("Bread", 3, clientTwo);



       ArrayList<Pastry> purchasedItems = client.getPurchasedItems();
       Pastry pastry = purchasedItems.get(0);
       pastry.eat();
       pastry.setBehavior(new Grill());
       pastry.eat();
       pastry.setBehavior(new MicroWave());
       pastry.eat();

        System.out.println(client);
        System.out.println(clientTwo);




    }

@Test
    public void strategy() {


    pastryFactory.makePastry("Bread", 1);



    Client client = new Client();
    client.setName("Dirk");
    client.setWalletAmount(5);

    pastryFactory.sellPastry("Bread", 1, client);


    ArrayList<Pastry> purchasedItems = client.getPurchasedItems();
    Pastry pastry = purchasedItems.get(0);

    pastry.eat();

    // zetten op de grill
    pastry.setBehavior(new Grill());
    pastry.eat();

    // zetten in de microwave
    pastry.setBehavior(new MicroWave());
    pastry.eat();

    }



    // strategy if possible
    // add individual client
    // warning when you sell more than in stock
    // change parameter names to realist
    // error handling

    // SRY = function qui fait ce que tu dis !
    // DRY == don't repeat yourself

}
