package Interfaces.Wallet;

import Interfaces.Supply.SupplyObserver;

public interface WalletSubject {

    public void register(WalletObserver o);

    public void unregister(WalletObserver o);

    public void notifyObserver();
}
