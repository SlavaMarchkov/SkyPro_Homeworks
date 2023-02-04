package skypro.homeworks.course1.homework13;

import java.util.Objects;

public class Book {

    private final String title;
    private final Author author;
    private int issueYear;

    public Book(String title, Author author, int issueYear) {
        this.title = title;
        this.author = author;
        this.issueYear = issueYear;
    }

    public String getTitle() {
        return this.title;
    }

    public Author getAuthor() {
        return this.author;
    }

    public int getIssueYear() {
        return this.issueYear;
    }

    public void setIssueYear(int issueYear) {
        this.issueYear = issueYear;
    }

    @Override
    public String toString() {
        return "Книга{" +
                "название='" + title + '\'' +
                ", " + author +
                ", год издания=" + issueYear +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return title.equals(book.title) && author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }
}
