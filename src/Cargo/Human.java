package Cargo;

public class Human extends Cargo {

    public Human(int weight, String region) {
        super(weight, region);
    }

    public String toString() {
        return "Human: " + super.toString();
    }
}
