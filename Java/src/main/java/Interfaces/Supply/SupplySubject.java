package Interfaces.Supply;

public interface SupplySubject {

    public void register(SupplyObserver o);

    public void unregister(SupplyObserver o);

    public void notifyObserver();
}
