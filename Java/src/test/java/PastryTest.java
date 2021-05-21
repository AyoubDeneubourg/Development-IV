import java.util.List;

import Models.*;
import Patterns.Factory.PastryFactory;
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
    public void makePastry() {

        pastryFactory.makePastry("Croissant", 10);
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


        System.out.println(client);
        System.out.println(clientTwo);



    }


    // strategy if possible
    // add individual client
    // warning when you sell more than in stock
    // change parameter names to realist
    // error handling

    // SRY = function qui fait ce que tu dis !
    // DRY == don't repeat yourself

}
