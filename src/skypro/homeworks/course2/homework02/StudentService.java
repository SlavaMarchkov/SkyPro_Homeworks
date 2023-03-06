package skypro.homeworks.course2.homework02;

public class StudentService {

    public void print(Hogwarts[] students, String facultyName) {
        System.out.println("Факультет " + facultyName + ": " + students.length);
        for (Hogwarts student : students) {
            System.out.println(student);
        }
    }

    /**
     * @param students Hogwarts
     * @param facultyName String
     */
    public void chooseBestStudent(Hogwarts[] students, String facultyName) {
        int max = students[0].sumProperties();
        String winner = students[0].getName();
        for (int i = 1; i < students.length; i++) {
            Hogwarts student = students[i];
            if (max < student.sumProperties()) {
                max = student.sumProperties();
                winner = student.getName();
            }
        }
        System.out.println(winner + " лучший " + facultyName + ", чем остальные");
    }

    public void compareStudents(Hogwarts student1, Hogwarts student2) {
        int totalStudent1 = student1.getPowerOfMagic() + student1.getMoveDistance();
        int totalStudent2 = student2.getPowerOfMagic() + student2.getMoveDistance();

        if (totalStudent1 > totalStudent2) {
            System.out.println(student1.getName() + " обладает бОльшей мощностью магии, чем " + student2.getName());
        } else {
            System.out.println(student2.getName() + " обладает бОльшей мощностью магии, чем " + student1.getName());
        }
    }
}
