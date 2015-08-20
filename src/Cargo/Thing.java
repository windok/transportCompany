package Cargo;

public class Thing extends Cargo {

    public Thing(int weight, String region) {
        super(weight, region);
    }

    public String toString() {
        return "Thing: " + super.toString();
    }
}
