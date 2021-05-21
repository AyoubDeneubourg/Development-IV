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

        pastryFactory.makePastry("Croissant", 9);
        pastryFactory.makePastry("Bread", 5);
        pastryFactory.makePastry("Cookie", 10);

        assertThrows(IllegalArgumentException.class, () -> pastryFactory.makePastry("Spaghetti", 5));
    }

    @Test
    public void sellPastry() {
        makePastry();
        Client client = new Client();
        client.setName("Dirk");
        client.setWalletAmount(25);

        pastryFactory.sellPastry("Croissant", 5, client);
        pastryFactory.sellPastry("Bread", 4, client);
        pastryFactory.sellPastry("Cookie", 8, client);

        System.out.println(client);

    }


    // add pain o chocolo
    // strategy if possible
    // add individual client
    // warning when you sell more than in stock
    // change parameter names to realist
    // error handling

    // SRY = function qui fait ce que tu dis !
    // DRY == don't repeat yourself

}
