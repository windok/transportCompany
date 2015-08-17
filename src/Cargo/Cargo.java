package Cargo;

public abstract class Cargo {

    int weight;

    public Cargo(int weight) {
        this.setWeight(weight);
    }

    public int getWeight() {
        return weight;
    }

    public Cargo setWeight(int weight) {
        this.weight = weight;
        return this;
    }
}
