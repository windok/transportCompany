package Cargo;

public abstract class Cargo implements Comparable {

    int weight;

    String region;

    public Cargo(int weight, String region) {
        this.setWeight(weight).setRegion(region);
    }

    public int getWeight() {
        return weight;
    }

    public Cargo setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public Cargo setRegion(String region) {
        this.region = region;
        return this;
    }

    public String toString() {
        return "weight - " + this.getWeight() + "; region - " + this.getRegion();
    }

    public int compareTo(Object object) {
        Cargo anotherCargo = (Cargo) object;
        if (anotherCargo.getWeight() < this.getWeight()) {
            return 1;
        }
        if (anotherCargo.getWeight() > this.getWeight()) {
            return -1;
        }
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Cargo cargo = (Cargo) object;

        return weight == cargo.weight && region.equals(cargo.region);
    }

    public int hashCode() {
        int result = weight;
        result = 31 * result + region.hashCode();
        return result;
    }
}
