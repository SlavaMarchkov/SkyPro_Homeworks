package skypro.homeworks.course2.homework15.exceptions;

public class StorageIsFullException extends RuntimeException {
    public StorageIsFullException(final String message) {
        super(message);
    }

}
