
import java.util.ArrayList;
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

        givenPastries_WhenMakingPastries_ThenPastriesAreMade();
        givenUnknownPastries_WhenMakingPastries_ThenThrowsError();
        givenClient_WhenSellingPastries_ThenPastriesAreSold();
        givenClient_WhenBakerSellsPastries_ThenPurchasedItemListOfClientIsGiven();
        givenClient_WhenSellingUnknownPastries_ThenThrowsError();
        givenClient_WhenSellingMorePastriesThanInStock_ThenThrowsError();
        givenBrokeClient_WhenSellingToBrokeClient_ThenThrowsError();
        givenPastry_WhenChangingPastryBehavior_ThenBehaviorIsChanged();

    }

    @Test
    public void givenPastries_WhenMakingPastries_ThenPastriesAreMade() { // Factory

        // make the pastries
        pastryFactory.makePastry("Croissant", 10);
        pastryFactory.makePastry("Bread", 10);
        pastryFactory.makePastry("Cookie", 10);

    }

    @Test
    public void givenUnknownPastries_WhenMakingPastries_ThenThrowsError() {
        // throws an error if tries to bake something unknown
        assertThrows(IllegalArgumentException.class, () -> pastryFactory.makePastry("Spaghetti", 5));
    }

    @Test
    public void givenClient_WhenSellingPastries_ThenPastriesAreSold() {
        givenPastries_WhenMakingPastries_ThenPastriesAreMade();

        //Create new client and gives him 5€ in wallet
        Client client = new Client();
        client.setName("Dirk");
        client.setWalletAmount(5);

        //Sell pastry to client
        pastryFactory.sellPastry("Croissant", 2, client);
        pastryFactory.sellPastry("Bread", 1, client);
        System.out.println(client);

    }

    @Test
    public void givenClient_WhenBakerSellsPastries_ThenPurchasedItemListOfClientIsGiven() {
        givenPastries_WhenMakingPastries_ThenPastriesAreMade();
        Client client = new Client();
        client.setName("Joni");
        client.setWalletAmount(200);

        //Sell pastry to client
        pastryFactory.sellPastry("Croissant", 4, client);
        pastryFactory.sellPastry("Bread", 2, client);

        //Get A list of the items he bought
       ArrayList purchasedItemOfClient = client.getPurchasedItems();
       System.out.println(purchasedItemOfClient);

    }

    @Test
    public void givenClient_WhenSellingUnknownPastries_ThenThrowsError() {
        Client client = new Client();
        client.setName("Dirk");
        client.setWalletAmount(5);

        //throws an error if tries to sell something unknown
        assertThrows(IllegalArgumentException.class, () -> pastryFactory.sellPastry("Spaghetti", 5, client));

    }

    @Test
    public void givenClient_WhenSellingMorePastriesThanInStock_ThenThrowsError() {
        Client client = new Client();
        client.setName("Dirk");
        client.setWalletAmount(5);

        //throws an error if tries too much amount of a pastry
        assertThrows(IllegalArgumentException.class, () -> pastryFactory.sellPastry("Croissant", 500, client));

    }

    @Test
    public void givenBrokeClient_WhenSellingToBrokeClient_ThenThrowsError() {

       // Create new client and gives him 0€ in wallet
        Client clientTwo = new Client();
        clientTwo.setName("Maarten");
        clientTwo.setWalletAmount(0);

        //throws error if client has not enough money
        assertThrows(IllegalArgumentException.class, () -> pastryFactory.sellPastry("Croissant", 1, clientTwo));

    }

    @Test
    public void givenPastry_WhenChangingPastryBehavior_ThenBehaviorIsChanged() {
        Pastry pastry = new Bread();
        pastry.eat();

        // put in grill
        pastry.setBehavior(new Grill());
        pastry.eat();

        // put in microwave
        pastry.setBehavior(new MicroWave());
        pastry.eat();

    }

    }



