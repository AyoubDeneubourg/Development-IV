import Models.Croissant;
import Patterns.Singleton.BakerySingleton;

public class Main {

    public static void main(String[] args) {

        BakerySingleton bakery = BakerySingleton.getInstance();

        System.out.println(bakery.getName());

        Croissant croissant = new Croissant();
        croissant.eatsProduct();


    }

}



//Singleton: Bakery =>


//factory: products: bread, croissants, ...


//observer: stock