package Patterns.Singleton;


public class BakerySingleton{

    private String name;

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