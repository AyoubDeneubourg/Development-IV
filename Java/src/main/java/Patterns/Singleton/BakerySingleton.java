package Patterns.Singleton;


public class BakerySingleton{

    //cannot create more than 1 bakery

    private String name = "DevelopmentBakery";

    private static final BakerySingleton instance = new BakerySingleton();

    private BakerySingleton() {

    }

    public static synchronized BakerySingleton getInstance() {
        return instance;
    }

    public void setName(String name) {
       this.name = name;
    }

    public String getName() {
        return name;
    }

}