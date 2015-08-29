package Departments;

import Exceptions.NoFreeTransportException;
import Transport.Transport;

import java.util.HashSet;
import java.util.Set;

public class TransportDepartment {

    private Set<Transport> transportPark;

    public TransportDepartment() {
        setTransportPark(new HashSet<>());
    }

    public TransportDepartment addTransport(Transport transport) {
        getTransportPark().add(transport);
        return this;
    }

    synchronized public Transport getFreeTransport() throws Exception {
        for (Transport transport : getTransportPark()) {
            if (!transport.isInTransit()) {
                return transport;
            }
        }

        throw new NoFreeTransportException();
    }

    private Set<Transport> getTransportPark() {
        return transportPark;
    }

    private TransportDepartment setTransportPark(Set<Transport> transportPark) {
        this.transportPark = transportPark;
        return this;
    }
}
