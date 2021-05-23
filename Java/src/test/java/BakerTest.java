import Models.Pastry;
import Patterns.Singleton.BakerySingleton;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class BakerTest {




    @Test
    public void makeBakery() {

        BakerySingleton bakery = BakerySingleton.getInstance();
        bakery.setName("DEV IV BAKERY");
        BakerySingleton bakeryTwo = BakerySingleton.getInstance();

        System.out.println(bakery.getName());
        System.out.println(bakeryTwo.getName());

        assertEquals(bakery, bakeryTwo);

    }

    @Test
    void tryInstantiation() {
     //   BakerySingleton bakery = new BakerySingleton(); // impossible -> compile time error
    }


}
