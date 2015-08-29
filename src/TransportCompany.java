import Builders.TransportBuilder;
import Departments.CargoLoadingDepartment;
import Departments.TransportDepartment;

public class TransportCompany {

    private TransportDepartment transportDepartment;

    private CargoLoadingDepartment cargoLoadingDepartment;

    public TransportCompany(TransportDepartment transportDepartment, CargoLoadingDepartment cargoLoadingDepartment) {
        setTransportDepartment(transportDepartment).setCargoLoadingDepartment(cargoLoadingDepartment);
    }


    public static void main(String args[]) throws Exception {

        TransportCompany transportCompany = new TransportCompany(new TransportDepartment(), new CargoLoadingDepartment());

        TransportBuilder carBuilder = TransportBuilder.instantiate(TransportBuilder.TYPE_CAR);
        TransportBuilder aircraftBuilder = TransportBuilder.instantiate(TransportBuilder.TYPE_AIRCRAFT);
        TransportBuilder boatBuilder = TransportBuilder.instantiate(TransportBuilder.TYPE_BOAT);

        transportCompany.getTransportDepartment().
                addTransport(carBuilder.buy("US")).addTransport(aircraftBuilder.buy("US")).addTransport(boatBuilder.buy("US")).
                addTransport(carBuilder.buy("EMEA")).addTransport(aircraftBuilder.buy("EMEA")).addTransport(boatBuilder.buy("EMEA")).
                addTransport(carBuilder.buy("APAC")).addTransport(aircraftBuilder.buy("APAC")).addTransport(boatBuilder.buy("APAC"))
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
