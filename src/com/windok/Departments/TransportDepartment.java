package com.windok.Departments;

import com.windok.Delivery.Delivery;
import com.windok.Delivery.DeliveryObservable;
import com.windok.Delivery.DeliverySubject;
import com.windok.Transport.Transport;

public class TransportDepartment implements DeliverySubject {

    private CargoLoadingDepartment cargoLoadingDepartment;

    public TransportDepartment(CargoLoadingDepartment cargoLoadingDepartment) {
        setCargoLoadingDepartment(cargoLoadingDepartment);
    }

    public TransportDepartment addTransport(Transport transport) {
        Delivery delivery = new Delivery(transport, getCargoLoadingDepartment());
        delivery.addObserver(this);
        delivery.startDelivery();

        return this;
    }

    @Override
    public void update(DeliveryObservable deliveryObservable) {
        if (!getCargoLoadingDepartment().isEmptyCargoQueue()) {
            deliveryObservable.startDelivery();
        }
    }

    private CargoLoadingDepartment getCargoLoadingDepartment() {
        return cargoLoadingDepartment;
    }

    private TransportDepartment setCargoLoadingDepartment(CargoLoadingDepartment cargoLoadingDepartment) {
        this.cargoLoadingDepartment = cargoLoadingDepartment;
        return this;
    }
}
