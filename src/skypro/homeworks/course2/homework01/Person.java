package skypro.homeworks.course2.homework01;

public class Person {
    private String name;
    private String surname;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    public void changePerson(Person person) {
        person = new Person("Ilya", "Lagutenko");
    }

    // Внутри метода запишите в поле name строку “Ilya”,
    // а в строку surname — “Lagutenko”.
    public void changePerson2(Person person) {
        person.name = "Ilya";
        person.surname = "Lagutenko";
    }
}
