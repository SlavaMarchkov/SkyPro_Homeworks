package skypro.homeworks.course2.homework02;

public class Slytherin extends Hogwarts {
    private final int slyness; // хитрость
    private final int determination; // решительность
    private final int ambition; // амбициозность
    private final int resourcefulness; // находчивость
    private final int powerLust; // жажда власти

    public Slytherin(String name) {
        super(name);
        this.slyness = rand();
        this.determination = rand();
        this.ambition = rand();
        this.resourcefulness = rand();
        this.powerLust = rand();
    }

    public int getSlyness() {
        return slyness;
    }

    public int getDetermination() {
        return determination;
    }

    public int getAmbition() {
        return ambition;
    }

    public int getResourcefulness() {
        return resourcefulness;
    }

    public int getPowerLust() {
        return powerLust;
    }

    @Override
    public int sumProperties() {
        return getSlyness() + getDetermination() + getAmbition() + getResourcefulness() + getPowerLust();
    }

    @Override
    public String toString() {
        return super.toString() +
                "хитрость=" + slyness +
                ", решительность=" + determination +
                ", амбициозность=" + ambition +
                ", находчивость=" + resourcefulness +
                ", жажда власти=" + powerLust +
                ", факультет='Слизерин'}";
    }
}
