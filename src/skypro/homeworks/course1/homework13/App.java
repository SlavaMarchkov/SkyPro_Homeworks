package skypro.homeworks.course1.homework13;

public class App {
    public static void main(String[] args) {
        Author stephenKing = new Author("Stephen", "King");
        Author viktorPelevin = new Author("Viktor", "Pelevin");

        Book heartsInAtlantis = new Book("Hearts In Atlantis", stephenKing, 1997);
        Book generationP = new Book("Generation «П»", viktorPelevin, 1998);

        generationP.setIssueYear(1999);
    }
}
