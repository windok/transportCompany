package Departments;

import Cargo.Cargo;
import Exceptions.OutOfSpaceException;
import Transport.Transport;

import java.util.Set;
import java.util.TreeSet;

public class CargoLoadingDepartment {

    private Set<Cargo> loadingQueue = new TreeSet<>();

    public void addToLoadingQueue(Cargo cargo) {
        this.getLoadingQueue().add(cargo);
    }

    public void load(Transport transport) {
        for (Cargo cargo : this.getLoadingQueue()) {
            if (transport.getRegion().equals(cargo.getRegion())) {
                try {
                    transport.load(cargo);
                } catch (OutOfSpaceException exception) {
                    break;
                }
            }
        }
    }

    private Set<Cargo> getLoadingQueue() {
        return loadingQueue;
    }

}
