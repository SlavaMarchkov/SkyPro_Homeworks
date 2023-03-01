package skypro.homeworks.course2.homework02;

public class Hufflepuff extends Hogwarts {
    private final int diligence; // трудолюбие
    private final int loyalty; // верность
    private final int honesty; // честность

    public Hufflepuff(String name) {
        super(name);
        this.diligence = rand();
        this.loyalty = rand();
        this.honesty = rand();
    }

    public int getDiligence() {
        return diligence;
    }

    public int getLoyalty() {
        return loyalty;
    }

    public int getHonesty() {
        return honesty;
    }

    @Override
    public int sumProperties() {
        return getDiligence() + getLoyalty() + getHonesty();
    }

    @Override
    public String toString() {
        return super.toString() +
                "трудолюбие=" + diligence +
                ", верность=" + loyalty +
                ", честность=" + honesty +
                ", факультет='Пуффендуй'}";
    }
}
