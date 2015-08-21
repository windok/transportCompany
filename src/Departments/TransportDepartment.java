package Departments;

import Transport.Transport;

import java.util.Set;

public class TransportDepartment {

    private Set<Transport> transportPark;

    public void addTransport(Transport transport) {
        getTransportPark().add(transport);
    }

    synchronized public Transport getFreeTransport() throws Exception {
        for (Transport transport : getTransportPark()) {
            if (!transport.isInTransit()) {
                return transport;
            }
        }

        throw new Exception("There is no free transport");
    }

    private Set<Transport> getTransportPark() {
        return transportPark;
    }

    private TransportDepartment setTransportPark(Set<Transport> transportPark) {
        this.transportPark = transportPark;
        return this;
    }
}
