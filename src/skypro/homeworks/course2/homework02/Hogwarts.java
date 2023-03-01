package skypro.homeworks.course2.homework02;

import java.util.Random;

abstract public class Hogwarts {
    private final String name;
    private final int powerOfMagic; // мощность в баллах
    private final int moveDistance; // расстояние трансгрессии
    private static final Random RANDOM = new Random();

    public Hogwarts(String name) {
        this.name = name;
        this.powerOfMagic = rand();
        this.moveDistance = rand();
    }

    public String getName() {
        return name;
    }

    public int getPowerOfMagic() {
        return powerOfMagic;
    }

    public int getMoveDistance() {
        return moveDistance;
    }

    public abstract int sumProperties();

    @Override
    public String toString() {
        return "Student{" +
                "имя='" + name + '\'' +
                ", мощность=" + powerOfMagic +
                ", трансгрессия=" + moveDistance +
                ", ";
    }

    protected static int rand() {
        int from = 0;
        int to = 101;
        return RANDOM.nextInt(from, to);
    }
}
