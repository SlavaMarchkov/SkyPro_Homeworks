package skypro.homeworks.course1.homework13;

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

}
