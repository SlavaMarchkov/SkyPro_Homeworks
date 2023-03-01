package skypro.homeworks.course2.homework02;

public class Gryffindor extends Hogwarts {
    private final int nobility; // благородство
    private final int honor; // честь
    private final int bravery; // храбрость

    public Gryffindor(String name) {
        super(name);
        this.nobility = rand();
        this.honor = rand();
        this.bravery = rand();
    }

    public int getNobility() {
        return nobility;
    }

    public int getHonor() {
        return honor;
    }

    public int getBravery() {
        return bravery;
    }

    @Override
    public int sumProperties() {
        return getNobility() + getHonor() + getBravery();
    }

    @Override
    public String toString() {
        return super.toString() +
                "благородство=" + nobility +
                ", честь=" + honor +
                ", храбрость=" + bravery +
                ", факультет='Гриффиндор'}";
    }
}
