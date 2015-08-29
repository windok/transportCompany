import Builders.TransportBuilder;
import Departments.CargoLoadingDepartment;
import Departments.TransportDepartment;
import Region.Region;
import Transport.TransportType;

public class TransportCompany {

    private TransportDepartment transportDepartment;

    private CargoLoadingDepartment cargoLoadingDepartment;

    public TransportCompany(TransportDepartment transportDepartment, CargoLoadingDepartment cargoLoadingDepartment) {
        setTransportDepartment(transportDepartment).setCargoLoadingDepartment(cargoLoadingDepartment);
    }

    public static void main(String args[]) throws Exception {

        TransportCompany transportCompany = new TransportCompany(new TransportDepartment(), new CargoLoadingDepartment());

        TransportBuilder carBuilder = TransportBuilder.instantiate(TransportType.CAR);
        TransportBuilder aircraftBuilder = TransportBuilder.instantiate(TransportType.AIRCRAFT);
        TransportBuilder boatBuilder = TransportBuilder.instantiate(TransportType.BOAT);

        transportCompany.getTransportDepartment().
                addTransport(carBuilder.buy(Region.random())).
                addTransport(carBuilder.buy(Region.random())).
                addTransport(aircraftBuilder.buy(Region.random())).
                addTransport(aircraftBuilder.buy(Region.random())).
                addTransport(boatBuilder.buy(Region.random())).
                addTransport(boatBuilder.buy(Region.random()))
        ;


        System.out.print(transportCompany);

    }

    private TransportDepartment getTransportDepartment() {
        return transportDepartment;
    }

    private TransportCompany setTransportDepartment(TransportDepartment transportDepartment) {
        this.transportDepartment = transportDepartment;
        return this;
    }

    private CargoLoadingDepartment getCargoLoadingDepartment() {
        return cargoLoadingDepartment;
    }

    private TransportCompany setCargoLoadingDepartment(CargoLoadingDepartment cargoLoadingDepartment) {
        this.cargoLoadingDepartment = cargoLoadingDepartment;
        return this;
    }
}
