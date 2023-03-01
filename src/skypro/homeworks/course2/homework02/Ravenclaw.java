package skypro.homeworks.course2.homework02;

public class Ravenclaw extends Hogwarts {
    private final int mind; // ум
    private final int wisdom; // мудрость
    private final int wit; // остроумие
    private final int creativity; // творчество

    public Ravenclaw(String name) {
        super(name);
        this.mind = rand();
        this.wisdom = rand();
        this.wit = rand();
        this.creativity = rand();
    }

    public int getMind() {
        return mind;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getWit() {
        return wit;
    }

    public int getCreativity() {
        return creativity;
    }

    @Override
    public int sumProperties() {
        return getMind() + getWisdom() + getWit() + getCreativity();
    }

    @Override
    public String toString() {
        return super.toString() +
                "ум=" + wisdom +
                ", мудрость=" + wisdom +
                ", остроумие=" + wit +
                ", творчество=" + creativity +
                ", факультет='Когтевран'}";
    }
}
