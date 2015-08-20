package Cargo;

public class Animal extends Cargo {

    public Animal(int weight, String region) {
        super(weight, region);
    }

    public String toString() {
        return "Animal: " + super.toString();
    }
}
