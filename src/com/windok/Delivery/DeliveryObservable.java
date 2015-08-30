package com.windok.Delivery;

public interface DeliveryObservable {

    void addObserver(DeliverySubject deliverySubject);
    void notifyObservers();
    void startDelivery();
}
