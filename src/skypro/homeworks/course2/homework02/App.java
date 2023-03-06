package skypro.homeworks.course2.homework02;

public class App {

    public static void main(String[] args) {
        Gryffindor[] gryffindors = new Gryffindor[]{
                new Gryffindor("Гарри Поттер"),
                new Gryffindor("Гермиона Грейнджер"),
                new Gryffindor("Рон Уизли"),
        };
        Hufflepuff[] hufflepuffs = new Hufflepuff[]{
                new Hufflepuff("Захария Смит"),
                new Hufflepuff("Седрик Диггори"),
                new Hufflepuff("Джастин Финч-Флетчли"),
        };
        Ravenclaw[] ravenclaws = new Ravenclaw[]{
                new Ravenclaw("Чжоу Чанг"),
                new Ravenclaw("Падма Патил"),
                new Ravenclaw("Маркус Белби"),
        };
        Slytherin[] slytherins = new Slytherin[]{
                new Slytherin("Драко Малфой"),
                new Slytherin("Грэхэм Монтегю"),
                new Slytherin("Грегори Гойл"),
        };

        // 1. Метод, который выводит на экран описание студента
        StudentService studentService = new StudentService();
        studentService.print(gryffindors, "Gryffindor");
        studentService.print(hufflepuffs, "Hufflepuff");
        studentService.print(ravenclaws, "Ravenclaw");
        studentService.print(slytherins, "Slytherin");

        // 2. Результат сравнения всех учеников одного факультета
        studentService.chooseBestStudent(gryffindors, "Гриффиндорец");
        studentService.chooseBestStudent(hufflepuffs, "Пуффендуец");
        studentService.chooseBestStudent(ravenclaws, "Когтевранец");
        studentService.chooseBestStudent(slytherins, "Слизеринец");

        // 3. Метод, который сравнивает двух любых учеников Хогвартса по силе магии и расстоянию трансгрессии
        studentService.compareStudents(slytherins[0], hufflepuffs[0]);
    }
}
