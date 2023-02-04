package skypro.homeworks.course1.homework13;

public class Author {

    private final String firstName;
    private final String lastName;

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String toString() {
        return "Автор{" +
                "имя='" + firstName + '\'' +
                ", фамилия='" + lastName + '\'' +
                '}';
    }
}
